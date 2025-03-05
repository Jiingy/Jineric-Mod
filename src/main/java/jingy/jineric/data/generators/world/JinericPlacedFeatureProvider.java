package jingy.jineric.data.generators.world;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.concurrent.CompletableFuture;

public class JinericPlacedFeatureProvider extends FabricDynamicRegistryProvider {
	public JinericPlacedFeatureProvider(FabricDataOutput generator, CompletableFuture<RegistryWrapper.WrapperLookup> registries) {
		super(generator, registries);
	}
	
	public static void bootstrap(Registerable<PlacedFeature> registry) {
	
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
		entries.addAll(registries.getOrThrow(RegistryKeys.PLACED_FEATURE));
		final RegistryWrapper.Impl<PlacedFeature> placedFeatureRegistry = registries.getOrThrow(RegistryKeys.PLACED_FEATURE);
//		entries.add(JinericTreePlacedFeatures.PETRIFIED_OAK_CHECKED, placedFeatureRegistry.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_CHECKED).value());
//      entries.add(JinericTreePlacedFeatures.PETRIFIED_OAK_BEES_002, placedFeatureRegistry.getOrThrow(JinericTreePlacedFeatures.PETRIFIED_OAK_BEES_002).value());
//		entries.add(JinericVegetationPlacedFeatures.TREES_WISTFUL_FOREST, placedFeatureRegistry.getOrThrow(JinericVegetationPlacedFeatures.TREES_WISTFUL_FOREST).value());
//		entries.add(JinericVegetationPlacedFeatures.CARVED_PUMPKIN_PATCH, placedFeatureRegistry.getOrThrow(JinericVegetationPlacedFeatures.CARVED_PUMPKIN_PATCH).value());
	}
	
	@Override
	public String getName() {
		return "Placed Feature";
	}
}
