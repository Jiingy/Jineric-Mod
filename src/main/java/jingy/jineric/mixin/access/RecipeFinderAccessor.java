package jingy.jineric.mixin.access;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.item.Item;

@Mixin(StackedItemContents.class)
public interface RecipeFinderAccessor {
	@Invoker
	boolean callCanCraft(
		List<? extends StackedContents.IngredientInfo<Holder<Item>>> rawIngredients,
		int quantity,
		@Nullable StackedContents.Output<Holder<Item>> itemCallback
	);
}
