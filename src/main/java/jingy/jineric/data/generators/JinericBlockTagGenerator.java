package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.tag.JinericBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class JinericBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
   public JinericBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
      super(output, registriesFuture);
   }

   @Override
   protected void configure(RegistryWrapper.WrapperLookup arg) {
      petrifiedOak();
      addStairs();
      addSlabs();
   }

   private void petrifiedOak() {
      this.getOrCreateTagBuilder(JinericBlockTags.PETRIFIED_OAK_LOGS).add(JinericBlocks.PETRIFIED_OAK_LOG).add(JinericBlocks.PETRIFIED_OAK_WOOD).add(JinericBlocks.STRIPPED_PETRIFIED_OAK_LOG).add(JinericBlocks.STRIPPED_PETRIFIED_OAK_WOOD);
      this.getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).addTag(JinericBlockTags.PETRIFIED_OAK_LOGS).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.PLANKS).add(JinericBlocks.PETRIFIED_OAK_PLANKS).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.STAIRS).add(JinericBlocks.PETRIFIED_OAK_STAIRS).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(JinericBlocks.PETRIFIED_OAK_STAIRS).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.SLABS).add(JinericBlocks.PETRIFIED_OAK_SLAB).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(JinericBlocks.PETRIFIED_OAK_SLAB).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.FENCES).add(JinericBlocks.PETRIFIED_OAK_FENCE, JinericBlocks.RED_NETHER_BRICK_FENCE).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(JinericBlocks.PETRIFIED_OAK_FENCE).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(JinericBlocks.PETRIFIED_OAK_FENCE_GATE).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.DOORS).add(JinericBlocks.PETRIFIED_OAK_DOOR).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(JinericBlocks.PETRIFIED_OAK_DOOR).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.TRAPDOORS).add(JinericBlocks.PETRIFIED_OAK_TRAPDOOR).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(JinericBlocks.PETRIFIED_OAK_TRAPDOOR).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES).add(JinericBlocks.PETRIFIED_OAK_PRESSURE_PLATE).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(JinericBlocks.PETRIFIED_OAK_PRESSURE_PLATE).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.BUTTONS).add(JinericBlocks.PETRIFIED_OAK_BUTTON).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(JinericBlocks.PETRIFIED_OAK_BUTTON).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.LEAVES).add(JinericBlocks.PETRIFIED_OAK_LEAVES).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.SAPLINGS).add(JinericBlocks.PETRIFIED_OAK_SAPLING).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(JinericBlocks.PETRIFIED_OAK_SIGN).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(JinericBlocks.PETRIFIED_OAK_WALL_SIGN).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(JinericBlocks.PETRIFIED_OAK_HANGING_SIGN).setReplace(false);
      this.getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(JinericBlocks.PETRIFIED_OAK_WALL_HANGING_SIGN).setReplace(false);
   }

   private void addStairs() {
      this.getOrCreateTagBuilder(BlockTags.STAIRS)
              .add(JinericBlocks.SMOOTH_STONE_STAIRS)
              .add(JinericBlocks.POLISHED_STONE_STAIRS)
              .add(JinericBlocks.STONE_TILE_STAIRS)
              .add(JinericBlocks.CRACKED_STONE_TILE_STAIRS)
              .add(JinericBlocks.CRACKED_STONE_BRICK_STAIRS)
              .add(JinericBlocks.DRIPSTONE_STAIRS)
              .add(JinericBlocks.COBBLED_DRIPSTONE_STAIRS)
              .add(JinericBlocks.DRIPSTONE_BRICK_STAIRS)
              .add(JinericBlocks.CRACKED_DRIPSTONE_BRICK_STAIRS)
              .add(JinericBlocks.POLISHED_DRIPSTONE_STAIRS)
              .add(JinericBlocks.DRIPSTONE_TILE_STAIRS)
              .add(JinericBlocks.CRACKED_DRIPSTONE_TILE_STAIRS)
              .add(JinericBlocks.SMOOTH_DRIPSTONE_STAIRS)
              .add(JinericBlocks.TUFF_STAIRS)
              .add(JinericBlocks.COBBLED_TUFF_STAIRS)
              .add(JinericBlocks.TUFF_BRICK_STAIRS)
              .add(JinericBlocks.CRACKED_TUFF_BRICK_STAIRS)
              .add(JinericBlocks.POLISHED_TUFF_STAIRS)
              .add(JinericBlocks.TUFF_TILE_STAIRS)
              .add(JinericBlocks.CRACKED_TUFF_TILE_STAIRS)
              .add(JinericBlocks.SMOOTH_TUFF_STAIRS)
              .add(JinericBlocks.CUT_SANDSTONE_STAIRS)
              .add(JinericBlocks.POLISHED_SANDSTONE_STAIRS)
              .add(JinericBlocks.WAVY_SANDSTONE_STAIRS)
              .add(JinericBlocks.CUT_RED_SANDSTONE_STAIRS)
              .add(JinericBlocks.POLISHED_RED_SANDSTONE_STAIRS)
              .add(JinericBlocks.WAVY_RED_SANDSTONE_STAIRS)
              .add(JinericBlocks.SOUL_SANDSTONE_STAIRS)
              .add(JinericBlocks.CUT_SOUL_SANDSTONE_STAIRS)
              .add(JinericBlocks.POLISHED_SOUL_SANDSTONE_STAIRS)
              .add(JinericBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS)
              .add(JinericBlocks.WAVY_SOUL_SANDSTONE_STAIRS)
              .add(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS)
              .add(JinericBlocks.CRACKED_NETHER_BRICK_STAIRS)
              .add(JinericBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS)
              .add(JinericBlocks.CRACKED_DEEPSLATE_TILE_STAIRS)
              .add(JinericBlocks.SMOOTH_DEEPSLATE_STAIRS)
              .add(JinericBlocks.SMOOTH_BASALT_STAIRS)
              .add(JinericBlocks.CALCITE_STAIRS)
              .add(JinericBlocks.PACKED_ICE_STAIRS)
              .add(JinericBlocks.QUARTZ_BRICK_STAIRS)
              .add(JinericBlocks.SNOW_BRICK_STAIRS)
              .add(JinericBlocks.OBSIDIAN_STAIRS);
   }
   private void addSlabs() {
      this.getOrCreateTagBuilder(BlockTags.SLABS)
              .add(JinericBlocks.POLISHED_STONE_SLAB)
              .add(JinericBlocks.STONE_TILE_SLAB)
              .add(JinericBlocks.CRACKED_STONE_TILE_SLAB)
              .add(JinericBlocks.CRACKED_STONE_BRICK_SLAB)
              .add(JinericBlocks.DRIPSTONE_SLAB)
              .add(JinericBlocks.COBBLED_DRIPSTONE_SLAB)
              .add(JinericBlocks.DRIPSTONE_BRICK_SLAB)
              .add(JinericBlocks.CRACKED_DRIPSTONE_BRICK_SLAB)
              .add(JinericBlocks.POLISHED_DRIPSTONE_SLAB)
              .add(JinericBlocks.DRIPSTONE_TILE_SLAB)
              .add(JinericBlocks.CRACKED_DRIPSTONE_TILE_SLAB)
              .add(JinericBlocks.SMOOTH_DRIPSTONE_SLAB)
              .add(JinericBlocks.TUFF_SLAB)
              .add(JinericBlocks.COBBLED_TUFF_SLAB)
              .add(JinericBlocks.TUFF_BRICK_SLAB)
              .add(JinericBlocks.CRACKED_TUFF_BRICK_SLAB)
              .add(JinericBlocks.POLISHED_TUFF_SLAB)
              .add(JinericBlocks.TUFF_TILE_SLAB)
              .add(JinericBlocks.CRACKED_TUFF_TILE_SLAB)
              .add(JinericBlocks.SMOOTH_TUFF_SLAB)
              .add(JinericBlocks.POLISHED_SANDSTONE_SLAB)
              .add(JinericBlocks.WAVY_SANDSTONE_SLAB)
              .add(JinericBlocks.POLISHED_RED_SANDSTONE_SLAB)
              .add(JinericBlocks.WAVY_RED_SANDSTONE_SLAB)
              .add(JinericBlocks.SOUL_SANDSTONE_SLAB)
              .add(JinericBlocks.CUT_SOUL_SANDSTONE_SLAB)
              .add(JinericBlocks.POLISHED_SOUL_SANDSTONE_SLAB)
              .add(JinericBlocks.SMOOTH_SOUL_SANDSTONE_SLAB)
              .add(JinericBlocks.WAVY_SOUL_SANDSTONE_SLAB)
              .add(JinericBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB)
              .add(JinericBlocks.CRACKED_NETHER_BRICK_SLAB)
              .add(JinericBlocks.CRACKED_DEEPSLATE_BRICK_SLAB)
              .add(JinericBlocks.CRACKED_DEEPSLATE_TILE_SLAB)
              .add(JinericBlocks.SMOOTH_DEEPSLATE_SLAB)
              .add(JinericBlocks.SMOOTH_BASALT_SLAB)
              .add(JinericBlocks.CALCITE_SLAB)
              .add(JinericBlocks.PACKED_ICE_SLAB)
              .add(JinericBlocks.QUARTZ_BRICK_SLAB)
              .add(JinericBlocks.SNOW_BRICK_SLAB)
              .add(JinericBlocks.OBSIDIAN_SLAB);
   }
//   private static void addStairs() {
//
//   }
}
