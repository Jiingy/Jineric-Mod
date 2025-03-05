package jingy.jineric.data.generators.tag;

import jingy.jineric.entity.JinericPaintingVariants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PaintingVariantTags;

import java.util.concurrent.CompletableFuture;


public class JinericPaintingVariantTagProvider extends FabricTagProvider<PaintingVariant> {
	public JinericPaintingVariantTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, RegistryKeys.PAINTING_VARIANT, registriesFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup registries) {
		this.getOrCreateTagBuilder(PaintingVariantTags.PLACEABLE)
				.add(JinericPaintingVariants.KEY_GEN)
				.add(JinericPaintingVariants.KROMER)
				.add(JinericPaintingVariants.PEACEFUL_FARM);
	}
	
	@Override
	public String getName() {
		return "Painting Variant Tags";
	}
}
