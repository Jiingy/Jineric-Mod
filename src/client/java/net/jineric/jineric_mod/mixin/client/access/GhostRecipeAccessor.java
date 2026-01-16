package net.jineric.jineric_mod.mixin.client.access;

import net.minecraft.client.gui.screen.recipebook.GhostRecipe;
import net.minecraft.recipe.display.SlotDisplay;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.context.ContextParameterMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GhostRecipe.class)
public interface GhostRecipeAccessor {
	@Invoker
	void callAddInputs(Slot slot, ContextParameterMap context, SlotDisplay display);
	
	@Invoker
	void callAddResults(Slot slot, ContextParameterMap context, SlotDisplay display);
}
