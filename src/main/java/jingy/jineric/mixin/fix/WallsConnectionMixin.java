package jingy.jineric.mixin.fix;

import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WallBlock.class)
public abstract class WallsConnectionMixin extends Block implements SimpleWaterloggedBlock {
	public WallsConnectionMixin(Properties settings) {
		super(settings);
	}
	
	@Inject(
			method = "connectsTo",
			at = @At("RETURN"), cancellable = true
	)
	private void jineric$shouldConnectTo(BlockState state, boolean faceFullSquare, Direction side, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(cir.getReturnValueZ() || state.is(JinericBlockTags.NOT_PICKAXE_WALL));
	}
}
