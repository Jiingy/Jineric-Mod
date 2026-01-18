package jingy.jineric.mixin.duck;

import jingy.jineric.access.ServerPlayerEntityAccess;
import jingy.jineric.server.network.JmServerRecipeBook;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerEntityDuckMixin implements ServerPlayerEntityAccess {
	@Unique private JmServerRecipeBook jmRecipeBook;
	
	@Override
	public JmServerRecipeBook jineric$getRecipeBook() {
		return this.jmRecipeBook;
	}
	
	@Override
	public void jineric$setRecipeBook(JmServerRecipeBook serverRecipeBook) {
		this.jmRecipeBook = serverRecipeBook;
	}
}
