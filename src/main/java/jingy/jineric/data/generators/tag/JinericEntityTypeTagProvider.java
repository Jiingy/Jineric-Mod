package jingy.jineric.data.generators.tag;

import jingy.jineric.entity.JinericEntityType;
import jingy.jineric.tag.JinericEntityTypeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class JinericEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {
	public JinericEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		this.getOrCreateTagBuilder(JinericEntityTypeTags.CLASSIC_BOAT)
				.add(JinericEntityType.PETRIFIED_OAK_BOAT)
				.add(JinericEntityType.PETRIFIED_OAK_CHEST_BOAT);
	}
	
	@Override
	public String getName() {
		return "entity_type_tag_provider";
	}
}
