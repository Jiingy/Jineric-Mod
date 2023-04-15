package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.block.entity.JinericChestBlockEntity;
import jingy.jineric.block.entity.RedstoneCampfireBlockEntity;
import jingy.jineric.block.entity.RefineryBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JinericBlockEntityType<T extends BlockEntity> {

   public static final BlockEntityType<JinericChestBlockEntity> JINERIC_CHEST =
           FabricBlockEntityTypeBuilder.create(
                   JinericChestBlockEntity::new,
                   JinericBlocks.ACACIA_CHEST,
                   JinericBlocks.BIRCH_CHEST,
                   JinericBlocks.BIRCH_CHEST,
                   JinericBlocks.CRIMSON_CHEST,
                   JinericBlocks.DARK_OAK_CHEST,
                   JinericBlocks.JUNGLE_CHEST,
                   JinericBlocks.SPRUCE_CHEST,
                   JinericBlocks.WARPED_CHEST,
                   JinericBlocks.MANGROVE_CHEST
           ).build();

   public static final BlockEntityType<RefineryBlockEntity> REFINERY =
           FabricBlockEntityTypeBuilder.create(RefineryBlockEntity::new, JinericBlocks.REFINERY).build();

   public static final BlockEntityType<RedstoneCampfireBlockEntity> REDSTONE_CAMPFIRE =
           FabricBlockEntityTypeBuilder.create(RedstoneCampfireBlockEntity::new, JinericBlocks.REDSTONE_CAMPFIRE).build();

   public static void registerBlockEntities() {
      Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "jineric_chest"), JINERIC_CHEST);
//      Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "shulker_chest"), SHULKER_CHEST);
      Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "refinery"), REFINERY);
      Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "campfire"), REDSTONE_CAMPFIRE);
   }
}

