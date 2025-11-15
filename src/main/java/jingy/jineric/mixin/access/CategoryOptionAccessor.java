package jingy.jineric.mixin.access;

import com.mojang.serialization.MapCodec;
import net.minecraft.recipe.book.RecipeBookOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(net.minecraft.recipe.book.RecipeBookOptions.CategoryOption.class)
public interface CategoryOptionAccessor {
	
	@Invoker("createCodec")
	static MapCodec<RecipeBookOptions.CategoryOption> callCreateCodec(String guiOpenField, String filteringCraftableField) {
		throw new UnsupportedOperationException();
	}
	
	@Accessor
	boolean isGuiOpen();
	
	@Accessor
	boolean isFilteringCraftable();
}
