package jingy.jineric.base.injected_interfaces;

import jingy.jineric.network.packet.s2c.play.JmRecipeBookSettingsS2CPacket;

public interface JmClientGamePacketListener {
	void jineric$onJmRecipeBookSettings(JmRecipeBookSettingsS2CPacket packet);
}
