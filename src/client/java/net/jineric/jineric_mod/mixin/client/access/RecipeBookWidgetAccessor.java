package net.jineric.jineric_mod.mixin.client.access;

import net.minecraft.client.gui.screens.recipebook.GhostSlots;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeBookPage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(RecipeBookComponent.class)
public interface RecipeBookWidgetAccessor {
	@Accessor
	RecipeBookPage getRecipeBookPage();
	
	@Accessor
	GhostSlots getGhostSlots();
}
