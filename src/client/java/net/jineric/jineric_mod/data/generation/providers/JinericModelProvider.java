package net.jineric.jineric_mod.data.generation.providers;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.data.family.JinericBlockFamilies;
import jingy.jineric.item.JinericItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.jineric.jineric_mod.data.BlockStateCreators;
import net.jineric.jineric_mod.data.JinericModels;
import net.jineric.jineric_mod.data.JinericTextureMap;
import net.minecraft.client.color.item.GrassColorSource;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.special.ChestSpecialRenderer;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.BiConsumer;

import static net.minecraft.client.data.models.BlockModelGenerators.createSimpleBlock;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class JinericModelProvider extends FabricModelProvider {
	
	public JinericModelProvider(FabricPackOutput output) {
		super(output);
	}
	
	@Override
	public void generateBlockStateModels(BlockModelGenerators bmg) {
		BiConsumer<Identifier, ModelInstance> itemModelOutput = bmg.modelOutput;
		this.registerBlockFamilyModels(bmg);
		this.registerWoodSetModels(bmg);
		bmg.createTrivialCube(JinericBlocks.PRISMARINE_CRYSTAL_BLOCK);
		bmg.createTrivialCube(JinericBlocks.SUGAR_BLOCK);
		bmg.createTrivialCube(JinericBlocks.CHARCOAL_BLOCK);
		bmg.createTrivialCube(JinericBlocks.FLINT_BLOCK);
		bmg.createTrivialCube(JinericBlocks.EGG_BLOCK);
		bmg.createTrivialCube(JinericBlocks.ROTTEN_FLESH_BLOCK);
		bmg.createTrivialCube(JinericBlocks.ENDER_PEARL_BLOCK);
		bmg.createTrivialCube(JinericBlocks.BONE_MEAL_BLOCK);
		bmg.createTrivialCube(JinericBlocks.CHISELED_DRIPSTONE_BRICKS);
		bmg.createRotatedPillarWithHorizontalVariant(JinericBlocks.STICK_BLOCK, TexturedModel.COLUMN, TexturedModel.COLUMN_HORIZONTAL);
		bmg.createTrivialBlock(JinericBlocks.PAPER_BLOCK, TexturedModel.COLUMN);
		bmg.createTrivialBlock(JinericBlocks.BLAZE_ROD_BLOCK, TexturedModel.COLUMN);
		bmg.createFurnace(JinericBlocks.REFINERY, TexturedModel.ORIENTABLE_ONLY_TOP);
		bmg.createCampfires(JinericBlocks.REDSTONE_CAMPFIRE);
		bmg.createLantern(JinericBlocks.REDSTONE_LANTERN);
		bmg.registerSimpleTintedItemModel(JinericBlocks.GRASS_BLOCK, ModelLocationUtils.getModelLocation(JinericBlocks.GRASS_BLOCK), new GrassColorSource());
		bmg.createRotatedPillarWithHorizontalVariant(JinericBlocks.STONE_BRICK_PILLAR, TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
		bmg.createRotatedPillarWithHorizontalVariant(JinericBlocks.TUFF_BRICK_PILLAR, TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
		bmg.createRotatedPillarWithHorizontalVariant(JinericBlocks.DRIPSTONE_BRICK_PILLAR, TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
		this.registerCubeBottomTopSet(JinericBlockFamilies.SOUL_SANDSTONE, bmg);
		this.registerChiseledBlock(JinericBlockFamilies.SOUL_SANDSTONE, JinericBlocks.SMOOTH_SOUL_SANDSTONE, bmg);
		this.registerCubeColumnBlockSet(JinericBlockFamilies.CUT_SANDSTONE, JinericBlockFamilies.SANDSTONE, bmg);
		this.registerCubeColumnBlockSet(JinericBlockFamilies.CUT_RED_SANDSTONE, JinericBlockFamilies.RED_SANDSTONE, bmg);
		this.registerCubeColumnBlockSet(JinericBlockFamilies.CUT_SOUL_SANDSTONE, JinericBlockFamilies.SOUL_SANDSTONE, bmg);
		this.registerBorderBlockSet(JinericBlockFamilies.SMOOTH_STONE, bmg);
		this.registerBorderBlockSet(JinericBlockFamilies.POLISHED_STONE, bmg);
		this.registerWall(JinericBlockFamilies.CUT_COPPER.weathering().unaffected(), TextureMapping.cube(Blocks.CUT_COPPER.weathering().unaffected()), bmg);
		this.registerWall(JinericBlockFamilies.CUT_COPPER.weathering().exposed(), TextureMapping.cube(Blocks.CUT_COPPER.weathering().exposed()), bmg);
		this.registerWall(JinericBlockFamilies.CUT_COPPER.weathering().weathered(), TextureMapping.cube(Blocks.CUT_COPPER.weathering().weathered()), bmg);
		this.registerWall(JinericBlockFamilies.CUT_COPPER.weathering().oxidized(), TextureMapping.cube(Blocks.CUT_COPPER.weathering().oxidized()), bmg);
		this.registerWall(JinericBlockFamilies.CUT_COPPER.waxed().unaffected(), TextureMapping.cube(Blocks.CUT_COPPER.weathering().unaffected()), bmg);
		this.registerWall(JinericBlockFamilies.CUT_COPPER.waxed().exposed(), TextureMapping.cube(Blocks.CUT_COPPER.weathering().exposed()), bmg);
		this.registerWall(JinericBlockFamilies.CUT_COPPER.waxed().weathered(), TextureMapping.cube(Blocks.CUT_COPPER.weathering().weathered()), bmg);
		this.registerWall(JinericBlockFamilies.CUT_COPPER.waxed().oxidized(), TextureMapping.cube(Blocks.CUT_COPPER.weathering().oxidized()), bmg);
	}
	
	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {
		this.registerWoodEquipmentFamily();
		Identifier jungleLadderId = itemModelGenerator.generateLayeredItem(
				JinericItems.JUNGLE_LADDER,
				TextureMapping.getBlockTexture(JinericBlocks.JUNGLE_LADDER),
				TextureMapping.getBlockTexture(JinericBlocks.JUNGLE_LADDER, "_overlay")
		);
		itemModelGenerator.itemModelOutput.accept(JinericItems.JUNGLE_LADDER, ItemModelUtils.tintedModel(jungleLadderId, new GrassColorSource()));

		itemModelGenerator.generateFlatItem(JinericItems.CLAY_BRICK, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.GOLDEN_BEETROOT, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.GOLDEN_POTATO, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.GOLDEN_SWEET_BERRIES, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.EMERALD_HELMET, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.EMERALD_CHESTPLATE, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.EMERALD_LEGGINGS, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.EMERALD_BOOTS, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.EMERALD_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.EMERALD_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.EMERALD_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.EMERALD_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.EMERALD_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.FLINT_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.DEEPSLATE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.AMETHYST_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.STONE_CRUCIBLE, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.BOW_DRILL, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.STONE_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.COPPER_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.GOLD_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(JinericItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
	}
	
	//TODO: 26.2 Fix
	public final void registerWoodEquipmentFamily() {
//		EquipmentFamilies.WOODEN.getVariants().forEach(this::registerWoodEquipmentFamily);
	}
	
//	public final void registerWoodEquipmentFamily(EquipmentFamily.Variant variant, Item item) {
//		List<SelectItemModel.SwitchCase<ResourceKey<TrimMaterial>>> list = new ArrayList(TRIM_MATERIAL_MODELS.size());
//
//		for (WoodType woodType : WoodType.values().toList()) {
//			String woodTypeName = woodType.name();
//			String woodTypeVariant = woodTypeName + "_" + variant;
//			Identifier itemId = getPrefixItemModelId(item, woodTypeName  + "_");
//
//			//  Generates armor item models with trim overlay
////			List<SelectItemModel.SwitchCase<RegistryKey<ArmorTrimMaterial>>> list
////					= new ArrayList<>(ItemModelGenerator.TRIM_MATERIALS.size()
////			);
////			for (ItemModelGenerator.TrimMaterial trimMaterial : ItemModelGenerator.TRIM_MATERIALS) {
////				Identifier identifier4 = itemId.withSuffixedPath("_" + trimMaterial.assets().base().suffix() + "_trim");
////				Identifier layer1 = trimIdPrefix.withSuffixedPath("_" + trimMaterial.assets().getAssetId(equipmentKey).suffix());
////				ItemModel.Unbaked unbaked;
////				this.uploadArmorWithTrim(identifier4, layer0, layer1);
////				unbaked = ItemModels.basic(identifier4);
////				list.add(ItemModels.switchCase(trimMaterial.materialKey, unbaked));
////			}
//			ModelTemplate model = variant.isArmor() ? ModelTemplates.FLAT_ITEM : ModelTemplates.FLAT_HANDHELD_ITEM;
//			Identifier identifier = Identifier.parse(woodTypeVariant).withPrefix("item/");
//			model.create(
//					identifier,
//					TextureMapping.layer0(itemId),
//					this.itemModelOutput
//			);
//
//			list.add(
//					ItemModelUtils.when(
//							woodTypeVariant,
//							ItemModelUtils.plainModel(identifier)
//					)
//			);
//		}
//
//		if (variant.isArmor()) {
//			ModelTemplates.FLAT_ITEM.create(item, TextureMapping.layer0(item), this.itemModelOutput);
//		}
//
//		this.itemModelOutput.accept(
//				item,
//				ItemModelUtils.select(
//						new TrimMaterialProperty(),
//						ItemModelUtils.plainModel(BuiltInRegistries.ITEM.getKey(item).withPrefix("item/")),
//						list
//				)
//		);
//	}
	
	public static Identifier getPrefixItemModelId(Item item, String prefix) {
		String path = BuiltInRegistries.ITEM.getKey(item).getPath();
		Identifier identifier = JinericMain.ofJineric(path);
		return identifier.withPrefix("item/" + prefix);
	}
	
	public void registerBlockFamilyModels(BlockModelGenerators bsmg) {
		BlockFamilies.getAllFamilies().filter(BlockFamily::shouldGenerateModel).forEach(blockFamily -> {
			Block baseBlock = blockFamily.getBaseBlock();
			TextureMapping textureMapAll = TextureMapping.cube(baseBlock);
			this.registerBlock(baseBlock, ModelTemplates.CUBE_ALL, textureMapAll, bsmg);
			this.registerFamilyVariantModels(blockFamily, textureMapAll, bsmg);
		});
	}
	
	public void registerFamilyVariantModels(BlockFamily blockFamily, TextureMapping textureMap, BlockModelGenerators bsmg) {
		for (BlockFamily.Variant familyVariant : BlockFamily.Variant.values()) {
			if (blockFamily.get(familyVariant) != null && BuiltInRegistries.BLOCK.getKey(blockFamily.get(familyVariant)).getNamespace().equals("jineric")) {
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
	
	public void registerWoodSetModels(BlockModelGenerators bsmg) {
		DefaultedRegistry<Block> blockRegistry = BuiltInRegistries.BLOCK;
		List<WoodType> woodTypes = WoodType.values().toList();
		woodTypes.forEach(woodType -> blockRegistry.stream()
				.filter(block -> blockRegistry.getKey(block).getNamespace().equals("jineric"))
				.forEach(block -> {
					Block plank = blockRegistry.getValue(Identifier.parse(woodType.name() + "_planks"));
					String blockKey = block.getDescriptionId();
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
	
	public void offerWoodTypeBlock(String blockKey, Block plank, Block checkedBlock, BlockModelGenerators bsmg, WoodType woodType) {
		// Instead of 'blockKey.contains("")', could use an instance of check
		if (blockKey.contains("_chest")) {
			this.registerChest(checkedBlock, woodType, true, bsmg);
		}
		if (blockKey.contains("_ladder")) {
			bsmg.createNonTemplateHorizontalBlock(checkedBlock);
			if (!blockKey.contains("jungle_")) {
				bsmg.registerSimpleFlatItemModel(checkedBlock);
			}
		}
		if (blockKey.contains("_bookshelf")) {
			this.registerBookshelf(checkedBlock, plank, bsmg);
		}
	}
	
	public void registerCubeBottomTopSet(BlockFamily blockFamily, BlockModelGenerators bsmg) {
		TextureMapping textureMap = JinericTextureMap.topBottomShort(blockFamily);
		this.registerBlock(blockFamily.getBaseBlock(), ModelTemplates.CUBE_BOTTOM_TOP, textureMap, bsmg);
		this.registerStairs(blockFamily, textureMap, bsmg);
		this.registerSlab(blockFamily, textureMap, bsmg);
		this.registerTopBottomWall(blockFamily, bsmg);
	}
	
	public void registerCubeColumnBlockSet(BlockFamily blockFamily, @Nullable BlockFamily blockTopFix, BlockModelGenerators bsmg) {
		TextureMapping textureMap = JinericTextureMap.columnShort(blockFamily, blockTopFix);
		Block baseBlock = blockFamily.getBaseBlock();
		this.registerBlock(baseBlock, ModelTemplates.CUBE_COLUMN, textureMap, bsmg);
		this.registerStairs(blockFamily, textureMap, bsmg);
		this.registerSlab(blockFamily, textureMap, bsmg);
		this.registerColumnWall(blockFamily, textureMap, bsmg);
	}
	
	public void registerBorderBlockSet(BlockFamily blockFamily, BlockModelGenerators bsmg) {
		Block blockFamilyWall = blockFamily.get(BlockFamily.Variant.WALL);
		Block baseBlock = blockFamily.getBaseBlock();
		this.registerBlock(baseBlock, ModelTemplates.CUBE_ALL, TextureMapping.cube(baseBlock), bsmg);
		this.registerStairs(blockFamily, JinericTextureMap.borderStairs(blockFamily), bsmg);
		this.registerSlab(blockFamily, JinericTextureMap.sidedSlab(blockFamily), bsmg);
		this.registerBorderWall(blockFamilyWall, JinericTextureMap.borderWall(blockFamily), bsmg);
	}
	
	private void registerBlock(Block block, ModelTemplate model, TextureMapping textureMap, BlockModelGenerators bsmg) {
		if (!this.isJineric(block)) return;
		MultiVariant id = plainVariant(model.create(block, textureMap, bsmg.modelOutput));
		bsmg.blockStateOutput.accept(createSimpleBlock(block, id));
	}
	
	private void registerChiseledBlock(BlockFamily blockFamily, Block endTexture, BlockModelGenerators bsmg) {
		Block chiseledBlock = blockFamily.get(BlockFamily.Variant.CHISELED);
		TextureMapping textureMap = JinericTextureMap.bareSideEnd(chiseledBlock, endTexture);
		MultiVariant id = plainVariant(
				ModelTemplates.CUBE_COLUMN.create(chiseledBlock, textureMap, bsmg.modelOutput)
		);
		bsmg.blockStateOutput.accept(createSimpleBlock(chiseledBlock, id));
	}
	
	private void registerStairs(BlockFamily blockFamily, TextureMapping textureMap, BlockModelGenerators bsmg) {
		Block stairs = blockFamily.get(BlockFamily.Variant.STAIRS);
		if (!this.isJineric(stairs)) return;
		MultiVariant regularModelId = plainVariant(
				ModelTemplates.STAIRS_STRAIGHT.create(stairs, textureMap, bsmg.modelOutput)
		);
		MultiVariant innerModelId = plainVariant(
				ModelTemplates.STAIRS_INNER.create(stairs, textureMap, bsmg.modelOutput)
		);
		MultiVariant outerModelId = plainVariant(
				ModelTemplates.STAIRS_OUTER.create(stairs, textureMap, bsmg.modelOutput)
		);
		bsmg.blockStateOutput.accept(BlockModelGenerators.createStairs(stairs, innerModelId, regularModelId, outerModelId));
	}
	
	private void registerColumnStairs(BlockFamily blockFamily, TextureMapping textureMap, BlockModelGenerators bsmg) {
		Block stairs = blockFamily.get(BlockFamily.Variant.STAIRS);
		MultiVariant regularModelId = plainVariant(ModelTemplates.STAIRS_STRAIGHT.create(stairs, textureMap, bsmg.modelOutput));
		MultiVariant innerModelId = plainVariant(ModelTemplates.STAIRS_INNER.create(stairs, textureMap, bsmg.modelOutput));
		MultiVariant outerModelId = plainVariant(ModelTemplates.STAIRS_OUTER.create(stairs, textureMap, bsmg.modelOutput));
		bsmg.blockStateOutput.accept(BlockModelGenerators.createStairs(stairs, innerModelId, regularModelId, outerModelId));
	}
	
	private void registerSlab(BlockFamily blockFamily, TextureMapping textureMap, BlockModelGenerators bsmg) {
		Block slab = blockFamily.get(BlockFamily.Variant.SLAB);
		if (!this.isJineric(slab)) return;
		Identifier slabModelId = ModelTemplates.SLAB_BOTTOM.create(slab, textureMap, bsmg.modelOutput);
		MultiVariant topModelId = plainVariant(ModelTemplates.SLAB_TOP.create(slab, textureMap, bsmg.modelOutput));
//      MultiVariant bottomModelId = BlockModelGenerators.BlockTexturePool.ensureModel(ModelTemplates.SLAB, block);
//      MultiVariant topModelId = bmg.ensureModel(ModelTemplates.SLAB_TOP, block);
		MultiVariant doubleModelId = plainVariant(
				ModelTemplates.CUBE_BOTTOM_TOP.createWithOverride(slab, "_double", textureMap, bsmg.modelOutput)
		);
		bsmg.blockStateOutput.accept(BlockModelGenerators.createSlab(slab, plainVariant(slabModelId), topModelId, doubleModelId));
		bsmg.registerSimpleItemModel(slab, slabModelId);
	}
	
	private void registerWall(BlockFamily blockFamily, TextureMapping textureMap, BlockModelGenerators bsmg) {
		Block wall = blockFamily.get(BlockFamily.Variant.WALL);
		if (!isJineric(wall)) return;
		MultiVariant postModelId = plainVariant(
				ModelTemplates.WALL_POST.create(wall, textureMap, bsmg.modelOutput)
		);
		MultiVariant sideModelId = plainVariant(
				ModelTemplates.WALL_LOW_SIDE.create(wall, textureMap, bsmg.modelOutput)
		);
		MultiVariant sideTallModelId = plainVariant(
				ModelTemplates.WALL_TALL_SIDE.create(wall, textureMap, bsmg.modelOutput)
		);
		bsmg.blockStateOutput.accept(BlockModelGenerators.createWall(wall, postModelId, sideModelId, sideTallModelId));
		Identifier wallInventory = ModelTemplates.WALL_INVENTORY.create(wall, textureMap, bsmg.modelOutput);
		bsmg.registerSimpleItemModel(wall, wallInventory);
	}
	
	private void registerColumnWall(BlockFamily blockFamily, TextureMapping textureMap, BlockModelGenerators bsmg) {
		Block wall = blockFamily.get(BlockFamily.Variant.WALL);
		MultiVariant postId = plainVariant(
				JinericModels.TEMPLATE_COLUMN_SHORT_WALL_POST.create(wall, textureMap, bsmg.modelOutput)
		);
		MultiVariant sideShortId = plainVariant(
				JinericModels.TEMPLATE_COLUMN_SHORT_WALL_SIDE_LOW.create(wall, textureMap, bsmg.modelOutput)
		);
		MultiVariant sideTallId = plainVariant(
				JinericModels.TEMPLATE_COLUMN_SHORT_WALL_SIDE_TALL.create(wall, textureMap, bsmg.modelOutput)
		);
		bsmg.blockStateOutput.accept(BlockModelGenerators.createWall(wall, postId, sideShortId, sideTallId));
		Identifier wallInventory = JinericModels.TEMPLATE_COLUMN_SHORT_WALL_INVENTORY.create(wall, textureMap, bsmg.modelOutput);
		bsmg.registerSimpleItemModel(wall, wallInventory);
	}
	
	private void registerTopBottomWall(BlockFamily blockFamily, BlockModelGenerators bsmg) {
		TextureMapping textureMap = JinericTextureMap.topBottomShort(blockFamily);
		Block wall = blockFamily.get(BlockFamily.Variant.WALL);
		MultiVariant postId  = plainVariant(
				JinericModels.TEMPLATE_TOP_BOTTOM_SHORT_WALL_POST.create(wall, textureMap, bsmg.modelOutput)
		);
		MultiVariant sideShortId = plainVariant(
				JinericModels.TEMPLATE_TOP_BOTTOM_SHORT_WALL_SIDE_LOW.create(wall, textureMap, bsmg.modelOutput)
		);
		MultiVariant sideTallId = plainVariant(
				JinericModels.TEMPLATE_TOP_BOTTOM_SHORT_WALL_SIDE_TALL.create(wall, textureMap, bsmg.modelOutput)
		);
		bsmg.blockStateOutput.accept(BlockModelGenerators.createWall(wall, postId, sideShortId, sideTallId));
		Identifier wallInventory = JinericModels.TEMPLATE_TOP_BOTTOM_WALL_INVENTORY.create(wall, textureMap, bsmg.modelOutput);
		bsmg.registerSimpleItemModel(wall, wallInventory);
	}
	
	private void registerBorderWall(Block wall, TextureMapping textureMap, BlockModelGenerators bsmg) {
		MultiVariant postId = plainVariant(
				JinericModels.TEMPLATE_COLUMN_SHORT_WALL_POST.create(wall, textureMap, bsmg.modelOutput)
		);
		MultiVariant sideShortId = plainVariant(
				JinericModels.TEMPLATE_BORDER_WALL_SIDE_LOW.create(wall, textureMap, bsmg.modelOutput)
		);
		MultiVariant sideShortLongId = plainVariant(
				JinericModels.TEMPLATE_BORDER_WALL_SIDE_LINE_LOW.create(wall, textureMap, bsmg.modelOutput)
		);
		MultiVariant sideTallId = plainVariant(
				JinericModels.TEMPLATE_BORDER_WALL_SIDE_TALL.create(wall, textureMap, bsmg.modelOutput)
		);
		bsmg.blockStateOutput.accept(BlockStateCreators.createBorderWallBlockState(wall, postId, sideShortId, sideShortLongId, sideTallId));
		Identifier wallInventory = JinericModels.TEMPLATE_COLUMN_SHORT_WALL_INVENTORY.create(wall, textureMap, bsmg.modelOutput);
		bsmg.registerSimpleItemModel(wall, wallInventory);
	}
	
	private TextureMapping verifyWall(BlockFamily blockFamily) {
		Block wallBlock = blockFamily.get(BlockFamily.Variant.WALL);
		// These walls use textures which have unusual naming conventions, this is a workaround for them not generating properly by default.
		if (wallBlock == JinericBlocks.QUARTZ_WALL) {
			return TextureMapping.cube(TextureMapping.getBlockTexture(Blocks.QUARTZ_BLOCK, "_side"));
		}
		if (wallBlock == JinericBlocks.SMOOTH_QUARTZ_WALL) {
			return TextureMapping.cube(TextureMapping.getBlockTexture(Blocks.QUARTZ_BLOCK, "_bottom"));
		}
		if (wallBlock == JinericBlocks.SMOOTH_SANDSTONE_WALL) {
			return TextureMapping.cube(TextureMapping.getBlockTexture(Blocks.SANDSTONE, "_top"));
		}
		if (wallBlock == JinericBlocks.SMOOTH_RED_SANDSTONE_WALL) {
			return TextureMapping.cube(TextureMapping.getBlockTexture(Blocks.RED_SANDSTONE, "_top"));
		} else {
			return TextureMapping.cube(blockFamily.getBaseBlock());
		}
	}
	
	public void registerFence(BlockFamily blockFamily, TextureMapping textureMap, boolean custom, BlockModelGenerators bsmg) {
		Block fenceBlock = custom
				? blockFamily.get(BlockFamily.Variant.CUSTOM_FENCE)
				: blockFamily.get(BlockFamily.Variant.FENCE);
		if (!this.isJineric(fenceBlock)) return;
		MultiVariant postModelId = plainVariant(
				ModelTemplates.FENCE_POST.create(fenceBlock, textureMap, bsmg.modelOutput)
		);
		MultiVariant sideModelId = plainVariant(
				ModelTemplates.FENCE_SIDE.create(fenceBlock, textureMap, bsmg.modelOutput)
		);
		bsmg.blockStateOutput.accept(BlockModelGenerators.createFence(fenceBlock, postModelId, sideModelId));
		Identifier fenceInventory = ModelTemplates.FENCE_INVENTORY.create(fenceBlock, textureMap, bsmg.modelOutput);
		bsmg.registerSimpleItemModel(fenceBlock, fenceInventory);
	}
	
	public final void registerChest(Block chest, WoodType WoodType, boolean christmas, BlockModelGenerators bsmg) {
		Material particle = new Material(JinericMain.ofJineric("block/" + WoodType.name() + "_chest_particle"));
		bsmg.createAirLikeBlock(chest, particle);
		Item chestItem = chest.asItem();
		Identifier itemModelBase = ModelTemplates.CHEST_INVENTORY.create(chestItem, TextureMapping.particle(particle), bsmg.modelOutput);
		ItemModel.Unbaked plainModel = ItemModelUtils.specialModel(itemModelBase, new ChestSpecialRenderer.Unbaked(BuiltInRegistries.BLOCK.getKey(chest)));
		if (christmas) {
			ItemModel.Unbaked giftModel = ItemModelUtils.specialModel(itemModelBase, new ChestSpecialRenderer.Unbaked(ChestSpecialRenderer.CHRISTMAS.single()));
			bsmg.itemModelOutput.accept(chestItem, ItemModelUtils.isXmas(giftModel, plainModel));
		} else {
			bsmg.itemModelOutput.accept(chestItem, plainModel);
		}
	}
	
	private void registerPillar(Block pillar, BlockModelGenerators bsmg) {
		TextureMapping textureMap = TextureMapping.column(TextureMapping.getBlockTexture(pillar, "_side"), TextureMapping.getBlockTexture(pillar, "_end"));
		Identifier identifier = ModelTemplates.CUBE_COLUMN.create(pillar, textureMap, bsmg.modelOutput);
		bsmg.createRotatedPillarWithHorizontalVariant(pillar, TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
	}
	
	private void registerBookshelf(Block bookshelf, Block plank, BlockModelGenerators bsmg) {
		TextureMapping textureMap = TextureMapping.column(TextureMapping.getBlockTexture(bookshelf), TextureMapping.getBlockTexture(plank));
		MultiVariant identifier = plainVariant(
				ModelTemplates.CUBE_COLUMN.create(bookshelf, textureMap, bsmg.modelOutput)
		);
		bsmg.blockStateOutput.accept(createSimpleBlock(bookshelf, identifier));
	}
	
	private boolean isJineric(Block block) {
		return block != null && BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals("jineric");
	}
	
	public static Block blockById(String id) {
		final Identifier identifier = JinericMain.ofJineric(id);
		if (!BuiltInRegistries.BLOCK.containsKey(identifier)) {
			throw new IllegalStateException("Block is not registered: " + identifier);
		}
		return BuiltInRegistries.BLOCK.getValue(identifier);
	}
	
	public static Item itemById(String id) {
		final Identifier identifier = JinericMain.ofJineric(id);
		if (!BuiltInRegistries.ITEM.containsKey(identifier)) {
			throw new IllegalStateException("Item is not registered: " + identifier);
		}
		return BuiltInRegistries.ITEM.getValue(identifier);
	}
	
	@Override
	public String getName() {
		return "ModelTemplates";
	}
}