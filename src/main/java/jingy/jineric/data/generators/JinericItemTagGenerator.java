package jingy.jineric.data.generators;

import jingy.jineric.item.JinericItems;
import jingy.jineric.tag.JinericItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
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
      this.getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).addTag(JinericItemTags.PETRIFIED_OAK_LOGS).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.PLANKS).add(JinericItems.PETRIFIED_OAK_PLANKS).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.STAIRS).add(JinericItems.PETRIFIED_OAK_STAIRS).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(JinericItems.PETRIFIED_OAK_STAIRS).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.SLABS).add(JinericItems.PETRIFIED_OAK_SLAB).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(JinericItems.PETRIFIED_OAK_SLAB).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.FENCES).add(JinericItems.PETRIFIED_OAK_FENCE, JinericItems.RED_NETHER_BRICK_FENCE).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(JinericItems.PETRIFIED_OAK_FENCE).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.DOORS).add(JinericItems.PETRIFIED_OAK_DOOR).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(JinericItems.PETRIFIED_OAK_DOOR).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.TRAPDOORS).add(JinericItems.PETRIFIED_OAK_TRAPDOOR).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(JinericItems.PETRIFIED_OAK_TRAPDOOR).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(JinericItems.PETRIFIED_OAK_PRESSURE_PLATE).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.BUTTONS).add(JinericItems.PETRIFIED_OAK_BUTTON).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(JinericItems.PETRIFIED_OAK_BUTTON).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.LEAVES).add(JinericItems.PETRIFIED_OAK_LEAVES).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.SAPLINGS).add(JinericItems.PETRIFIED_OAK_SAPLING).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.SIGNS).add(JinericItems.PETRIFIED_OAK_SIGN).setReplace(false);
      this.getOrCreateTagBuilder(ItemTags.HANGING_SIGNS).add(JinericItems.PETRIFIED_OAK_HANGING_SIGN).setReplace(false);
   }
}
