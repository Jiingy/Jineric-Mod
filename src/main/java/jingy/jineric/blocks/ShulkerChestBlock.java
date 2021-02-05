package jingy.jineric.blocks;

import jingy.jineric.Jineric;
import jingy.jineric.blockentities.ShulkerChestBlockEntity;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ShulkerChestBlock extends BlockWithEntity {
        protected ShulkerChestBlock(Settings settings) {
            super(settings);
        }

        @Override
        public BlockEntity createBlockEntity(BlockView view) {
            return new ShulkerChestBlockEntity();
        }

        @Override
        public BlockRenderType getRenderType(BlockState state) {
            return BlockRenderType.MODEL;
        }

        @Override
        public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
            if (!world.isClient) {
                NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
                if (screenHandlerFactory != null) {
                    player.openHandledScreen(screenHandlerFactory);
                }
            }
            return ActionResult.SUCCESS;
        }

        @Override
        public void onStateReplaced (BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
            if (state.getBlock() != newState.getBlock()) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity instanceof ShulkerChestBlockEntity) {
                    ItemScatterer.spawn(world, pos, (Inventory) blockEntity);
                    world.updateComparators(pos,this);
                }
                super.onStateReplaced(state, world, pos, newState, moved);
            }
        }

        @Override
        public boolean hasComparatorOutput(BlockState state) {
            return true;
        }

        @Override
        public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
            return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
        }

}

