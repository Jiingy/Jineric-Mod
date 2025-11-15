package net.jineric.jineric_mod.mixin.client.duck;

import jingy.jineric.access.ClientPlayPacketListenerAccess;
import jingy.jineric.access.RecipeBookAccess;
import jingy.jineric.network.packet.s2c.play.JmRecipeBookSettingsS2CPacket;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientCommonNetworkHandler;
import net.minecraft.client.network.ClientConnectionState;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkThreadUtils;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.listener.TickablePacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin extends ClientCommonNetworkHandler implements ClientPlayPacketListener, TickablePacketListener, ClientPlayPacketListenerAccess {
	protected ClientPlayNetworkHandlerMixin(MinecraftClient client, ClientConnection connection, ClientConnectionState connectionState) {
		super(client, connection, connectionState);
	}
	@Shadow protected abstract void refreshRecipeBook(ClientRecipeBook recipeBook);
	
	public void jineric_mod$onJmRecipeBookSettings(JmRecipeBookSettingsS2CPacket packet) {
		NetworkThreadUtils.forceMainThread(packet, this, this.client.getPacketApplyBatcher());
		ClientRecipeBook clientRecipeBook = this.client.player.getRecipeBook();
		((RecipeBookAccess)clientRecipeBook).jineric$setOptions(packet.bookSettings());
		this.refreshRecipeBook(clientRecipeBook);
	}
}
