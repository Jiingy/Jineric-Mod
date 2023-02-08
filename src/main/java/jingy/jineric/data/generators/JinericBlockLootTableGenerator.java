package jingy.jineric.data.generators;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;

public class JinericBlockLootTableGenerator extends FabricBlockLootTableProvider {
   public JinericBlockLootTableGenerator(FabricDataOutput dataGenerator) {
      super(dataGenerator);
   }

   @Override
   public void generate() {
   }

   public void addBlockSetDrops(Block block, Block stairBlock, Block slabBlock, Block wallBlock) {
      addDrop(block);
      addDrop(stairBlock);
      addDrop(slabBlock);
      addDrop(wallBlock);
   }
}
