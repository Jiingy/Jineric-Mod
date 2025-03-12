package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.Entity;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EntityPredicate.class)
public abstract class SoulSpeedPartialBlocksMixin {
	@WrapOperation(
			method = "test(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/entity/Entity;)Z",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/entity/Entity;getVelocityAffectingPos()Lnet/minecraft/util/math/BlockPos;"
			)
	)
	private BlockPos allowPartialBlocksToProvideSoulSpeed(Entity instance, Operation<BlockPos> original) {
		if (instance.getSteppingBlockState()
				.isIn(BlockTags.SOUL_SPEED_BLOCKS)
		) {
			return instance.getSteppingPos();
		} else {
			return instance.getVelocityAffectingPos();
		}
	}
}
