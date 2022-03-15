package jingy.jineric.block;

import jingy.jineric.sound.JinericSounds;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;

public class JinericBlockSettings {
	public static FabricBlockSettings jinericSoulSandstoneSettings() {
		return FabricBlockSettings
				.of(Material.STONE)
				.requiresTool()
				.strength(0.8f, 4f)
				.sounds(JinericSounds.SOUL_SANDSTONE);
	}
}
