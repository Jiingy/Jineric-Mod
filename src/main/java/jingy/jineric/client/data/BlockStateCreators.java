package jingy.jineric.client.data;

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
										.put(Properties.WEST_WALL_SHAPE, WallShape.NONE),
								
						)
				)
				
//				.with(
//						When.create().set(Properties.UP, true),
//						BlockStateVariant.create().put(VariantSettings.MODEL, postModel))
				.with(
						When.anyOf(
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.EAST_WALL_SHAPE, WallShape.NONE)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.WEST_WALL_SHAPE, WallShape.NONE)
						), BlockStateVariant.create().put(VariantSettings.MODEL, shortSideLineModel)
				)
				.with(
						When.anyOf(
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.NONE)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.NONE)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW)
						),
						BlockStateVariant.create()
								.put(VariantSettings.MODEL, shortSideLineModel)
								.put(VariantSettings.Y, VariantSettings.Rotation.R90)
				)
				.with(
						When.anyOf(
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
						),
						BlockStateVariant.create()
								.put(VariantSettings.MODEL, shortSideModel)
								.put(VariantSettings.Y, VariantSettings.Rotation.R0)
								.put(VariantSettings.UVLOCK, true)
				)
				.with(
						When.anyOf(
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
						),
						BlockStateVariant.create()
								.put(VariantSettings.MODEL, shortSideModel)
								.put(VariantSettings.Y, VariantSettings.Rotation.R90)
								.put(VariantSettings.UVLOCK, true)
				)
				.with(
						When.anyOf(
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.WEST_WALL_SHAPE, WallShape.NONE, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
						),
						BlockStateVariant.create()
								.put(VariantSettings.MODEL, shortSideModel)
								.put(VariantSettings.Y, VariantSettings.Rotation.R180)
								.put(VariantSettings.UVLOCK, true)
				)
				.with(
						When.anyOf(
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.NONE, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW),
								When.create()
										.set(Properties.NORTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.EAST_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.SOUTH_WALL_SHAPE, WallShape.LOW, WallShape.TALL)
										.set(Properties.WEST_WALL_SHAPE, WallShape.LOW)
						),
						BlockStateVariant.create()
								.put(VariantSettings.MODEL, shortSideModel)
								.put(VariantSettings.Y, VariantSettings.Rotation.R270)
								.put(VariantSettings.UVLOCK, true)
				)
				.with(
						When.create().set(Properties.NORTH_WALL_SHAPE, WallShape.TALL),
						BlockStateVariant.create()
								.put(VariantSettings.MODEL, tallSideModel)
								.put(VariantSettings.UVLOCK, true)
				)
				.with(
						When.create().set(Properties.EAST_WALL_SHAPE, WallShape.TALL),
						BlockStateVariant.create()
								.put(VariantSettings.MODEL, tallSideModel)
								.put(VariantSettings.Y, VariantSettings.Rotation.R90)
								.put(VariantSettings.UVLOCK, true)
				)
				.with(
						When.create().set(Properties.SOUTH_WALL_SHAPE, WallShape.TALL),
						BlockStateVariant.create()
								.put(VariantSettings.MODEL, tallSideModel)
								.put(VariantSettings.Y, VariantSettings.Rotation.R180)
								.put(VariantSettings.UVLOCK, true)
				)
				.with(
						When.create().set(Properties.WEST_WALL_SHAPE, WallShape.TALL),
						BlockStateVariant.create()
								.put(VariantSettings.MODEL, tallSideModel)
								.put(VariantSettings.Y, VariantSettings.Rotation.R270)
								.put(VariantSettings.UVLOCK, true)
				)
				;
	}
}
