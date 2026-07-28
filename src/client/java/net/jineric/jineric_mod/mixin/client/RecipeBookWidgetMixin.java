package net.jineric.jineric_mod.mixin.client;

import jingy.jineric.access.JmRecipeBook;
import jingy.jineric.config.JmConfig;
import jingy.jineric.recipe.book.JmRecipeBookOptions;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.network.protocol.game.ServerboundRecipeBookChangeSettingsPacket;
import net.minecraft.world.inventory.RecipeBookMenu;
import net.minecraft.world.inventory.RecipeBookType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RecipeBookComponent.class)
public abstract class RecipeBookWidgetMixin<T extends RecipeBookMenu> implements Renderable, GuiEventListener, NarratableEntry {
	@Shadow private ClientRecipeBook book;
	@Shadow protected Minecraft minecraft;
	@Shadow @Final protected T menu;

	@Unique private final boolean replaceVanilla = JmConfig.REPLACE_VANILLA_RECIPE_BOOK;
	
	@Inject(
			method = "sendUpdateSettings",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/inventory/RecipeBookMenu;getRecipeBookType()Lnet/minecraft/world/inventory/RecipeBookType;"
			), cancellable = true
	)
	private void replaceVanillaChecksWithJm(CallbackInfo ci) {
		if (this.replaceVanilla && this.minecraft.getConnection() != null) {
			RecipeBookType recipeBookType = this.menu.getRecipeBookType();
			JmRecipeBookOptions jmRecipeBookOptions = ((JmRecipeBook)this.book).jineric$getOptions();
			this.minecraft.getConnection().send(
					new ServerboundRecipeBookChangeSettingsPacket(
							recipeBookType,
							jmRecipeBookOptions.isGuiOpen(recipeBookType),
							jmRecipeBookOptions.isFilteringCraftable(recipeBookType)
					)
			);
			ci.cancel();
		}
	}
}
