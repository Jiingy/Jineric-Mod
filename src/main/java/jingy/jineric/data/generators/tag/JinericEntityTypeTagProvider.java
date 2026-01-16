package jingy.jineric.data.generators.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import java.util.concurrent.CompletableFuture;

public class JinericEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {
	public JinericEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
		super(output, completableFuture);
	}
	
	@Override
	protected void addTags(HolderLookup.Provider wrapperLookup) {
	}
	
	@Override
	public String getName() {
		return "Entity Types";
	}
}
