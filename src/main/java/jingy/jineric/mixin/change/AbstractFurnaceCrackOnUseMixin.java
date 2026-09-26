package jingy.jineric.mixin.change;

import jingy.jineric.block.KilnBlock;
import jingy.jineric.block.entity.KilnBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceCrackOnUseMixin {

    @Inject(
            method = "serverTick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/entity/AbstractFurnaceBlockEntity;burn(Lnet/minecraft/core/NonNullList;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)V"
            )
    )
    private static void deteriorateBlockOnCook(ServerLevel level, BlockPos pos, BlockState state, AbstractFurnaceBlockEntity entity, CallbackInfo ci) {
        if (entity instanceof KilnBlockEntity kilnBlockEntity) {
            BlockState newBlockState = KilnBlock.damage(kilnBlockEntity.getBlockState());
            if (newBlockState == null) {
                level.removeBlock(pos, false);
                level.levelEvent(1029, pos, 0);
            } else {
                level.setBlock(pos, newBlockState, 2);
                level.levelEvent(1030, pos, 0);
            }
        }
    }
}
