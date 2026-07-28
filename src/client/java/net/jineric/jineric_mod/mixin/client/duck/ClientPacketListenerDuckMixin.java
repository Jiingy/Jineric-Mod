package net.jineric.jineric_mod.mixin.client.duck;

import jingy.jineric.base.injected_interfaces.JmClientGamePacketListener;
import jingy.jineric.base.injected_interfaces.JmRecipeBook;
import jingy.jineric.network.packet.s2c.play.JmRecipeBookSettingsS2CPacket;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientCommonPacketListenerImpl;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.CommonListenerCookie;
import net.minecraft.network.Connection;
import net.minecraft.network.TickablePacketListener;
import net.minecraft.network.protocol.PacketUtils;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClientPacketListener.class)
public abstract class ClientPacketListenerDuckMixin extends ClientCommonPacketListenerImpl implements ClientGamePacketListener, TickablePacketListener, JmClientGamePacketListener {
	protected ClientPacketListenerDuckMixin(Minecraft client, Connection connection, CommonListenerCookie connectionState) {
		super(client, connection, connectionState);
	}
	@Shadow protected abstract void refreshRecipeBook(ClientRecipeBook recipeBook);
	
	public void jineric_mod$onJmRecipeBookSettings(JmRecipeBookSettingsS2CPacket packet) {
		PacketUtils.ensureRunningOnSameThread(packet, this, this.minecraft.packetProcessor());
		ClientRecipeBook clientRecipeBook = this.minecraft.player.getRecipeBook();
		((JmRecipeBook)clientRecipeBook).jineric$setOptions(packet.bookSettings());
		this.refreshRecipeBook(clientRecipeBook);
	}
}
