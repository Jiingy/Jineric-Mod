package jingy.jineric.data.generators;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class JinericBuiltRegistryProvider extends FabricDynamicRegistryProvider {
	public JinericBuiltRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
		entries.addAll(registries.getOrThrow(RegistryKeys.CONFIGURED_FEATURE));
		entries.addAll(registries.getOrThrow(RegistryKeys.PLACED_FEATURE));
		entries.addAll(registries.getOrThrow(RegistryKeys.BIOME));
		entries.addAll(registries.getOrThrow(RegistryKeys.PAINTING_VARIANT));
	}
	
	@Override
	public String getName() {
		return "Built Registry Providers";
	}
}
