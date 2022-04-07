package jingy.jineric.block.custom;

import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class JinericWoodenButtonBlock extends AbstractButtonBlock {
	public JinericWoodenButtonBlock(Boolean powered, Settings settings) {
		super(powered, settings);
	}

	@Override
	protected SoundEvent getClickSound(boolean powered) {
		return SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON;
	}
}
