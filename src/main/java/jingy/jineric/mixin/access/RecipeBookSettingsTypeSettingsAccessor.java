package jingy.jineric.mixin.access;

import com.mojang.serialization.MapCodec;
import net.minecraft.stats.RecipeBookSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(RecipeBookSettings.TypeSettings.class)
public interface RecipeBookSettingsTypeSettingsAccessor {
	
	@Invoker("codec")
	static MapCodec<RecipeBookSettings.TypeSettings> invokeCodec(String guiOpenField, String filteringCraftableField) {
		throw new UnsupportedOperationException();
	}
	
	@Accessor("open")
	boolean isOpen();
	
	@Accessor("filtering")
	boolean isFiltering();
}
