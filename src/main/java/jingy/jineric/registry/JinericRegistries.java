package jingy.jineric.registry;

import jingy.jineric.block.blockentity.shulkerchest.ShulkerChestBlockEntity;
import jingy.jineric.block.custom.campfire.JinericCampfireBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.util.registry.Registry;

public class JinericRegistries {

   public static void registerJinericMod() {
      registerIsFuel();
      registerCompostable();
      registerStrippable();
      registerFlammable();
      registerBlockEntities();
      registerOxidizableBlockPairs();
      registerWaxableBlockPairs();
      registerEntityAttributes();
   }

   private static void registerIsFuel() {
      FuelRegistry registry = FuelRegistry.INSTANCE;
      registry.add(JinericItems.BOREAL_WOOD, 300);
      registry.add(JinericItems.STRIPPED_BOREAL_WOOD, 300);
      registry.add(JinericItems.BOREAL_LOG, 300);
      registry.add(JinericItems.STRIPPED_BOREAL_LOG, 300);
      registry.add(JinericItems.STRIPPED_BOREAL_LOG, 300);
      registry.add(JinericItems.BOREAL_FENCE, 300);
      registry.add(JinericItems.BOREAL_FENCE_GATE, 300);
   }

   private static void registerCompostable() {
      CompostingChanceRegistry registry = CompostingChanceRegistry.INSTANCE;
      registry.add(JinericItems.TUMBLEWEED, 0.5F);
      registry.add(JinericItems.BOREAL_LEAVES, 0.5F);
   }

   private static void registerStrippable() {
      StrippableBlockRegistry.register(JinericBlocks.BOREAL_LOG, JinericBlocks.STRIPPED_BOREAL_LOG);
      StrippableBlockRegistry.register(JinericBlocks.BOREAL_WOOD, JinericBlocks.STRIPPED_BOREAL_WOOD);

   }

   private static void registerFlammable() {
      FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();
      instance.add(JinericBlocks.BOREAL_WOOD, 5, 5);
      instance.add(JinericBlocks.BOREAL_LOG, 5, 5);
      instance.add(JinericBlocks.STRIPPED_BOREAL_LOG, 5, 5);
      instance.add(JinericBlocks.STRIPPED_BOREAL_WOOD, 5, 5);
      instance.add(JinericBlocks.BOREAL_PLANKS, 5, 20);
      instance.add(JinericBlocks.BOREAL_STAIRS, 5, 20);
      instance.add(JinericBlocks.BOREAL_SLAB, 5, 20);
      instance.add(JinericBlocks.BOREAL_FENCE, 5, 20);
      instance.add(JinericBlocks.BOREAL_FENCE_GATE, 5, 20);
      instance.add(JinericBlocks.BOREAL_TRAPDOOR, 5, 20);
      instance.add(JinericBlocks.BOREAL_DOOR, 5, 20);
      instance.add(JinericBlocks.BOREAL_PRESSURE_PLATE, 5, 20);
      instance.add(JinericBlocks.BOREAL_BUTTON, 5, 20);
      //instance.add(JinericBlocks.BOREAL_SIGN, 5, 20);
      instance.add(JinericBlocks.CHARCOAL_BLOCK, 5, 5);
      instance.add(JinericBlocks.BAMBOO_BLOCK, 60, 20);
      instance.add(JinericBlocks.BOREAL_LEAVES, 30, 60);
      instance.add(JinericBlocks.TUMBLEWEED, 30, 60);

   }

   private static void registerBlockEntities() {
      JinericBlocks.SHULKER_CHEST_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
              "jineric:shulker_chest_entity", FabricBlockEntityTypeBuilder.create(ShulkerChestBlockEntity::new, JinericBlocks.SHULKER_CHEST).build(null));


      JinericBlocks.JINERIC_CAMPFIRE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
              "jineric:redstone_campfire_entity", FabricBlockEntityTypeBuilder.create(JinericCampfireBlockEntity::new, JinericBlocks.REDSTONE_CAMPFIRE).build(null));
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

   private static void registerEntityAttributes() {
      //EntityModelLayerRegistry.registerModelLayer(JinericEntityModelLayers.MANX_LOAGHTAN, );
   }
}
