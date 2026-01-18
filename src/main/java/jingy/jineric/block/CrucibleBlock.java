package jingy.jineric.block;

import com.mojang.serialization.MapCodec;
import jingy.jineric.block.entity.CrucibleBlockEntity;
import jingy.jineric.screen.CrucibleScreenHandler;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class CrucibleBlock extends BaseEntityBlock {
	
	public CrucibleBlock(BlockBehaviour.Properties settings) {
		super(settings);
	}
	
	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return null;
	}
	
	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
		if (!level.isClientSide() && level.getBlockEntity(pos) instanceof CrucibleBlockEntity crucibleBlockEntity) {
			player.openMenu(crucibleBlockEntity);
			return InteractionResult.PASS;
		}
		return super.useWithoutItem(state, level, pos, player, hit);
	}
	
	@Override
	protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (stack.is(ConventionalItemTags.RAW_MATERIALS)) {
			stack.shrink(1);
			return InteractionResult.PASS;
		} else {
			return super.useItemOn(stack, state, level, pos, player, hand, hit);
		}
	}
	
	@Override
	protected @Nullable MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
		return new SimpleMenuProvider((syncId, playerInventory, player) -> new CrucibleScreenHandler(syncId, playerInventory, ContainerLevelAccess.create(level, pos)), Component.literal("Crucible"));
	}
	
	@Override
	public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new CrucibleBlockEntity(pos, state);
	}
}
