package jingy.jineric.mixin;

import jingy.jineric.block.JinericBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.predicate.block.BlockStatePredicate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Predicate;

@Debug(export = true)
@Mixin(EatGrassGoal.class)
public abstract class EatGrassGoalMixin extends Goal {

   @Shadow @Final private World world;
   @Shadow @Final private MobEntity mob;
   @Mutable
   @Shadow
   private int timer;

   @Shadow @Final private static final Predicate<BlockState> GRASS_PREDICATE = BlockStatePredicate.forBlock(Blocks.GRASS).or(BlockStatePredicate.forBlock(JinericBlocks.FULL_GRASS_BLOCK));

   @Inject(method = "canStart", at = @At(value = "HEAD", target = "net/minecraft/block/BlockState.isOf(Lnet/minecraft/block/Block;)Z"), cancellable = true)
   public void jineric$canStart(CallbackInfoReturnable<Boolean> cir) {
      if (this.mob.getRandom().nextInt(this.mob.isBaby() ? 50 : 1000) != 0) {
         cir.setReturnValue(false);
      } else {
         BlockPos blockPos = this.mob.getBlockPos();
         if (GRASS_PREDICATE.test(this.world.getBlockState(blockPos))) {
            cir.setReturnValue(true);
         } else {
            cir.setReturnValue(this.world.getBlockState(blockPos.down()).isOf(Blocks.GRASS_BLOCK) || this.world.getBlockState(blockPos.down()).isOf(JinericBlocks.FULL_GRASS_BLOCK));
         }
      }
      cir.cancel();
   }

   @Inject(method = "tick", at = @At(value = "HEAD"), cancellable = true)
   public void jineric$tick(CallbackInfo ci) {
      this.timer = Math.max(0, this.timer - 1);
      if (this.timer == this.getTickCount(4)) {
         BlockPos blockPos = this.mob.getBlockPos();
         if (GRASS_PREDICATE.test(this.world.getBlockState(blockPos))) {
            if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
               this.world.breakBlock(blockPos, false);
            }

            this.mob.onEatingGrass();
         } else {
            BlockPos blockPos2 = blockPos.down();
            if (this.world.getBlockState(blockPos2).isOf(Blocks.GRASS_BLOCK)) {
               if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                  this.world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, blockPos2, Block.getRawIdFromState(Blocks.GRASS_BLOCK.getDefaultState()));
                  this.world.setBlockState(blockPos2, Blocks.DIRT.getDefaultState(), Block.NOTIFY_LISTENERS);
               }

               this.mob.onEatingGrass();
            }
            if (this.world.getBlockState(blockPos2).isOf(JinericBlocks.FULL_GRASS_BLOCK)) {
               if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                  this.world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, blockPos2, Block.getRawIdFromState(JinericBlocks.FULL_GRASS_BLOCK.getDefaultState()));
                  this.world.setBlockState(blockPos2, Blocks.DIRT.getDefaultState(), Block.NOTIFY_LISTENERS);
               }

               this.mob.onEatingGrass();
            }
         }
      }
      ci.cancel();
   }
}
