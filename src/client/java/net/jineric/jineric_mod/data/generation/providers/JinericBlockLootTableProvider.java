package net.jineric.jineric_mod.data.generation.providers;

import com.google.common.collect.ImmutableMap;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.data.family.JinericBlockFamilyVariants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class JinericBlockLootTableProvider extends FabricBlockLootTableProvider {
	Map<BlockFamily.Variant, JinericDropFactory> VARIANT_DROPS = ImmutableMap.<BlockFamily.Variant, JinericDropFactory>builder()
			.put(BlockFamily.Variant.SLAB, blockDrop -> this.add(blockDrop, this::createSlabItemTable))
			.put(JinericBlockFamilyVariants.BOOKSHELF, this::addBookshelfDrop)
			.put(JinericBlockFamilyVariants.CHEST, this::dropSelfNameableBlockEntityTable)
			.put(JinericBlockFamilyVariants.TRAPPED_CHEST, this::dropSelfNameableBlockEntityTable)
			.build();
	
	public JinericBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(dataOutput, registryLookup);
	}
	
	@Override
	public void generate() {
		this.genFamilyDrops();
		this.genUniqueDrops();
	}
	
	public void genUniqueDrops() {
		this.dropSelf(JinericBlocks.TUFF_BRICK_PILLAR);
		this.dropSelf(JinericBlocks.REFINERY);
		this.dropSelf(JinericBlocks.STONE_BRICK_PILLAR);
		this.dropSelf(JinericBlocks.DRIPSTONE_BRICK_PILLAR);
		this.dropSelf(JinericBlocks.BLAZE_ROD_BLOCK);
		this.dropSelf(JinericBlocks.ENDER_PEARL_BLOCK);
		this.dropSelf(JinericBlocks.PAPER_BLOCK);
		this.dropSelf(JinericBlocks.EGG_BLOCK);
		this.dropSelf(JinericBlocks.STICK_BLOCK);
		this.dropSelf(JinericBlocks.ROTTEN_FLESH_BLOCK);
		this.dropSelf(JinericBlocks.SUGAR_BLOCK);
		this.dropSelf(JinericBlocks.PRISMARINE_CRYSTAL_BLOCK);
		this.dropSelf(JinericBlocks.BONE_MEAL_BLOCK);
		this.dropSelf(JinericBlocks.FLINT_BLOCK);
		this.dropSelf(JinericBlocks.CHARCOAL_BLOCK);
		this.dropSelf(JinericBlocks.SOUL_JACK_O_LANTERN);
		this.add(JinericBlocks.GRASS_BLOCK, block -> this.createSingleItemTableWithSilkTouch(block, Blocks.DIRT));
	}
	
	public void dropSelfNameableBlockEntityTable(Block input) {
		this.add(input, this::createNameableBlockEntityTable);
	}
	
	public void addBookshelfDrop(Block input) {
		this.add(input, block -> this.createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0F)));
	}
	
	public void genFamilyDrops() {
		BlockFamilies.getAllFamilies().forEach(blockFamily -> {
			Block baseBlock = blockFamily.getBaseBlock();
			if (this.jinericNamespace(baseBlock)) {
				this.dropSelf(baseBlock);
			}
			this.genFamilyVariantDrops(blockFamily);
		});
	}
	
	public void genFamilyVariantDrops(BlockFamily blockFamily) {
		blockFamily.getVariants().forEach((variant, block) -> {
			if (this.jinericNamespace(block)) {
				JinericDropFactory dropFactory = VARIANT_DROPS.get(variant);
				if (dropFactory != null) {
					dropFactory.dropSelf(block);
				}
				if (!VARIANT_DROPS.containsKey(variant)) {
					this.dropSelf(block);
				}
			}
		});
	}
	
	private boolean jinericNamespace(Block block) {
		return block != null && BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals("jineric");
	}
	
	@Override
	public String getName() {
		return "Block Loot Tables";
	}
	
	@FunctionalInterface
	public interface JinericDropFactory {
		void dropSelf(Block blockDrop);
	}
}
