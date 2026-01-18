package jingy.jineric.mixin.add;

import jingy.jineric.potion.JinericPotions;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PotionBrewing.class)
public abstract class BrewingRecipeRegistryMixin {
	
	@Inject(
			at = @At("HEAD"),
			method = "addVanillaMixes"
	)
	private static void jineric$registerDefaults(PotionBrewing.Builder builder, CallbackInfo ci) {
		//DARKNESS
		builder.addMix(Potions.NIGHT_VISION, Items.FERMENTED_SPIDER_EYE, JinericPotions.DARKNESS);
		builder.addMix(JinericPotions.DARKNESS, Items.REDSTONE, JinericPotions.LONG_DARKNESS);
		builder.addMix(Potions.LONG_NIGHT_VISION, Items.FERMENTED_SPIDER_EYE, JinericPotions.LONG_DARKNESS);
		//GLOWING
		builder.addMix(Potions.AWKWARD, Items.GLOW_BERRIES, JinericPotions.GLOWING);
		builder.addMix(JinericPotions.GLOWING, Items.REDSTONE, JinericPotions.LONG_GLOWING);
		//INVISIBILITY
		builder.addMix(JinericPotions.GLOWING, Items.FERMENTED_SPIDER_EYE, Potions.INVISIBILITY);
		builder.addMix(JinericPotions.LONG_GLOWING, Items.FERMENTED_SPIDER_EYE, Potions.LONG_INVISIBILITY);
	}
}
