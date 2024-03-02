package jingy.jineric.data.generators;

import jingy.jineric.data.family.JinericBlockFamilies;
import jingy.jineric.item.JinericItems;
import jingy.jineric.mixin.access.CookingRecipeJsonBuilderAccess;
import jingy.jineric.recipe.JinericRecipeSerializers;
import jingy.jineric.tag.JinericItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

public class JinericRecipeProviders extends FabricRecipeProvider {

   public JinericRecipeProviders(FabricDataOutput output) {
      super(output);
   }

   @Override
   public void generate(RecipeExporter exporter) {
      generateFamily(exporter, JinericBlockFamilies.PETRIFIED_OAK, FeatureSet.of(FeatureFlags.VANILLA));
      JinericGeneratedRecipes.offerGeneralRecipes(exporter);
      JinericGeneratedRecipes.offerRefiningRecipes(exporter);
      JinericGeneratedRecipes.offerStoneCuttingRecipes(exporter);
      JinericGeneratedRecipes.offerUpgradeRecipes(exporter);
   }

   public static void offerChestBoatRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
      ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, output).input(JinericItemTags.CHESTS).input(input).group("chest_boat").criterion("has_boat", conditionsFromTag(ItemTags.BOATS)).offerTo(exporter);
   }

   public static void offerTrappedChestRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
      ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output)
              .input(Blocks.TRIPWIRE_HOOK)
              .input(input)
              .group("trapped_chest")
              .criterion("has_chest", conditionsFromTag(JinericItemTags.WOODEN_CHESTS))
              .offerTo(exporter);
   }

   public static void offerFenceRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
      createFenceRecipe(category, output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
   }

   public static CraftingRecipeJsonBuilder createFenceRecipe(RecipeCategory category, ItemConvertible output, Ingredient outerInput) {
      return ShapedRecipeJsonBuilder.create(category, output, 6).input('#', Items.NETHER_BRICK).input('%', outerInput).pattern("%#%").pattern("%#%");
   }

   public static void offerIronUpgradeRecipe(RecipeExporter exporter, Item input, RecipeCategory category, Item result) {
      SmithingTransformRecipeJsonBuilder.create(
                      Ingredient.ofItems(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE),
                      Ingredient.ofItems(input),
                      Ingredient.ofItems(Items.IRON_INGOT), category, result)
              .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
              .offerTo(exporter, getItemPath(result) + "_smithing");
   }

   public static void offerRefinery(RecipeExporter exporter, ItemConvertible output) {
      ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 1)
              .input('P', Blocks.POLISHED_DEEPSLATE).input('T', Blocks.DEEPSLATE_TILES).input('F', Blocks.FURNACE)
              .pattern("PPP")
              .pattern("PFP")
              .pattern("TTT")
              .criterion("has_furnace", conditionsFromItem(Items.FURNACE))
              .offerTo(exporter);
   }

   public static void offerRefining(RecipeExporter exporter, ItemConvertible itemOutput, Item itemInput, RecipeCategory category, CookingRecipeCategory cookingCategory, float xp, Item group) {
      Identifier outId = new Identifier(itemOutput.toString());
      createRefining(Ingredient.ofItems(itemInput), category, cookingCategory, itemOutput, xp, 100, JinericRecipeSerializers.REFINING)
              .group(group == Items.AIR ? null : group.toString())
              .criterion(hasItem(itemInput), conditionsFromItem(itemInput))
              .offerTo(exporter, outId + "_refining_" + itemInput);
   }

   public static void offerRefining(RecipeExporter exporter, ItemConvertible itemOutput, Item itemInput, Item group) {
      Identifier outId = new Identifier(itemOutput.toString());
      createRefining(Ingredient.ofItems(itemInput), RecipeCategory.BUILDING_BLOCKS, CookingRecipeCategory.BLOCKS, itemOutput, 0.2F, 100, JinericRecipeSerializers.REFINING)
              .group(group == Items.AIR ? null : group.toString())
              .criterion(hasItem(itemInput), conditionsFromItem(itemInput))
              .offerTo(exporter, outId + "_refining_" + itemInput);
   }

   public static CookingRecipeJsonBuilder createRefining(Ingredient input, RecipeCategory category, CookingRecipeCategory cookingCategory, ItemConvertible output, float experience, int cookingTime, RecipeSerializer<? extends AbstractCookingRecipe> serializer) {
      return CookingRecipeJsonBuilderAccess.invokeInit(category, cookingCategory, output, input, experience, cookingTime, serializer);
   }

   public static void offerStonecuttingRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
      offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, output, input, 1);
   }

   public static void offerSimpleBrickSetRecipes(RecipeExporter exporter, Item baseBlockIn, Item baseBlockOut, Item stairsOut, Item slabOut, Item wallOut) {
      if (baseBlockOut.toString().contains("cracked")) {
         offerCrackingRecipe(exporter, baseBlockOut, baseBlockIn);
      } else {
         offerBrickRecipe(exporter, baseBlockOut, baseBlockIn);
      }
      createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, slabOut, Ingredient.ofItems(baseBlockOut)).criterion("has_" + baseBlockOut, conditionsFromItem(baseBlockOut)).offerTo(exporter);
      createStairsRecipe(stairsOut, Ingredient.ofItems(baseBlockOut)).criterion("has_" + baseBlockOut, conditionsFromItem(baseBlockOut)).offerTo(exporter);
      offerWallRecipe(exporter, RecipeCategory.DECORATIONS, wallOut, baseBlockOut);
   }

   public static void offerBrickRecipe(RecipeExporter exporter, Item output, Item input) {
      ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4).input('#', input).pattern("##").pattern("##").criterion("has_" + input, conditionsFromItem(input)).offerTo(exporter);
   }
}
