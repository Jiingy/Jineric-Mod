package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class JinericLanguageProvider extends FabricLanguageProvider {
	public JinericLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}
	
	@Override
	public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
		translationBuilder.add(JinericBlocks.BLOSSOMED_DANDELION, "Blossomed Dandelion");
		translationBuilder.add(JinericBlocks.ROSE, "Rose");
	}
}
