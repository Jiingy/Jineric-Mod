package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.goal.CatSitOnBlockGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CatSitOnBlockGoal.class)
public abstract class CatSitOnBlockGoalMixin {

   @WrapOperation(
           method = "isTargetPos",
           at = @At(
                   value = "INVOKE",
                   target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z",
                   ordinal = 0
           )
   )
   private boolean jineric$addJinericChests(BlockState instance, Block block, Operation<Boolean> original) {
      return original.call(instance, block) || instance.isIn(JinericBlockTags.CHESTS);
   }

   @WrapOperation(
           method = "isTargetPos",
           at = @At(
                   value = "INVOKE",
                   target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z",
                   ordinal = 1
           )
   )
   private boolean jineric$addRefinery(BlockState instance, Block block, Operation<Boolean> original) {
      return original.call(instance, block) || instance.isOf(JinericBlocks.REFINERY);
   }
}
