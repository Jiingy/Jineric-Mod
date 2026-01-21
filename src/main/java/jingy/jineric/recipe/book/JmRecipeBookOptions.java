package jingy.jineric.recipe.book;

import com.google.common.annotations.VisibleForTesting;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jingy.jineric.mixin.access.CategoryOptionAccessor;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.world.inventory.RecipeBookType;
import java.util.function.UnaryOperator;

public class JmRecipeBookOptions {
	public static final MapCodec<RecipeBookSettings.TypeSettings> REFINERY = CategoryOptionAccessor.callCreateCodec("isRefineryGuiOpen", "isRefineryFilteringCraftable");
	public static final MapCodec<RecipeBookSettings.TypeSettings> FOUNDRY = CategoryOptionAccessor.callCreateCodec("isFoundryGuiOpen", "isFoundryFilteringCraftable");
	public static final MapCodec<RecipeBookSettings.TypeSettings> KILN = CategoryOptionAccessor.callCreateCodec("isKilnGuiOpen", "isKilnFilteringCraftable");
	
	public static final StreamCodec<FriendlyByteBuf, JmRecipeBookOptions> PACKET_CODEC = StreamCodec.composite(
			//  Modded
			RecipeBookSettings.TypeSettings.STREAM_CODEC, options -> options.refinery,
			RecipeBookSettings.TypeSettings.STREAM_CODEC, options -> options.foundry,
			RecipeBookSettings.TypeSettings.STREAM_CODEC, options -> options.kiln,
			//  Vanilla
			RecipeBookSettings.TypeSettings.STREAM_CODEC, options -> options.crafting,
			RecipeBookSettings.TypeSettings.STREAM_CODEC, options -> options.furnace,
			RecipeBookSettings.TypeSettings.STREAM_CODEC, options -> options.blastFurnace,
			RecipeBookSettings.TypeSettings.STREAM_CODEC, options -> options.smoker,
			JmRecipeBookOptions::new
	);
	public static final MapCodec<JmRecipeBookOptions> CODEC = RecordCodecBuilder.mapCodec(
			instance -> instance.group(
					//  Modded
					REFINERY.forGetter(options -> options.refinery),
					FOUNDRY.forGetter(options -> options.foundry),
					KILN.forGetter(options -> options.kiln),
					//  Vanilla
					RecipeBookSettings.TypeSettings.CRAFTING_MAP_CODEC.forGetter(options -> options.crafting),
					RecipeBookSettings.TypeSettings.FURNACE_MAP_CODEC.forGetter(options -> options.furnace),
					RecipeBookSettings.TypeSettings.BLAST_FURNACE_MAP_CODEC.forGetter(options -> options.blastFurnace),
					RecipeBookSettings.TypeSettings.SMOKER_MAP_CODEC.forGetter(options -> options.smoker)
			).apply(instance, JmRecipeBookOptions::new)
	);
	
	//  Modded
	private RecipeBookSettings.TypeSettings refinery;
	private RecipeBookSettings.TypeSettings foundry;
	private RecipeBookSettings.TypeSettings kiln;
	//  Vanilla
	private RecipeBookSettings.TypeSettings crafting;
	private RecipeBookSettings.TypeSettings furnace;
	private RecipeBookSettings.TypeSettings blastFurnace;
	private RecipeBookSettings.TypeSettings smoker;
	
	public JmRecipeBookOptions() {
		this(
				RecipeBookSettings.TypeSettings.DEFAULT,
				RecipeBookSettings.TypeSettings.DEFAULT,
				RecipeBookSettings.TypeSettings.DEFAULT,
				RecipeBookSettings.TypeSettings.DEFAULT,
				RecipeBookSettings.TypeSettings.DEFAULT,
				RecipeBookSettings.TypeSettings.DEFAULT,
				RecipeBookSettings.TypeSettings.DEFAULT
		);
	}
	
	private JmRecipeBookOptions(
			//  Modded
			RecipeBookSettings.TypeSettings refinery,
			RecipeBookSettings.TypeSettings foundry,
			RecipeBookSettings.TypeSettings kiln,
			//  Vanilla
			RecipeBookSettings.TypeSettings crafting,
			RecipeBookSettings.TypeSettings furnace,
			RecipeBookSettings.TypeSettings blastFurnace,
			RecipeBookSettings.TypeSettings smoker
	) {
		//  Modded
		this.refinery = refinery;
		this.foundry = foundry;
		this.kiln = kiln;
		//  Vanilla
		this.crafting = crafting;
		this.furnace = furnace;
		this.blastFurnace = blastFurnace;
		this.smoker = smoker;
	}
	
	@VisibleForTesting
	public RecipeBookSettings.TypeSettings getOption(RecipeBookType type) {
		//  Modded
		if (type.equals(JinericRecipeBookType.JINERIC_REFINERY)) {
			return this.refinery;
		} else if (type.equals(JinericRecipeBookType.JINERIC_FOUNDRY)) {
			return this.foundry;
		} else if (type.equals(JinericRecipeBookType.JINERIC_KILN)) {
			return this.kiln;
		}
		else {
			//  Vanilla
			return switch (type) {
				case CRAFTING -> this.crafting;
				case FURNACE -> this.furnace;
				case BLAST_FURNACE -> this.blastFurnace;
				case SMOKER -> this.smoker;
			};
		}
	}
	
	private void apply(RecipeBookType type, UnaryOperator<RecipeBookSettings.TypeSettings> modifier) {
		//  Modded
		if (type.equals(JinericRecipeBookType.JINERIC_REFINERY)) {
			this.refinery = modifier.apply(this.refinery);
			return;
		}
		if (type.equals(JinericRecipeBookType.JINERIC_FOUNDRY)) {
			this.foundry = modifier.apply(this.foundry);
			return;
		}
		if (type.equals(JinericRecipeBookType.JINERIC_KILN)) {
			this.kiln = modifier.apply(this.kiln);
			return;
		}
		//  Vanilla
		switch (type) {
			case CRAFTING:
				this.crafting = modifier.apply(this.crafting);
				break;
			case FURNACE:
				this.furnace = modifier.apply(this.furnace);
				break;
			case BLAST_FURNACE:
				this.blastFurnace = modifier.apply(this.blastFurnace);
				break;
			case SMOKER:
				this.smoker = modifier.apply(this.smoker);
		}
	}
	
	public boolean isGuiOpen(RecipeBookType category) {
		return ((CategoryOptionAccessor)(Object)this.getOption(category)).isOpen();
	}
	
	public void setGuiOpen(RecipeBookType category, boolean open) {
		this.apply(category, option -> option.setOpen(open));
	}
	
	public boolean isFilteringCraftable(RecipeBookType category) {
		return ((CategoryOptionAccessor)(Object)this.getOption(category)).isFiltering();
	}
	
	public void setFilteringCraftable(RecipeBookType category, boolean filtering) {
		this.apply(category, option -> option.setFiltering(filtering));
	}
	
	public JmRecipeBookOptions copy() {
		return new JmRecipeBookOptions(
				//  Modded
				this.refinery,
				this.foundry,
				this.kiln,
				//  Vanilla
				this.crafting,
				this.furnace,
				this.blastFurnace,
				this.smoker
		);
	}
	
	public void copyFrom(JmRecipeBookOptions other) {
		//  Modded
		this.refinery = other.refinery;
		this.foundry = other.foundry;
		this.kiln = other.kiln;
		//  Vanilla
		this.crafting = other.crafting;
		this.furnace = other.furnace;
		this.blastFurnace = other.blastFurnace;
		this.smoker = other.smoker;
	}
}
