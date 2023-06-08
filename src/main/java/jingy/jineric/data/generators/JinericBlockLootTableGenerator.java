package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;

public class JinericBlockLootTableGenerator extends FabricBlockLootTableProvider {
   public JinericBlockLootTableGenerator(FabricDataOutput dataGenerator) {
      super(dataGenerator);
   }

   @Override
   public void generate() {
      nameableContainersGen();
   }

   public void nameableContainersGen() {
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

      addDrop(JinericBlocks.SNOW_BRICKS);
      addDrop(JinericBlocks.SNOW_BRICK_STAIRS);
      addDrop(JinericBlocks.SNOW_BRICK_SLAB);
      addDrop(JinericBlocks.SNOW_BRICK_WALL);
      addDrop(JinericBlocks.REFINERY);
   }

   public void addBlockSetDrops(Block block, Block stairBlock, Block slabBlock, Block wallBlock) {
      addDrop(block);
      addDrop(stairBlock);
      addDrop(slabBlock);
      addDrop(wallBlock);
   }
}
