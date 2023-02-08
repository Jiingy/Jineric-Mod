package jingy.jineric.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
      if (state.isIn(BlockTags.LEAVES)) {
         cir.setReturnValue(BlockSoundGroup.AZALEA_LEAVES);
      }
   }
}
