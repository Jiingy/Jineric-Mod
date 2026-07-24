package jingy.jineric.data.generators.tag;

import jingy.jineric.entity.JinericPaintingVariants;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import java.util.concurrent.CompletableFuture;


public class JinericPaintingVariantTagProvider extends FabricTagsProvider<PaintingVariant> {
	public JinericPaintingVariantTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, Registries.PAINTING_VARIANT, registriesFuture);
	}
	
	@Override
	protected void addTags(HolderLookup.Provider registries) {
		this.getOrCreateRawBuilder(PaintingVariantTags.PLACEABLE)
				.addElement(JinericPaintingVariants.KEY_GEN.identifier())
				.addElement(JinericPaintingVariants.KROMER.identifier())
				.addElement(JinericPaintingVariants.PEACEFUL_FARM.identifier());
	}
	
	@Override
	public String getName() {
		return "Painting Variant Tags";
	}
}
