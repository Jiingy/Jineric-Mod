package jingy.jineric.network.packet.s2c.play;

import jingy.jineric.access.ClientPlayPacketListenerAccess;
import jingy.jineric.network.packet.JmPlayPackets;
import jingy.jineric.recipe.book.JmRecipeBookOptions;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.PacketType;

public record JmRecipeBookSettingsS2CPacket(JmRecipeBookOptions bookSettings) implements Packet<ClientPlayPacketListener> {
	public static final PacketCodec<PacketByteBuf, JmRecipeBookSettingsS2CPacket> CODEC = PacketCodec.tuple(
			JmRecipeBookOptions.PACKET_CODEC,
			JmRecipeBookSettingsS2CPacket::bookSettings,
			JmRecipeBookSettingsS2CPacket::new
	);
	
	//  TODO RECIPE BOOK: Code commented out due to my CustomPayload not working, and being unable to fix it without internet
//	public static final CustomPayload.Id<JmRecipeBookSettingsS2CPacket> ID = new CustomPayload.Id<>(Identifier.of("jineric", "recipe_book_settings"));
	
	@Override
	public PacketType<? extends Packet<ClientPlayPacketListener>> getPacketType() {
		return JmPlayPackets.RECIPE_BOOK_SETTINGS;
	}
	
	public void apply(ClientPlayPacketListener clientPlayPacketListener) {
		((ClientPlayPacketListenerAccess)clientPlayPacketListener).jineric_mod$onJmRecipeBookSettings(this);
	}
	
//	@Override
//	public Id<? extends CustomPayload> getId() {
//		return ID;
//	}
}