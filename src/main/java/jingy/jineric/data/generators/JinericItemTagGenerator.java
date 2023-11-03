package jingy.jineric.data.generators;

import jingy.jineric.item.JinericItems;
import jingy.jineric.tag.JinericItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class JinericItemTagGenerator extends FabricTagProvider.ItemTagProvider {

   public JinericItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable BlockTagProvider blockTagProvider) {
      super(output, completableFuture, blockTagProvider);
   }

   public JinericItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
      super(output, completableFuture);
   }

   @Override
   protected void configure(RegistryWrapper.WrapperLookup arg) {
      this.getOrCreateTagBuilder(JinericItemTags.PETRIFIED_OAK_LOGS).add(JinericItems.PETRIFIED_OAK_LOG).add(JinericItems.PETRIFIED_OAK_WOOD).add(JinericItems.STRIPPED_PETRIFIED_OAK_LOG).add(JinericItems.STRIPPED_PETRIFIED_OAK_WOOD);
   }
}
