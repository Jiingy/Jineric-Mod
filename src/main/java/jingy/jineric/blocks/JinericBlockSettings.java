package jingy.jineric.blocks;

import jingy.jineric.sounds.JinericSounds;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class JinericBlockSettings {

	public static Block JinericSoulSandstoneSettings() {
		return new Block(FabricBlockSettings
				.of(Material.STONE)
				.breakByTool(FabricToolTags.PICKAXES, 0)
				.requiresTool()
				.strength(0.8f, 4f)
				.sounds(JinericSounds.SOUL_SANDSTONE));
	}
	public static Block SandstoneSettings() {
		return new Block(FabricBlockSettings
				.of(Material.STONE)
				.breakByTool(FabricToolTags.PICKAXES, 0)
				.requiresTool()
				.strength(0.8f, 4f)
				.sounds(BlockSoundGroup.STONE));
	}
}
