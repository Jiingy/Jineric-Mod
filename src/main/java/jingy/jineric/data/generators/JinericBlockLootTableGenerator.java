package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class JinericBlockLootTableGenerator extends FabricBlockLootTableProvider {
   //TODO: Add convenient way to add a simple block set's loot table
   public JinericBlockLootTableGenerator(FabricDataOutput dataGenerator) {
      super(dataGenerator);
   }

   @Override
   public void generate() {
      nameableContainersGen();
      genSimpleBlockSets();
      genUniqueBlocks();
   }

   private void genUniqueBlocks() {
      addDrop(JinericBlocks.REFINERY);
   }

   private void nameableContainersGen() {
      //Chests
      addDrop(JinericBlocks.SPRUCE_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.BIRCH_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.JUNGLE_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.ACACIA_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.DARK_OAK_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.MANGROVE_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.CRIMSON_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.WARPED_CHEST, this::nameableContainerDrops);
      //Trapped Chests
      addDrop(JinericBlocks.TRAPPED_SPRUCE_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.TRAPPED_BIRCH_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.TRAPPED_JUNGLE_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.TRAPPED_ACACIA_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.TRAPPED_DARK_OAK_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.TRAPPED_MANGROVE_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.TRAPPED_CRIMSON_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.TRAPPED_WARPED_CHEST, this::nameableContainerDrops);
   }

   private void genSimpleBlockSets() {
      addDrop(JinericBlocks.SNOW_BRICKS);
      addDrop(JinericBlocks.SNOW_BRICK_STAIRS);
      addDrop(JinericBlocks.SNOW_BRICK_SLAB);
      addDrop(JinericBlocks.SNOW_BRICK_WALL);
      addDrop(JinericBlocks.CRACKED_DRIPSTONE_TILES);
      addDrop(JinericBlocks.CRACKED_DRIPSTONE_TILE_STAIRS);
      addDrop(JinericBlocks.CRACKED_DRIPSTONE_TILE_SLAB);
      addDrop(JinericBlocks.CRACKED_DRIPSTONE_TILE_WALL);
      addDrop(JinericBlocks.CRACKED_DRIPSTONE_BRICKS);
      addDrop(JinericBlocks.CRACKED_DRIPSTONE_BRICK_STAIRS);
      addDrop(JinericBlocks.CRACKED_DRIPSTONE_BRICK_SLAB);
      addDrop(JinericBlocks.CRACKED_DRIPSTONE_BRICK_WALL);
      addDrop(JinericBlocks.CRACKED_TUFF_TILES);
      addDrop(JinericBlocks.CRACKED_TUFF_TILE_STAIRS);
      addDrop(JinericBlocks.CRACKED_TUFF_TILE_SLAB);
      addDrop(JinericBlocks.CRACKED_TUFF_TILE_WALL);
      addDrop(JinericBlocks.CRACKED_STONE_TILES);
      addDrop(JinericBlocks.CRACKED_STONE_TILE_STAIRS);
      addDrop(JinericBlocks.CRACKED_STONE_TILE_SLAB);
      addDrop(JinericBlocks.CRACKED_STONE_TILE_WALL);
   }
}
