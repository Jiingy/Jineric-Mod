package jingy.jineric.data.generators;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class JinericRecipeGenerator extends FabricRecipeProvider {
   public JinericRecipeGenerator(FabricDataOutput output) {
      super(output);
   }

   @Override
   public void generate(Consumer<RecipeJsonProvider> exporter) {
      //--- REMINDERS ---
      // - SLAB STONECUTTING RECIPES NEED 2 OUTPUT
      // - STAIRS NEED .offerTo(exporter);
      RecipeCategory building = RecipeCategory.BUILDING_BLOCKS;
      RecipeCategory misc = RecipeCategory.MISC;
      // offerStonecuttingRecipe(exporter, building, JinericBlocks., JinericBlocks.);
      // offerStonecuttingRecipe(exporter, building, JinericBlocks._SLAB, JinericBlocks.);
      // offerStonecuttingRecipe(exporter, building, JinericBlocks._STAIRS, JinericBlocks.);
      // offerStonecuttingRecipe(exporter, building, JinericBlocks._WALL, JinericBlocks.);
   }
}
