package jingy.jineric.mixin.duck;

import jingy.jineric.base.injected_interfaces.JmRecipeBook;
import jingy.jineric.recipe.book.JmRecipeBookOptions;
import net.minecraft.stats.RecipeBook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(RecipeBook.class)
public abstract class RecipeBookDuckMixin implements JmRecipeBook {
	@Unique private final JmRecipeBookOptions jmOptions = new JmRecipeBookOptions();
	
	@Override
	public void jineric$setOptions(JmRecipeBookOptions options) {
		this.jmOptions.copyFrom(options);
	}
	
	@Override
	public JmRecipeBookOptions jineric$getOptions() {
		return this.jmOptions;
	}
}
