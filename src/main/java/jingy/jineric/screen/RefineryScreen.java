package jingy.jineric.screen;

import com.chocohead.mm.api.ClassTinkerers;
import jingy.jineric.base.JinericMain;
import jingy.jineric.recipe.JinericRecipeBookCategories;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.client.recipebook.RecipeBookType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

@Environment(EnvType.CLIENT)
public class RefineryScreen extends AbstractFurnaceScreen<RefineryScreenHandler> {
   private static final Identifier LIT_PROGRESS_TEXTURE = JinericMain.ofJineric("container/refinery/lit_progress");
   private static final Identifier BURN_PROGRESS_TEXTURE = JinericMain.ofJineric("container/refinery/burn_progress");
   private static final Identifier TEXTURE = JinericMain.ofJineric("textures/gui/container/refinery.png");
   private static final Text TOGGLE_REFINABLE_TEXT = Text.translatable("gui.recipebook.toggleRecipes.refinable");
   private static final net.minecraft.client.recipebook.RecipeBookType JINERIC_REFINERY = ClassTinkerers.getEnum(RecipeBookType.class, "JINERIC_REFINERY");
   private static final List<RecipeBookWidget.Tab> TABS = List.of(
           new RecipeBookWidget.Tab(JINERIC_REFINERY),
           new RecipeBookWidget.Tab(Items.STONE, JinericRecipeBookCategories.REFINERY_BLOCKS),
           new RecipeBookWidget.Tab(Items.CYAN_GLAZED_TERRACOTTA, JinericRecipeBookCategories.REFINERY_MISC)
   );

   public RefineryScreen(RefineryScreenHandler container, PlayerInventory inventory, Text title) {
      super(container, inventory, title, TOGGLE_REFINABLE_TEXT, TEXTURE, LIT_PROGRESS_TEXTURE, BURN_PROGRESS_TEXTURE, TABS);
   }
}
