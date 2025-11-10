package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.block.entity.RedstoneCampfireBlockEntity;
import jingy.jineric.block.entity.RefineryBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class JinericBlockEntityType {
	public static final BlockEntityType<RefineryBlockEntity> REFINERY = FabricBlockEntityTypeBuilder.create(RefineryBlockEntity::new, JinericBlocks.REFINERY).build();
	public static final BlockEntityType<RedstoneCampfireBlockEntity> REDSTONE_CAMPFIRE = FabricBlockEntityTypeBuilder.create(RedstoneCampfireBlockEntity::new, JinericBlocks.REDSTONE_CAMPFIRE).build();
	
	public static void registerBlockEntityTypes() {
		//  Modded
		register("refinery", REFINERY);
		register("campfire", REDSTONE_CAMPFIRE);
		//  Vanilla
			// Chest
		BlockEntityType.CHEST.addSupportedBlock(JinericBlocks.SPRUCE_CHEST);
		BlockEntityType.CHEST.addSupportedBlock(JinericBlocks.BIRCH_CHEST);
		BlockEntityType.CHEST.addSupportedBlock(JinericBlocks.JUNGLE_CHEST);
		BlockEntityType.CHEST.addSupportedBlock(JinericBlocks.ACACIA_CHEST);
		BlockEntityType.CHEST.addSupportedBlock(JinericBlocks.DARK_OAK_CHEST);
		BlockEntityType.CHEST.addSupportedBlock(JinericBlocks.MANGROVE_CHEST);
		BlockEntityType.CHEST.addSupportedBlock(JinericBlocks.CHERRY_CHEST);
		BlockEntityType.CHEST.addSupportedBlock(JinericBlocks.BAMBOO_CHEST);
		BlockEntityType.CHEST.addSupportedBlock(JinericBlocks.CRIMSON_CHEST);
		BlockEntityType.CHEST.addSupportedBlock(JinericBlocks.WARPED_CHEST);
			//  Trapped Chest
		BlockEntityType.TRAPPED_CHEST.addSupportedBlock(JinericBlocks.TRAPPED_SPRUCE_CHEST);
		BlockEntityType.TRAPPED_CHEST.addSupportedBlock(JinericBlocks.TRAPPED_BIRCH_CHEST);
		BlockEntityType.TRAPPED_CHEST.addSupportedBlock(JinericBlocks.TRAPPED_JUNGLE_CHEST);
		BlockEntityType.TRAPPED_CHEST.addSupportedBlock(JinericBlocks.TRAPPED_ACACIA_CHEST);
		BlockEntityType.TRAPPED_CHEST.addSupportedBlock(JinericBlocks.TRAPPED_DARK_OAK_CHEST);
		BlockEntityType.TRAPPED_CHEST.addSupportedBlock(JinericBlocks.TRAPPED_MANGROVE_CHEST);
		BlockEntityType.TRAPPED_CHEST.addSupportedBlock(JinericBlocks.TRAPPED_CHERRY_CHEST);
		BlockEntityType.TRAPPED_CHEST.addSupportedBlock(JinericBlocks.TRAPPED_BAMBOO_CHEST);
		BlockEntityType.TRAPPED_CHEST.addSupportedBlock(JinericBlocks.TRAPPED_CRIMSON_CHEST);
		BlockEntityType.TRAPPED_CHEST.addSupportedBlock(JinericBlocks.TRAPPED_WARPED_CHEST);
	}
	
	public static BlockEntityType<?> register(String id, BlockEntityType<?> blockEntityType) {
		return Registry.register(Registries.BLOCK_ENTITY_TYPE, JinericMain.ofJineric(id), blockEntityType);
	}
}

