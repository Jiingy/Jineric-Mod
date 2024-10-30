package jingy.jineric.registry;

import jingy.jineric.sound.JinericBlockSoundGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

public class JinericBlockSettings extends Blocks {

	public static AbstractBlock.Settings soulSandstoneSettings() {
		return AbstractBlock.Settings
				.copy(STONE)
				.requiresTool()
				.strength(0.8f, 4f)
				.sounds(JinericBlockSoundGroup.SOUL_SANDSTONE)
				.mapColor(MapColor.BROWN)
				.sounds(JinericBlockSoundGroup.SOUL_SANDSTONE);
	}

	public static AbstractBlock.Settings obsidianSettings() {
		return AbstractBlock.Settings.copy(OBSIDIAN)
				.requiresTool()
				.strength(50.0F, 1200.0F).sounds(BlockSoundGroup.STONE);
	}
	public static AbstractBlock.Settings redstoneCampfireSettings() {
		return AbstractBlock.Settings
				.copy(OAK_WOOD)
				.strength(2.0F)
				.sounds(BlockSoundGroup.WOOD)
				.luminance(createLightLevelFromLitBlockState(7))
				.nonOpaque();
	}

	public static AbstractBlock.Settings snowBrickSettings() {
		return AbstractBlock.Settings
				.copy(SNOW_BLOCK)
				.strength(0.5F)
				.sounds(BlockSoundGroup.SNOW)
				.requiresTool()
				.mapColor(MapColor.WHITE)
				.hardness(0.4F);
	}
}
