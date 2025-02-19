package jingy.jineric.mixin.change;

import net.minecraft.block.BellBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(BellBlock.class)
public abstract class BellBlockShapeMixin {
	@Unique
	private static final VoxelShape JINERIC_NORTH_SOUTH_LEFT_POST = Block.createCuboidShape(0.0, 0.0, 6.0, 2.0, 16.0, 10.0);
	@Unique
	private static final VoxelShape JINERIC_NORTH_SOUTH_RIGHT_POST = Block.createCuboidShape(14.0, 0.0, 6.0, 16.0, 16.0, 10.0);
	@Unique
	private static final VoxelShape JINERIC_EAST_WEST_LEFT_POST = Block.createCuboidShape(6.0, 0.0, 0.0, 10.0, 16.0, 2.0);
	@Unique
	private static final VoxelShape JINERIC_EAST_WEST_RIGHT_POST = Block.createCuboidShape(6.0, 0.0, 14.0, 10.0, 16.0, 16.0);
	@Unique
	private static final VoxelShape JINERIC_NORTH_SOUTH_POSTS = VoxelShapes.union(JINERIC_NORTH_SOUTH_LEFT_POST, JINERIC_NORTH_SOUTH_RIGHT_POST);
	@Unique
	private static final VoxelShape JINERIC_EAST_WEST_POSTS = VoxelShapes.union(JINERIC_EAST_WEST_LEFT_POST, JINERIC_EAST_WEST_RIGHT_POST);
	@Shadow
	@Final
	private static VoxelShape NORTH_SOUTH_WALLS_SHAPE;
	@Shadow
	private static final VoxelShape EAST_WEST_SHAPE = VoxelShapes.union(JINERIC_EAST_WEST_POSTS, NORTH_SOUTH_WALLS_SHAPE);
	@Shadow
	@Final
	private static VoxelShape EAST_WEST_WALLS_SHAPE;
	@Shadow
	private static final VoxelShape NORTH_SOUTH_SHAPE = VoxelShapes.union(JINERIC_NORTH_SOUTH_POSTS, EAST_WEST_WALLS_SHAPE);
}
