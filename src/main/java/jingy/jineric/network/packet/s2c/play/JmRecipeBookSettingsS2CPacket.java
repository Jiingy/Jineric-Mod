package jingy.jineric.network.packet.s2c.play;

import jingy.jineric.base.injected_interfaces.JmClientGamePacketListener;
import jingy.jineric.network.packet.JmPlayPackets;
import jingy.jineric.recipe.book.JmRecipeBookOptions;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.PacketType;
import net.minecraft.network.protocol.game.ClientGamePacketListener;

public record JmRecipeBookSettingsS2CPacket(JmRecipeBookOptions bookSettings) implements Packet<ClientGamePacketListener> {
	public static final StreamCodec<FriendlyByteBuf, JmRecipeBookSettingsS2CPacket> CODEC = StreamCodec.composite(
			JmRecipeBookOptions.PACKET_CODEC,
			JmRecipeBookSettingsS2CPacket::bookSettings,
			JmRecipeBookSettingsS2CPacket::new
	);

	@Override
	public PacketType<? extends Packet<ClientGamePacketListener>> type() {
		return JmPlayPackets.RECIPE_BOOK_SETTINGS;
	}
	
	@Override
	public void handle(ClientGamePacketListener clientPlayPacketListener) {
		((JmClientGamePacketListener)clientPlayPacketListener).jineric$onJmRecipeBookSettings(this);
	}
}