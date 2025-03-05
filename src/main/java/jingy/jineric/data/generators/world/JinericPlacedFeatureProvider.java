package jingy.jineric.data.generators.world;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.Registerable;
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
	}
	
	@Override
	public String getName() {
		return "Placed Feature";
	}
}
