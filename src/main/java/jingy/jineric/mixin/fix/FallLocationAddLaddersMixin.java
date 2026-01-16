package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.world.damagesource.FallLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FallLocation.class)
public abstract class FallLocationAddLaddersMixin {
	
	@WrapOperation(
			method = "blockToFallLocation",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z",
					ordinal = 0
			)
	)
	private static boolean checkJinericLadders(BlockState instance, Block block, Operation<Boolean> original) {
		return original.call(instance, block) || instance.is(JinericBlockTags.LADDERS);
	}
}
