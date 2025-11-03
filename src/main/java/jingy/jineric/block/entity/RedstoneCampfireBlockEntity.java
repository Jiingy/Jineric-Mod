package jingy.jineric.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Clearable;
import net.minecraft.util.math.BlockPos;

public class RedstoneCampfireBlockEntity extends CampfireBlockEntity implements Clearable {
	public RedstoneCampfireBlockEntity(BlockPos pos, BlockState state) {
		super(pos, state);
	}
	
	public int getRedstoneOutput() {
		int outputSignal = 0;
		for (ItemStack itemStack : this.getItemsBeingCooked()) {
			if (!itemStack.isEmpty()) {
				outputSignal = outputSignal + 1;
			}
		}
		return outputSignal * 2;
	}
}
