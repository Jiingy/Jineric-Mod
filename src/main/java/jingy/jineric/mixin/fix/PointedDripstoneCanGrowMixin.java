package jingy.jineric.mixin.fix;

import jingy.jineric.block.JinericBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.SlabType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PointedDripstoneBlock.class)
public abstract class PointedDripstoneCanGrowMixin extends Block implements Fallable, SimpleWaterloggedBlock {
	@Shadow
	@Final
	public static BooleanProperty WATERLOGGED;
	
	public PointedDripstoneCanGrowMixin(Properties settings) {
		super(settings);
	}
	
	@Inject(
			method = "canGrow(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/state/BlockState;)Z",
			at = @At("HEAD"),
			cancellable = true
	)
	private static void jineric$canGrow(BlockState dripstoneBlockState, BlockState waterState, CallbackInfoReturnable<Boolean> cir) {
		//Checks if block is == to DRIPSTONE_SLAB which is water logged and type.BOTTOM
		if (dripstoneBlockState.is(JinericBlocks.DRIPSTONE_SLAB)
				&& (dripstoneBlockState.getValue(WATERLOGGED)
				&& (dripstoneBlockState.getValue(SlabBlock.TYPE) == SlabType.BOTTOM))) {
			cir.setReturnValue(true);
		}
		//Checks if block is == to DRIPSTONE_STAIRS
		if (dripstoneBlockState.is((JinericBlocks.DRIPSTONE_STAIRS))) {
			cir.setReturnValue(true);
			
		}
	}
}