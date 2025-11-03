package jingy.jineric.mixin.fix;

import jingy.jineric.registry.JinericBlockEntityType;
import net.fabricmc.fabric.api.blockview.v2.RenderDataBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.debug.DebugTrackable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEntity.class)
public abstract class FixCampfireBlockEntityType implements DebugTrackable, RenderDataBlockEntity {
	@Mutable @Shadow @Final private BlockEntityType<?> type;
	
	@Inject(
			method = "<init>",
			at = @At(value = "TAIL")
	)
	private void setBlockEntityType(BlockEntityType<?> type, BlockPos pos, BlockState state, CallbackInfo ci) {
		if ((BlockEntity)(Object)this instanceof CampfireBlockEntity campfireBlockEntity && this.type.equals(BlockEntityType.CAMPFIRE)) {
			this.type = JinericBlockEntityType.REDSTONE_CAMPFIRE;
		}
	}
}
