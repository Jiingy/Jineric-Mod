package jingy.jineric.mixin.access;

import com.mojang.serialization.MapCodec;
import net.minecraft.stats.RecipeBookSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(net.minecraft.stats.RecipeBookSettings.TypeSettings.class)
public interface CategoryOptionAccessor {
	
	@Invoker("codec")
	static MapCodec<RecipeBookSettings.TypeSettings> callCreateCodec(String guiOpenField, String filteringCraftableField) {
		throw new UnsupportedOperationException();
	}
	
	@Accessor
	boolean isOpen();
	
	@Accessor
	boolean isFiltering();
}
