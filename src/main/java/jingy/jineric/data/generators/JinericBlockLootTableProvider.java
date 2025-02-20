package jingy.jineric.data.generators;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.data.family.JinericBlockFamilies;
import jingy.jineric.registry.JinericWoodType;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodType;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.Items;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class JinericBlockLootTableProvider extends FabricBlockLootTableProvider {
	public JinericBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}
	
	@Override
	public void generate() {
		this.addVanillaWoodenFamilyDrops();
		this.genBlockFamilyDrops();
		this.genUniqueDrops();
		this.genWoodSets();
	}
	
	private void genUniqueDrops() {
		this.addDrop(JinericBlocks.TUFF_BRICK_PILLAR);
		this.addDrop(JinericBlocks.REFINERY);
		this.addDrop(JinericBlocks.STONE_BRICK_PILLAR);
		this.addDrop(JinericBlocks.DRIPSTONE_BRICK_PILLAR);
		this.addDrop(JinericBlocks.BLAZE_ROD_BLOCK);
		this.addDrop(JinericBlocks.ENDER_PEARL_BLOCK);
		this.addDrop(JinericBlocks.PAPER_BLOCK);
		this.addDrop(JinericBlocks.EGG_BLOCK);
		this.addDrop(JinericBlocks.STICK_BLOCK);
		this.addDrop(JinericBlocks.ROTTEN_FLESH_BLOCK);
		this.addDrop(JinericBlocks.SUGAR_BLOCK);
		this.addDrop(JinericBlocks.PRISMARINE_CRYSTAL_BLOCK);
		this.addDrop(JinericBlocks.BONE_MEAL_BLOCK);
		this.addDrop(JinericBlocks.FLINT_BLOCK);
		this.addDrop(JinericBlocks.CHARCOAL_BLOCK);
		this.addDrop(JinericBlocks.SOUL_JACK_O_LANTERN);
		this.addDrop(JinericBlocks.FULL_GRASS_BLOCK, block -> this.drops(block, Blocks.DIRT));
	}
	
	private void genWoodSets() {
		// PETRIFIED OAK
		this.addWoodenFamilyVariantDrops(JinericBlockFamilies.PETRIFIED_OAK, JinericWoodType.PETRIFIED_OAK);
		this.addDrop(JinericBlocks.PETRIFIED_OAK_LOG);
		this.addDrop(JinericBlocks.PETRIFIED_OAK_WOOD);
		this.addDrop(JinericBlocks.STRIPPED_PETRIFIED_OAK_LOG);
		this.addDrop(JinericBlocks.STRIPPED_PETRIFIED_OAK_WOOD);
		this.addDrop(JinericBlocks.PETRIFIED_OAK_HANGING_SIGN);
		this.addDrop(JinericBlocks.PETRIFIED_OAK_LEAVES, (block) -> this.leavesDrops(block, JinericBlocks.PETRIFIED_OAK_SAPLING, SAPLING_DROP_CHANCE));
		this.addDrop(JinericBlocks.PETRIFIED_OAK_SAPLING);
		this.addDrop(JinericBlocks.PETRIFIED_OAK_LADDER);
		this.addDrop(JinericBlocks.PETRIFIED_OAK_BOOKSHELF, (block) -> this.drops(block, Items.BOOK, ConstantLootNumberProvider.create(3.0F)));
		this.addPottedPlantDrops(JinericBlocks.POTTED_PETRIFIED_OAK_SAPLING);
	}
	
	private void addWoodenFamilyVariantDrops(BlockFamily blockFamily, WoodType woodType) {
		DefaultedRegistry<Block> blockRegistry = Registries.BLOCK;
		for (BlockFamily.Variant variant : BlockFamily.Variant.values()) {
			if (blockFamily.getVariant(variant) != null && blockRegistry.getId(blockFamily.getVariant(variant)).getNamespace().matches("jineric")) {
				if (variant == BlockFamily.Variant.DOOR) {
					this.addDrop(blockFamily.getVariant(BlockFamily.Variant.DOOR), this::doorDrops);
				} else {
					this.addDrop(blockFamily.getVariant(variant));
				}
			}
		}
		this.addVanillaWoodExtensions(woodType);
	}
	
	public void addVanillaWoodenFamilyDrops() {
		Stream<WoodType> woodTypes = WoodType.stream();
		for (WoodType woodType : woodTypes.toList()) {
			this.addVanillaWoodExtensions(woodType);
		}
	}
	
	public void addVanillaWoodExtensions(WoodType woodType) {
		DefaultedRegistry<Block> blockRegistry = Registries.BLOCK;
		String woodTypeName = woodType.name().replace("jineric:", "");
		if (woodType != WoodType.OAK && woodType != WoodType.PALE_OAK) {
			this.addDrop(blockRegistry.get(JinericMain.ofJineric(woodTypeName + "_ladder")));
			if (woodType != JinericWoodType.PETRIFIED_OAK) {
				this.addNameableContainerDrop(blockRegistry.get(JinericMain.ofJineric(woodTypeName + "_chest")));
				this.addNameableContainerDrop(blockRegistry.get(JinericMain.ofJineric("trapped_" + woodTypeName + "_chest")));
			}
			this.addDrop(blockRegistry.get(JinericMain.ofJineric(woodTypeName + "_bookshelf")), block -> this.drops(block, Items.BOOK, ConstantLootNumberProvider.create(3.0F)));
		}
	}
	
	private void addNameableContainerDrop(Block drop) {
		this.addDrop(drop, this::nameableContainerDrops);
	}
	
	private void genBlockFamilyDrops() {
		Stream<BlockFamily> blockFamilies = BlockFamilies.getFamilies();
		blockFamilies.forEach(blockFamily -> {
			Block baseBlock = blockFamily.getBaseBlock();
			for (Block block : blockFamily.getVariants().values()) {
				if (Registries.BLOCK.getId(block).getNamespace().matches("jineric")) {
					if (block == blockFamily.getVariant(BlockFamily.Variant.SLAB)) {
						this.addDrop(block, this::slabDrops);
					} else {
						this.addDrop(block);
					}
				}
			}
			if (Registries.BLOCK.getId(baseBlock).getNamespace().matches("jineric")) {
				this.addDrop(baseBlock);
			}
		});
	}
	
	@Override
	public String getName() {
		return "jineric_block_loot_table";
	}
}
