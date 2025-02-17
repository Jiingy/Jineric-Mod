package jingy.jineric.sound;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class JinericBlockSoundGroup {
	public static final BlockSoundGroup SOUL_SANDSTONE = new BlockSoundGroup(
			1.0F,
			1,
			JinericSoundEvents.BLOCK_SOUL_SANDSTONE_PLACE,
			JinericSoundEvents.BLOCK_SOUL_SANDSTONE_STEP,
			JinericSoundEvents.BLOCK_SOUL_SANDSTONE_PLACE,
			JinericSoundEvents.BLOCK_SOUL_SANDSTONE_STEP,
			JinericSoundEvents.BLOCK_SOUL_SANDSTONE_STEP
	);
	public static final BlockSoundGroup COBBLED_STONES = new BlockSoundGroup(
			1.0F,
			0.9F,
			SoundEvents.BLOCK_TUFF_BREAK,
			SoundEvents.BLOCK_TUFF_STEP,
			SoundEvents.BLOCK_TUFF_PLACE,
			SoundEvents.BLOCK_TUFF_HIT,
			SoundEvents.BLOCK_TUFF_FALL
	);
	public static final BlockSoundGroup WOODEN_ACCESSORIES = new BlockSoundGroup(
			0.75F,
			1.1F,
			SoundEvents.BLOCK_WOOD_BREAK,
			SoundEvents.BLOCK_WOOD_STEP,
			SoundEvents.BLOCK_WOOD_PLACE,
			SoundEvents.BLOCK_WOOD_HIT,
			SoundEvents.BLOCK_WOOD_FALL
	);
	public static final BlockSoundGroup WOODEN_BLOCKS = new BlockSoundGroup(
			1.0F,
			1.05F,
			SoundEvents.BLOCK_CHERRY_WOOD_BREAK,
			SoundEvents.BLOCK_CHERRY_WOOD_STEP,
			SoundEvents.BLOCK_CHERRY_WOOD_PLACE,
			SoundEvents.BLOCK_CHERRY_WOOD_HIT,
			SoundEvents.BLOCK_CHERRY_WOOD_FALL
	);
	public static final BlockSoundGroup WOODEN_LADDER = new BlockSoundGroup(
			0.75F,
			1.1F,
			SoundEvents.BLOCK_WOOD_BREAK,
			SoundEvents.BLOCK_LADDER_STEP,
			SoundEvents.BLOCK_WOOD_PLACE,
			SoundEvents.BLOCK_WOOD_HIT,
			SoundEvents.BLOCK_WOOD_FALL
	);
	public static final BlockSoundGroup NETHER_WOODEN_LADDER = new BlockSoundGroup(
			1.0F,
			1.0F,
			SoundEvents.BLOCK_NETHER_WOOD_BREAK,
			SoundEvents.BLOCK_LADDER_STEP,
			SoundEvents.BLOCK_NETHER_WOOD_PLACE,
			SoundEvents.BLOCK_NETHER_WOOD_HIT,
			SoundEvents.BLOCK_NETHER_WOOD_FALL
	);
	public static final BlockSoundGroup REDSTONE_DUST = new BlockSoundGroup(
			0.75F,
			1.1F,
			SoundEvents.BLOCK_SAND_BREAK,
			SoundEvents.BLOCK_SAND_STEP,
			SoundEvents.BLOCK_SAND_PLACE,
			SoundEvents.BLOCK_SAND_HIT,
			SoundEvents.BLOCK_SAND_FALL
	);
}
