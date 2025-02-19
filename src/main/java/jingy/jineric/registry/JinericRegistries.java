package jingy.jineric.registry;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.item.JinericItems;
import jingy.jineric.tag.JinericBlockTags;
import jingy.jineric.tag.JinericItemTags;
import net.fabricmc.fabric.api.registry.*;

public class JinericRegistries {
   public static void initializeJinericRegistries() {
      registerIsFuel();
      registerCompostable();
      registerStrippable();
      registerFlammable();
      registerOxidizableBlockPairs();
      registerWaxableBlockPairs();
   }

   private static void registerIsFuel() {
      FuelRegistryEvents.BUILD.register((builder, context) -> builder
              .add(JinericItemTags.WOODEN_BOOKSHELVES, 300)
              .add(JinericItemTags.WOODEN_CHESTS, 300)
              .add(JinericItemTags.WOODEN_TRAPPED_CHESTS, 300)
              .add(JinericItemTags.WOODEN_LADDERS, 300)
      );
   }

   private static void registerCompostable() {
      CompostingChanceRegistry registry = CompostingChanceRegistry.INSTANCE;
      registry.add(JinericItems.PETRIFIED_OAK_LEAVES, 0.3F);
      registry.add(JinericItems.PETRIFIED_OAK_SAPLING, 0.3F);
   }

   private static void registerStrippable() {
      StrippableBlockRegistry.register(JinericBlocks.PETRIFIED_OAK_LOG, JinericBlocks.STRIPPED_PETRIFIED_OAK_LOG);
      StrippableBlockRegistry.register(JinericBlocks.PETRIFIED_OAK_WOOD, JinericBlocks.STRIPPED_PETRIFIED_OAK_WOOD);
   }

   private static void registerFlammable() {
      FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();
      instance.add(JinericBlockTags.WOODEN_BOOKSHELVES, 30, 20);
      instance.add(JinericBlocks.PAPER_BLOCK, 5, 20);
      instance.add(JinericBlocks.STICK_BLOCK, 5, 20);
      // PETRIFIED OAK
      instance.add(JinericBlockTags.PETRIFIED_OAK_LOGS, 5, 5);
      instance.add(JinericBlocks.PETRIFIED_OAK_PLANKS, 5, 20);
      instance.add(JinericBlocks.PETRIFIED_OAK_SLAB, 5, 20);
      instance.add(JinericBlocks.PETRIFIED_OAK_FENCE_GATE, 5, 20);
      instance.add(JinericBlocks.PETRIFIED_OAK_FENCE, 5, 20);
      instance.add(JinericBlocks.PETRIFIED_OAK_STAIRS, 5, 20);
      instance.add(JinericBlocks.PETRIFIED_OAK_LEAVES, 30, 60);
   }

   private static void registerOxidizableBlockPairs() {
      OxidizableBlocksRegistry.registerOxidizableBlockPair(JinericBlocks.CUT_COPPER_WALL, JinericBlocks.EXPOSED_CUT_COPPER_WALL);
      OxidizableBlocksRegistry.registerOxidizableBlockPair(JinericBlocks.EXPOSED_CUT_COPPER_WALL, JinericBlocks.WEATHERED_CUT_COPPER_WALL);
      OxidizableBlocksRegistry.registerOxidizableBlockPair(JinericBlocks.WEATHERED_CUT_COPPER_WALL, JinericBlocks.OXIDIZED_CUT_COPPER_WALL);
   }

   private static void registerWaxableBlockPairs() {
      OxidizableBlocksRegistry.registerWaxableBlockPair(JinericBlocks.CUT_COPPER_WALL, JinericBlocks.WAXED_CUT_COPPER_WALL);
      OxidizableBlocksRegistry.registerWaxableBlockPair(JinericBlocks.EXPOSED_CUT_COPPER_WALL, JinericBlocks.WAXED_EXPOSED_CUT_COPPER_WALL);
      OxidizableBlocksRegistry.registerWaxableBlockPair(JinericBlocks.WEATHERED_CUT_COPPER_WALL, JinericBlocks.WAXED_WEATHERED_CUT_COPPER_WALL);
      OxidizableBlocksRegistry.registerWaxableBlockPair(JinericBlocks.OXIDIZED_CUT_COPPER_WALL, JinericBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL);
   }
}
