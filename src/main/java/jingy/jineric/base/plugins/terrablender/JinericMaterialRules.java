package jingy.jineric.base.plugins.terrablender;

import com.google.common.collect.ImmutableList;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.world.biome.JinericBiomeKeys;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class JinericMaterialRules {
	public static final MaterialRules.MaterialCondition STONE_DEPTH_FLOOR_RANGE_1 = MaterialRules.stoneDepth(1, false, VerticalSurfaceType.FLOOR);
	private static final MaterialRules.MaterialRule GRASS_BLOCK = block(Blocks.GRASS_BLOCK);
	private static final MaterialRules.MaterialRule FULL_GRASS_BLOCK = block(JinericBlocks.FULL_GRASS_BLOCK);
	
	private static MaterialRules.MaterialRule block(Block block) {
		return MaterialRules.block(block.getDefaultState());
	}
	protected static MaterialRules.MaterialRule createJinericDefaultRule() {
		MaterialRules.MaterialCondition waterCheck = MaterialRules.water(-1, 0);
		MaterialRules.MaterialCondition isForFullGrass = MaterialRules.biome(JinericBiomeKeys.WISTFUL_FOREST);
		
		MaterialRules.MaterialRule fullGrassSequence = MaterialRules.sequence(
				MaterialRules.condition(
						waterCheck,
						MaterialRules.condition(
								MaterialRules.biome(JinericBiomeKeys.WISTFUL_FOREST),
								MaterialRules.sequence(
										MaterialRules.condition(
												MaterialRules.STONE_DEPTH_FLOOR,
												FULL_GRASS_BLOCK
										),
										MaterialRules.condition(
												STONE_DEPTH_FLOOR_RANGE_1,
												GRASS_BLOCK
										)
								)
						)
				)
		);
		
		MaterialRules.MaterialRule surfaceRules = MaterialRules.sequence(
				MaterialRules.condition(
						isForFullGrass,
						fullGrassSequence
				)
		);
		
		ImmutableList.Builder<MaterialRules.MaterialRule> builder = ImmutableList.builder();
		MaterialRules.MaterialRule surfaceRule = MaterialRules.condition(MaterialRules.surface(), surfaceRules);
		builder.add(surfaceRule);
		return MaterialRules.sequence(builder.build().toArray(MaterialRules.MaterialRule[]::new));
	}
}