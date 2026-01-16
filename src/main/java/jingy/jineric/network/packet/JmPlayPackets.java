package jingy.jineric.network.packet;

import jingy.jineric.base.JinericMain;
import jingy.jineric.network.packet.s2c.play.JmRecipeBookSettingsS2CPacket;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.listener.ServerPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.PacketType;

public class JmPlayPackets {
	public static final PacketType<JmRecipeBookSettingsS2CPacket> RECIPE_BOOK_SETTINGS = s2c("recipe_book_settings");
	
	private static <T extends Packet<ClientPlayPacketListener>> PacketType<T> s2c(String id) {
		return new PacketType<>(NetworkSide.CLIENTBOUND, JinericMain.ofJineric(id));
	}
	
	private static <T extends Packet<ServerPlayPacketListener>> PacketType<T> c2s(String id) {
		return new PacketType<>(NetworkSide.SERVERBOUND, JinericMain.ofJineric(id));
	}
	
	public static void initialize() {}
}
