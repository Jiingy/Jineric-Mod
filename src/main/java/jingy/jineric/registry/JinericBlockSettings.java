package jingy.jineric.registry;

import jingy.jineric.sound.JinericSounds;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class JinericBlockSettings {
	public static AbstractBlock.Settings jinericSoulSandstoneSettings() {
		return AbstractBlock.Settings
				.of(Material.STONE)
				.requiresTool()
				.strength(0.8f, 4f)
				.sounds(JinericSounds.SOUL_SANDSTONE)
				.mapColor(MapColor.BROWN);
	}

	public static AbstractBlock.Settings Obsidian() {
		return AbstractBlock.Settings
				.of(JinericBlockMaterials.OBSIDIAN, MapColor.BLACK)
				.requiresTool()
				.strength(50.0F, 1200.0F).sounds(BlockSoundGroup.STONE);
	}
}
