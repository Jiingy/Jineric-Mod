package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.sugar.Local;
import jingy.jineric.block.JinericBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SpreadingSnowyBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpreadingSnowyBlock.class)
public abstract class SurviveUnderGrassBlockMixin {
	
	@Inject(
			method = "canStayAlive",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/level/lighting/LightEngine;getLightDampeningInto(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/Direction;I)I"
			),
			cancellable = true
	)
	private static void canSurviveUnder(
			BlockState state, LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> cir,
			@Local(type = BlockState.class, name = "aboveState") BlockState aboveState
	) {
		if (aboveState.is(JinericBlocks.GRASS_BLOCK)) {
			cir.setReturnValue(true);
		}
	}
}
