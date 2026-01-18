package jingy.jineric.network.packet;

import jingy.jineric.base.JinericMain;
import jingy.jineric.network.packet.s2c.play.JmRecipeBookSettingsS2CPacket;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.PacketType;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ServerGamePacketListener;

public class JmPlayPackets {
	public static final PacketType<JmRecipeBookSettingsS2CPacket> RECIPE_BOOK_SETTINGS = s2c("recipe_book_settings");
	
	private static <T extends Packet<ClientGamePacketListener>> PacketType<T> s2c(String id) {
		return new PacketType<>(PacketFlow.CLIENTBOUND, JinericMain.ofJineric(id));
	}
	
	private static <T extends Packet<ServerGamePacketListener>> PacketType<T> c2s(String id) {
		return new PacketType<>(PacketFlow.SERVERBOUND, JinericMain.ofJineric(id));
	}
	
	public static void initialize() {}
}
