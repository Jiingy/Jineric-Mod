package jingy.jineric.registry;

import jingy.jineric.sound.JinericBlockSoundGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

public class JinericBlockSettings extends Blocks {

	public static FabricBlockSettings soulSandstoneSettings() {
		return FabricBlockSettings
				.copyOf(STONE)
				.requiresTool()
				.strength(0.8f, 4f)
				.sounds(JinericBlockSoundGroup.SOUL_SANDSTONE)
				.mapColor(MapColor.BROWN)
				.sounds(JinericBlockSoundGroup.SOUL_SANDSTONE);
	}

	public static FabricBlockSettings obsidianSettings() {
		return FabricBlockSettings.copyOf(OBSIDIAN)
				.requiresTool()
				.strength(50.0F, 1200.0F).sounds(BlockSoundGroup.STONE);
	}
	public static FabricBlockSettings redstoneCampfireSettings() {
		return FabricBlockSettings
				.copyOf(OAK_WOOD)
				.strength(2.0F)
				.sounds(BlockSoundGroup.WOOD)
				.luminance(createLightLevelFromLitBlockState(7))
				.nonOpaque();
	}

	public static LeavesBlock JinericLeavesBlock(BlockSoundGroup soundGroup) {
		return new LeavesBlock(
				AbstractBlock.Settings.copy(OAK_LEAVES)
				.strength(0.2F)
				.ticksRandomly()
				.sounds(soundGroup)
				.nonOpaque()
				.allowsSpawning(Blocks::canSpawnOnLeaves)
				.suffocates(Blocks::never)
				.blockVision(Blocks::never)
		);
	}

	public static FabricBlockSettings snowBrickSettings() {
		return FabricBlockSettings
				.copyOf(SNOW_BLOCK)
				.strength(0.5F)
				.sounds(BlockSoundGroup.SNOW)
				.requiresTool()
				.mapColor(MapColor.WHITE)
				.hardness(0.4F);
	}
}
