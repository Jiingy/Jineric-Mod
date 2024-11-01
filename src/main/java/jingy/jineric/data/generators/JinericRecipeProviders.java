package jingy.jineric.data.generators;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.mixin.access.BaseBlocksToFamiliesAccess;
import jingy.jineric.recipe.JinericRecipeSerializer;
import jingy.jineric.recipe.RefiningRecipe;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.family.BlockFamily.Variant.*;

//TODO: THIS IS ALL BROKEN 1.21.3
public class JinericRecipeProviders extends FabricRecipeProvider {

   public JinericRecipeProviders(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
      super(output, registriesFuture);
   }

   @Override
   protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
      return new RecipeGenerator(wrapperLookup, recipeExporter) {
         @Override
         public void generate() {
            RegistryEntryLookup<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

            // Compact Blocks
            this.offerSimpleReversibleCompacting(RecipeCategory.MISC, Items.BLAZE_ROD, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.BLAZE_ROD_BLOCK);
            this.offerSimpleReversibleCompacting(RecipeCategory.MISC, Items.ENDER_PEARL, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.ENDER_PEARL_BLOCK);
            this.offerSimpleReversibleCompacting(RecipeCategory.MISC, Items.PAPER, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.PAPER_BLOCK);
            this.offerSimpleReversibleCompacting(RecipeCategory.MISC, Items.PRISMARINE_CRYSTALS, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.PRISMARINE_CRYSTAL_BLOCK);
            this.offerSimpleReversibleCompacting(RecipeCategory.MISC, Items.STICK, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.STICK_BLOCK);
            this.offerSimpleReversibleCompacting(RecipeCategory.MISC, Items.FLINT, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.FLINT_BLOCK);
            this.offerSimpleReversibleCompacting(RecipeCategory.MISC, Items.ROTTEN_FLESH, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.ROTTEN_FLESH_BLOCK);
            this.offerSimpleReversibleCompacting(RecipeCategory.MISC, Items.BONE_MEAL, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.BONE_MEAL_BLOCK);
            this.offerSimpleReversibleCompacting(RecipeCategory.MISC, Items.EGG, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.EGG_BLOCK);
            this.offerSimpleReversibleCompacting(RecipeCategory.MISC, Items.SUGAR, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SUGAR_BLOCK);
            this.offerSimpleReversibleCompacting(RecipeCategory.MISC, Items.CHARCOAL, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.CHARCOAL_BLOCK);

            // REFINING
            offerSimpleRefiningBlockFamily(Blocks.COBBLESTONE, Blocks.STONE, RecipeCategory.BUILDING_BLOCKS, 0.1F, 100, "stone_set");
            offerSimpleRefiningBlockFamily(Blocks.STONE, Blocks.SMOOTH_STONE, RecipeCategory.BUILDING_BLOCKS, 0.1F, 100, "smooth_stone_set");
            // TODO: FIX COBBLED DEEPSLATE REWARDING SMOOTH DEEPSLATE -- MORE GENERALLY FOR OTHER SETS
            //offerSimpleRefiningBlockFamily(Blocks.COBBLED_DEEPSLATE, JinericBlocks.SMOOTH_DEEPSLATE, RecipeCategory.BUILDING_BLOCKS, 0.1F, 100, "smooth_deepslate_set");
            this.offerRefining(Blocks.COBBLED_DEEPSLATE, RecipeCategory.BUILDING_BLOCKS, Blocks.DEEPSLATE, 0.1F, 100, "cobbled_deepslate_set");
            this.offerRefining(Blocks.DEEPSLATE, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SMOOTH_DEEPSLATE, 0.1F, 100, "deepslate_set");
            this.offerRefining(Blocks.COBBLED_DEEPSLATE_STAIRS, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SMOOTH_DEEPSLATE_STAIRS, 0.1F, 100, "cobbled_deepslate_set");
            this.offerRefining(Blocks.COBBLED_DEEPSLATE_SLAB, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SMOOTH_DEEPSLATE_SLAB, 0.1F, 100, "cobbled_deepslate_set");
            this.offerRefining(Blocks.COBBLED_DEEPSLATE_WALL, RecipeCategory.BUILDING_BLOCKS, JinericBlocks.SMOOTH_DEEPSLATE_WALL, 0.1F, 100, "cobbled_deepslate_set");
         }

         public void offerSimpleReversibleCompacting(
                 RecipeCategory reverseCategory, ItemConvertible baseItem, RecipeCategory compactingCategory, ItemConvertible compactItem
         ) {
            String removeSuffixCompactItem = compactItem.asItem().toString().replace("minecraft:", "").replace("jineric:", "");
            String removeSuffixBaseItem = baseItem.asItem().toString().replace("minecraft:", "").replace("jineric:", "");
            this.offerReversibleCompactingRecipesWithReverseRecipeGroup(
                    reverseCategory, baseItem, compactingCategory, compactItem,
                    removeSuffixBaseItem + "_from_" + removeSuffixCompactItem, removeSuffixBaseItem
            );

            System.out.println(compactItem.asItem().getTranslationKey());
            System.out.println(baseItem.asItem().getTranslationKey());
         }

         public Block vanillaBaseToJineric(Block block, BlockFamily.Variant variant) {
            String throughPutTrimmed = block.getTranslationKey().replace("block.minecraft.", "");
            String variantSuffix = "_" + variant.getName();
            Identifier jinericThroughPutBlockIdentifier = JinericMain.ofJineric(throughPutTrimmed + variantSuffix);
            return Registries.BLOCK.get(jinericThroughPutBlockIdentifier);
         }

         public Block getOfferThroughPut(Block block, @Nullable BlockFamily.Variant variant) {
            Map<Block, BlockFamily> blockFamilies = BaseBlocksToFamiliesAccess.getBlockFamilies();
            if (variant != null) {
               if (!blockFamilies.get(block).getVariants().containsKey(variant)) {
                  return vanillaBaseToJineric(block, variant);
               }
               return blockFamilies.get(block).getVariant(variant);
            }
            return blockFamilies.get(block).getBaseBlock();
         }

         public void offerSimpleRefiningBlockFamily(Block input, Block output, RecipeCategory category, float experience, int cookingTime, String group) {
            this.offerSingleOption(JinericRecipeSerializer.REFINING, RefiningRecipe::new, getOfferThroughPut(input, null), category, getOfferThroughPut(output, null), experience, cookingTime, group, "_from_refining");
            this.offerSingleOption(JinericRecipeSerializer.REFINING, RefiningRecipe::new, getOfferThroughPut(input, STAIRS), category, getOfferThroughPut(output, STAIRS), experience, cookingTime, group, "_from_refining");
            this.offerSingleOption(JinericRecipeSerializer.REFINING, RefiningRecipe::new, getOfferThroughPut(input, SLAB), category, getOfferThroughPut(output, SLAB), experience, cookingTime, group, "_from_refining");
            this.offerSingleOption(JinericRecipeSerializer.REFINING, RefiningRecipe::new, getOfferThroughPut(input, WALL), category, getOfferThroughPut(output, WALL), experience, cookingTime, group, "_from_refining");
         }

         public void offerRefining(Block inputs, RecipeCategory category, Block output, float experience, int cookingTime, String group) {
            this.offerSingleOption(JinericRecipeSerializer.REFINING, RefiningRecipe::new, inputs, category, output, experience, cookingTime, group, "_from_refining");
         }

         public <T extends AbstractCookingRecipe> void offerSingleOption(
                 RecipeSerializer<T> serializer, AbstractCookingRecipe.RecipeFactory<T> recipeFactory, ItemConvertible input,
                 RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group, String suffix
         ) {
            CookingRecipeJsonBuilder.create(Ingredient.ofItem(input), category, output, experience, cookingTime, serializer, recipeFactory)
                    .group(group)
                    .criterion(hasItem(input), this.conditionsFromItem(input))
                    .offerTo(this.exporter, getItemPath(output) + suffix + "_" + getItemPath(input));
         }

//         public static void offerTrappedChestRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
//            ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output)
//                    .input(Blocks.TRIPWIRE_HOOK)
//                    .input(input)
//                    .group("trapped_chest")
//                    .criterion("has_chest", conditionsFromTag(JinericItemTags.WOODEN_CHESTS))
//                    .offerTo(exporter);
//         }

//         public static void offerFenceRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input) {
//            createFenceRecipe(registryLookup, category, output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
//         }

//         public static CraftingRecipeJsonBuilder createFenceRecipe(RecipeCategory category, ItemConvertible output, Ingredient outerInput) {
//            return ShapedRecipeJsonBuilder.create(category, output, 6).input('#', Items.NETHER_BRICK).input('%', outerInput).pattern("%#%").pattern("%#%");
//         }

//         public static void offerIronUpgradeRecipe(RecipeExporter exporter, Item input, RecipeCategory category, Item result) {
//         SmithingTransformRecipeJsonBuilder.create(
//                      Ingredient.ofItems(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE),
//                      Ingredient.ofItems(input),
//                      Ingredient.ofItems(Items.IRON_INGOT), category, result)
//              .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
//              .offerTo(exporter, getItemPath(result) + "_smithing");
//         }

//         public void offerRefinery(RecipeExporter exporter, ItemConvertible output) {
//            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 1)
//                    .input('P', Blocks.POLISHED_DEEPSLATE).input('T', Blocks.DEEPSLATE_TILES).input('F', Blocks.FURNACE)
//                    .pattern("PPP")
//                    .pattern("PFP")
//                    .pattern("TTT")
//                    .criterion("has_furnace", conditionsFromItem(Items.FURNACE))
//                    .offerTo(exporter);
//         }

//         public static void offerStonecuttingRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
//            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, output, input, 1);
//         }
//
//         public void offerSimpleBrickSetRecipes(RecipeExporter exporter, Item baseBlockIn, Item baseBlockOut, Item stairsOut, Item slabOut, Item wallOut) {
//            if (baseBlockOut.toString().contains("cracked")) {
//               offerCrackingRecipe(exporter, baseBlockOut, baseBlockIn);
//            } else {
//               offerBrickRecipe(exporter, baseBlockOut, baseBlockIn);
//            }
//            createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, slabOut, Ingredient.ofItems(baseBlockOut)).criterion("has_" + baseBlockOut, conditionsFromItem(baseBlockOut)).offerTo(exporter);
//            createStairsRecipe(stairsOut, Ingredient.ofItems(baseBlockOut)).criterion("has_" + baseBlockOut, conditionsFromItem(baseBlockOut)).offerTo(exporter);
//            offerWallRecipe(exporter, RecipeCategory.DECORATIONS, wallOut, baseBlockOut);
//         }
//
//         public static void offerBrickRecipe(RecipeExporter exporter, Item output, Item input) {
//            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4).input('#', input).pattern("##").pattern("##").criterion("has_" + input, conditionsFromItem(input)).offerTo(exporter);
//         }

//         public void offerRefining(RecipeExporter exporter, ItemConvertible itemOutput, Item itemInput, RecipeCategory category, CookingRecipeCategory cookingCategory, float xp, Item group) {
//            Identifier outId = Identifier.of(itemOutput.toString());
//            createRefining(Ingredient.ofItems(itemInput), category, cookingCategory, itemOutput, xp, 100, JinericRecipeSerializer.REFINING)
//                    .group(group == Items.AIR ? null : group.toString())
//                    .criterion(RecipeGenerator.hasItem(itemInput), this.conditionsFromItem(itemInput))
//                    .offerTo(exporter, outId + "_refining_" + itemInput);
//         }
//
//         public void offerRefining(RecipeExporter exporter, ItemConvertible itemOutput, Item itemInput, Item group) {
//            Identifier outId = Identifier.of(itemOutput.toString());
//            createRefining(Ingredient.ofItems(itemInput), RecipeCategory.BUILDING_BLOCKS, CookingRecipeCategory.BLOCKS, itemOutput, 0.2F, 100, JinericRecipeSerializer.REFINING)
//                    .group(group == Items.AIR ? null : group.toString())
//                    .criterion(RecipeGenerator.hasItem(itemInput), this.conditionsFromItem(itemInput))
//                    .offerTo(exporter, outId + "_refining_" + itemInput);
//         }
//
//         public static CookingRecipeJsonBuilder createRefining(Ingredient input, RecipeCategory category, CookingRecipeCategory cookingCategory, ItemConvertible output, float experience, int cookingTime, RecipeSerializer<? extends AbstractCookingRecipe> serializer) {
//            return CookingRecipeJsonBuilderAccess.invokeInit(category, cookingCategory, output, input, experience, cookingTime, serializer);
//         }
      };
   }

   @Override
   public String getName() {
      return "jineric";
   }
}
