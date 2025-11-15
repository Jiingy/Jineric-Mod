package jingy.jineric.mixin.access;

import net.minecraft.server.network.ServerRecipeBook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ServerRecipeBook.class)
public interface ServerRecipeBookAccess {
	
	@Accessor("collector")
	ServerRecipeBook.DisplayCollector getCollector();
}
