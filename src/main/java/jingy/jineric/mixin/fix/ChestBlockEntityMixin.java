package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import jingy.jineric.block.WoodenChestBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CopperChestBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.LidOpenable;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChestBlockEntity.class)
public abstract class ChestBlockEntityMixin extends LootableContainerBlockEntity implements LidOpenable {
	protected ChestBlockEntityMixin(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
		super(blockEntityType, blockPos, blockState);
	}
	
	@ModifyReturnValue(
			method = "getContainerName",
			at = @At(value = "RETURN")
	)
	private Text enhanceVanillaChestScreenText(Text original) {
		BlockState blockState = this.getCachedState();
		Block chestBlock = blockState.getBlock();
		if (chestBlock instanceof WoodenChestBlock woodenChestBlock) {
			return Text.translatable("container." + woodenChestBlock.getWoodType().name() + "_chest");
		} else if (chestBlock instanceof CopperChestBlock copperChestBlock) {
			return Text.translatable("container." + copperChestBlock.getOxidationLevel().name().toLowerCase() + "_copper_chest");
		} else {
			return Text.translatable("container.chest");
		}
	}
}