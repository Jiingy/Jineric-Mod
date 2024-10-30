package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.block.entity.JinericChestBlockEntity;
import jingy.jineric.block.entity.JinericTrappedChestBlockEntity;
import jingy.jineric.block.entity.RedstoneCampfireBlockEntity;
import jingy.jineric.block.entity.RefineryBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JinericBlockEntityType {

   public static final BlockEntityType<JinericChestBlockEntity> JINERIC_CHEST =
           FabricBlockEntityTypeBuilder.create(
                   JinericChestBlockEntity::new,
                   JinericBlocks.SPRUCE_CHEST,
                   JinericBlocks.BIRCH_CHEST,
                   JinericBlocks.JUNGLE_CHEST,
                   JinericBlocks.ACACIA_CHEST,
                   JinericBlocks.DARK_OAK_CHEST,
                   JinericBlocks.MANGROVE_CHEST,
                   JinericBlocks.CHERRY_CHEST,
                   JinericBlocks.BAMBOO_CHEST,
                   JinericBlocks.CRIMSON_CHEST,
                   JinericBlocks.WARPED_CHEST
           ).build();
   public static final BlockEntityType<JinericTrappedChestBlockEntity> JINERIC_TRAPPED_CHEST =
           FabricBlockEntityTypeBuilder.create(
                   JinericTrappedChestBlockEntity::new,
                   JinericBlocks.TRAPPED_SPRUCE_CHEST,
                   JinericBlocks.TRAPPED_BIRCH_CHEST,
                   JinericBlocks.TRAPPED_JUNGLE_CHEST,
                   JinericBlocks.TRAPPED_ACACIA_CHEST,
                   JinericBlocks.TRAPPED_DARK_OAK_CHEST,
                   JinericBlocks.TRAPPED_MANGROVE_CHEST,
                   JinericBlocks.TRAPPED_CHERRY_CHEST,
                   JinericBlocks.TRAPPED_BAMBOO_CHEST,
                   JinericBlocks.TRAPPED_CRIMSON_CHEST,
                   JinericBlocks.TRAPPED_WARPED_CHEST
           ).build();

   public static final BlockEntityType<RefineryBlockEntity> REFINERY =
           FabricBlockEntityTypeBuilder.create(RefineryBlockEntity::new, JinericBlocks.REFINERY).build();

   public static final BlockEntityType<RedstoneCampfireBlockEntity> REDSTONE_CAMPFIRE =
           FabricBlockEntityTypeBuilder.create(RedstoneCampfireBlockEntity::new, JinericBlocks.REDSTONE_CAMPFIRE).build();

   public static void registerBlockEntities() {
      Registry.register(Registries.BLOCK_ENTITY_TYPE, JinericMain.ofJineric("jineric_chest"), JINERIC_CHEST);
      Registry.register(Registries.BLOCK_ENTITY_TYPE, JinericMain.ofJineric("jineric_trapped_chest"), JINERIC_TRAPPED_CHEST);
//      Registry.register(Registries.BLOCK_ENTITY_TYPE, JinericMain.ofJineric("shulker_chest"), SHULKER_CHEST);
      Registry.register(Registries.BLOCK_ENTITY_TYPE, JinericMain.ofJineric("refinery"), REFINERY);
      Registry.register(Registries.BLOCK_ENTITY_TYPE, JinericMain.ofJineric("campfire"), REDSTONE_CAMPFIRE);
   }
}

