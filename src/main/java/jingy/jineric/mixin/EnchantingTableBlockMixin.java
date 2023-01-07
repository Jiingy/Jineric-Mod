package jingy.jineric.mixin;

import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.EnchantingTableBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EnchantingTableBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantingTableBlock.class)
public abstract class EnchantingTableBlockMixin extends BlockWithEntity {
   public EnchantingTableBlockMixin(Settings settings) {
      super(settings);
   }

   @Inject(method = "canAccessBookshelf(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/BlockPos;)Z", at = @At("HEAD"), cancellable = true)
   private static void jineric$canAccessBookshelf(World world, BlockPos tablePos, BlockPos bookshelfOffset, CallbackInfoReturnable<Boolean> cir) {
      if (world.getBlockState(tablePos.add(bookshelfOffset)).isIn(JinericBlockTags.WOODEN_BOOKSHELVES)
      && world.isAir(tablePos.add(bookshelfOffset.getX() / 2, bookshelfOffset.getY(), bookshelfOffset.getZ() / 2))) {
         cir.setReturnValue(true);
      }
   }

   @Nullable
   @Override
   public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
      return new EnchantingTableBlockEntity(pos, state);
   }
}
