package net.jineric.jineric_mod.data;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WallSide;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public class BlockStateCreators extends BlockModelGenerators {
	public BlockStateCreators(Consumer<BlockModelDefinitionGenerator> blockStateCollector, ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelCollector) {
		super(blockStateCollector, itemModelOutput, modelCollector);
	}
	
	public static BlockModelDefinitionGenerator createBorderWallBlockState(Block wallBlock, MultiVariant postModel, MultiVariant shortSideModel, MultiVariant shortSideLineModel, MultiVariant tallSideModel) {
		return MultiPartGenerator.multiPart(wallBlock)
				.with(condition().term(BlockStateProperties.UP, true), postModel)
				.with(
						or(
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.EAST_WALL, WallSide.NONE)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.WEST_WALL, WallSide.NONE)
								
						),
						shortSideLineModel
				)
				.with(
						or(
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.NONE)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.NONE)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW)
						),
						shortSideLineModel.with(Y_ROT_90)
				)
				.with(
						or(
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.EAST_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.NONE, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.NONE, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.EAST_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.NONE, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.EAST_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW, WallSide.TALL)
						),
						shortSideModel.with(UV_LOCK)
				)
				.with(
						or(
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.NONE, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.NONE, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.NONE, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.NONE, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW, WallSide.TALL)
						),
						shortSideModel.with(Y_ROT_90).with(UV_LOCK)
				)
				.with(
						or(
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.WEST_WALL, WallSide.NONE, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.WEST_WALL, WallSide.NONE, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.WEST_WALL, WallSide.NONE, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW, WallSide.TALL),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW, WallSide.TALL)
						),
						shortSideModel.with(Y_ROT_180).with(UV_LOCK)
				)
				.with(
						or(
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.NONE, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW),
								condition()
										.term(BlockStateProperties.NORTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.EAST_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.SOUTH_WALL, WallSide.LOW, WallSide.TALL)
										.term(BlockStateProperties.WEST_WALL, WallSide.LOW)
						),
						shortSideModel.with(Y_ROT_270).with(UV_LOCK)
				)
				.with(
						condition().term(BlockStateProperties.NORTH_WALL, WallSide.TALL),
						tallSideModel.with(UV_LOCK)
				)
				.with(
						condition().term(BlockStateProperties.EAST_WALL, WallSide.TALL),
						tallSideModel.with(Y_ROT_90).with(UV_LOCK)
				)
				.with(
						condition().term(BlockStateProperties.SOUTH_WALL, WallSide.TALL),
						tallSideModel.with(Y_ROT_180).with(UV_LOCK)
				)
				.with(
						condition().term(BlockStateProperties.WEST_WALL, WallSide.TALL),
						tallSideModel.with(Y_ROT_270).with(UV_LOCK)
				);
	}
}
