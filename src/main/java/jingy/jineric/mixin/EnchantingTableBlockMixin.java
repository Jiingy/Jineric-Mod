package jingy.jineric.mixin;

import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.EnchantingTableBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnchantingTableBlock.class)
public abstract class EnchantingTableBlockMixin extends BlockWithEntity {
   public EnchantingTableBlockMixin(Settings settings) {
      super(settings);
   }

//   @Inject(method = "canAccessBookshelf(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/BlockPos;)Z", at = @At("HEAD"), cancellable = true)
//   private static void jineric$canAccessBookshelf(World world, BlockPos tablePos, BlockPos bookshelfOffset, CallbackInfoReturnable<Boolean> cir) {
//      if (world.getBlockState(tablePos.add(bookshelfOffset)).isIn(JinericBlockTags.WOODEN_BOOKSHELVES)
//      && world.isAir(tablePos.add(bookshelfOffset.getX() / 2, bookshelfOffset.getY(), bookshelfOffset.getZ() / 2))) {
//         cir.setReturnValue(true);
//      }
//   }
}
