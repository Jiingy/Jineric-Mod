package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.block.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;

public class JinericBlockEntityType {
	public static final BlockEntityType<RefineryBlockEntity> REFINERY = FabricBlockEntityTypeBuilder.create(RefineryBlockEntity::new, JinericBlocks.REFINERY).build();
	public static final BlockEntityType<RedstoneCampfireBlockEntity> REDSTONE_CAMPFIRE = FabricBlockEntityTypeBuilder.create(RedstoneCampfireBlockEntity::new, JinericBlocks.REDSTONE_CAMPFIRE).build();
	public static final BlockEntityType<CrucibleBlockEntity> CRUCIBLE = FabricBlockEntityTypeBuilder.create(CrucibleBlockEntity::new, JinericBlocks.STONE_CRUCIBLE).build();
	public static final BlockEntityType<FoundryBlockEntity> FOUNDRY = FabricBlockEntityTypeBuilder.create(FoundryBlockEntity::new, JinericBlocks.FOUNDRY).build();
	public static final BlockEntityType<KilnBlockEntity> KILN = FabricBlockEntityTypeBuilder.create(KilnBlockEntity::new, JinericBlocks.KILN).build();
	
	public static void registerBlockEntityTypes() {
		//  Modded
		register("refinery", REFINERY);
		register("campfire", REDSTONE_CAMPFIRE);
		register("crucible", CRUCIBLE);
		register("foundry", FOUNDRY);
		register("kiln", KILN);
		//  Vanilla
			// Chest
		BlockEntityTypes.CHEST.addValidBlock(JinericBlocks.SPRUCE_CHEST);
		BlockEntityTypes.CHEST.addValidBlock(JinericBlocks.BIRCH_CHEST);
		BlockEntityTypes.CHEST.addValidBlock(JinericBlocks.JUNGLE_CHEST);
		BlockEntityTypes.CHEST.addValidBlock(JinericBlocks.ACACIA_CHEST);
		BlockEntityTypes.CHEST.addValidBlock(JinericBlocks.DARK_OAK_CHEST);
		BlockEntityTypes.CHEST.addValidBlock(JinericBlocks.MANGROVE_CHEST);
		BlockEntityTypes.CHEST.addValidBlock(JinericBlocks.CHERRY_CHEST);
		BlockEntityTypes.CHEST.addValidBlock(JinericBlocks.BAMBOO_CHEST);
		BlockEntityTypes.CHEST.addValidBlock(JinericBlocks.CRIMSON_CHEST);
		BlockEntityTypes.CHEST.addValidBlock(JinericBlocks.WARPED_CHEST);
//			  Trapped Chest
		BlockEntityTypes.TRAPPED_CHEST.addValidBlock(JinericBlocks.TRAPPED_SPRUCE_CHEST);
		BlockEntityTypes.TRAPPED_CHEST.addValidBlock(JinericBlocks.TRAPPED_BIRCH_CHEST);
		BlockEntityTypes.TRAPPED_CHEST.addValidBlock(JinericBlocks.TRAPPED_JUNGLE_CHEST);
		BlockEntityTypes.TRAPPED_CHEST.addValidBlock(JinericBlocks.TRAPPED_ACACIA_CHEST);
		BlockEntityTypes.TRAPPED_CHEST.addValidBlock(JinericBlocks.TRAPPED_DARK_OAK_CHEST);
		BlockEntityTypes.TRAPPED_CHEST.addValidBlock(JinericBlocks.TRAPPED_MANGROVE_CHEST);
		BlockEntityTypes.TRAPPED_CHEST.addValidBlock(JinericBlocks.TRAPPED_CHERRY_CHEST);
		BlockEntityTypes.TRAPPED_CHEST.addValidBlock(JinericBlocks.TRAPPED_BAMBOO_CHEST);
		BlockEntityTypes.TRAPPED_CHEST.addValidBlock(JinericBlocks.TRAPPED_CRIMSON_CHEST);
		BlockEntityTypes.TRAPPED_CHEST.addValidBlock(JinericBlocks.TRAPPED_WARPED_CHEST);
	}
	
	public static BlockEntityType<?> register(String id, BlockEntityType<?> blockEntityType) {
		return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, JinericMain.ofJineric(id), blockEntityType);
	}
}

