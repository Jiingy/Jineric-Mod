package jingy.jineric.mixin;

import jingy.jineric.registry.JinericBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	@Shadow public abstract boolean canMoveVoluntarily();
	@Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(at = @At("HEAD"), method = "isOnSoulSpeedBlock()Z", cancellable = true)
	protected void jineric$handleSoulSpeedForSlabsAndFences(CallbackInfoReturnable<Boolean> cir) {
		// check feet pos block
		BlockPos pos = getBlockPos();
		if (world.getBlockState(pos).isIn(BlockTags.SOUL_SPEED_BLOCKS)) {
			cir.setReturnValue(true);
		}
		// check head pos block
		if (world.getBlockState(pos.up()).isIn(BlockTags.SOUL_SPEED_BLOCKS)) {
			cir.setReturnValue(true);
		}
	}
/*
	@Inject(at = @At("TAIL"), method = "travel")
	public void jineric$travel(Vec3d movementInput, CallbackInfo ci) {
		if (this.canMoveVoluntarily() || this.isLogicalSideForUpdatingMovement()) {
			double d = 0.08;
			if (this.getVelocity().y <= 0.0 && this.hasStatusEffect(JinericStatusEffects.FAST_FALLING)) {
				d = 0.01;
				this.onLanding();
			}
		}
	}
*/
	@ModifyVariable(
			method = "travel",
			slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getVelocityAffectingPos()Lnet/minecraft/util/math/BlockPos;")),
			at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/block/Block;getSlipperiness()F")
	)



	@SuppressWarnings("InvalidInjectorMethodSignature")
	public float jineric$setSlipperiness(float p) {
		BlockPos pos = getBlockPos();
		BlockState state = world.getBlockState(pos);
		if (isOnGround() && JinericBlocks.blockIsJinericIce(state)) {
			// if Y is a perfect integer, we're on a full block.
			// Otherwise, get friction from the block the entity
			// is in, not on.
			return state.getBlock().getSlipperiness();
		}
		return p;
	}

}