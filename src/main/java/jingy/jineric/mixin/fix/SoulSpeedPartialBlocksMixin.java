package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.advancements.predicates.entity.MovementAffectedByPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MovementAffectedByPredicate.class)
public abstract class SoulSpeedPartialBlocksMixin {

	@WrapOperation(
			method = "matches",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/entity/Entity;getBlockPosBelowThatAffectsMyMovement()Lnet/minecraft/core/BlockPos;"
			)
	)
	private BlockPos allowPartialBlocksToProvideSoulSpeed(Entity instance, Operation<BlockPos> original) {
		if (instance.getBlockStateOn().is(BlockTags.SOUL_SPEED_BLOCKS)) {
			return instance.getOnPos();
		} else {
			return instance.getBlockPosBelowThatAffectsMyMovement();
		}
	}
}
