package jingy.jineric.sound;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

public class JinericBlockSoundGroup {
	public static final SoundType SOUL_SANDSTONE = new SoundType(
			1.0F,
			1,
			JinericSoundEvents.BLOCK_SOUL_SANDSTONE_PLACE,
			JinericSoundEvents.BLOCK_SOUL_SANDSTONE_STEP,
			JinericSoundEvents.BLOCK_SOUL_SANDSTONE_PLACE,
			JinericSoundEvents.BLOCK_SOUL_SANDSTONE_STEP,
			JinericSoundEvents.BLOCK_SOUL_SANDSTONE_STEP
	);
	public static final SoundType COBBLED_STONES = new SoundType(
			1.0F,
			0.9F,
			SoundEvents.TUFF_BREAK,
			SoundEvents.TUFF_STEP,
			SoundEvents.TUFF_PLACE,
			SoundEvents.TUFF_HIT,
			SoundEvents.TUFF_FALL
	);
	public static final SoundType WOODEN_ACCESSORIES = new SoundType(
			0.75F,
			1.1F,
			SoundEvents.WOOD_BREAK,
			SoundEvents.WOOD_STEP,
			SoundEvents.WOOD_PLACE,
			SoundEvents.WOOD_HIT,
			SoundEvents.WOOD_FALL
	);
	public static final SoundType WOODEN_BLOCKS = new SoundType(
			1.0F,
			1.05F,
			SoundEvents.CHERRY_WOOD_BREAK,
			SoundEvents.CHERRY_WOOD_STEP,
			SoundEvents.CHERRY_WOOD_PLACE,
			SoundEvents.CHERRY_WOOD_HIT,
			SoundEvents.CHERRY_WOOD_FALL
	);
	public static final SoundType WOODEN_LADDER = new SoundType(
			0.75F,
			1.0F,
			SoundEvents.WOOD_BREAK,
			SoundEvents.LADDER_STEP,
			SoundEvents.WOOD_PLACE,
			SoundEvents.WOOD_HIT,
			SoundEvents.WOOD_FALL
	);
	public static final SoundType NETHER_WOODEN_LADDER = new SoundType(
			1.0F,
			1.0F,
			SoundEvents.NETHER_WOOD_BREAK,
			SoundEvents.LADDER_STEP,
			SoundEvents.NETHER_WOOD_PLACE,
			SoundEvents.NETHER_WOOD_HIT,
			SoundEvents.NETHER_WOOD_FALL
	);
	public static final SoundType REDSTONE_DUST = new SoundType(
			0.75F,
			1.1F,
			SoundEvents.SAND_BREAK,
			SoundEvents.SAND_STEP,
			SoundEvents.SAND_PLACE,
			SoundEvents.SAND_HIT,
			SoundEvents.SAND_FALL
	);
}
