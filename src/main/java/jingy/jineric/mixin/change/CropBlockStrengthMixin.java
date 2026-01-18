package jingy.jineric.mixin.change;

import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CropBlock.class)
public abstract class CropBlockStrengthMixin {
	
	@ModifyArg(
			method = "<init>",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/level/block/VegetationBlock;<init>(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V"
			)
	)
	private static BlockBehaviour.Properties modifyCropBlockSettings(BlockBehaviour.Properties settings) {
		settings.strength(0.66F);
		return settings;
	}
}
