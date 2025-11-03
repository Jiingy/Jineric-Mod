package net.jineric.jineric_mod.data;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.enums.WallShape;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public class BlockStateCreators extends BlockStateModelGenerator {
	public BlockStateCreators(Consumer<BlockModelDefinitionCreator> blockStateCollector, ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelSupplier> modelCollector) {
		super(blockStateCollector, itemModelOutput, modelCollector);
	}
	
	public static BlockModelDefinitionCreator createBorderWallBlockState(Block wallBlock, WeightedVariant postModel, WeightedVariant shortSideModel, WeightedVariant shortSideLineModel, WeightedVariant tallSideModel) {
		return MultipartBlockModelDefinitionCreator.create(wallBlock)
				.with(createMultipartConditionBuilder().put(Properties.UP, true), postModel)
				.with(
						or(
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.EAST_WALL_SHAPE, WallShape.NONE)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.WEST_WALL_SHAPE, WallShape.NONE)
								
						),
						shortSideLineModel
				)
				.with(
						or(
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.NONE)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.NONE)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW)
						),
						shortSideLineModel.apply(ROTATE_Y_90)
				)
				.with(
						or(
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
						),
						shortSideModel.apply(UV_LOCK)
				)
				.with(
						or(
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
						),
						shortSideModel.apply(ROTATE_Y_90).apply(UV_LOCK)
				)
				.with(
						or(
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
						),
						shortSideModel.apply(ROTATE_Y_180).apply(UV_LOCK)
				)
				.with(
						or(
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW),
								createMultipartConditionBuilder()
										.put(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.put(Properties.WEST_WALL_SHAPE, WallShape.LOW)
						),
						shortSideModel.apply(ROTATE_Y_270).apply(UV_LOCK)
				)
				.with(
						createMultipartConditionBuilder().put(Properties.NORTH_WALL_SHAPE, WallShape.TALL),
						tallSideModel.apply(UV_LOCK)
				)
				.with(
						createMultipartConditionBuilder().put(Properties.EAST_WALL_SHAPE, WallShape.TALL),
						tallSideModel.apply(ROTATE_Y_90).apply(UV_LOCK)
				)
				.with(
						createMultipartConditionBuilder().put(Properties.SOUTH_WALL_SHAPE, WallShape.TALL),
						tallSideModel.apply(ROTATE_Y_180).apply(UV_LOCK)
				)
				.with(
						createMultipartConditionBuilder().put(Properties.WEST_WALL_SHAPE, WallShape.TALL),
						tallSideModel.apply(ROTATE_Y_270).apply(UV_LOCK)
				);
	}
}
