package jingy.jineric.mixin;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public abstract class BlockEntityTypeMixin {
	
	@Inject(
			method = "supports",
			at = @At("HEAD"),
			cancellable = true
	)
	private void supports(BlockState state, CallbackInfoReturnable<Boolean> info) {
		if ((state.getBlock() instanceof SignBlock || state.getBlock() instanceof WallSignBlock)) {
			info.setReturnValue(true);
		}
		if ((state.getBlock() instanceof HangingSignBlock || state.getBlock() instanceof WallHangingSignBlock)) {
			info.setReturnValue(true);
		}
	}
}
