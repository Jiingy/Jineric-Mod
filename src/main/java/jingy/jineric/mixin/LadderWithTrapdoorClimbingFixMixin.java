package jingy.jineric.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LadderWithTrapdoorClimbingFixMixin {

   @WrapOperation(
           method = "canEnterTrapdoor",
           at = @At(
                   value = "INVOKE",
                   target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"
           )
   )
   private boolean jineric$fixPlayerClimbingWithTrapdoor(BlockState instance, Block block, Operation<Boolean> original) {
      return original.call(instance, block) || instance.isIn(JinericBlockTags.WOODEN_LADDERS);
   }
}
