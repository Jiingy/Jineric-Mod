package jingy.jineric.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Clearable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RedstoneCampfireBlockEntity extends CampfireBlockEntity {
	public RedstoneCampfireBlockEntity(BlockPos pos, BlockState state) {
		super(pos, state);
	}
	
	public int getRedstoneOutput() {
		int outputSignal = 0;
		for (ItemStack itemStack : this.getItems()) {
			if (!itemStack.isEmpty()) {
				outputSignal = outputSignal + 1;
			}
		}
		return outputSignal * 2;
	}
	
	@Override
	public Component getDisplayName() {
		return Component.translatable("container.redstone_campfire");
	}
}
