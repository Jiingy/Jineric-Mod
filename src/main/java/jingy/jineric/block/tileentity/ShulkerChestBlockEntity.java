package jingy.jineric.block.tileentity;

import java.util.stream.IntStream;

import jingy.jineric.base.Jineric;
import jingy.jineric.inventory.ShulkerChestInventory;
import jingy.jineric.screen.ShulkerChestScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class ShulkerChestBlockEntity extends LootableContainerBlockEntity implements NamedScreenHandlerFactory, ShulkerChestInventory {

	private static final int[] AVAILABLE_SLOTS = IntStream.range(0, 81).toArray();
	private DefaultedList<ItemStack> inventory;
	//private final ViewerCountManager stateManager;
	private int viewerCount;

	public ShulkerChestBlockEntity(BlockPos blockPos, BlockState state) {
		super(Jineric.SHULKER_CHEST_ENTITY, blockPos, state);
		this.inventory = DefaultedList.ofSize(81, ItemStack.EMPTY);

	}
	/*
		protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
			ShulkerChestEntity.playSound(world, pos, state, SoundEvents.BLOCK_CHEST_OPEN);

		}

		protected void onContainerClose(World world, BlockPos pos, BlockState state) {
			ShulkerChestEntity.playSound(world, pos, state, SoundEvents.BLOCK_CHEST_CLOSE);

		}

		static void playSound(World world, BlockPos pos, BlockState state, SoundEvent soundEvent) {
			world.playSound((PlayerEntity), soundEvent, SoundCategory.BLOCKS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);

		}
	*/
	@Override
	public int size() {
		return this.inventory.size();
	}

	@Override
	public DefaultedList<ItemStack> getItems() {
		return inventory;
	}
/*
	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
		return new ShulkerChestScreenHandler(syncId, playerInventory, this);
	}
*/
	@Override
	protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
		return new ShulkerChestScreenHandler(syncId, playerInventory, this);
	}

	@Override
	public Text getDisplayName() {
		return new TranslatableText(getCachedState().getBlock().getTranslationKey());
	}

	@Override
	public void onOpen(PlayerEntity player) {
		if (!player.isSpectator()) {
			if (this.viewerCount < 0) {
				this.viewerCount = 0;
			}

			++this.viewerCount;
			this.world.addSyncedBlockEvent(this.pos, this.getCachedState().getBlock(), 1, this.viewerCount);
			if (this.viewerCount == 1) {
				this.world.emitGameEvent(player, GameEvent.CONTAINER_OPEN, this.pos);
				this.world.playSound((PlayerEntity)null, this.pos, SoundEvents.BLOCK_SHULKER_BOX_OPEN, SoundCategory.BLOCKS, 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
			}
		}

	}
/*
	@Override
	public void onOpen(PlayerEntity player) {
		if (!this.removed && !player.isSpectator()) {
			this.stateManager.openContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
		}

	}
*/
	@Override
	public void onClose(PlayerEntity player) {
		if (!player.isSpectator()) {
			--this.viewerCount;
			this.world.addSyncedBlockEvent(this.pos, this.getCachedState().getBlock(), 1, this.viewerCount);
			if (this.viewerCount <= 0) {
				this.world.emitGameEvent(player, GameEvent.CONTAINER_CLOSE, this.pos);
				this.world.playSound((PlayerEntity)null, this.pos, SoundEvents.BLOCK_SHULKER_BOX_CLOSE, SoundCategory.BLOCKS, 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
			}
		}

	}

	@Override
	protected Text getContainerName() {
		return new TranslatableText("container.shulkerChest");
	}

	@Override
	public void readNbt(NbtCompound nbt) {
		super.readNbt(nbt);
		this.readInventoryNbt(nbt);
	}

	@Override
	public void writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
		if (!this.serializeLootTable(nbt)) {
			Inventories.writeNbt(nbt, this.inventory, false);
		}
	}

	public void readInventoryNbt(NbtCompound nbt) {
		this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
		if (!this.deserializeLootTable(nbt) && nbt.contains("Items", 9)) {
			Inventories.readNbt(nbt, this.inventory);
		}
	}

	@Override
	protected DefaultedList<ItemStack> getInvStackList() {
		return this.inventory;
	}

	@Override
	protected void setInvStackList(DefaultedList<ItemStack> list) {
		this.inventory = list;
	}

	protected void onInvOpenOrClose(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
		Block block = state.getBlock();
		world.addSyncedBlockEvent(pos, block, 1, newViewerCount);
	}
}
