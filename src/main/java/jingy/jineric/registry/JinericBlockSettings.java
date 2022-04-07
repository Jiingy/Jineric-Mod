package jingy.jineric.registry;

import jingy.jineric.sound.JinericSounds;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.function.ToIntFunction;

public class JinericBlockSettings extends Blocks {

	public static FabricBlockSettings soulSandstoneSettings() {
		return FabricBlockSettings
				.of(Material.STONE)
				.requiresTool()
				.strength(0.8f, 4f)
				.sounds(JinericSounds.SOUL_SANDSTONE)
				.mapColor(MapColor.BROWN);
	}

	public static FabricBlockSettings obsidianSettings() {
		return FabricBlockSettings
				.of(JinericBlockMaterials.OBSIDIAN, MapColor.BLACK)
				.requiresTool()
				.strength(50.0F, 1200.0F).sounds(BlockSoundGroup.STONE);
	}

	public static FabricBlockSettings shulkerChestSettings() {
		return FabricBlockSettings
				.of(JinericBlockMaterials.SHULKER_CHEST_MATERIAL, MapColor.PURPLE)
				.requiresTool()
				.strength(2.0F, 2.5F)
				.sounds(BlockSoundGroup.STONE)
				.suffocates(JinericBlockSettings::never)
				.blockVision(JinericBlockSettings::never);
	}
	public static FabricBlockSettings redstoneLanternSettings() {
		return FabricBlockSettings
				.of(Material.METAL)
				.requiresTool()
				.strength(3.5F)
				.sounds(BlockSoundGroup.LANTERN)
				.luminance(7)
				.nonOpaque();
	}
	public static FabricBlockSettings redstoneCampfireSettings() {
		return FabricBlockSettings
				.of(Material.WOOD, MapColor.BROWN)
				.requiresTool()
				.strength(2.0F)
				.sounds(BlockSoundGroup.WOOD)
				.luminance(createLightLevelFromLitBlockState(7))
				.nonOpaque()
				.suffocates(JinericBlockSettings::never)
				.blockVision(JinericBlockSettings::never);
	}

	public static FabricBlockSettings JinericLeavesBlock(BlockSoundGroup soundGroup) {
		return FabricBlockSettings
				.of(Material.LEAVES, MapColor.DARK_GREEN)
				.strength(0.2F)
				.ticksRandomly()
				.sounds(soundGroup)
				.nonOpaque()
				.allowsSpawning(JinericBlockSettings::always)
				.suffocates(JinericBlockSettings::never)
				.blockVision(JinericBlockSettings::never);

	}

	private static boolean always(BlockState state, BlockView blockView, BlockPos blockPos, EntityType<?> entityType) {
		return true;
	}

	private static boolean never(BlockState state, BlockView blockView, BlockPos blockPos) {
		return (boolean)false;
	}

	private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
		return state -> state.get(Properties.LIT) ? litLevel : 0;
	}
}
