package jingy.jineric.base.plugins;

import com.chocohead.mm.api.ClassTinkerers;
import jingy.jineric.recipe.JinericRecipeBookCategories;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeBookCategory;

public class EarlyRiser implements Runnable {

   @Override
   public void run() {
      boolean isClient = FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
      MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
      String recipeBookType = remapper.mapClassName("intermediary", "net.minecraft.class_5421");
//      ClassTinkerers.enumBuilder(recipeBookType).addEnum("JINERIC_REFINERY").build();

      if (isClient) {
//         String recipeBookGroup = remapper.mapClassName("intermediary", "net.minecraft.class_314");
         String recipeBookCategory = remapper.mapClassName("intermediary", "net.minecraft.class_10355");

         //TODO: FIX AND CLEAN UP 1.21.3
//         String itemStack = "[L" + remapper.mapClassName("intermediary", "net.minecraft.class_1799") + ";";
//         ClassTinkerers.enumBuilder(recipeBookGroup, itemStack).addEnum("JINERIC_REFINERY_BUILDING",
//                 () -> new Object[] {
//                         new ItemStack[] {
//                                 new ItemStack(Items.STONE)
//                         }
//                 }
//         ).build();
//         ClassTinkerers.enumBuilder(recipeBookGroup, itemStack).addEnum("JINERIC_REFINERY_MISC", () -> new Object[] {new ItemStack[]{new ItemStack(Items.CYAN_GLAZED_TERRACOTTA)}}).build();

         ClassTinkerers.enumBuilder(recipeBookType).addEnum("JINERIC_REFINERY", () -> new Object[] {new RecipeBookCategory[] {JinericRecipeBookCategories.REFINERY_BLOCKS, JinericRecipeBookCategories.REFINERY_MISC}}).build();
      }
   }
}
