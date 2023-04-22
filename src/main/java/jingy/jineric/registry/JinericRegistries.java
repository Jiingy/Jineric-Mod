package jingy.jineric.registry;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.item.JinericItems;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;

public class JinericRegistries {
   public static void registerJinericMod() {
      registerIsFuel();
      registerCompostable();
      registerStrippable();
      registerFlammable();
      registerOxidizableBlockPairs();
      registerWaxableBlockPairs();
   }

   private static void registerIsFuel() {
      FuelRegistry registry = FuelRegistry.INSTANCE;
//      registry.add(JinericItems.BOREAL_WOOD, 300);
//      registry.add(JinericItems.STRIPPED_BOREAL_WOOD, 300);
//      registry.add(JinericItems.BOREAL_LOG, 300);
//      registry.add(JinericItems.STRIPPED_BOREAL_LOG, 300);
//      registry.add(JinericItems.STRIPPED_BOREAL_LOG, 300);
//      registry.add(JinericItems.BOREAL_FENCE, 300);
//      registry.add(JinericItems.BOREAL_FENCE_GATE, 300);
      //BOOKSHELVES
//      registry.add(JinericItems.BOREAL_BOOKSHELF, 300);
      registry.add(JinericItems.SPRUCE_BOOKSHELF, 300);
      registry.add(JinericItems.BIRCH_BOOKSHELF, 300);
      registry.add(JinericItems.JUNGLE_BOOKSHELF, 300);
      registry.add(JinericItems.ACACIA_BOOKSHELF, 300);
      registry.add(JinericItems.DARK_OAK_BOOKSHELF, 300);
      registry.add(JinericItems.MANGROVE_BOOKSHELF, 300);
      registry.add(JinericItems.CRIMSON_BOOKSHELF, 300);
      registry.add(JinericItems.WARPED_BOOKSHELF, 300);
      //LADDERS
//      registry.add(JinericItems.BOREAL_LADDER, 300);
      registry.add(JinericItems.SPRUCE_LADDER, 300);
      registry.add(JinericItems.BIRCH_LADDER, 300);
      registry.add(JinericItems.JUNGLE_LADDER, 300);
      registry.add(JinericItems.ACACIA_LADDER, 300);
      registry.add(JinericItems.DARK_OAK_LADDER, 300);
      registry.add(JinericItems.MANGROVE_LADDER, 300);
      registry.add(JinericItems.CRIMSON_LADDER, 300);
      registry.add(JinericItems.WARPED_LADDER, 300);
      //CHESTS
//      registry.add(JinericItems.BOREAL_CHEST, 300);
      registry.add(JinericItems.SPRUCE_CHEST, 300);
      registry.add(JinericItems.BIRCH_CHEST, 300);
      registry.add(JinericItems.JUNGLE_CHEST, 300);
      registry.add(JinericItems.ACACIA_CHEST, 300);
      registry.add(JinericItems.DARK_OAK_CHEST, 300);
      registry.add(JinericItems.MANGROVE_CHEST, 300);
      registry.add(JinericItems.CRIMSON_CHEST, 300);
      registry.add(JinericItems.WARPED_CHEST, 300);
      registry.add(JinericItems.TRAPPED_SPRUCE_CHEST, 300);
      registry.add(JinericItems.TRAPPED_BIRCH_CHEST, 300);
      registry.add(JinericItems.TRAPPED_JUNGLE_CHEST, 300);
      registry.add(JinericItems.TRAPPED_ACACIA_CHEST, 300);
      registry.add(JinericItems.TRAPPED_DARK_OAK_CHEST, 300);
      registry.add(JinericItems.TRAPPED_MANGROVE_CHEST, 300);
      registry.add(JinericItems.TRAPPED_CRIMSON_CHEST, 300);
      registry.add(JinericItems.TRAPPED_WARPED_CHEST, 300);
   }

   private static void registerCompostable() {
      CompostingChanceRegistry registry = CompostingChanceRegistry.INSTANCE;
      registry.add(JinericItems.TUMBLEWEED, 0.5F);
//      registry.add(JinericItems.BOREAL_LEAVES, 0.5F);
   }

   private static void registerStrippable() {
//      StrippableBlockRegistry.register(JinericBlocks.BOREAL_LOG, JinericBlocks.STRIPPED_BOREAL_LOG);
//      StrippableBlockRegistry.register(JinericBlocks.BOREAL_WOOD, JinericBlocks.STRIPPED_BOREAL_WOOD);
   }

   private static void registerFlammable() {
      FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();
//      instance.add(JinericBlocks.BOREAL_WOOD, 5, 5);
//      instance.add(JinericBlocks.BOREAL_LOG, 5, 5);
//      instance.add(JinericBlocks.STRIPPED_BOREAL_LOG, 5, 5);
//      instance.add(JinericBlocks.STRIPPED_BOREAL_WOOD, 5, 5);
//      instance.add(JinericBlocks.BOREAL_PLANKS, 5, 20);
//      instance.add(JinericBlocks.BOREAL_STAIRS, 5, 20);
//      instance.add(JinericBlocks.BOREAL_SLAB, 5, 20);
//      instance.add(JinericBlocks.BOREAL_FENCE, 5, 20);
//      instance.add(JinericBlocks.BOREAL_FENCE_GATE, 5, 20);
//      instance.add(JinericBlocks.BOREAL_TRAPDOOR, 5, 20);
//      instance.add(JinericBlocks.BOREAL_DOOR, 5, 20);
//      instance.add(JinericBlocks.BOREAL_PRESSURE_PLATE, 5, 20);
//      instance.add(JinericBlocks.BOREAL_BUTTON, 5, 20);
//      instance.add(JinericBlocks.BOREAL_LEAVES, 30, 60);
      instance.add(JinericBlocks.TUMBLEWEED, 30, 60);
      instance.add(JinericBlocks.SPRUCE_BOOKSHELF, 30, 20);
      instance.add(JinericBlocks.BIRCH_BOOKSHELF, 30, 20);
      instance.add(JinericBlocks.JUNGLE_BOOKSHELF, 30, 20);
      instance.add(JinericBlocks.ACACIA_BOOKSHELF, 30, 20);
      instance.add(JinericBlocks.DARK_OAK_BOOKSHELF, 30, 20);
      instance.add(JinericBlocks.MANGROVE_BOOKSHELF, 30, 20);
      instance.add(JinericBlocks.CRIMSON_BOOKSHELF, 30, 20);
      instance.add(JinericBlocks.WARPED_BOOKSHELF, 30, 20);
      instance.add(JinericBlocks.PAPER_BLOCK, 5, 20);
      instance.add(JinericBlocks.STICK_BLOCK, 5, 20);
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
