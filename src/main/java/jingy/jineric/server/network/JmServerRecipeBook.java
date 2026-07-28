package jingy.jineric.server.network;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jingy.jineric.base.injected_interfaces.JmRecipeBook;
import jingy.jineric.mixin.accessor.ServerRecipeBookAccessor;
import jingy.jineric.network.packet.s2c.play.JmRecipeBookSettingsS2CPacket;
import jingy.jineric.recipe.book.JmRecipeBookOptions;
import net.minecraft.network.protocol.game.ClientboundRecipeBookAddPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.ServerRecipeBook;
import net.minecraft.world.item.crafting.Recipe;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class JmServerRecipeBook extends ServerRecipeBook {
	private static final Logger LOGGER = LogUtils.getLogger();
	
	public JmServerRecipeBook(DisplayResolver collector) {
		super(collector);
	}
	
	private void loadRecipes(List<ResourceKey<Recipe<?>>> recipes, Consumer<ResourceKey<Recipe<?>>> handler, Predicate<ResourceKey<Recipe<?>>> validPredicate) {
		for (ResourceKey<Recipe<?>> registryKey : recipes) {
			if (!validPredicate.test(registryKey)) {
				LOGGER.error("Tried to load unrecognized recipe: {} removed now.", registryKey);
			} else {
				handler.accept(registryKey);
			}
		}
	}
	
	@Override
	public void sendInitialRecipeBook(ServerPlayer player) {
		JmRecipeBookOptions bookOptions = ((JmRecipeBook)this).jineric$getOptions();
		player.connection.send(new JmRecipeBookSettingsS2CPacket(bookOptions.copy()));
		//  TODO RECIPE BOOK: Code commented out due to my CustomPayload not working, and being unable to fix it without internet
//		ServerPlayNetworking.send(player, new JmRecipeBookSettingsS2CPacket(bookOptions.copy()));
		List<ClientboundRecipeBookAddPacket.Entry> list = new ArrayList(this.known.size());
		
		for (ResourceKey<Recipe<?>> registryKey : this.known) {
			((ServerRecipeBookAccessor)this).getCollector().displaysForRecipe(registryKey, display -> list.add(new ClientboundRecipeBookAddPacket.Entry(display, false, this.highlight.contains(registryKey))));
		}
		
		player.connection.send(new ClientboundRecipeBookAddPacket(list, true));
	}
	
	public void copyFrom(JmServerRecipeBook recipeBook) {
		this.unpack(recipeBook.jmPack());
	}
	
	public jingy.jineric.server.network.JmServerRecipeBook.Packed jmPack() {
		return new jingy.jineric.server.network.JmServerRecipeBook.Packed(((JmRecipeBook)this).jineric$getOptions().copy(), List.copyOf(this.known), List.copyOf(this.highlight));
	}
	
	private void unpack(jingy.jineric.server.network.JmServerRecipeBook.Packed packed) {
		this.known.clear();
		this.highlight.clear();
		((JmRecipeBook)this).jineric$getOptions().copyFrom(packed.settings);
		this.known.addAll(packed.known);
		this.highlight.addAll(packed.highlight);
	}
	
	public void unpack(jingy.jineric.server.network.JmServerRecipeBook.Packed packed, Predicate<ResourceKey<Recipe<?>>> validPredicate) {
		((JmRecipeBook)this).jineric$getOptions().copyFrom(packed.settings);
		this.loadRecipes(packed.known, this.known::add, validPredicate);
		this.loadRecipes(packed.highlight, this.highlight::add, validPredicate);
	}
	
	public record Packed(JmRecipeBookOptions settings, List<ResourceKey<Recipe<?>>> known, List<ResourceKey<Recipe<?>>> highlight) {
		public static final Codec<jingy.jineric.server.network.JmServerRecipeBook.Packed> CODEC = RecordCodecBuilder.create(
				instance -> instance.group(
								JmRecipeBookOptions.CODEC.forGetter(jingy.jineric.server.network.JmServerRecipeBook.Packed::settings),
								Recipe.KEY_CODEC.listOf().fieldOf("recipes").forGetter(jingy.jineric.server.network.JmServerRecipeBook.Packed::known),
								Recipe.KEY_CODEC.listOf().fieldOf("toBeDisplayed").forGetter(jingy.jineric.server.network.JmServerRecipeBook.Packed::highlight)
						)
						.apply(instance, jingy.jineric.server.network.JmServerRecipeBook.Packed::new)
		);
	}
}
