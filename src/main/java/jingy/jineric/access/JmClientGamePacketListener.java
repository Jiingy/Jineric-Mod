package jingy.jineric.access;

import jingy.jineric.network.packet.s2c.play.JmRecipeBookSettingsS2CPacket;

public interface JmClientGamePacketListener {
	void jineric_mod$onJmRecipeBookSettings(JmRecipeBookSettingsS2CPacket packet);
}
