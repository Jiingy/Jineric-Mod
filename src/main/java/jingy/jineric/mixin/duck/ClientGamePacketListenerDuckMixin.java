package jingy.jineric.mixin.duck;

import jingy.jineric.base.injected_interfaces.JmClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientGamePacketListener.class)
public interface ClientGamePacketListenerDuckMixin extends JmClientGamePacketListener {
}
