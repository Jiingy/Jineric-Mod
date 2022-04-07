package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.blockentity.shulkerchest.ShulkerChestBlockEntity;
import jingy.jineric.block.blockentity.sign.JinericSignBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JinericBlockEntities {

   public static final BlockEntityType<ShulkerChestBlockEntity> SHULKER_CHEST =
           FabricBlockEntityTypeBuilder.create(ShulkerChestBlockEntity::new, JinericBlocks.SHULKER_CHEST).build(null);

   public static final BlockEntityType<ShulkerChestBlockEntity> BOREAL_CHEST =
           FabricBlockEntityTypeBuilder.create(ShulkerChestBlockEntity::new, JinericBlocks.SHULKER_CHEST).build(null);

   public static final BlockEntityType<JinericSignBlockEntity> SIGN =
           FabricBlockEntityTypeBuilder.create(JinericSignBlockEntity::new,
                   JinericBlocks.BOREAL_SIGN)
                   .build(null);

   public static void registerBlockEntities() {

      //Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "boreal", SIGN));
      Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "shulker_chest"), SHULKER_CHEST);
      Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(JinericMain.MOD_ID, "boreal_chest"), BOREAL_CHEST);
   }
}
