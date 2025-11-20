package jingy.jineric.recipe.book;

import com.google.common.annotations.VisibleForTesting;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jingy.jineric.mixin.access.CategoryOptionAccessor;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.book.RecipeBookOptions;
import net.minecraft.recipe.book.RecipeBookType;

import java.util.function.UnaryOperator;

public class JmRecipeBookOptions {
	public static final MapCodec<RecipeBookOptions.CategoryOption> REFINERY = CategoryOptionAccessor.callCreateCodec("isRefineryGuiOpen", "isRefineryFilteringCraftable");
	public static final MapCodec<RecipeBookOptions.CategoryOption> FOUNDRY = CategoryOptionAccessor.callCreateCodec("isFoundryGuiOpen", "isFoundryFilteringCraftable");
	
	public static final PacketCodec<PacketByteBuf, JmRecipeBookOptions> PACKET_CODEC = PacketCodec.tuple(
			//  Modded
			RecipeBookOptions.CategoryOption.PACKET_CODEC, options -> options.refinery,
			RecipeBookOptions.CategoryOption.PACKET_CODEC, options -> options.foundry,
			//  Vanilla
			RecipeBookOptions.CategoryOption.PACKET_CODEC, options -> options.crafting,
			RecipeBookOptions.CategoryOption.PACKET_CODEC, options -> options.furnace,
			RecipeBookOptions.CategoryOption.PACKET_CODEC, options -> options.blastFurnace,
			RecipeBookOptions.CategoryOption.PACKET_CODEC, options -> options.smoker,
			JmRecipeBookOptions::new
	);
	public static final MapCodec<JmRecipeBookOptions> CODEC = RecordCodecBuilder.mapCodec(
			instance -> instance.group(
					//  Modded
					REFINERY.forGetter(options -> options.refinery),
					FOUNDRY.forGetter(options -> options.foundry),
					//  Vanilla
					RecipeBookOptions.CategoryOption.CRAFTING.forGetter(options -> options.crafting),
					RecipeBookOptions.CategoryOption.FURNACE.forGetter(options -> options.furnace),
					RecipeBookOptions.CategoryOption.BLAST_FURNACE.forGetter(options -> options.blastFurnace),
					RecipeBookOptions.CategoryOption.SMOKER.forGetter(options -> options.smoker)
			).apply(instance, JmRecipeBookOptions::new)
	);
	
	//  Modded
	private RecipeBookOptions.CategoryOption refinery;
	private RecipeBookOptions.CategoryOption foundry;
	//  Vanilla
	private RecipeBookOptions.CategoryOption crafting;
	private RecipeBookOptions.CategoryOption furnace;
	private RecipeBookOptions.CategoryOption blastFurnace;
	private RecipeBookOptions.CategoryOption smoker;
	
	public JmRecipeBookOptions() {
		this(
				RecipeBookOptions.CategoryOption.DEFAULT,
				RecipeBookOptions.CategoryOption.DEFAULT,
				RecipeBookOptions.CategoryOption.DEFAULT,
				RecipeBookOptions.CategoryOption.DEFAULT,
				RecipeBookOptions.CategoryOption.DEFAULT,
				RecipeBookOptions.CategoryOption.DEFAULT
		);
	}
	
	private JmRecipeBookOptions(
			//  Modded
			RecipeBookOptions.CategoryOption refinery,
			RecipeBookOptions.CategoryOption foundry,
			//  Vanilla
			RecipeBookOptions.CategoryOption crafting,
			RecipeBookOptions.CategoryOption furnace,
			RecipeBookOptions.CategoryOption blastFurnace,
			RecipeBookOptions.CategoryOption smoker
	) {
		//  Modded
		this.refinery = refinery;
		this.foundry = foundry;
		//  Vanilla
		this.crafting = crafting;
		this.furnace = furnace;
		this.blastFurnace = blastFurnace;
		this.smoker = smoker;
	}
	
	@VisibleForTesting
	public RecipeBookOptions.CategoryOption getOption(RecipeBookType type) {
		//  Modded
		if (type.equals(JinericRecipeBookType.JINERIC_REFINERY)) {
			return this.refinery;
		} else if (type.equals(JinericRecipeBookType.JINERIC_FOUNDRY)) {
			return this.foundry;
		} else {
			//  Vanilla
			return switch (type) {
				case CRAFTING -> this.crafting;
				case FURNACE -> this.furnace;
				case BLAST_FURNACE -> this.blastFurnace;
				case SMOKER -> this.smoker;
			};
		}
	}
	
	private void apply(RecipeBookType type, UnaryOperator<RecipeBookOptions.CategoryOption> modifier) {
		//  Modded
		if (type.equals(JinericRecipeBookType.JINERIC_REFINERY)) {
			this.refinery = modifier.apply(this.refinery);
			return;
		}
		if (type.equals(JinericRecipeBookType.JINERIC_FOUNDRY)) {
			this.foundry = modifier.apply(this.foundry);
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
		return ((CategoryOptionAccessor)(Object)this.getOption(category)).isGuiOpen();
	}
	
	public void setGuiOpen(RecipeBookType category, boolean open) {
		this.apply(category, option -> option.withGuiOpen(open));
	}
	
	public boolean isFilteringCraftable(RecipeBookType category) {
		return ((CategoryOptionAccessor)(Object)this.getOption(category)).isFilteringCraftable();
	}
	
	public void setFilteringCraftable(RecipeBookType category, boolean filtering) {
		this.apply(category, option -> option.withFilteringCraftable(filtering));
	}
	
	public JmRecipeBookOptions copy() {
		return new JmRecipeBookOptions(
				//  Modded
				this.refinery,
				this.foundry,
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
		//  Vanilla
		this.crafting = other.crafting;
		this.furnace = other.furnace;
		this.blastFurnace = other.blastFurnace;
		this.smoker = other.smoker;
	}
}
