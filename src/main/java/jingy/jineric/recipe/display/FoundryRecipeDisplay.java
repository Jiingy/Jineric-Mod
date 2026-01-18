package jingy.jineric.recipe.display;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;

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
	public static final StreamCodec<RegistryFriendlyByteBuf, FoundryRecipeDisplay> STREAM_CODEC = StreamCodec.composite(
			SlotDisplay.STREAM_CODEC,
			FoundryRecipeDisplay::ingredient,
			ByteBufCodecs.INT,
			FoundryRecipeDisplay::inputCount,
			SlotDisplay.STREAM_CODEC,
			FoundryRecipeDisplay::fuel,
			SlotDisplay.STREAM_CODEC,
			FoundryRecipeDisplay::result,
			SlotDisplay.STREAM_CODEC,
			FoundryRecipeDisplay::craftingStation,
			ByteBufCodecs.VAR_INT,
			FoundryRecipeDisplay::duration,
			ByteBufCodecs.FLOAT,
			FoundryRecipeDisplay::experience,
			FoundryRecipeDisplay::new
	);
	public static final RecipeDisplay.Type<FoundryRecipeDisplay> SERIALIZER = new RecipeDisplay.Type<>(CODEC, STREAM_CODEC);
	
	@Override
	public RecipeDisplay.Type<FoundryRecipeDisplay> type() {
		return SERIALIZER;
	}
	
	@Override
	public boolean isEnabled(FeatureFlagSet features) {
		return this.ingredient.isEnabled(features) && this.fuel().isEnabled(features) && RecipeDisplay.super.isEnabled(features);
	}
}
