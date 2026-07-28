package jingy.jineric.mixin.access;

import net.minecraft.stats.ServerRecipeBook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ServerRecipeBook.class)
public interface ServerRecipeBookAccessor {
	
	@Accessor("displayResolver")
	ServerRecipeBook.DisplayResolver getCollector();
}
