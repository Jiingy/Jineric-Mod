package jingy.jineric.mixin.duck;

import jingy.jineric.access.ClientPlayPacketListenerAccess;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientGamePacketListener.class)
public interface ClientPlayPacketListenerDuckMixin extends ClientPlayPacketListenerAccess {
}
