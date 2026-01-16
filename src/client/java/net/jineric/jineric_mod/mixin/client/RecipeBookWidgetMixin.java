package net.jineric.jineric_mod.mixin.client;

import jingy.jineric.access.RecipeBookAccess;
import jingy.jineric.config.JmConfig;
import jingy.jineric.recipe.book.JmRecipeBookOptions;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.network.packet.c2s.play.RecipeCategoryOptionsC2SPacket;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(RecipeBookWidget.class)
public abstract class RecipeBookWidgetMixin<T extends AbstractRecipeScreenHandler> implements Drawable, Element, Selectable {
	@Shadow private ClientRecipeBook recipeBook;
	@Shadow protected MinecraftClient client;
	@Shadow @Final protected T craftingScreenHandler;
	@Unique private final boolean replaceVanilla = JmConfig.REPLACE_VANILLA_RECIPE_BOOK;
	
	@Inject(
			method = "sendBookDataPacket",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/screen/AbstractRecipeScreenHandler;getCategory()Lnet/minecraft/recipe/book/RecipeBookType;"
			), cancellable = true
	)
	private void replaceVanillaChecksWithJm(CallbackInfo ci) {
		if (this.replaceVanilla) {
			net.minecraft.recipe.book.RecipeBookType recipeBookType = this.craftingScreenHandler.getCategory();
			JmRecipeBookOptions jmRecipeBookOptions = ((RecipeBookAccess)this.recipeBook).jineric$getOptions();
			this.client.getNetworkHandler().sendPacket(
					new RecipeCategoryOptionsC2SPacket(
							recipeBookType,
							jmRecipeBookOptions.isGuiOpen(recipeBookType),
							jmRecipeBookOptions.isFilteringCraftable(recipeBookType)
					)
			);
			ci.cancel();
		}
	}
}
