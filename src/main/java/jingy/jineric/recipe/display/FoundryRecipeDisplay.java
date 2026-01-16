package jingy.jineric.recipe.display;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.recipe.display.SlotDisplay;
import net.minecraft.resource.featuretoggle.FeatureSet;

public record FoundryRecipeDisplay(SlotDisplay ingredient, int inputCount, SlotDisplay fuel, SlotDisplay result, SlotDisplay craftingStation, int duration, float experience)
		implements RecipeDisplay {
	public static final MapCodec<FoundryRecipeDisplay> CODEC = RecordCodecBuilder.mapCodec(
			instance -> instance.group(
							SlotDisplay.CODEC.fieldOf("ingredient").forGetter(FoundryRecipeDisplay::ingredient),
							Codec.INT.fieldOf("input_count").forGetter(FoundryRecipeDisplay::inputCount),
							SlotDisplay.CODEC.fieldOf("fuel").forGetter(FoundryRecipeDisplay::fuel),
							SlotDisplay.CODEC.fieldOf("result").forGetter(FoundryRecipeDisplay::result),
							SlotDisplay.CODEC.fieldOf("crafting_station").forGetter(FoundryRecipeDisplay::craftingStation),
							Codec.INT.fieldOf("duration").forGetter(FoundryRecipeDisplay::duration),
							Codec.FLOAT.fieldOf("experience").forGetter(FoundryRecipeDisplay::experience)
					)
					.apply(instance, FoundryRecipeDisplay::new)
	);
	public static final PacketCodec<RegistryByteBuf, FoundryRecipeDisplay> PACKET_CODEC = PacketCodec.tuple(
			SlotDisplay.PACKET_CODEC,
			FoundryRecipeDisplay::ingredient,
			PacketCodecs.INTEGER,
			FoundryRecipeDisplay::inputCount,
			SlotDisplay.PACKET_CODEC,
			FoundryRecipeDisplay::fuel,
			SlotDisplay.PACKET_CODEC,
			FoundryRecipeDisplay::result,
			SlotDisplay.PACKET_CODEC,
			FoundryRecipeDisplay::craftingStation,
			PacketCodecs.VAR_INT,
			FoundryRecipeDisplay::duration,
			PacketCodecs.FLOAT,
			FoundryRecipeDisplay::experience,
			FoundryRecipeDisplay::new
	);
	public static final RecipeDisplay.Serializer<FoundryRecipeDisplay> SERIALIZER = new RecipeDisplay.Serializer<>(CODEC, PACKET_CODEC);
	
	@Override
	public RecipeDisplay.Serializer<FoundryRecipeDisplay> serializer() {
		return SERIALIZER;
	}
	
	@Override
	public boolean isEnabled(FeatureSet features) {
		return this.ingredient.isEnabled(features) && this.fuel().isEnabled(features) && RecipeDisplay.super.isEnabled(features);
	}
}
