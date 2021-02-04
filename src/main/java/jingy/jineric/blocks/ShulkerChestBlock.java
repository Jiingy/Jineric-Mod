package jingy.jineric.blocks;

import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.awt.*;

public class ShulkerChestBlock extends BlockWithEntity {
        public ShulkerChestBlock(Settings settings) {
            super(settings);
        }

        // A side effect of extending BlockWithEntity is it changes the render type to INVISIBLE, so we have to revert this
        @Override
        public BlockRenderType getRenderType(BlockState state) {
            return BlockRenderType.MODEL;
        }

        // We will create the BlockEntity later.
        @Override
        public BlockEntity createBlockEntity(BlockView view) {
            return new ShulkerChestBlockEntity();
        }

        @Override
        public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
            if (itemStack.hasCustomName()) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity instanceof ShulkerChestBlockEntity) {
                    ((ShulkerChestBlockEntity)blockEntity).setCustomName(itemStack.getName());
                }
            }
        }

        @Override
        public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
            if (!world.isClient) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity instanceof ShulkerChestBlockEntity) {
                    ContainerProviderRegistry.INSTANCE.openContainer(JinericBlocks.SHULKER_CHEST, player, buf -> buf.writeBlockPos(pos));
                }
            }
            return ActionResult.SUCCESS;
        }

        // Scatter the items in the chest when it is removed.
        public void onBlockRemoved(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
            if (state.getBlock() != newState.getBlock()) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity instanceof ShulkerChestBlockEntity) {
                    ItemScatterer.spawn(world, pos, (ShulkerChestBlockEntity)blockEntity);
                    // update comparators
                    world.updateHorizontalAdjacent(pos, this);
                }
                super.onBlockRemoved(state, world, pos, newState, moved);
            }
        }

        @Override
        public boolean hasComparatorOutput(BlockState state) {
            return true;
        }

        @Override
        public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
            return Container.calculateComparatorOutput(world.getBlockEntity(pos));
        }

    public static void init() {

    }
}
