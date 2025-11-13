package jingy.jineric.block.entity;

import jingy.jineric.recipe.FoundrySmeltingRecipe;
import jingy.jineric.recipe.JinericRecipeTypes;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.screen.FoundryScreenHandler;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;

public class FoundryBlockEntity extends AbstractFurnaceBlockEntity {
	private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
	
	public FoundryBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(JinericBlockEntityType.FOUNDRY, blockPos, blockState, JinericRecipeTypes.FOUNDRY_SMELTING);
	}
	
	@Override
	protected Text getContainerName() {
		return Text.of("container.foundry");
	}
	
	@Override
	protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
		return new FoundryScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
	}
	
	public static void tick(ServerWorld world, BlockPos pos, BlockState state, AbstractFurnaceBlockEntity blockEntity) {
		boolean isBurning = blockEntity.isBurning();
		boolean markDirty = false;
		if (blockEntity.isBurning()) {
			blockEntity.litTimeRemaining--;
		}
		
		ItemStack inputSlotStack = blockEntity.inventory.get(INPUT_SLOT_INDEX);
		ItemStack fuelSlotStack = blockEntity.inventory.get(FUEL_SLOT_INDEX);
		boolean inputSlotHasStack = !inputSlotStack.isEmpty();
		boolean fuelSlotHasStack = !fuelSlotStack.isEmpty();
		
		if (blockEntity.isBurning() || fuelSlotHasStack && inputSlotHasStack) {
			SingleStackRecipeInput singleStackRecipeInput = new SingleStackRecipeInput(inputSlotStack);
			RecipeEntry<? extends AbstractCookingRecipe> recipeEntry;
			
			if (inputSlotHasStack) {
				recipeEntry = blockEntity.matchGetter.getFirstMatch(singleStackRecipeInput, world).orElse(null);
				//  TODO FOUNDRY: May not be the most optimal way to do this. Currently pauses the smelting progress when stack is > 0 && stack < recipeCount
				assert recipeEntry != null;
				if (recipeEntry.value() instanceof FoundrySmeltingRecipe foundrySmeltingRecipe) {
					if (inputSlotStack.getCount() < foundrySmeltingRecipe.getInputCount()) {
						return;
					}
				}
			} else {
				recipeEntry = null;
			}

			int maxStackCount = blockEntity.getMaxCountPerStack();
			if (!blockEntity.isBurning() && canAcceptRecipeOutput(world.getRegistryManager(), recipeEntry, singleStackRecipeInput, blockEntity.inventory, maxStackCount)) {
				blockEntity.litTimeRemaining = blockEntity.getFuelTime(world.getFuelRegistry(), fuelSlotStack);
				blockEntity.litTotalTime = blockEntity.litTimeRemaining;
				if (blockEntity.isBurning()) {
					markDirty = true;
					if (fuelSlotHasStack) {
						Item fuelItem = fuelSlotStack.getItem();
						fuelSlotStack.decrement(1);
						if (fuelSlotStack.isEmpty()) {
							blockEntity.inventory.set(1, fuelItem.getRecipeRemainder());
						}
					}
				}
			}

			if (blockEntity.isBurning() && canAcceptRecipeOutput(world.getRegistryManager(), recipeEntry, singleStackRecipeInput, blockEntity.inventory, maxStackCount)) {
				if (recipeEntry.value() instanceof FoundrySmeltingRecipe foundrySmeltingRecipe) {
					if (inputSlotStack.getCount() >= foundrySmeltingRecipe.getInputCount()) {
						blockEntity.cookingTimeSpent++;
					} else {
						degradeCookTime(blockEntity);
					}
				} else {
					blockEntity.cookingTimeSpent++;
				}
				if (blockEntity.cookingTimeSpent == blockEntity.cookingTotalTime) {
					blockEntity.cookingTimeSpent = 0;
					blockEntity.cookingTotalTime = getCookTime(world, blockEntity);
					if (craftRecipe(world.getRegistryManager(), recipeEntry, singleStackRecipeInput, blockEntity.inventory, maxStackCount)) {
						blockEntity.setLastRecipe(recipeEntry);
					}

					markDirty = true;
				}
			} else {
				blockEntity.cookingTimeSpent = 0;
			}
		} else if (!blockEntity.isBurning() && blockEntity.cookingTimeSpent > 0) {
			degradeCookTime(blockEntity);
		}

		if (isBurning != blockEntity.isBurning()) {
			markDirty = true;
			state = state.with(AbstractFurnaceBlock.LIT, blockEntity.isBurning());
			world.setBlockState(pos, state, Block.NOTIFY_ALL);
		}

		if (markDirty) {
			markDirty(world, pos, state);
		}
	}
	
	private static boolean craftRecipe(
			DynamicRegistryManager dynamicRegistryManager,
			@Nullable RecipeEntry<? extends AbstractCookingRecipe> recipeEntry,
			SingleStackRecipeInput input,
			DefaultedList<ItemStack> inventory,
			int maxCount
	) {
		if (recipeEntry != null && canAcceptRecipeOutput(dynamicRegistryManager, recipeEntry, input, inventory, maxCount)) {
			ItemStack inputStack = inventory.get(INPUT_SLOT_INDEX);
			ItemStack craftedOutputStack = recipeEntry.value().craft(input, dynamicRegistryManager);
			ItemStack outputStack = inventory.get(OUTPUT_SLOT_INDEX);
			if (outputStack.isEmpty()) {
				inventory.set(OUTPUT_SLOT_INDEX, craftedOutputStack.copy());
			} else if (ItemStack.areItemsAndComponentsEqual(outputStack, craftedOutputStack)) {
				outputStack.increment(1);
			}
			
			if (inputStack.isOf(Blocks.WET_SPONGE.asItem()) && !inventory.get(FUEL_SLOT_INDEX).isEmpty() && inventory.get(1).isOf(Items.BUCKET)) {
				inventory.set(FUEL_SLOT_INDEX, new ItemStack(Items.WATER_BUCKET));
			}
			
			if (recipeEntry.value() instanceof FoundrySmeltingRecipe foundrySmeltingRecipe) {
				inputStack.decrement(foundrySmeltingRecipe.getInputCount());
			} else {
				inputStack.decrement(1);
			}
			return true;
		} else {
			return false;
		}
	}
	
	private static void degradeCookTime(AbstractFurnaceBlockEntity blockEntity) {
		blockEntity.cookingTimeSpent = MathHelper.clamp(blockEntity.cookingTimeSpent - 2, 0, blockEntity.cookingTotalTime);
	}
}
