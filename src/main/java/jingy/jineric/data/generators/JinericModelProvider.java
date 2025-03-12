package jingy.jineric.data.generators;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.client.data.BlockStateCreators;
import jingy.jineric.client.data.JinericModels;
import jingy.jineric.client.data.JinericTextureMap;
import jingy.jineric.data.family.JinericBlockFamilies;
import jingy.jineric.item.JinericItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodType;
import net.minecraft.client.data.*;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.model.special.ChestModelRenderer;
import net.minecraft.client.render.item.tint.GrassTintSource;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.Item;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraft.client.data.BlockStateModelGenerator.createSingletonBlockState;

public class JinericModelProvider extends FabricModelProvider {
	public JinericModelProvider(FabricDataOutput output) {
		super(output);
	}
	
	@Override
	public void generateBlockStateModels(BlockStateModelGenerator bsmg) {
		this.registerBlockFamilyModels(bsmg);
		this.registerWoodSetModels(bsmg);
		bsmg.registerSimpleCubeAll(JinericBlocks.PRISMARINE_CRYSTAL_BLOCK);
		bsmg.registerSimpleCubeAll(JinericBlocks.SUGAR_BLOCK);
		bsmg.registerSimpleCubeAll(JinericBlocks.CHARCOAL_BLOCK);
		bsmg.registerSimpleCubeAll(JinericBlocks.FLINT_BLOCK);
		bsmg.registerSimpleCubeAll(JinericBlocks.EGG_BLOCK);
		bsmg.registerSimpleCubeAll(JinericBlocks.ROTTEN_FLESH_BLOCK);
		bsmg.registerSimpleCubeAll(JinericBlocks.ENDER_PEARL_BLOCK);
		bsmg.registerSimpleCubeAll(JinericBlocks.BONE_MEAL_BLOCK);
		bsmg.registerSimpleCubeAll(JinericBlocks.CHISELED_DRIPSTONE_BRICKS);
		bsmg.registerAxisRotated(JinericBlocks.STICK_BLOCK, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
		bsmg.registerSingleton(JinericBlocks.PAPER_BLOCK, TexturedModel.CUBE_COLUMN);
		bsmg.registerSingleton(JinericBlocks.BLAZE_ROD_BLOCK, TexturedModel.CUBE_COLUMN);
		bsmg.registerCooker(JinericBlocks.REFINERY, TexturedModel.ORIENTABLE);
		bsmg.registerCampfire(JinericBlocks.REDSTONE_CAMPFIRE);
		bsmg.registerLantern(JinericBlocks.REDSTONE_LANTERN);
		bsmg.registerTintedItemModel(JinericBlocks.FULL_GRASS_BLOCK, ModelIds.getBlockModelId(JinericBlocks.FULL_GRASS_BLOCK), new GrassTintSource());
		bsmg.registerAxisRotated(JinericBlocks.STONE_BRICK_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
		bsmg.registerAxisRotated(JinericBlocks.TUFF_BRICK_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
		bsmg.registerAxisRotated(JinericBlocks.DRIPSTONE_BRICK_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
		this.registerCubeBottomTopSet(JinericBlockFamilies.SOUL_SANDSTONE, bsmg);
		this.registerChiseledBlock(JinericBlockFamilies.SOUL_SANDSTONE, JinericBlocks.SMOOTH_SOUL_SANDSTONE, bsmg);
		this.registerCubeColumnBlockSet(JinericBlockFamilies.CUT_SANDSTONE, JinericBlockFamilies.SANDSTONE, bsmg);
		this.registerCubeColumnBlockSet(JinericBlockFamilies.CUT_RED_SANDSTONE, JinericBlockFamilies.RED_SANDSTONE, bsmg);
		this.registerCubeColumnBlockSet(JinericBlockFamilies.CUT_SOUL_SANDSTONE, JinericBlockFamilies.SOUL_SANDSTONE, bsmg);
		this.registerBorderBlockSet(JinericBlockFamilies.SMOOTH_STONE, bsmg);
		this.registerBorderBlockSet(JinericBlockFamilies.POLISHED_STONE, bsmg);
		this.registerWall(JinericBlockFamilies.CUT_COPPER, TextureMap.all(Blocks.CUT_COPPER), bsmg);
		this.registerWall(JinericBlockFamilies.EXPOSED_CUT_COPPER, TextureMap.all(Blocks.EXPOSED_CUT_COPPER), bsmg);
		this.registerWall(JinericBlockFamilies.WEATHERED_CUT_COPPER, TextureMap.all(Blocks.WEATHERED_CUT_COPPER), bsmg);
		this.registerWall(JinericBlockFamilies.OXIDIZED_CUT_COPPER, TextureMap.all(Blocks.OXIDIZED_CUT_COPPER), bsmg);
		this.registerWall(JinericBlockFamilies.WAXED_CUT_COPPER, TextureMap.all(Blocks.CUT_COPPER), bsmg);
		this.registerWall(JinericBlockFamilies.WAXED_EXPOSED_CUT_COPPER, TextureMap.all(Blocks.EXPOSED_CUT_COPPER), bsmg);
		this.registerWall(JinericBlockFamilies.WAXED_WEATHERED_CUT_COPPER, TextureMap.all(Blocks.WEATHERED_CUT_COPPER), bsmg);
		this.registerWall(JinericBlockFamilies.WAXED_OXIDIZED_CUT_COPPER, TextureMap.all(Blocks.OXIDIZED_CUT_COPPER), bsmg);
	}
	
	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		Identifier jungleLadderId = itemModelGenerator.uploadTwoLayers(JinericItems.JUNGLE_LADDER, ModelIds.getBlockModelId(JinericBlocks.JUNGLE_LADDER), JinericMain.ofJineric("block/jungle_ladder_overlay"));
		itemModelGenerator.output.accept(JinericItems.JUNGLE_LADDER, ItemModels.tinted(jungleLadderId, new GrassTintSource()));
		itemModelGenerator.register(JinericItems.GOLDEN_BEETROOT, Models.GENERATED);
		itemModelGenerator.register(JinericItems.GOLDEN_POTATO, Models.GENERATED);
		itemModelGenerator.register(JinericItems.GOLDEN_SWEET_BERRIES, Models.GENERATED);
		itemModelGenerator.register(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
		itemModelGenerator.register(JinericItems.NETHERITE_HORSE_ARMOR, Models.GENERATED);
	}
	
	public void registerBlockFamilyModels(BlockStateModelGenerator bsmg) {
		BlockFamilies.getFamilies().filter(BlockFamily::shouldGenerateModels).forEach(blockFamily -> {
			Block baseBlock = blockFamily.getBaseBlock();
			TextureMap textureMapAll = TextureMap.all(baseBlock);
			this.registerBlock(baseBlock, Models.CUBE_ALL, textureMapAll, bsmg);
			this.registerFamilyVariantModels(blockFamily, textureMapAll, bsmg);
		});
	}
	
	public void registerFamilyVariantModels(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator bsmg) {
		for (BlockFamily.Variant familyVariant : BlockFamily.Variant.values()) {
			if (blockFamily.getVariant(familyVariant) != null && Registries.BLOCK.getId(blockFamily.getVariant(familyVariant)).getNamespace().equals("jineric")) {
				switch (familyVariant) {
					case STAIRS -> this.registerStairs(blockFamily, textureMap, bsmg);
					case SLAB -> this.registerSlab(blockFamily, textureMap, bsmg);
					case WALL -> this.registerWall(blockFamily, this.verifyWall(blockFamily), bsmg);
					case FENCE -> this.registerFence(blockFamily, textureMap, false, bsmg);
					case CUSTOM_FENCE -> this.registerFence(blockFamily, textureMap, true, bsmg);
				}
			}
		}
	}
	
	public void registerWoodSetModels(BlockStateModelGenerator bsmg) {
		DefaultedRegistry<Block> blockRegistry = Registries.BLOCK;
		List<WoodType> woodTypes = WoodType.stream().toList();
		woodTypes.forEach(woodType -> blockRegistry.stream()
				.filter(block -> blockRegistry.getId(block).getNamespace().equals("jineric"))
				.forEach(block -> {
					Block plank = blockRegistry.get(Identifier.of(woodType.name() + "_planks"));
					String blockKey = block.getTranslationKey();
					// Strips the input block's key to check what wood type it is. This is very much an unstable manual hack and should be redone.
					String trimmedBlockKey = blockKey
							.replace("block.jineric.", "")
							.replace("_ladder", "")
							.replace("trapped_", "").replace("_chest", "")
							.replace("_bookshelf", "");
					if (trimmedBlockKey.equals(woodType.name())) {
						this.offerWoodTypeBlock(blockKey, plank, block, bsmg, woodType);
					}
				})
		);
	}
	
	public void offerWoodTypeBlock(String blockKey, Block plank, Block checkedBlock, BlockStateModelGenerator bsmg, WoodType woodType) {
		// Instead of 'blockKey.contains("")', could use an instance of check
		if (blockKey.contains("_chest")) {
			this.registerChest(checkedBlock, woodType, true, bsmg);
		}
		if (blockKey.contains("_ladder")) {
			bsmg.registerNorthDefaultHorizontalRotation(checkedBlock);
			if (!blockKey.contains("jungle_")) {
				bsmg.registerItemModel(checkedBlock);
			}
		}
		if (blockKey.contains("_bookshelf")) {
			this.registerBookshelf(checkedBlock, plank, bsmg);
		}
	}
	
	public void registerCubeBottomTopSet(BlockFamily blockFamily, BlockStateModelGenerator bsmg) {
		TextureMap textureMap = JinericTextureMap.topBottomShort(blockFamily);
		this.registerBlock(blockFamily.getBaseBlock(), Models.CUBE_BOTTOM_TOP, textureMap, bsmg);
		this.registerStairs(blockFamily, textureMap, bsmg);
		this.registerSlab(blockFamily, textureMap, bsmg);
		this.registerTopBottomWall(blockFamily, bsmg);
	}
	
	public void registerCubeColumnBlockSet(BlockFamily blockFamily, @Nullable BlockFamily blockTopFix, BlockStateModelGenerator bsmg) {
		TextureMap textureMap = JinericTextureMap.columnShort(blockFamily, blockTopFix);
		Block baseBlock = blockFamily.getBaseBlock();
		this.registerBlock(baseBlock, Models.CUBE_COLUMN, textureMap, bsmg);
		this.registerStairs(blockFamily, textureMap, bsmg);
		this.registerSlab(blockFamily, textureMap, bsmg);
		this.registerColumnWall(blockFamily, textureMap, bsmg);
	}
	
	public void registerBorderBlockSet(BlockFamily blockFamily, BlockStateModelGenerator bsmg) {
		Block blockFamilyWall = blockFamily.getVariant(BlockFamily.Variant.WALL);
		Block baseBlock = blockFamily.getBaseBlock();
		this.registerBlock(baseBlock, Models.CUBE_ALL, TextureMap.all(baseBlock), bsmg);
		this.registerStairs(blockFamily, JinericTextureMap.borderStairs(blockFamily), bsmg);
		this.registerSlab(blockFamily, JinericTextureMap.sidedSlab(blockFamily), bsmg);
		this.registerBorderWall(blockFamilyWall, JinericTextureMap.borderWall(blockFamily), bsmg);
	}
	
	private void registerBlock(Block block, Model model, TextureMap textureMap, BlockStateModelGenerator bsmg) {
		if (!this.isJineric(block)) return;
		Identifier id = model.upload(block, textureMap, bsmg.modelCollector);
		bsmg.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, id));
	}
	
	private void registerChiseledBlock(BlockFamily blockFamily, Block endTexture, BlockStateModelGenerator bsmg) {
		Block chiseledBlock = blockFamily.getVariant(BlockFamily.Variant.CHISELED);
		TextureMap textureMap = JinericTextureMap.bareSideEnd(chiseledBlock, endTexture);
		Identifier id = Models.CUBE_COLUMN.upload(chiseledBlock, textureMap, bsmg.modelCollector);
		bsmg.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(chiseledBlock, id));
	}
	
	private void registerStairs(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator bsmg) {
		Block stairs = blockFamily.getVariant(BlockFamily.Variant.STAIRS);
		if (!this.isJineric(stairs)) return;
		Identifier regularModelId = Models.STAIRS.upload(stairs, textureMap, bsmg.modelCollector);
		Identifier innerModelId = Models.INNER_STAIRS.upload(stairs, textureMap, bsmg.modelCollector);
		Identifier outerModelId = Models.OUTER_STAIRS.upload(stairs, textureMap, bsmg.modelCollector);
		bsmg.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(stairs, innerModelId, regularModelId, outerModelId));
	}
	
	private void registerColumnStairs(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator bsmg) {
		Block stairs = blockFamily.getVariant(BlockFamily.Variant.STAIRS);
		Identifier regularModelId = Models.STAIRS.upload(stairs, textureMap, bsmg.modelCollector);
		Identifier innerModelId = Models.INNER_STAIRS.upload(stairs, textureMap, bsmg.modelCollector);
		Identifier outerModelId = Models.OUTER_STAIRS.upload(stairs, textureMap, bsmg.modelCollector);
		bsmg.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(stairs, innerModelId, regularModelId, outerModelId));
	}
	
	private void registerSlab(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator bsmg) {
		Block slab = blockFamily.getVariant(BlockFamily.Variant.SLAB);
		if (!this.isJineric(slab)) return;
		Identifier slabModelId = Models.SLAB.upload(slab, textureMap, bsmg.modelCollector);
		Identifier topModelId = Models.SLAB_TOP.upload(slab, textureMap, bsmg.modelCollector);
//      Identifier bottomModelId = BlockStateModelGenerator.BlockTexturePool.ensureModel(Models.SLAB, block);
//      Identifier topModelId = bsmg.ensureModel(Models.SLAB_TOP, block);
		Identifier doubleModelId = Models.CUBE_BOTTOM_TOP.uploadWithoutVariant(slab, "_double", textureMap, bsmg.modelCollector);
		bsmg.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(slab, slabModelId, topModelId, doubleModelId));
		bsmg.registerParentedItemModel(slab, slabModelId);
	}
	
	private void registerWall(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator bsmg) {
		Block wall = blockFamily.getVariant(BlockFamily.Variant.WALL);
		if (!isJineric(wall)) return;
		Identifier postModelId = Models.TEMPLATE_WALL_POST.upload(wall, textureMap, bsmg.modelCollector);
		Identifier sideModelId = Models.TEMPLATE_WALL_SIDE.upload(wall, textureMap, bsmg.modelCollector);
		Identifier sideTallModelId = Models.TEMPLATE_WALL_SIDE_TALL.upload(wall, textureMap, bsmg.modelCollector);
		bsmg.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(wall, postModelId, sideModelId, sideTallModelId));
		Identifier wallInventory = Models.WALL_INVENTORY.upload(wall, textureMap, bsmg.modelCollector);
		bsmg.registerParentedItemModel(wall, wallInventory);
	}
	
	private void registerColumnWall(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator bsmg) {
		Block wall = blockFamily.getVariant(BlockFamily.Variant.WALL);
		Identifier postId = JinericModels.TEMPLATE_COLUMN_SHORT_WALL_POST.upload(wall, textureMap, bsmg.modelCollector);
		Identifier sideShortId = JinericModels.TEMPLATE_COLUMN_SHORT_WALL_SIDE_LOW.upload(wall, textureMap, bsmg.modelCollector);
		Identifier sideTallId = JinericModels.TEMPLATE_COLUMN_SHORT_WALL_SIDE_TALL.upload(wall, textureMap, bsmg.modelCollector);
		bsmg.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(wall, postId, sideShortId, sideTallId));
		Identifier wallInventory = JinericModels.TEMPLATE_COLUMN_SHORT_WALL_INVENTORY.upload(wall, textureMap, bsmg.modelCollector);
		bsmg.registerParentedItemModel(wall, wallInventory);
	}
	
	private void registerTopBottomWall(BlockFamily blockFamily, BlockStateModelGenerator bsmg) {
		TextureMap textureMap = JinericTextureMap.topBottomShort(blockFamily);
		Block wall = blockFamily.getVariant(BlockFamily.Variant.WALL);
		Identifier postId = JinericModels.TEMPLATE_TOP_BOTTOM_SHORT_WALL_POST.upload(wall, textureMap, bsmg.modelCollector);
		Identifier sideShortId = JinericModels.TEMPLATE_TOP_BOTTOM_SHORT_WALL_SIDE_LOW.upload(wall, textureMap, bsmg.modelCollector);
		Identifier sideTallId = JinericModels.TEMPLATE_TOP_BOTTOM_SHORT_WALL_SIDE_TALL.upload(wall, textureMap, bsmg.modelCollector);
		bsmg.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(wall, postId, sideShortId, sideTallId));
		Identifier wallInventory = JinericModels.TEMPLATE_TOP_BOTTOM_WALL_INVENTORY.upload(wall, textureMap, bsmg.modelCollector);
		bsmg.registerParentedItemModel(wall, wallInventory);
	}
	
	private void registerBorderWall(Block wall, TextureMap textureMap, BlockStateModelGenerator bsmg) {
		Identifier postId = JinericModels.TEMPLATE_COLUMN_SHORT_WALL_POST.upload(wall, textureMap, bsmg.modelCollector);
		Identifier sideShortId = JinericModels.TEMPLATE_BORDER_WALL_SIDE_LOW.upload(wall, textureMap, bsmg.modelCollector);
		Identifier sideShortLongId = JinericModels.TEMPLATE_BORDER_WALL_SIDE_LINE_LOW.upload(wall, textureMap, bsmg.modelCollector);
		Identifier sideTallId = JinericModels.TEMPLATE_BORDER_WALL_SIDE_TALL.upload(wall, textureMap, bsmg.modelCollector);
		bsmg.blockStateCollector.accept(BlockStateCreators.createBorderWallBlockState(wall, postId, sideShortId, sideShortLongId, sideTallId));
		Identifier wallInventory = JinericModels.TEMPLATE_COLUMN_SHORT_WALL_INVENTORY.upload(wall, textureMap, bsmg.modelCollector);
		bsmg.registerParentedItemModel(wall, wallInventory);
	}
	
	private TextureMap verifyWall(BlockFamily blockFamily) {
		Block wallBlock = blockFamily.getVariant(BlockFamily.Variant.WALL);
		// These walls use textures which have unusual naming conventions, this is a workaround for them not generating properly by default.
		if (wallBlock == JinericBlocks.QUARTZ_WALL) {
			return TextureMap.all(TextureMap.getSubId(Blocks.QUARTZ_BLOCK, "_side"));
		}
		if (wallBlock == JinericBlocks.SMOOTH_QUARTZ_WALL) {
			return TextureMap.all(TextureMap.getSubId(Blocks.QUARTZ_BLOCK, "_bottom"));
		}
		if (wallBlock == JinericBlocks.SMOOTH_SANDSTONE_WALL) {
			return TextureMap.all(TextureMap.getSubId(Blocks.SANDSTONE, "_top"));
		}
		if (wallBlock == JinericBlocks.SMOOTH_RED_SANDSTONE_WALL) {
			return TextureMap.all(TextureMap.getSubId(Blocks.RED_SANDSTONE, "_top"));
		} else {
			return TextureMap.all(blockFamily.getBaseBlock());
		}
	}
	
	public void registerFence(BlockFamily blockFamily, TextureMap textureMap, boolean custom, BlockStateModelGenerator bsmg) {
		Block fenceBlock = custom
				? blockFamily.getVariant(BlockFamily.Variant.CUSTOM_FENCE)
				: blockFamily.getVariant(BlockFamily.Variant.FENCE);
		if (!this.isJineric(fenceBlock)) return;
		Identifier postModelId = Models.FENCE_POST.upload(fenceBlock, textureMap, bsmg.modelCollector);
		Identifier sideModelId = Models.FENCE_SIDE.upload(fenceBlock, textureMap, bsmg.modelCollector);
		bsmg.blockStateCollector.accept(BlockStateModelGenerator.createFenceBlockState(fenceBlock, postModelId, sideModelId));
		Identifier fenceInventory = Models.FENCE_INVENTORY.upload(fenceBlock, textureMap, bsmg.modelCollector);
		bsmg.registerParentedItemModel(fenceBlock, fenceInventory);
	}
	
	public final void registerChest(Block chest, WoodType WoodType, boolean christmas, BlockStateModelGenerator bsmg) {
		Identifier particleSource = JinericMain.ofJineric("block/" + WoodType.name() + "_chest_particle");
		
		bsmg.registerBuiltinWithParticle(chest, particleSource);
		Item item = chest.asItem();
		Identifier identifier = Models.TEMPLATE_CHEST.upload(item, TextureMap.particle(particleSource), bsmg.modelCollector);
		ItemModel.Unbaked unbaked = ItemModels.special(identifier, new ChestModelRenderer.Unbaked(Registries.BLOCK.getId(chest)));
		if (christmas) {
			ItemModel.Unbaked unbaked2 = ItemModels.special(identifier, new ChestModelRenderer.Unbaked(ChestModelRenderer.CHRISTMAS_ID));
			bsmg.itemModelOutput.accept(item, ItemModels.christmasSelect(unbaked2, unbaked));
		} else {
			bsmg.itemModelOutput.accept(item, unbaked);
		}
	}
	
	private void registerPillar(Block pillar, BlockStateModelGenerator bsmg) {
		TextureMap textureMap = TextureMap.sideEnd(TextureMap.getSubId(pillar, "_side"), TextureMap.getSubId(pillar, "_end"));
		Identifier identifier = Models.CUBE_COLUMN.upload(pillar, textureMap, bsmg.modelCollector);
		bsmg.registerAxisRotated(pillar, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
	}
	
	private void registerBookshelf(Block bookshelf, Block plank, BlockStateModelGenerator bsmg) {
		TextureMap textureMap = TextureMap.sideEnd(TextureMap.getId(bookshelf), TextureMap.getId(plank));
		Identifier identifier = Models.CUBE_COLUMN.upload(bookshelf, textureMap, bsmg.modelCollector);
		bsmg.blockStateCollector.accept(createSingletonBlockState(bookshelf, identifier));
	}
	
	private boolean isJineric(Block block) {
		return block != null && Registries.BLOCK.getId(block).getNamespace().equals("jineric");
	}
	
	public static Block blockById(String id) {
		final Identifier identifier = JinericMain.ofJineric(id);
		if (!Registries.BLOCK.containsId(identifier)) {
			throw new IllegalStateException("Block is not registered: " + identifier);
		}
		return Registries.BLOCK.get(identifier);
	}
	
	public static Item itemById(String id) {
		final Identifier identifier = JinericMain.ofJineric(id);
		if (!Registries.ITEM.containsId(identifier)) {
			throw new IllegalStateException("Item is not registered: " + identifier);
		}
		return Registries.ITEM.get(identifier);
	}
	
	@Override
	public String getName() {
		return "Models";
	}
}