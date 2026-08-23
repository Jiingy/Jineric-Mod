package jingy.jineric.mixin.add;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.base.injected_interfaces.JmCampfireBlockEntity;
import jingy.jineric.screen.CampfireScreenHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CampfireBlockEntity.class)
public abstract class ScreenForCampfireBlockEntityMixin extends BlockEntity implements Clearable, MenuProvider, Nameable, Container, JmCampfireBlockEntity {
	//  VANILLA
	@Shadow protected abstract void markUpdated();
	@Shadow @Final private int[] cookingProgress;
	@Shadow @Final private int[] cookingTime;
	@Shadow public abstract NonNullList<ItemStack> getItems();
	//  MODDED
	int[] cookingTimesCopy = new int[4];
	int[] cookingTotalTimesCopy = new int[4];
	//TOOD: ADD
	@Nullable private Component name;
	
	@Unique
	protected final SimpleContainerData simpleContainerData = new SimpleContainerData(4) {
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
		public int getCount() {
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
					target = "Lnet/minecraft/core/NonNullList;withSize(ILjava/lang/Object;)Lnet/minecraft/core/NonNullList;"
			)
	)
	private int expandSizeOfInventoryToFive(int size) {
		return 5;
	}
	
	@WrapOperation(
			method = "cookTick",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/core/NonNullList;size()I")
	)
	private static int litTickOnlyCookItems(NonNullList<ItemStack> instance, Operation<Integer> original) {
		return 4;
	}
	
	@WrapOperation(
			method = "cooldownTick",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/core/NonNullList;size()I")
	)
	private static int unlitTickOnlyCookItems(NonNullList<ItemStack> instance, Operation<Integer> original) {
		return 4;
	}
	
	@WrapOperation(
			method = "particleTick",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/core/NonNullList;size()I")
	)
	private static int clientTickOnlyCookItems(NonNullList<ItemStack> instance, Operation<Integer> original) {
		return 4;
	}
	
	@WrapOperation(
			method = "placeFood",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/core/NonNullList;size()I")
	)
	private static int addItemOnlyCookItems(NonNullList<ItemStack> instance, Operation<Integer> original) {
		return 4;
	}
	
	
//  NEW METHODS
	//  cookingTimes
	@Unique
	@Override
	public int jineric$getCookingTime(int index) {
		return cookingProgress[index];
	}
	
	@Unique
	@Override
	public int[] jineric$getCookingTimes() {
		return cookingProgress;
	}
	
	@Unique
	@Override
	public void jineric$setCookingTimes(int time) {
		for (int index : this.cookingProgress) {
			this.jineric$setCookingTime(index, time);
		}
	}
	
	@Unique
	@Override
	public void jineric$setCookingTime(int index, int cookingTimes) {
		this.cookingProgress[index] = cookingTimes;
	}
	//  cookingTotalTimes
	@Unique
	@Override
	public int[] jineric$getCookingTotalTimes() {
		return cookingTime;
	}
	
	@Unique
	@Override
	public int jineric$getCookingTotalTime(int index) {
		return cookingTime[index];
	}
	
	@Unique
	@Override
	public void jineric$setCookingTotalTimes(int time) {
		for (int index : this.cookingTime) {
			this.jineric$setCookingTotalTime(index, time);
		}
	}
	
	@Unique
	@Override
	public void jineric$setCookingTotalTime(int index, int cookingTotalTimes) {
		this.cookingTime[index] = cookingTotalTimes;
	}
	
	
	
//  OVERRIDES
	@Override
	public int getContainerSize() {
		return this.getItems().size();
	}
	
	@Override
	public boolean canTakeItem(Container hopperInventory, int slot, ItemStack stack) {
		return false;
	}
	
	@Override
	public boolean canPlaceItem(int slot, ItemStack stack) {
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		for (ItemStack itemStack : this.getItems()) {
			if (!itemStack.isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public ItemStack removeItem(int slot, int amount) {
		return ContainerHelper.removeItem(this.getItems(), slot, amount);
	}
	
	@Override
	public void setItem(int slot, ItemStack stack) {
		this.getItems().set(slot, stack);
		stack.limitSize(this.getMaxStackSize(stack));
	}
	
	@Override
	public ItemStack getItem(int slot) {
		return this.getItems().get(slot);
	}
	
	@Override
	public boolean stillValid(Player player) {
		return Container.stillValidBlockEntity(this, player);
	}
	
	@Nullable
	@Override
	public AbstractContainerMenu createMenu(int syncId, Inventory playerInventory, Player player) {
		return new CampfireScreenHandler(syncId, playerInventory, ContainerLevelAccess.create(this.level, this.getBlockPos()), (CampfireBlockEntity)(Object)this, this.simpleContainerData);
	}
	
	@Override
	public Component getName() {
		return this.name != null ? this.name : Component.translatable("container.jineric.campfire");
	}
	
	@Override
	public Component getDisplayName() {
		return Component.translatable("container.jineric.campfire");
	}
	
	@Override
	public void setComponents(DataComponentMap components) {
		super.setComponents(components);
	}
}
