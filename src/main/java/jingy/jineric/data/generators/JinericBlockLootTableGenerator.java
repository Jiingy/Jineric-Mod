package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;

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
      genWoodSets();
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
      addDrop(JinericBlocks.CHERRY_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.BAMBOO_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.CRIMSON_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.WARPED_CHEST, this::nameableContainerDrops);
      //Trapped Chests
      addDrop(JinericBlocks.TRAPPED_SPRUCE_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.TRAPPED_BIRCH_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.TRAPPED_JUNGLE_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.TRAPPED_ACACIA_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.TRAPPED_DARK_OAK_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.TRAPPED_MANGROVE_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.TRAPPED_CHERRY_CHEST, this::nameableContainerDrops);
      addDrop(JinericBlocks.TRAPPED_BAMBOO_CHEST, this::nameableContainerDrops);
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

   private void genWoodSets() {
      // PETRIFIED OAK
      this.addDrop(JinericBlocks.PETRIFIED_OAK_LOG);
      this.addDrop(JinericBlocks.PETRIFIED_OAK_WOOD);
      this.addDrop(JinericBlocks.STRIPPED_PETRIFIED_OAK_LOG);
      this.addDrop(JinericBlocks.STRIPPED_PETRIFIED_OAK_WOOD);
      this.addDrop(JinericBlocks.PETRIFIED_OAK_PLANKS);
      this.addDrop(JinericBlocks.PETRIFIED_OAK_STAIRS);
      this.addDrop(JinericBlocks.PETRIFIED_OAK_SLAB);
      this.addDrop(JinericBlocks.PETRIFIED_OAK_FENCE);
      this.addDrop(JinericBlocks.PETRIFIED_OAK_FENCE_GATE);
      this.addDrop(JinericBlocks.PETRIFIED_OAK_DOOR, this::doorDrops);
      this.addDrop(JinericBlocks.PETRIFIED_OAK_TRAPDOOR);
      this.addDrop(JinericBlocks.PETRIFIED_OAK_PRESSURE_PLATE);
      this.addDrop(JinericBlocks.PETRIFIED_OAK_BUTTON);
      this.addDrop(JinericBlocks.PETRIFIED_OAK_LEAVES, (block) -> this.leavesDrops(block, JinericBlocks.PETRIFIED_OAK_SAPLING, SAPLING_DROP_CHANCE));
      this.addDrop(JinericBlocks.PETRIFIED_OAK_SAPLING);
      this.addPottedPlantDrops(JinericBlocks.POTTED_PETRIFIED_OAK_SAPLING);
      this.addDrop(JinericBlocks.PETRIFIED_OAK_LADDER);
      this.addDrop(JinericBlocks.PETRIFIED_OAK_BOOKSHELF, (block) -> this.drops(block, Items.BOOK, ConstantLootNumberProvider.create(3.0F)));
      this.addDrop(JinericBlocks.PETRIFIED_OAK_SIGN);
      this.addDrop(JinericBlocks.PETRIFIED_OAK_HANGING_SIGN);
   }
}
