package jingy.jineric.mixin.add;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.access.CampfireBlockEntityAccess;
import jingy.jineric.screen.CampfireScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.component.ComponentMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.util.Clearable;
import net.minecraft.util.Nameable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CampfireBlockEntity.class)
public abstract class ScreenForCampfireBlockEntityMixin extends BlockEntity implements Inventory, NamedScreenHandlerFactory, Nameable, Clearable, CampfireBlockEntityAccess {
	//  VANILLA
	@Shadow public abstract DefaultedList<ItemStack> getItemsBeingCooked();
	@Shadow protected abstract void updateListeners();
	@Shadow @Final private DefaultedList<ItemStack> itemsBeingCooked;
	@Shadow @Final private int[] cookingTimes;
	@Shadow @Final private int[] cookingTotalTimes;
	
	//  MODDED
	int[] cookingTimesCopy = new int[4];
	int[] cookingTotalTimesCopy = new int[4];
	
	//TOOD: ADD
	@Nullable private Text customName;
	
	@Unique
	protected final ArrayPropertyDelegate propertyDelegate = new ArrayPropertyDelegate(4) {
		@Override
		public int get(int index) {
			return switch (index) {
//				case 0 -> ScreenForCampfireBlockEntityMixin.this.cookingTimesCopy;
//				case 1 -> (CampfireBlockEntity) (Object) ScreenForCampfireBlockEntityMixin.this.cookingTotalTimesCopy;
				default -> 0;
			};
		}
		
		@Override
		public void set(int index, int value) {
		
		}
		
		@Override
		public int size() {
			return 2;
		}
	};
	
	public ScreenForCampfireBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}
	
//  CORRECTION FOR EXPANDING itemsBeingCooked FROM 4 TO 5
	@ModifyArg(
			method = "<init>",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/util/collection/DefaultedList;ofSize(ILjava/lang/Object;)Lnet/minecraft/util/collection/DefaultedList;"
			)
	)
	private int expandSizeOfInventoryToFive(int size) {
		return 5;
	}
	
	@WrapOperation(
			method = "litServerTick",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/util/collection/DefaultedList;size()I"
			)
	)
	private static int litTickOnlyCookItems(DefaultedList<ItemStack> instance, Operation<Integer> original) {
		return 4;
	}
	
	@WrapOperation(
			method = "unlitServerTick",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/util/collection/DefaultedList;size()I")
	)
	private static int unlitTickOnlyCookItems(DefaultedList<ItemStack> instance, Operation<Integer> original) {
		return 4;
	}
	
	@WrapOperation(
			method = "clientTick",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/util/collection/DefaultedList;size()I")
	)
	private static int clientTickOnlyCookItems(DefaultedList<ItemStack> instance, Operation<Integer> original) {
		return 4;
	}
	
	@WrapOperation(
			method = "addItem",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/util/collection/DefaultedList;size()I")
	)
	private static int addItemOnlyCookItems(DefaultedList<ItemStack> instance, Operation<Integer> original) {
		return 4;
	}
	
	
//  NEW METHODS
	//  cookingTimes
	@Unique
	@Override
	public int jineric$getCookingTime(int index) {
		return cookingTimes[index];
	}
	
	@Unique
	@Override
	public int[] jineric$getCookingTimes() {
		return cookingTimes;
	}
	
	@Unique
	@Override
	public void jineric$setCookingTimes(int time) {
		for (int index : this.cookingTimes) {
			this.jineric$setCookingTime(index, time);
		}
	}
	
	@Unique
	@Override
	public void jineric$setCookingTime(int index, int cookingTimes) {
		this.cookingTimes[index] = cookingTimes;
	}
	//  cookingTotalTimes
	@Unique
	@Override
	public int[] jineric$getCookingTotalTimes() {
		return cookingTotalTimes;
	}
	
	@Unique
	@Override
	public int jineric$getCookingTotalTime(int index) {
		return cookingTotalTimes[index];
	}
	
	@Unique
	@Override
	public void jineric$setCookingTotalTimes(int time) {
		for (int index : this.cookingTotalTimes) {
			this.jineric$setCookingTotalTime(index, time);
		}
	}
	
	@Unique
	@Override
	public void jineric$setCookingTotalTime(int index, int cookingTotalTimes) {
		this.cookingTotalTimes[index] = cookingTotalTimes;
	}
	
	
	
//  OVERRIDES
	@Override
	public int size() {
		return this.getItemsBeingCooked().size();
	}
	
	@Override
	public boolean canTransferTo(Inventory hopperInventory, int slot, ItemStack stack) {
		return false;
	}
	
	@Override
	public boolean isValid(int slot, ItemStack stack) {
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		for (ItemStack itemStack : this.getItemsBeingCooked()) {
			if (!itemStack.isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public ItemStack removeStack(int slot, int amount) {
		return Inventories.splitStack(this.getItemsBeingCooked(), slot, amount);
	}
	
	@Override
	public void setStack(int slot, ItemStack stack) {
		this.getItemsBeingCooked().set(slot, stack);
		stack.capCount(this.getMaxCount(stack));
	}
	
	@Override
	public ItemStack getStack(int slot) {
		return this.getItemsBeingCooked().get(slot);
	}
	
	@Override
	public boolean canPlayerUse(PlayerEntity player) {
		return Inventory.canPlayerUse(this, player);
	}
	
	@Nullable
	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
		return new CampfireScreenHandler(syncId, playerInventory, ScreenHandlerContext.create(this.world, this.getPos()), (CampfireBlockEntity)(Object)this, this.propertyDelegate);
	}
	
	@Override
	public Text getName() {
		return this.customName != null ? this.customName : Text.translatable("container.jineric.campfire");
	}
	
	@Override
	public Text getDisplayName() {
		return Text.translatable("container.jineric.campfire");
	}
	
	@Override
	public void setComponents(ComponentMap components) {
		super.setComponents(components);
	}
}
