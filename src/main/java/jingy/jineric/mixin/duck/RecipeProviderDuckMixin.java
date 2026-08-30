package jingy.jineric.mixin.duck;

import jingy.jineric.base.injected_interfaces.JmRecipeProvider;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(RecipeProvider.class)
public abstract class RecipeProviderDuckMixin implements JmRecipeProvider {
	@Shadow public static String getHasName(ItemLike item) {return null;}
	@Shadow public abstract Criterion<InventoryChangeTrigger.TriggerInstance> has(ItemLike item);
	@Shadow public abstract ShapelessRecipeBuilder shapeless(RecipeCategory category, ItemLike output);
	@Shadow public abstract ShapedRecipeBuilder shaped(RecipeCategory category, ItemLike output);
	@Shadow public abstract ShapedRecipeBuilder shaped(RecipeCategory category, ItemLike output, int count);
	
	@Override
	public RecipeBuilder bookshelfBuilder$jineric(Ingredient input, ItemLike output) {
		return this.shaped(RecipeCategory.BUILDING_BLOCKS, output, 1)
				.group("bookshelf")
				.define('P', input)
				.define('B', Items.BOOK)
				.pattern("PPP")
				.pattern("BBB")
				.pattern("PPP")
				.unlockedBy(
						getHasName(Items.BOOK),
						has(Items.BOOK)
				);
	}
	
	@Override
	public RecipeBuilder chestBuilder$jineric(ItemLike input, ItemLike output) {
		return this.shaped(RecipeCategory.DECORATIONS, output)
				.group("chest")
				.define('M', input)
				.pattern("MMM")
				.pattern("M M")
				.pattern("MMM");
	}
	
	@Override
	public RecipeBuilder trappedChestBuilder$jineric(Ingredient input, ItemLike output) {
		return this.shapeless(RecipeCategory.REDSTONE, output)
				.group("trapped_chest")
				.requires(input)
				.requires(Blocks.TRIPWIRE_HOOK);
	}
	
	@Override
	public RecipeBuilder ladderBuilder$jineric(Ingredient input, ItemLike output) {
		return this.shaped(RecipeCategory.DECORATIONS, output, 6)
				.group("ladder")
				.define('P', input)
				.define('/', Items.STICK)
				.pattern("P P")
				.pattern("P/P")
				.pattern("P P");
	}
}
