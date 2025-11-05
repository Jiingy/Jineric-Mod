package jingy.jineric.screen.slot;

import jingy.jineric.access.CampfireBlockEntityAccess;
import jingy.jineric.screen.CampfireScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.GameEvent;

import java.util.Optional;

public class CampfireLogSlog extends Slot {
	private final CampfireScreenHandler handler;
	private final Inventory inventory;
	private final PlayerEntity player;
	private final ScreenHandlerContext context;
	
	public CampfireLogSlog(CampfireScreenHandler handler, PlayerEntity player, ScreenHandlerContext context, Inventory inventory, int index, int x, int y) {
		super(inventory, index, x, y);
		this.handler = handler;
		this.player = player;
		this.context = context;
		this.inventory = inventory;
	}
	
	@Override
	public void onTakeItem(PlayerEntity player, ItemStack stack) {
		this.slotStacksToBlockEntity(ItemStack.EMPTY);
		super.onTakeItem(player, stack);
	}
	
	@Override
	public void setStack(ItemStack stack) {
		this.slotStacksToBlockEntity(stack);
		super.setStack(stack);
	}
	
	public void slotStacksToBlockEntity(ItemStack newStack) {
		int index = this.getIndex();
		this.context.run((world, pos) -> {
			if (world.getBlockEntity(pos) instanceof CampfireBlockEntity campfireBlockEntity && this.getIndex() < 4) {
				if (world instanceof ServerWorld serverWorld) {
					Optional<RecipeEntry<CampfireCookingRecipe>> optional = serverWorld.getRecipeManager().getFirstMatch(RecipeType.CAMPFIRE_COOKING, new SingleStackRecipeInput(newStack), world);
					this.emitUpdates(serverWorld, pos, campfireBlockEntity);
					
					if (optional.isEmpty() || newStack.isEmpty()) {
						return;
					}
					((CampfireBlockEntityAccess)campfireBlockEntity).jineric$setCookingTotalTime(index, ((CampfireCookingRecipe)((RecipeEntry<?>)optional.get()).value()).getCookingTime());
					((CampfireBlockEntityAccess)campfireBlockEntity).jineric$setCookingTime(index, 0);
					campfireBlockEntity.getItemsBeingCooked().set(index, newStack);
				}
			}
		});
	}
	
	public void emitUpdates(ServerWorld world, BlockPos pos, BlockEntity campfireBlockEntity) {
		world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, campfireBlockEntity.getCachedState()));
		campfireBlockEntity.markDirty();
		world.updateListeners(pos, campfireBlockEntity.getCachedState(), campfireBlockEntity.getCachedState(), Block.NOTIFY_ALL);
	}
	
	@Override
	public boolean canInsert(ItemStack itemStack) {
		return this.handler.isCampfireRecipeItem(itemStack) && this.inventory.getStack(this.getIndex()).isEmpty();
	}
	
	@Override
	public int getMaxItemCount() {
		return 1;
	}
	
	
}
