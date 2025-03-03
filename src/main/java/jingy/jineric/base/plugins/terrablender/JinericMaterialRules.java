package jingy.jineric.base.plugins.terrablender;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.world.biome.JinericBiomeKeys;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class JinericMaterialRules {
	private static final MaterialRules.MaterialRule DIRT = materialRule(Blocks.DIRT);
	private static final MaterialRules.MaterialRule FULL_GRASS_BLOCK = materialRule(JinericBlocks.FULL_GRASS_BLOCK);
	private static final MaterialRules.MaterialCondition WATER_CHECK = MaterialRules.water(-1, 0);
	
	public static final MaterialRules.MaterialRule FULL_GRASS_BLOCK_SURFACE = MaterialRules.sequence(
			MaterialRules.condition(WATER_CHECK, MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, FULL_GRASS_BLOCK)),
			MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, DIRT)
	);
	
	public static final MaterialRules.MaterialRule WISTFUL_FORESTS = MaterialRules.sequence(
			MaterialRules.condition(MaterialRules.biome(JinericBiomeKeys.WISTFUL_FOREST), FULL_GRASS_BLOCK_SURFACE),
			MaterialRules.condition(MaterialRules.biome(JinericBiomeKeys.WISTFUL_FLOWER_FOREST), FULL_GRASS_BLOCK_SURFACE)
	);
	
	protected static MaterialRules.MaterialRule makeRules() {
		return MaterialRules.sequence(
				WISTFUL_FORESTS
		);
	}
	
	private static MaterialRules.MaterialRule materialRule(Block block) {
		return MaterialRules.block(block.getDefaultState());
	}
}
