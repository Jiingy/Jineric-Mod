package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.entity.RefineryBlockEntity;
import jingy.jineric.block.entity.ShulkerChestBlockEntity;
import jingy.jineric.block.entity.custom.JinericCampfireBlockEntity;
import jingy.jineric.block.entity.custom.chest.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JinericBlockEntityType {
   //CHESTS
   public static final BlockEntityType<AcaciaChestBlockEntity> ACACIA_CHEST =
           FabricBlockEntityTypeBuilder.create(AcaciaChestBlockEntity::new, JinericBlocks.ACACIA_CHEST).build(null);

   public static final BlockEntityType<BirchChestBlockEntity> BIRCH_CHEST =
           FabricBlockEntityTypeBuilder.create(BirchChestBlockEntity::new, JinericBlocks.BIRCH_CHEST).build(null);

   public static final BlockEntityType<BorealChestBlockEntity> BOREAL_CHEST =
           FabricBlockEntityTypeBuilder.create(BorealChestBlockEntity::new, JinericBlocks.BOREAL_CHEST).build(null);

   public static final BlockEntityType<CrimsonChestBlockEntity> CRIMSON_CHEST =
           FabricBlockEntityTypeBuilder.create(CrimsonChestBlockEntity::new, JinericBlocks.CRIMSON_CHEST).build(null);

   public static final BlockEntityType<DarkOakChestBlockEntity> DARK_OAK_CHEST =
           FabricBlockEntityTypeBuilder.create(DarkOakChestBlockEntity::new, JinericBlocks.DARK_OAK_CHEST).build(null);

   public static final BlockEntityType<JungleChestBlockEntity> JUNGLE_CHEST =
           FabricBlockEntityTypeBuilder.create(JungleChestBlockEntity::new, JinericBlocks.JUNGLE_CHEST).build(null);

   public static final BlockEntityType<SpruceChestBlockEntity> SPRUCE_CHEST =
           FabricBlockEntityTypeBuilder.create(SpruceChestBlockEntity::new, JinericBlocks.SPRUCE_CHEST).build(null);

   public static final BlockEntityType<WarpedChestBlockEntity> WARPED_CHEST =
           FabricBlockEntityTypeBuilder.create(WarpedChestBlockEntity::new, JinericBlocks.WARPED_CHEST).build(null);

   public static final BlockEntityType<MangroveChestBlockEntity> MANGROVE_CHEST =
           FabricBlockEntityTypeBuilder.create(MangroveChestBlockEntity::new, JinericBlocks.MANGROVE_CHEST).build(null);

   public static final BlockEntityType<ShulkerChestBlockEntity> SHULKER_CHEST =
           FabricBlockEntityTypeBuilder.create(ShulkerChestBlockEntity::new, JinericBlocks.SHULKER_CHEST).build(null);


   public static final BlockEntityType<RefineryBlockEntity> REFINERY =
           FabricBlockEntityTypeBuilder.create(RefineryBlockEntity::new, JinericBlocks.REFINERY).build(null);

   public static final BlockEntityType<JinericCampfireBlockEntity> CAMPFIRE =
           FabricBlockEntityTypeBuilder.create(JinericCampfireBlockEntity::new, JinericBlocks.REDSTONE_CAMPFIRE).build(null);

   public static void registerBlockEntities() {
      //CHESTS
      Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "acacia_chest"), ACACIA_CHEST);
      Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "birch_chest"), BIRCH_CHEST);
      Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "boreal_chest"), BOREAL_CHEST);
      Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "crimson_chest"), CRIMSON_CHEST);
      Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "dark_oak_chest"), DARK_OAK_CHEST);
      Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "jungle_chest"), JUNGLE_CHEST);
      Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "spruce_chest"), SPRUCE_CHEST);
      Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "warped_chest"), WARPED_CHEST);
      Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "mangrove_chest"), MANGROVE_CHEST);
      Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "shulker_chest"), SHULKER_CHEST);

      Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "refinery"), REFINERY);
      Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "campfire"), CAMPFIRE);
   }
}

