package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.block.JinericBlocks;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.Predicate;

@Mixin(EatBlockGoal.class)
public abstract class EatJmGrassBlockMixin extends Goal {
	@Mutable @Shadow @Final private static Predicate<BlockState> IS_EDIBLE;
	static {
		IS_EDIBLE = IS_EDIBLE.or(BlockStatePredicate.forBlock(JinericBlocks.GRASS_BLOCK));
	}
	
	@WrapOperation(
			method = "canUse",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"
			)
	)
	private boolean canStartJmGrassBlockCheck(BlockState instance, Block block, Operation<Boolean> original) {
		return original.call(instance, block) || instance.is(JinericBlocks.GRASS_BLOCK);
	}
	
	@WrapOperation(
			method = "tick",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"
			)
	)
	private boolean tickJmGrassBlockCheck(BlockState instance, Block block, Operation<Boolean> original) {
		return original.call(instance, block) || instance.is(JinericBlocks.GRASS_BLOCK);
	}
	
	@ModifyArg(
			method = "tick",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/level/block/Block;getId(Lnet/minecraft/world/level/block/state/BlockState;)I"
			)
	)
	private BlockState jmGrassBlockRawIdFromState(@Nullable BlockState state) {
		return JinericBlocks.GRASS_BLOCK.defaultBlockState();
	}
}
