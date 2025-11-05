package jingy.jineric.block;

import com.mojang.serialization.MapCodec;
import jingy.jineric.block.entity.CrucibleBlockEntity;
import jingy.jineric.screen.CrucibleScreenHandler;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CrucibleBlock extends BlockWithEntity {
	
	public CrucibleBlock(Settings settings) {
		super(settings);
	}
	
	@Override
	protected MapCodec<? extends BlockWithEntity> getCodec() {
		return null;
	}
	
	@Override
	protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
		if (!world.isClient() && world.getBlockEntity(pos) instanceof CrucibleBlockEntity crucibleBlockEntity) {
			player.openHandledScreen(crucibleBlockEntity);
			return ActionResult.PASS;
		}
		return super.onUse(state, world, pos, player, hit);
	}
	
	@Override
	protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (stack.isIn(ConventionalItemTags.RAW_MATERIALS)) {
			stack.decrement(1);
			return ActionResult.PASS;
		} else {
			return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
		}
	}
	
	@Override
	protected @Nullable NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
		return new SimpleNamedScreenHandlerFactory((syncId, playerInventory, player) -> new CrucibleScreenHandler(syncId, playerInventory, ScreenHandlerContext.create(world, pos)), Text.of("Crucible"));
	}
	
	@Override
	public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new CrucibleBlockEntity(pos, state);
	}
}
