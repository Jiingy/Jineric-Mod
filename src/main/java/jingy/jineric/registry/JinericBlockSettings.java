package jingy.jineric.registry;

import jingy.jineric.sound.JinericBlockSoundGroup;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class JinericBlockSettings extends Blocks {
	
	public static BlockBehaviour.Properties soulSandstoneSettings() {
		return BlockBehaviour.Properties
				.ofFullCopy(STONE)
				.requiresCorrectToolForDrops()
				.strength(0.8f, 4f)
				.sound(JinericBlockSoundGroup.SOUL_SANDSTONE)
				.mapColor(MapColor.COLOR_BROWN)
				.sound(JinericBlockSoundGroup.SOUL_SANDSTONE);
	}
	
	public static BlockBehaviour.Properties snowBrickSettings() {
		return BlockBehaviour.Properties
				.ofFullCopy(SNOW_BLOCK)
				.strength(0.5F)
				.sound(SoundType.SNOW)
				.requiresCorrectToolForDrops()
				.mapColor(MapColor.SNOW)
				.destroyTime(0.4F);
	}
}
