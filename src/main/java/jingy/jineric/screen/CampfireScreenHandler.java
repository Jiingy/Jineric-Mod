package jingy.jineric.screen;

import jingy.jineric.item.JinericItems;
import jingy.jineric.screen.slot.CampfireLogSlog;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipePropertySet;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

public class CampfireScreenHandler extends ScreenHandler implements ScreenHandlerListener {
	private final PlayerEntity player;
	private final Inventory inventory;
	private final World world;
	private final ScreenHandlerContext context;
	private final PropertyDelegate propertyDelegate;
	
	public CampfireScreenHandler(int syncId, PlayerInventory inventory) {
		this(syncId, inventory, ScreenHandlerContext.EMPTY, new SimpleInventory(5), new ArrayPropertyDelegate(2));
	}
	
	public CampfireScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context, Inventory inventory, PropertyDelegate propertyDelegate) {
		super(JinericScreenHandlerType.CAMPFIRE_SCREEN_HANDLER, syncId);
		checkSize(inventory, 5);
		checkDataCount(propertyDelegate, 2);
		this.inventory = inventory;
		this.propertyDelegate = propertyDelegate;
		this.player = playerInventory.player;
		this.world = player.getEntityWorld();
		this.context = context;
		
		//  Tinder Slot
		for (int index = 0; index < 4; index++) {
			Optional<BlockPos> blockPos = context.get((world1, blockPos1) -> blockPos1);

			//  4 Firing Slots
			int logSlotIndex = index + 1;
			this.addSlot(
					new CampfireLogSlog(
							this, player, context, inventory, index,
							logSlotIndex == 1 || logSlotIndex == 4 ? 100 : 60, // X
							logSlotIndex == 1 || logSlotIndex == 2 ? 55 : 15 // Y
					)
			);
		}
		//  TINDER SLOT
		this.addSlot(new Slot(inventory, 4, 80, 35) {
			@Override
			public boolean canInsert(ItemStack stack) {
				return stack.isOf(JinericItems.TINDER);
			}
		});
		//  PLAYER SLOTS
		this.addPlayerSlots(playerInventory, 8, 84);
	}
	
	public boolean isCampfireRecipeItem(ItemStack itemStack) {
		return this.world.getRecipeManager().getPropertySet(RecipePropertySet.CAMPFIRE_INPUT).canUse(itemStack);
	}
	
	//  CUSTOM
	
	
	//  OVERRIDES
	@Override
	public ItemStack quickMove(PlayerEntity player, int slot) {
		return null;
	}
	
	@Override
	public boolean canUse(PlayerEntity player) {
		return this.inventory.canPlayerUse(player);
	}
	
	@Override
	public ScreenHandlerType<?> getType() {
		return JinericScreenHandlerType.CAMPFIRE_SCREEN_HANDLER;
	}
	
	@Override
	public void onClosed(PlayerEntity player) {
		super.onClosed(player);
		this.inventory.onClose(player);
	}
	
	@Override
	public void onSlotUpdate(ScreenHandler handler, int slotId, ItemStack stack) {
	}
	
	@Override
	public void onPropertyUpdate(ScreenHandler handler, int property, int value) {
	}
}
