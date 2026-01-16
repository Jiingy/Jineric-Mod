package jingy.jineric.mixin.duck;

import jingy.jineric.access.ClientPlayPacketListenerAccess;
import net.minecraft.network.listener.ClientPlayPacketListener;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientPlayPacketListener.class)
public interface ClientPlayPacketListenerDuckMixin extends ClientPlayPacketListenerAccess {
}
