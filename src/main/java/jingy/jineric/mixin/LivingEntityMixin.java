package jingy.jineric.mixin;

import jingy.jineric.block.JinericBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	//TODO: CHANGED IN 1.21.3, LIKELY TIED TO SOUL SPEED DIRECTLY NOW IN THE DATA DRIVEN ENCHANTMENT. TEST IF WORKING.
//	@Inject(at = @At("HEAD"), method = "isOnSoulSpeedBlock()Z", cancellable = true)
//	protected void jineric$handleSoulSpeedForSlabsAndFences(CallbackInfoReturnable<Boolean> cir) {
//		// check feet pos block
//		BlockPos pos = getBlockPos();
//		if (getWorld().getBlockState(pos).isIn(BlockTags.SOUL_SPEED_BLOCKS)) {
//			cir.setReturnValue(true);
//		}
//		// check head pos block
//		if (getWorld().getBlockState(pos.up()).isIn(BlockTags.SOUL_SPEED_BLOCKS)) {
//			cir.setReturnValue(true);
//		}
//	}

	//TODO: BROKEN IN 1.21.3, MAY BE FIXED
//	@ModifyVariable(
//			method = "travel",
//			slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getVelocityAffectingPos()Lnet/minecraft/util/math/BlockPos;")),
//			at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/block/Block;getSlipperiness()F"))
//	@SuppressWarnings("InvalidInjectorMethodSignature")
//	public float jineric$setSlipperiness(float p) {
//		BlockPos pos = getBlockPos();
//		BlockState state = getWorld().getBlockState(pos);
//		if (isOnGround() && JinericBlocks.isSlipperyBlock(state)) {
//			// if Y is a perfect integer, we're on a full block.
//			// Otherwise, get friction from the block the entity is in, not on.
//			return state.getBlock().getSlipperiness();
//		}
//		return p;
//	}

//	@Inject(
////			method = "travel",
////			slice = @Slice(from = @At(
////					value = "INVOKE",
////					target = "net/minecraft/entity/LivingEntity.getVelocity ()Lnet/minecraft/util/math/Vec3d;")),
////			at = @At(value = "RETURN")
//			method = "travel",
//			at = @At(
//					value = "INVOKE",
//					target = "net/minecraft/entity/LivingEntity.getVelocity()Lnet/minecraft/util/math/Vec3d;",
//					shift = At.Shift.BEFORE
//			),
//			slice = @Slice(
//					from = @At(
//							value = "INVOKE",
//							target = "net/minecraft/entity/LivingEntity.isLogicalSideForUpdatingMovement ()Z"
//					),
//					to = @At(
//							value = "INVOKE",
//							target = "net/minecraft/entity/LivingEntity.hasStatusEffect (Lnet/minecraft/entity/effect/StatusEffect;)Z"
//					)
//			)
//	)
//	private void jineric$modifyFallSpeed(Vec3d movementInput, CallbackInfo ci) {
//		if ()
//	}
}
