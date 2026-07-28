package net.jineric.jineric_mod.mixin.client.access.overrides;

import net.jineric.jineric_mod.base.injected_interfaces.JmGhostSlots;
import net.minecraft.client.gui.screens.recipebook.GhostSlots;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(GhostSlots.class)
public class GhostSlotsOverrides implements JmGhostSlots {
	@Unique private RecipeDisplay recipeDisplay;
	
	@Override
	public RecipeDisplay jineric$getRecipeDisplay() {
		return this.recipeDisplay;
	}
	
	@Override
	public void jineric$setRecipeDisplay(RecipeDisplay recipeDisplay) {
		this.recipeDisplay = recipeDisplay;
	}
}
