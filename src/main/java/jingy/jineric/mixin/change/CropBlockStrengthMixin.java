package jingy.jineric.mixin.change;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CropBlock.class)
public abstract class CropBlockStrengthMixin {
	
	@ModifyArg(
			method = "<init>",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/block/PlantBlock;<init>(Lnet/minecraft/block/AbstractBlock$Settings;)V"
			)
	)
	private static AbstractBlock.Settings modifyCropBlockSettings(AbstractBlock.Settings settings) {
		settings.strength(0.66F);
		return settings;
	}
}
