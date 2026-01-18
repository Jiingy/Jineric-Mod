package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import jingy.jineric.block.WoodenChestBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CopperChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChestBlockEntity.class)
public abstract class ChestBlockEntityMixin extends RandomizableContainerBlockEntity implements LidBlockEntity {
	protected ChestBlockEntityMixin(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
		super(blockEntityType, blockPos, blockState);
	}
	
	@ModifyReturnValue(
			method = "getDefaultName",
			at = @At(value = "RETURN")
	)
	private Component enhanceVanillaChestScreenText(Component original) {
		BlockState blockState = this.getBlockState();
		Block chestBlock = blockState.getBlock();
		if (chestBlock instanceof WoodenChestBlock woodenChestBlock) {
			return Component.translatable("container." + woodenChestBlock.getWoodType().name() + "_chest");
		} else if (chestBlock instanceof CopperChestBlock copperChestBlock) {
			return Component.translatable("container." + copperChestBlock.getState().name().toLowerCase() + "_copper_chest");
		} else {
			return Component.translatable("container.chest");
		}
	}
}