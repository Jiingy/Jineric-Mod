package jingy.jineric.data.generators;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.registry.JinericWoodType;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodType;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.Items;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class JinericBlockLootTableGenerator extends FabricBlockLootTableProvider {
   public JinericBlockLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
      super(dataOutput, registryLookup);
   }

   @Override
   public void generate() {
      this.genVanillaWoodFamilyAdditionDrops();
      this.genBlockFamilyDrops();
      this.genUniqueDrops();
      this.genWoodSets();
   }

   private void genUniqueDrops() {
      this.addDrop(JinericBlocks.REFINERY);
      this.addDrop(JinericBlocks.STONE_BRICK_PILLAR);
      this.addDrop(JinericBlocks.DRIPSTONE_BRICK_PILLAR);
      this.addDrop(JinericBlocks.BLAZE_ROD_BLOCK);
      this.addDrop(JinericBlocks.ENDER_PEARL_BLOCK);
      this.addDrop(JinericBlocks.PAPER_BLOCK);
      this.addDrop(JinericBlocks.EGG_BLOCK);
      this.addDrop(JinericBlocks.STICK_BLOCK);
      this.addDrop(JinericBlocks.ROTTEN_FLESH_BLOCK);
      this.addDrop(JinericBlocks.SUGAR_BLOCK);
      this.addDrop(JinericBlocks.PRISMARINE_CRYSTAL_BLOCK);
      this.addDrop(JinericBlocks.BONE_MEAL_BLOCK);
      this.addDrop(JinericBlocks.FLINT_BLOCK);
      this.addDrop(JinericBlocks.CHARCOAL_BLOCK);
      this.addDrop(JinericBlocks.SOUL_JACK_O_LANTERN);
      this.addDrop(JinericBlocks.FULL_GRASS_BLOCK, block -> this.drops(block, Blocks.DIRT));
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

   private void genVanillaWoodFamilyAdditionDrops() {
      DefaultedRegistry<Block> blockRegistry = Registries.BLOCK;
      List<WoodType> woodTypes = WoodType.stream().toList();
      woodTypes.forEach(
              woodType -> {
                 // TODO: SKIPS OAK BECAUSE JINERIC DOES NOT HAVE UNIQUE OAK AT THE MOMENT
                 if (woodType != WoodType.OAK && woodType != WoodType.PALE_OAK && woodType != JinericWoodType.PETRIFIED_OAK) {
                    this.addDrop(blockRegistry.get(JinericMain.ofJineric(woodType.name() + "_ladder")));
                    this.addDrop(blockRegistry.get(JinericMain.ofJineric(woodType.name() + "_bookshelf")), block -> this.drops(block, Items.BOOK, ConstantLootNumberProvider.create(3.0F)));
                    this.addNameableContainerDrop(blockRegistry.get(JinericMain.ofJineric(woodType.name() + "_chest")));
                    this.addNameableContainerDrop(blockRegistry.get(JinericMain.ofJineric("trapped_" + woodType.name() + "_chest")));
                 }
              }
      );
   }

   private void addNameableContainerDrop(Block drop) {
      this.addDrop(drop, this::nameableContainerDrops);
   }

   private void genBlockFamilyDrops() {
      Stream<BlockFamily> blockFamilies = BlockFamilies.getFamilies();
      blockFamilies.forEach(blockFamily -> {
         Block baseBlock = blockFamily.getBaseBlock();
         for (Block block : blockFamily.getVariants().values()) {
            if (Registries.BLOCK.getId(block).getNamespace().matches("jineric")) {
               this.addDrop(block);
            }
         }
         if (Registries.BLOCK.getId(baseBlock).getNamespace().matches("jineric")) {
            this.addDrop(baseBlock);
         }
      });
   }

   @Override
   public String getName() {
      return "jineric_block_loot_table";
   }
}
