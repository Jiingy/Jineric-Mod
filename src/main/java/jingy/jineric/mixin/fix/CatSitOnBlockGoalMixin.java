package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.world.entity.ai.goal.CatSitOnBlockGoal;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CatSitOnBlockGoal.class)
public abstract class CatSitOnBlockGoalMixin {
	
	@WrapOperation(
			method = "isValidTarget",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z",
					ordinal = 0
			)
	)
	private boolean jineric$addJinericChests(BlockState instance, Block block, Operation<Boolean> original) {
		return original.call(instance, block) || instance.is(JinericBlockTags.CHESTS);
	}
	
	@WrapOperation(
			method = "isValidTarget",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z",
					ordinal = 1
			)
	)
	private boolean jineric$addRefinery(BlockState instance, Block block, Operation<Boolean> original) {
		return original.call(instance, block) || instance.is(JinericBlocks.REFINERY);
	}
}
