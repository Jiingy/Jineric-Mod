package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.FallLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FallLocation.class)
public abstract class FallLocationFixMixin {

    @WrapOperation(
            method = "fromBlockState",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z",
                    ordinal = 0
            )
    )
    private static boolean checkJinericLadders(BlockState instance, Block block, Operation<Boolean> original) {
        return original.call(instance, block) || instance.isIn(JinericBlockTags.LADDERS);
    }
}
