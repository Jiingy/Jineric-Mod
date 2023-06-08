package jingy.jineric.base.plugins;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class EarlyRiser implements Runnable {

   @Override
   public void run() {
      MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
      String recipeBookCategory = remapper.mapClassName("intermediary", "net.minecraft.class_5421");
      ClassTinkerers.enumBuilder(recipeBookCategory).addEnum("JINERIC_REFINERY").build();

      String recipeBookGroup = remapper.mapClassName("intermediary", "net.minecraft.class_314");
      String itemStack = "[L" + remapper.mapClassName("intermediary", "net.minecraft.class_1799") + ";";
      ClassTinkerers.enumBuilder(recipeBookGroup, itemStack).addEnum("JINERIC_REFINERY_SEARCH", () -> new Object[] {new ItemStack[]{new ItemStack(Items.COMPASS)}}).build();
      ClassTinkerers.enumBuilder(recipeBookGroup, itemStack).addEnum("JINERIC_REFINERY_STONES", () -> new Object[] {new ItemStack[]{new ItemStack(Items.STONE)}}).build();
      ClassTinkerers.enumBuilder(recipeBookGroup, itemStack).addEnum("JINERIC_REFINERY_MISC", () -> new Object[] {new ItemStack[]{new ItemStack(Items.CYAN_GLAZED_TERRACOTTA)}}).build();

   }
}
