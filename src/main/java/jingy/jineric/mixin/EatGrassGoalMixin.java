package jingy.jineric.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.block.JinericBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.predicate.block.BlockStatePredicate;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.Predicate;

@Debug(export = true)
@Mixin(EatGrassGoal.class)
public abstract class EatGrassGoalMixin extends Goal {

   @Mutable
   @Shadow @Final
   public static Predicate<BlockState> GRASS_PREDICATE;

   static {
      GRASS_PREDICATE = GRASS_PREDICATE.or(BlockStatePredicate.forBlock(JinericBlocks.FULL_GRASS_BLOCK));
   }

   @WrapOperation(
           method = "canStart",
           at = @At(value = "INVOKE", target = "net/minecraft/block/BlockState.isOf(Lnet/minecraft/block/Block;)Z")
   )
   private boolean jineric$canStartFullGrassBlockCheck(BlockState instance, Block block, Operation<Boolean> original) {
      return original.call(instance, block) || instance.isOf(JinericBlocks.FULL_GRASS_BLOCK);
   }

   @WrapOperation(
           method = "tick",
           at = @At(value = "INVOKE", target = "net/minecraft/block/BlockState.isOf(Lnet/minecraft/block/Block;)Z")
   )
   private boolean jineric$tickFullGrassBlockCheck(BlockState instance, Block block, Operation<Boolean> original) {
      return original.call(instance, block) || instance.isOf(JinericBlocks.FULL_GRASS_BLOCK);
   }

   @ModifyArg(
           method = "tick",
           at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRawIdFromState(Lnet/minecraft/block/BlockState;)I")
   )
   private BlockState jineric$FullGrassRawIdFromState(@Nullable BlockState state) {
      return JinericBlocks.FULL_GRASS_BLOCK.getDefaultState();
   }
}
