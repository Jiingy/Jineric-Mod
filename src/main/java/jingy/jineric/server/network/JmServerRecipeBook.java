package jingy.jineric.server.network;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jingy.jineric.access.RecipeBookAccess;
import jingy.jineric.mixin.access.ServerRecipeBookAccess;
import jingy.jineric.network.packet.s2c.play.JmRecipeBookSettingsS2CPacket;
import jingy.jineric.recipe.book.JmRecipeBookOptions;
import net.minecraft.network.packet.s2c.play.RecipeBookAddS2CPacket;
import net.minecraft.recipe.Recipe;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerRecipeBook;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class JmServerRecipeBook extends ServerRecipeBook {
	private static final Logger LOGGER = LogUtils.getLogger();
	
	public JmServerRecipeBook(DisplayCollector collector) {
		super(collector);
	}
	
	private void handleList(List<RegistryKey<Recipe<?>>> recipes, Consumer<RegistryKey<Recipe<?>>> handler, Predicate<RegistryKey<Recipe<?>>> validPredicate) {
		for (RegistryKey<Recipe<?>> registryKey : recipes) {
			if (!validPredicate.test(registryKey)) {
				LOGGER.error("Tried to load unrecognized recipe: {} removed now.", registryKey);
			} else {
				handler.accept(registryKey);
			}
		}
	}
	
	@Override
	public void sendInitRecipesPacket(ServerPlayerEntity player) {
		JmRecipeBookOptions bookOptions = ((RecipeBookAccess)this).jineric$getOptions();
		player.networkHandler.sendPacket(new JmRecipeBookSettingsS2CPacket(bookOptions.copy()));
		//  TODO RECIPE BOOK: Code commented out due to my CustomPayload not working, and being unable to fix it without internet
//		ServerPlayNetworking.send(player, new JmRecipeBookSettingsS2CPacket(bookOptions.copy()));
		List<RecipeBookAddS2CPacket.Entry> list = new ArrayList(this.unlocked.size());
		
		for (RegistryKey<Recipe<?>> registryKey : this.unlocked) {
			((ServerRecipeBookAccess)this).getCollector().displaysForRecipe(registryKey, display -> list.add(new RecipeBookAddS2CPacket.Entry(display, false, this.highlighted.contains(registryKey))));
		}
		
		player.networkHandler.sendPacket(new RecipeBookAddS2CPacket(list, true));
	}
	
	public void copyFrom(JmServerRecipeBook recipeBook) {
		this.unpack(recipeBook.jmPack());
	}
	
	public Packed jmPack() {
		return new Packed(((RecipeBookAccess)this).jineric$getOptions().copy(), List.copyOf(this.unlocked), List.copyOf(this.highlighted));
	}
	
	private void unpack(Packed packed) {
		this.unlocked.clear();
		this.highlighted.clear();
		((RecipeBookAccess)this).jineric$getOptions().copyFrom(packed.settings);
		this.unlocked.addAll(packed.known);
		this.highlighted.addAll(packed.highlight);
	}
	
	public void unpack(Packed packed, Predicate<RegistryKey<Recipe<?>>> validPredicate) {
		((RecipeBookAccess)this).jineric$getOptions().copyFrom(packed.settings);
		this.handleList(packed.known, this.unlocked::add, validPredicate);
		this.handleList(packed.highlight, this.highlighted::add, validPredicate);
	}
	
	public record Packed(JmRecipeBookOptions settings, List<RegistryKey<Recipe<?>>> known, List<RegistryKey<Recipe<?>>> highlight) {
		public static final Codec<Packed> CODEC = RecordCodecBuilder.create(
				instance -> instance.group(
								JmRecipeBookOptions.CODEC.forGetter(Packed::settings),
								Recipe.KEY_CODEC.listOf().fieldOf("recipes").forGetter(Packed::known),
								Recipe.KEY_CODEC.listOf().fieldOf("toBeDisplayed").forGetter(Packed::highlight)
						)
						.apply(instance, Packed::new)
		);
	}
}
