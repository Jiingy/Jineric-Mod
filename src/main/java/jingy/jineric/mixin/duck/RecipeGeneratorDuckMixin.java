package jingy.jineric.mixin.duck;

import jingy.jineric.access.RecipeGeneratorAccess;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.predicate.NumberRange;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;
import java.util.Optional;

@Mixin(RecipeGenerator.class)
public abstract class RecipeGeneratorDuckMixin implements RecipeGeneratorAccess {
	@Shadow public static String hasItem(ItemConvertible item) {return null;}
	@Shadow public abstract AdvancementCriterion<InventoryChangedCriterion.Conditions> conditionsFromItem(ItemConvertible item);
	@Shadow public abstract ShapelessRecipeJsonBuilder createShapeless(RecipeCategory category, ItemConvertible output);
	@Shadow public abstract ShapedRecipeJsonBuilder createShaped(RecipeCategory category, ItemConvertible output);
	@Shadow public abstract ShapedRecipeJsonBuilder createShaped(RecipeCategory category, ItemConvertible output, int count);
	
	@Override
	public CraftingRecipeJsonBuilder createBookshelf$jineric(Ingredient input, ItemConvertible output) {
		return this.createShaped(RecipeCategory.BUILDING_BLOCKS, output, 1)
				.group("bookshelf")
				.input('P', input)
				.input('B', Items.BOOK)
				.pattern("PPP")
				.pattern("BBB")
				.pattern("PPP")
				.criterion(
						hasItem(Items.BOOK),
						conditionsFromItem(Items.BOOK)
				);
	}
	
	@Override
	public CraftingRecipeJsonBuilder createChest$jineric(Ingredient input, ItemConvertible output) {
		return this.createShaped(RecipeCategory.DECORATIONS, output)
				.group("chest")
				.input('P', input)
				.pattern("PPP")
				.pattern("P P")
				.pattern("PPP")
				.criterion(
						"has_lots_of_items",
						Criteria.INVENTORY_CHANGED
								.create(
										new InventoryChangedCriterion.Conditions(
												Optional.empty(),
												new InventoryChangedCriterion.Conditions.Slots(NumberRange.IntRange.atLeast(10), NumberRange.IntRange.ANY, NumberRange.IntRange.ANY),
												List.of()
										)
								)
				);
	}
	
	@Override
	public CraftingRecipeJsonBuilder createTrappedChest$jineric(Ingredient input, ItemConvertible output) {
		return this.createShapeless(RecipeCategory.REDSTONE, output)
				.group("trapped_chest")
				.input(input)
				.input(Blocks.TRIPWIRE_HOOK);
	}
	
	@Override
	public CraftingRecipeJsonBuilder createLadder$jineric(Ingredient input, ItemConvertible output) {
		return this.createShaped(RecipeCategory.DECORATIONS, output, 6)
				.group("ladder")
				.input('P', input)
				.input('/', Items.STICK)
				.pattern("P P")
				.pattern("P/P")
				.pattern("P P");
	}
}
