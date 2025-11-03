package jingy.jineric.mixin.fix;

import jingy.jineric.block.RedstoneCampfireBlock;
import jingy.jineric.registry.JinericBlockEntityType;
import net.fabricmc.fabric.api.blockview.v2.RenderDataBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.debug.DebugTrackable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CampfireBlockEntity.class)
public abstract class RedstoneCampfireBlockEntityType implements DebugTrackable, RenderDataBlockEntity {
	
	@ModifyArg(
			method = "<init>",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/block/entity/BlockEntity;<init>(Lnet/minecraft/block/entity/BlockEntityType;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V"
			),
			index = 0
	)
	private static BlockEntityType<?> setBlockEntityType(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		if (state.getBlock() instanceof RedstoneCampfireBlock) {
			return JinericBlockEntityType.REDSTONE_CAMPFIRE;
		} else {
			return type;
		}
	}
}
