package jingy.jineric.block.entity;

import jingy.jineric.recipe.JinericRecipeTypes;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.screen.FoundryScreenHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

//TODO: 26.2
public class FoundryBlockEntity extends AbstractFurnaceBlockEntity {
	public FoundryBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(JinericBlockEntityType.FOUNDRY, blockPos, blockState, JinericRecipeTypes.FOUNDRY_SMELTING);
	}
	
	@Override
	protected Component getDefaultName() {
		return Component.translatable("container.jineric.foundry");
	}
	
	@Override
	protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
		return new FoundryScreenHandler(syncId, playerInventory, this, this.dataAccess);
	}
	
	public static void serverTick(ServerLevel world, BlockPos pos, BlockState state, AbstractFurnaceBlockEntity blockEntity) {
//		boolean isBurning = blockEntity.isLit();
//		boolean markDirty = false;
//		if (blockEntity.isLit()) {
//			blockEntity.litTimeRemaining--;
//		}
//
//		ItemStack inputSlotStack = blockEntity.items.get(SLOT_INPUT);
//		ItemStack fuelSlotStack = blockEntity.items.get(SLOT_FUEL);
//		boolean inputSlotHasStack = !inputSlotStack.isEmpty();
//		boolean fuelSlotHasStack = !fuelSlotStack.isEmpty();
//
//		if (blockEntity.isLit() || fuelSlotHasStack && inputSlotHasStack) {
//			SingleRecipeInput singleStackRecipeInput = new SingleRecipeInput(inputSlotStack);
//			RecipeHolder<? extends AbstractCookingRecipe> recipeEntry;
//
//			if (inputSlotHasStack) {
//				recipeEntry = blockEntity.quickCheck.getRecipeFor(singleStackRecipeInput, world).orElse(null);
//				assert recipeEntry != null;
//				if (recipeEntry.value() instanceof FoundrySmeltingRecipe foundrySmeltingRecipe) {
//					if (inputSlotStack.getCount() < foundrySmeltingRecipe.jineric$getInputCount()) {
//						return;
//					}
//				}
//			} else {
//				recipeEntry = null;
//			}
//
//			int maxStackCount = blockEntity.getMaxStackSize();
//			if (!blockEntity.isLit() && canBurn(world.registryAccess(), recipeEntry, singleStackRecipeInput, blockEntity.items, maxStackCount)) {
//				blockEntity.litTimeRemaining = blockEntity.getBurnDuration(world.fuelValues(), fuelSlotStack);
//				blockEntity.litTotalTime = blockEntity.litTimeRemaining;
//				if (blockEntity.isLit()) {
//					markDirty = true;
//					if (fuelSlotHasStack) {
//						Item fuelItem = fuelSlotStack.getItem();
//						fuelSlotStack.shrink(1);
//						if (fuelSlotStack.isEmpty()) {
//							blockEntity.items.set(1, fuelItem.getCraftingRemainder());
//						}
//					}
//				}
//			}
//
//			if (blockEntity.isLit() && canBurn(world.registryAccess(), recipeEntry, singleStackRecipeInput, blockEntity.items, maxStackCount)) {
//				if (recipeEntry.value() instanceof FoundrySmeltingRecipe foundrySmeltingRecipe) {
//					if (inputSlotStack.getCount() >= foundrySmeltingRecipe.jineric$getInputCount()) {
//						blockEntity.cookingTimer++;
//					} else {
//						degradeCookTime(blockEntity);
//					}
//				} else {
//					blockEntity.cookingTimer++;
//				}
//				if (blockEntity.cookingTimer == blockEntity.cookingTotalTime) {
//					blockEntity.cookingTimer = 0;
//					blockEntity.cookingTotalTime = getTotalCookTime(world, blockEntity);
//					if (craftRecipe(world.registryAccess(), recipeEntry, singleStackRecipeInput, blockEntity.items, maxStackCount)) {
//						blockEntity.setRecipeUsed(recipeEntry);
//					}
//
//					markDirty = true;
//				}
//			} else {
//				blockEntity.cookingTimer = 0;
//			}
//		} else if (!blockEntity.isLit() && blockEntity.cookingTimer > 0) {
//			degradeCookTime(blockEntity);
//		}
//
//		if (isBurning != blockEntity.isLit()) {
//			markDirty = true;
//			state = state.setValue(AbstractFurnaceBlock.LIT, blockEntity.isLit());
//			world.setBlock(pos, state, Block.UPDATE_ALL);
//		}
//
//		if (markDirty) {
//			setChanged(world, pos, state);
//		}
	}
	
//	private static boolean craftRecipe(
//			RegistryAccess dynamicRegistryManager,
//			@Nullable RecipeHolder<? extends AbstractCookingRecipe> recipeEntry,
//			SingleRecipeInput input,
//			NonNullList<ItemStack> inventory,
//			int maxCount
//	) {
//		if (recipeEntry != null && canBurn(dynamicRegistryManager, recipeEntry, input, inventory, maxCount)) {
//			ItemStack inputStack = inventory.get(SLOT_INPUT);
//			ItemStack craftedOutputStack = recipeEntry.value().assemble(input, dynamicRegistryManager);
//			ItemStack outputStack = inventory.get(SLOT_RESULT);
//			if (outputStack.isEmpty()) {
//				inventory.set(SLOT_RESULT, craftedOutputStack.copy());
//			} else if (ItemStack.isSameItemSameComponents(outputStack, craftedOutputStack)) {
//				outputStack.grow(1);
//			}
//
//			if (inputStack.is(Blocks.WET_SPONGE.asItem()) && !inventory.get(SLOT_FUEL).isEmpty() && inventory.get(1).is(Items.BUCKET)) {
//				inventory.set(SLOT_FUEL, new ItemStack(Items.WATER_BUCKET));
//			}
//
//			if (recipeEntry.value() instanceof FoundrySmeltingRecipe foundrySmeltingRecipe) {
//				inputStack.shrink(foundrySmeltingRecipe.jineric$getInputCount());
//			} else {
//				inputStack.shrink(1);
//			}
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	private static void degradeCookTime(AbstractFurnaceBlockEntity blockEntity) {
		blockEntity.cookingTimer = Mth.clamp(blockEntity.cookingTimer - 1, 0, blockEntity.cookingTotalTime);
	}
}
