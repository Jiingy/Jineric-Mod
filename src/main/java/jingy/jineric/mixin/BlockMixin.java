package jingy.jineric.mixin;

import jingy.jineric.sound.JinericBlockSoundGroup;
import jingy.jineric.tag.JinericBlockSoundTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.BlockSoundGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class BlockMixin {

   @Inject(method = "getSoundGroup", at = @At(value = "HEAD"), cancellable = true)
   private void jineric$CustomSoundGroups(BlockState state, CallbackInfoReturnable<BlockSoundGroup> cir) {
      if (state.isIn(JinericBlockSoundTags.LEAF_SOUNDS)) {
         cir.setReturnValue(BlockSoundGroup.AZALEA_LEAVES);
      }
      else if (state.isIn(JinericBlockSoundTags.WOODEN_BLOCK_SOUNDS)) {
         cir.setReturnValue(JinericBlockSoundGroup.WOODEN_BLOCKS);
      }
      else if (state.isIn(JinericBlockSoundTags.WOODEN_ACCESSORY_SOUNDS)) {
         cir.setReturnValue(JinericBlockSoundGroup.WOODEN_ACCESSORIES);
      }
//      else if (state.isIn(JinericBlockSoundTags.STONE_ORE_SOUNDS)) {
//         cir.setReturnValue(JinericBlockSoundGroup.STONE_ORES);
//      }
      else if (state.isIn(JinericBlockSoundTags.MUSHROOM_SOUNDS)) {
         cir.setReturnValue(BlockSoundGroup.NETHER_WART);
      }
      else if (state.isIn(JinericBlockSoundTags.VEGETATION_SOUNDS)) {
         cir.setReturnValue(BlockSoundGroup.MOSS_BLOCK);
      }
      else if (state.isOf(Blocks.REDSTONE_WIRE)) {
         cir.setReturnValue(JinericBlockSoundGroup.REDSTONE_DUST);
      }
      else if (state.isOf(Blocks.TRIPWIRE)) {
         cir.setReturnValue(BlockSoundGroup.WOOL);
      }



      else if (state.isOf(Blocks.COBBLESTONE) || state.isOf(Blocks.INFESTED_COBBLESTONE)) {
         cir.setReturnValue(JinericBlockSoundGroup.COBBLED_STONES);
      }
      else if (state.isIn(BlockTags.SAPLINGS)) {
         cir.setReturnValue(BlockSoundGroup.CHERRY_SAPLING);
      }
      else if (state.isIn(JinericBlockSoundTags.WOODEN_NETHER_CHEST_SOUNDS)) {
         cir.setReturnValue(BlockSoundGroup.NETHER_WOOD);
      }
      else if (state.isOf(Blocks.SKELETON_SKULL)
              || state.isOf(Blocks.SKELETON_WALL_SKULL)
              || state.isOf(Blocks.WITHER_SKELETON_SKULL)
              || state.isOf(Blocks.WITHER_SKELETON_WALL_SKULL)) {
         cir.setReturnValue(BlockSoundGroup.BONE);
      }
   }
}
