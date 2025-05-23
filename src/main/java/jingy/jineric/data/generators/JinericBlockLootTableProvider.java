package jingy.jineric.data.generators;

import com.google.common.collect.ImmutableMap;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.data.family.JinericBlockFamilyVariants;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.Items;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class JinericBlockLootTableProvider extends FabricBlockLootTableProvider {
	Map<BlockFamily.Variant, JinericDropFactory> VARIANT_DROPS = ImmutableMap.<BlockFamily.Variant, JinericDropFactory>builder()
			.put(BlockFamily.Variant.SLAB, block -> this.addDrop(block, this::slabDrops))
			.put(JinericBlockFamilyVariants.BOOKSHELF, this::addBookshelfDrop)
			.put(JinericBlockFamilyVariants.CHEST, this::addNameableContainerDrop)
			.put(JinericBlockFamilyVariants.TRAPPED_CHEST, this::addNameableContainerDrop)
			.build();
	
	public JinericBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}
	
	@Override
	public void generate() {
		this.genFamilyDrops();
		this.genUniqueDrops();
	}
	
	public void genUniqueDrops() {
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
	
	public void addNameableContainerDrop(Block input) {
		this.addDrop(input, this::nameableContainerDrops);
	}
	
	public void addBookshelfDrop(Block input) {
		this.addDrop(input, block -> this.drops(block, Items.BOOK, ConstantLootNumberProvider.create(3.0F)));
	}
	
	public void genFamilyDrops() {
		BlockFamilies.getFamilies().forEach(blockFamily -> {
			Block baseBlock = blockFamily.getBaseBlock();
			if (this.jinericNamespace(baseBlock)) {
				this.addDrop(baseBlock);
			}
			this.genFamilyVariantDrops(blockFamily);
		});
	}
	
	public void genFamilyVariantDrops(BlockFamily blockFamily) {
		blockFamily.getVariants().forEach((variant, block) -> {
			if (this.jinericNamespace(block)) {
				JinericDropFactory dropFactory = VARIANT_DROPS.get(variant);
				if (dropFactory != null) {
					dropFactory.addDrop(block);
				}
				if (!VARIANT_DROPS.containsKey(variant)) {
					this.addDrop(block);
				}
			}
		});
	}
	
	private boolean jinericNamespace(Block block) {
		return block != null && Registries.BLOCK.getId(block).getNamespace().equals("jineric");
	}
	
	@Override
	public String getName() {
		return "Block Loot Tables";
	}
	
	@FunctionalInterface
	public interface JinericDropFactory {
		void addDrop(Block blockDrop);
	}
}
