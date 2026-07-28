package jingy.jineric.screen.slot;

import jingy.jineric.base.injected_interfaces.JmCampfireBlockEntity;
import jingy.jineric.screen.CampfireScreenHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Optional;

public class CampfireLogSlog extends Slot {
	private final CampfireScreenHandler handler;
	private final Player player;
	private final ContainerLevelAccess context;
	
	public CampfireLogSlog(CampfireScreenHandler handler, Player player, ContainerLevelAccess context, Container inventory, int index, int x, int y) {
		super(inventory, index, x, y);
		this.handler = handler;
		this.player = player;
		this.context = context;
	}
	
	@Override
	public void onTake(Player player, ItemStack stack) {
		this.slotStacksToBlockEntity(ItemStack.EMPTY);
		super.onTake(player, stack);
	}
	
	@Override
	public void setByPlayer(ItemStack stack) {
		this.slotStacksToBlockEntity(stack);
		super.setByPlayer(stack);
	}
	
	public void slotStacksToBlockEntity(ItemStack newStack) {
		int index = this.getContainerSlot();
		this.context.execute((world, pos) -> {
			if (world.getBlockEntity(pos) instanceof CampfireBlockEntity campfireBlockEntity && index < 4) {
				if (world instanceof ServerLevel serverWorld) {
					Optional<RecipeHolder<CampfireCookingRecipe>> optional = serverWorld.recipeAccess().getRecipeFor(RecipeType.CAMPFIRE_COOKING, new SingleRecipeInput(newStack), world);
					this.emitUpdates(serverWorld, pos, campfireBlockEntity);
					
					if (optional.isEmpty() || newStack.isEmpty()) {
						return;
					}
					((JmCampfireBlockEntity)campfireBlockEntity).jineric$setCookingTotalTime(index, ((CampfireCookingRecipe)((RecipeHolder<?>)optional.get()).value()).cookingTime());
					((JmCampfireBlockEntity)campfireBlockEntity).jineric$setCookingTime(index, 0);
					campfireBlockEntity.getItems().set(index, newStack);
				}
			}
		});
	}
	
	public void emitUpdates(ServerLevel world, BlockPos pos, BlockEntity campfireBlockEntity) {
		world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, campfireBlockEntity.getBlockState()));
		campfireBlockEntity.setChanged();
		world.sendBlockUpdated(pos, campfireBlockEntity.getBlockState(), campfireBlockEntity.getBlockState(), Block.UPDATE_ALL);
	}
	
	@Override
	public boolean mayPlace(ItemStack itemStack) {
		return this.handler.isCampfireRecipeItem(itemStack) && this.container.getItem(this.getContainerSlot()).isEmpty();
	}
	
	@Override
	public int getMaxStackSize() {
		return 1;
	}
}
