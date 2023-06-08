package jingy.jineric.registry;

import jingy.jineric.sound.JinericBlockSoundGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.function.ToIntFunction;

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
				.allowsSpawning(JinericBlockSettings::canSpawnOnLeaves)
				.suffocates(JinericBlockSettings::never)
				.blockVision(JinericBlockSettings::never)
		);
	}

	public static FabricBlockSettings snowBrickSettings() {
		return FabricBlockSettings
				.of(Material.SNOW_BLOCK)
				.strength(0.5F)
				.sounds(BlockSoundGroup.SNOW)
				.requiresTool()
				.mapColor(MapColor.WHITE)
				.hardness(0.4F);
	}

	private static boolean always(BlockState state, BlockView blockView, BlockPos blockPos, EntityType<?> entityType) {
		return true;
	}

	private static boolean never(BlockState state, BlockView blockView, BlockPos blockPos) {
		return false;
	}

	private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
		return state -> state.get(Properties.LIT) ? litLevel : 0;
	}

	private static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
		return type == EntityType.OCELOT || type == EntityType.PARROT;
	}
}
