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
import net.minecraft.client.render.item.tint.GrassTintSource;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.Item;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

import static net.minecraft.client.data.BlockStateModelGenerator.createModelVariantWithRandomHorizontalRotations;
import static net.minecraft.client.data.BlockStateModelGenerator.createSingletonBlockState;

public class JinericModelGenerator extends FabricModelProvider {
   public JinericModelGenerator(FabricDataOutput output) {
      super(output);
   }

   @Override
   public void generateBlockStateModels(BlockStateModelGenerator bsmg) {
      BlockFamilies.getFamilies().filter(BlockFamily::shouldGenerateModels).forEach(blockFamily -> {
         Block baseBlock = blockFamily.getBaseBlock();
         TextureMap textureMapAll = TextureMap.all(baseBlock);
         this.acceptBlock(baseBlock, Models.CUBE_ALL, textureMapAll, bsmg);
         for (BlockFamily.Variant familyVariant : BlockFamily.Variant.values()) {
            if (Registries.BLOCK.getId(blockFamily.getVariant(familyVariant)).getNamespace().equals("jineric")) {
               switch (familyVariant) {
                  case BUTTON -> this.registerButton(blockFamily, textureMapAll, bsmg);
                  case DOOR -> bsmg.registerDoor(blockFamily.getVariant(BlockFamily.Variant.DOOR));
                  case FENCE_GATE -> this.registerFenceGate(blockFamily, textureMapAll, bsmg);
                  case SIGN -> this.registerSign(blockFamily, textureMapAll, bsmg);
                  case FENCE -> this.registerFence(blockFamily, textureMapAll, bsmg);
                  case STAIRS -> this.acceptStairs(blockFamily, textureMapAll, bsmg);
                  case PRESSURE_PLATE -> this.registerPressurePlate(blockFamily, textureMapAll, bsmg);
                  case SLAB -> this.acceptSlab(blockFamily, textureMapAll, bsmg);
                  case TRAPDOOR -> bsmg.registerTrapdoor(blockFamily.getVariant(BlockFamily.Variant.TRAPDOOR));
                  case WALL -> this.acceptWall(blockFamily, this.verifyWall(blockFamily), bsmg);
               }
            }
         }

         blockFamily.getGroup().ifPresent(name -> {
            if (name.equals("wooden") && Registries.BLOCK.getId(baseBlock).getNamespace().equals("jineric")) {
               WoodType.stream()
                       .filter(woodType -> woodType.name().contains("jineric") && blockFamily.getBaseBlock().toString().contains(woodType.name()))
                       .forEach(woodType -> this.finishWoodSet(woodType, null, bsmg));
            }
         });
      });

      this.genVanillaWoodFamilyAdditions(bsmg);
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
      bsmg.registerAxisRotated(JinericBlocks.STONE_BRICK_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
      bsmg.registerAxisRotated(JinericBlocks.TUFF_BRICK_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
      bsmg.registerAxisRotated(JinericBlocks.DRIPSTONE_BRICK_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
      bsmg.registerTintedItemModel(JinericBlocks.FULL_GRASS_BLOCK, ModelIds.getBlockModelId(JinericBlocks.FULL_GRASS_BLOCK), new GrassTintSource());
      this.registerCubeBottomTopSet(JinericBlockFamilies.SOUL_SANDSTONE,  bsmg);
      this.acceptChiseledBlock(JinericBlockFamilies.SOUL_SANDSTONE, JinericBlocks.SMOOTH_SOUL_SANDSTONE, bsmg);
      this.registerCubeColumnBlockSet(JinericBlockFamilies.CUT_SANDSTONE, JinericBlockFamilies.SANDSTONE, bsmg);
      this.registerCubeColumnBlockSet(JinericBlockFamilies.CUT_RED_SANDSTONE, JinericBlockFamilies.RED_SANDSTONE, bsmg);
      this.registerCubeColumnBlockSet(JinericBlockFamilies.CUT_SOUL_SANDSTONE, JinericBlockFamilies.SOUL_SANDSTONE, bsmg);
      this.registerBorderBlockSet(JinericBlockFamilies.SMOOTH_STONE, bsmg);
      this.registerBorderBlockSet(JinericBlockFamilies.POLISHED_STONE, bsmg);
      this.acceptWall(JinericBlockFamilies.CUT_COPPER, TextureMap.all(Blocks.CUT_COPPER), bsmg);
      this.acceptWall(JinericBlockFamilies.EXPOSED_CUT_COPPER, TextureMap.all(Blocks.EXPOSED_CUT_COPPER), bsmg);
      this.acceptWall(JinericBlockFamilies.WEATHERED_CUT_COPPER, TextureMap.all(Blocks.WEATHERED_CUT_COPPER), bsmg);
      this.acceptWall(JinericBlockFamilies.OXIDIZED_CUT_COPPER, TextureMap.all(Blocks.OXIDIZED_CUT_COPPER), bsmg);
      this.acceptWall(JinericBlockFamilies.WAXED_CUT_COPPER, TextureMap.all(Blocks.CUT_COPPER), bsmg);
      this.acceptWall(JinericBlockFamilies.WAXED_EXPOSED_CUT_COPPER, TextureMap.all(Blocks.EXPOSED_CUT_COPPER), bsmg);
      this.acceptWall(JinericBlockFamilies.WAXED_WEATHERED_CUT_COPPER, TextureMap.all(Blocks.WEATHERED_CUT_COPPER), bsmg);
      this.acceptWall(JinericBlockFamilies.WAXED_OXIDIZED_CUT_COPPER, TextureMap.all(Blocks.OXIDIZED_CUT_COPPER), bsmg);

      bsmg.registerFlowerPotPlantAndItem(JinericBlocks.PETRIFIED_OAK_SAPLING, JinericBlocks.POTTED_PETRIFIED_OAK_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
   }

   @Override
   public void generateItemModels(ItemModelGenerator itemModelGenerator) {
      BlockFamilies.getFamilies().filter(BlockFamily::shouldGenerateModels).forEach(blockFamily -> {
         Block baseBlock = blockFamily.getBaseBlock();
         blockFamily.getGroup().ifPresent(name -> {
            if (name.equals("wooden") && Registries.BLOCK.getId(baseBlock).getNamespace().equals("jineric")) {
               WoodType.stream()
                       .filter(woodType -> woodType.name().contains("jineric") && blockFamily.getBaseBlock().toString().contains(woodType.name()))
                       .forEach(woodType -> this.finishWoodSet(woodType, itemModelGenerator, null));
            }
         });
      });
      Identifier jungleLadderId = itemModelGenerator.uploadTwoLayers(JinericItems.JUNGLE_LADDER, ModelIds.getBlockModelId(JinericBlocks.JUNGLE_LADDER), JinericMain.ofJineric("block/jungle_ladder_overlay"));
      itemModelGenerator.output.accept(JinericItems.JUNGLE_LADDER, ItemModels.tinted(jungleLadderId, new GrassTintSource()));
      itemModelGenerator.register(JinericItems.GOLDEN_BEETROOT, Models.GENERATED);
      itemModelGenerator.register(JinericItems.GOLDEN_POTATO, Models.GENERATED);
      itemModelGenerator.register(JinericItems.GOLDEN_SWEET_BERRIES, Models.GENERATED);
      itemModelGenerator.register(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
      itemModelGenerator.register(JinericItems.NETHERITE_HORSE_ARMOR, Models.GENERATED);
   }

   public void finishWoodSet(WoodType woodType, @Nullable ItemModelGenerator img, @Nullable BlockStateModelGenerator bsmg) {
      String woodTypeName = woodType.name().replace("jineric:", "");
      if (bsmg != null) {
         this.acceptLogs(woodType, bsmg);
         this.registerBookshelf(blockById(woodTypeName + "_bookshelf"), blockById(woodTypeName + "_planks"), bsmg);
         bsmg.registerTintedBlockAndItem(
                 blockById(woodTypeName + "_leaves"),
                 TexturedModel.LEAVES,
                 -12012264);
         bsmg.registerNorthDefaultHorizontalRotation(blockById(woodTypeName + "_ladder"));
         bsmg.registerItemModel(blockById(woodTypeName + "_ladder"));
         bsmg.registerHangingSign(
                 blockById("stripped_" + woodTypeName + "_log"),
                 blockById(woodTypeName + "_hanging_sign"),
                 blockById(woodTypeName + "_wall_hanging_sign")
         );
      }
      if (img != null) {
         img.register(itemById(woodTypeName + "_boat"), Models.GENERATED);
         img.register(itemById(woodTypeName + "_chest_boat"), Models.GENERATED);
      }
   }

   public void genVanillaWoodFamilyAdditions(BlockStateModelGenerator blockStateModelGenerator) {
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
                    this.offerWoodTypeBlock(blockKey, plank, block, blockStateModelGenerator, woodType);
                 }
              })
      );
   }

   public void offerWoodTypeBlock(String blockKey, Block plank, Block checkedBlock, BlockStateModelGenerator blockModelGenerator, WoodType woodType) {
      // Instead of 'blockKey.contains("")', could use an instance of check
      if (blockKey.contains("_chest")) {
         blockModelGenerator.registerChest(checkedBlock, plank, JinericMain.ofJineric(woodType.name() + "_chest"), true);
      }
      if (blockKey.contains("_ladder")) {
         blockModelGenerator.registerNorthDefaultHorizontalRotation(checkedBlock);
         if (!blockKey.contains("jungle_")) {
            blockModelGenerator.registerItemModel(checkedBlock);
         }
      }
      if (blockKey.contains("_bookshelf")) {
         this.registerBookshelf(checkedBlock, plank, blockModelGenerator);
      }
   }

   public void registerCubeBottomTopSet(BlockFamily blockFamily, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap textureMap = JinericTextureMap.topBottomShort(blockFamily);
      this.acceptBlock(blockFamily.getBaseBlock(), Models.CUBE_BOTTOM_TOP, textureMap, blockStateModelGenerator);
      this.acceptStairs(blockFamily, textureMap, blockStateModelGenerator);
      this.acceptSlab(blockFamily, textureMap, blockStateModelGenerator);
      this.acceptTopBottomWall(blockFamily, blockStateModelGenerator);
   }

   public void registerCubeColumnBlockSet(BlockFamily blockFamily, @Nullable BlockFamily blockTopFix, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap textureMap = JinericTextureMap.columnShort(blockFamily, blockTopFix);
      Block baseBlock = blockFamily.getBaseBlock();
      this.acceptBlock(baseBlock, Models.CUBE_COLUMN, textureMap, blockStateModelGenerator);
      this.acceptStairs(blockFamily, textureMap, blockStateModelGenerator);
      this.acceptSlab(blockFamily, textureMap, blockStateModelGenerator);
      this.acceptColumnWall(blockFamily, textureMap, blockStateModelGenerator);
   }

   public void registerBorderBlockSet(BlockFamily blockFamily, BlockStateModelGenerator blockStateModelGenerator) {
      Block blockFamilyWall = blockFamily.getVariant(BlockFamily.Variant.WALL);
      Block baseBlock = blockFamily.getBaseBlock();
      this.acceptBlock(baseBlock, Models.CUBE_ALL, TextureMap.all(baseBlock), blockStateModelGenerator);
      this.acceptStairs(blockFamily, JinericTextureMap.borderStairs(blockFamily), blockStateModelGenerator);
      this.acceptSlab(blockFamily, JinericTextureMap.sidedSlab(blockFamily), blockStateModelGenerator);
      this.acceptBorderWall(blockFamilyWall, JinericTextureMap.borderWall(blockFamily), blockStateModelGenerator);
   }

   private void acceptBlock(Block block, Model model, TextureMap textureMap, BlockStateModelGenerator blockStateModelGenerator) {
      if (!this.isJineric(block)) return;
      Identifier id = model.upload(block, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, id));
   }

   private void acceptChiseledBlock(BlockFamily blockFamily, Block endTexture, BlockStateModelGenerator blockStateModelGenerator) {
      Block chiseledBlock = blockFamily.getVariant(BlockFamily.Variant.CHISELED);
      TextureMap textureMap = JinericTextureMap.bareSideEnd(chiseledBlock, endTexture);
      Identifier id = Models.CUBE_COLUMN.upload(chiseledBlock, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(chiseledBlock, id));
   }

   private void acceptLogs(WoodType woodType, BlockStateModelGenerator bsmg) {
      String woodTypeName = woodType.name().replace("jineric:", "");
      bsmg.registerLog(blockById(woodTypeName + "_log"))
              .log(blockById(woodTypeName + "_log"))
              .wood(blockById(woodTypeName + "_wood"));
      bsmg.registerLog(blockById("stripped_" + woodTypeName + "_log"))
              .log(blockById("stripped_" + woodTypeName + "_log"))
              .wood(blockById("stripped_" + woodTypeName + "_wood"));
   }

   private void acceptStairs(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator blockStateModelGenerator) {
      Block stairs = blockFamily.getVariant(BlockFamily.Variant.STAIRS);
      if (!this.isJineric(stairs)) return;
      Identifier regularModelId = Models.STAIRS.upload(stairs, textureMap, blockStateModelGenerator.modelCollector);
      Identifier innerModelId = Models.INNER_STAIRS.upload(stairs, textureMap, blockStateModelGenerator.modelCollector);
      Identifier outerModelId = Models.OUTER_STAIRS.upload(stairs, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(stairs, innerModelId, regularModelId, outerModelId));
   }

   private void acceptColumnStairs(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator blockStateModelGenerator) {
      Block stairs = blockFamily.getVariant(BlockFamily.Variant.STAIRS);
      Identifier regularModelId = Models.STAIRS.upload(stairs, textureMap, blockStateModelGenerator.modelCollector);
      Identifier innerModelId = Models.INNER_STAIRS.upload(stairs, textureMap, blockStateModelGenerator.modelCollector);
      Identifier outerModelId = Models.OUTER_STAIRS.upload(stairs, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(stairs, innerModelId, regularModelId, outerModelId));
   }

   private void acceptSlab(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator blockStateModelGenerator) {
      Block slab = blockFamily.getVariant(BlockFamily.Variant.SLAB);
      if (!this.isJineric(slab)) return;
      Identifier slabModelId = Models.SLAB.upload(slab, textureMap, blockStateModelGenerator.modelCollector);
      Identifier topModelId = Models.SLAB_TOP.upload(slab, textureMap, blockStateModelGenerator.modelCollector);
//      Identifier bottomModelId = BlockStateModelGenerator.BlockTexturePool.ensureModel(Models.SLAB, block);
//      Identifier topModelId = blockStateModelGenerator.ensureModel(Models.SLAB_TOP, block);
      Identifier doubleModelId = Models.CUBE_BOTTOM_TOP.uploadWithoutVariant(slab, "_double", textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(slab, slabModelId, topModelId, doubleModelId));
      blockStateModelGenerator.registerParentedItemModel(slab, slabModelId);
   }

   private void acceptWall(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator blockStateModelGenerator) {
      Block wall = blockFamily.getVariant(BlockFamily.Variant.WALL);
      if (!isJineric(wall)) return;
      Identifier postModelId = Models.TEMPLATE_WALL_POST.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      Identifier sideModelId = Models.TEMPLATE_WALL_SIDE.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      Identifier sideTallModelId = Models.TEMPLATE_WALL_SIDE_TALL.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(wall, postModelId, sideModelId, sideTallModelId));
      Identifier wallInventory = Models.WALL_INVENTORY.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.registerParentedItemModel(wall, wallInventory);
   }

   private void acceptColumnWall(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator blockStateModelGenerator) {
      Block wall = blockFamily.getVariant(BlockFamily.Variant.WALL);
      Identifier postId = JinericModels.TEMPLATE_COLUMN_SHORT_WALL_POST.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      Identifier sideShortId = JinericModels.TEMPLATE_COLUMN_SHORT_WALL_SIDE_LOW.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      Identifier sideTallId = JinericModels.TEMPLATE_COLUMN_SHORT_WALL_TALL_SIDE.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(wall, postId, sideShortId, sideTallId));
      Identifier wallInventory = JinericModels.TEMPLATE_COLUMN_SHORT_WALL_INVENTORY.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.registerParentedItemModel(wall, wallInventory);
   }

   private void acceptTopBottomWall(BlockFamily blockFamily, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap textureMap = JinericTextureMap.topBottomShort(blockFamily);
      Block wall = blockFamily.getVariant(BlockFamily.Variant.WALL);
      Identifier postId = JinericModels.TEMPLATE_TOP_BOTTOM_SHORT_WALL_POST.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      Identifier sideShortId = JinericModels.TEMPLATE_TOP_BOTTOM_SHORT_WALL_SIDE_LOW.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      Identifier sideTallId = JinericModels.TEMPLATE_TOP_BOTTOM_SHORT_WALL_SIDE_TALL.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(wall, postId, sideShortId, sideTallId));
      Identifier wallInventory = JinericModels.TEMPLATE_TOP_BOTTOM_WALL_INVENTORY.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.registerParentedItemModel(wall, wallInventory);
   }

   private void acceptBorderWall(Block wall, TextureMap textureMap, BlockStateModelGenerator blockStateModelGenerator) {
      Identifier postId = JinericModels.TEMPLATE_COLUMN_SHORT_WALL_POST.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      Identifier sideShortId = JinericModels.TEMPLATE_BORDER_WALL_SIDE_LOW.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      Identifier sideShortLongId = JinericModels.TEMPLATE_BORDER_WALL_SIDE_LINE_LOW.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      Identifier sideTallId = JinericModels.TEMPLATE_BORDER_WALL_SIDE_TALL.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateCreators.createBorderWallBlockState(wall, postId, sideShortId, sideShortLongId, sideTallId));
      Identifier wallInventory = JinericModels.TEMPLATE_COLUMN_SHORT_WALL_INVENTORY.upload(wall, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.registerParentedItemModel(wall, wallInventory);
   }

   private TextureMap verifyWall(BlockFamily blockFamily) {
      Block wallBlock = blockFamily.getVariant(BlockFamily.Variant.WALL);
      // These walls use textures which have unusual naming conventions, this is a workaround for them not generating properly by default.
      if (wallBlock == JinericBlocks.QUARTZ_WALL) {return TextureMap.all(TextureMap.getSubId(Blocks.QUARTZ_BLOCK, "_side"));}
      if (wallBlock == JinericBlocks.SMOOTH_QUARTZ_WALL) {return TextureMap.all(TextureMap.getSubId(Blocks.QUARTZ_BLOCK, "_bottom"));}
      if (wallBlock == JinericBlocks.SMOOTH_SANDSTONE_WALL) {return TextureMap.all(TextureMap.getSubId(Blocks.SANDSTONE, "_top"));}
      if (wallBlock == JinericBlocks.SMOOTH_RED_SANDSTONE_WALL) {return TextureMap.all(TextureMap.getSubId(Blocks.RED_SANDSTONE, "_top"));}
      else {
         return TextureMap.all(blockFamily.getBaseBlock());
      }
   }

   public void registerSign(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator blockStateModelGenerator) {
      Block signBlock = blockFamily.getVariants().get(BlockFamily.Variant.SIGN);
      Block wallSignBlock = blockFamily.getVariants().get(BlockFamily.Variant.WALL_SIGN);
      Identifier identifier = Models.PARTICLE.upload(signBlock, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(signBlock, identifier));
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(wallSignBlock, identifier));
      blockStateModelGenerator.registerItemModel(signBlock.asItem());
   }

   public void registerFence(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator blockStateModelGenerator) {
      Block fenceBlock = blockFamily.getVariant(BlockFamily.Variant.FENCE);
      if (!this.isJineric(fenceBlock)) return;
      Identifier postModelId = Models.FENCE_POST.upload(fenceBlock, textureMap, blockStateModelGenerator.modelCollector);
      Identifier sideModelId = Models.FENCE_SIDE.upload(fenceBlock, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createFenceBlockState(fenceBlock, postModelId, sideModelId));
      Identifier fenceInventory = Models.FENCE_INVENTORY.upload(fenceBlock, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.registerParentedItemModel(fenceBlock, fenceInventory);
   }

   public void registerFenceGate(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator generator) {
      Block fenceGateBlock = blockFamily.getVariant(BlockFamily.Variant.FENCE_GATE);
      Identifier identifier = Models.TEMPLATE_FENCE_GATE_OPEN.upload(fenceGateBlock, textureMap, generator.modelCollector);
      Identifier identifier2 = Models.TEMPLATE_FENCE_GATE.upload(fenceGateBlock, textureMap, generator.modelCollector);
      Identifier identifier3 = Models.TEMPLATE_FENCE_GATE_WALL_OPEN.upload(fenceGateBlock, textureMap, generator.modelCollector);
      Identifier identifier4 = Models.TEMPLATE_FENCE_GATE_WALL.upload(fenceGateBlock, textureMap, generator.modelCollector);
      generator.blockStateCollector.accept(BlockStateModelGenerator.createFenceGateBlockState(fenceGateBlock, identifier, identifier2, identifier3, identifier4, true));
   }

   public void registerPressurePlate(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator generator) {
      Block pressurePlateBlock = blockFamily.getVariant(BlockFamily.Variant.PRESSURE_PLATE);
      Identifier upModelId = Models.PRESSURE_PLATE_UP.upload(pressurePlateBlock, textureMap, generator.modelCollector);
      Identifier downModelId = Models.PRESSURE_PLATE_DOWN.upload(pressurePlateBlock, textureMap, generator.modelCollector);
      generator.blockStateCollector.accept(BlockStateModelGenerator.createPressurePlateBlockState(pressurePlateBlock, upModelId, downModelId));
   }

   public void registerButton(BlockFamily blockFamily, TextureMap textureMap, BlockStateModelGenerator generator) {
      Block buttonBlock = blockFamily.getVariant(BlockFamily.Variant.BUTTON);
      Identifier buttonId = Models.BUTTON.upload(buttonBlock, textureMap, generator.modelCollector);
      Identifier pressedButtonId = Models.BUTTON_PRESSED.upload(buttonBlock, textureMap, generator.modelCollector);
      generator.blockStateCollector.accept(BlockStateModelGenerator.createButtonBlockState(buttonBlock, buttonId, pressedButtonId));
      Identifier buttonInventory = Models.BUTTON_INVENTORY.upload(buttonBlock, textureMap, generator.modelCollector);
      generator.registerParentedItemModel(buttonBlock, buttonInventory);
   }

   private void registerPillar(Block pillar, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap textureMap = TextureMap.sideEnd(TextureMap.getSubId(pillar, "_side"), TextureMap.getSubId(pillar, "_end"));
      Identifier identifier = Models.CUBE_COLUMN.upload(pillar, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.registerAxisRotated(pillar, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
   }

   private void registerBookshelf(Block bookshelf, Block plank, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap textureMap = TextureMap.sideEnd(TextureMap.getId(bookshelf), TextureMap.getId(plank));
      Identifier identifier = Models.CUBE_COLUMN.upload(bookshelf, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(bookshelf, identifier));
   }

   public void registerFullGrassBlock(BlockStateModelGenerator blockStateModelGenerator) {
      Identifier fullGrassBlockId = TextureMap.getId(JinericBlocks.FULL_GRASS_BLOCK);
      Identifier fullGrassBlock = TexturedModel.CUBE_BOTTOM_TOP
              .get(JinericBlocks.FULL_GRASS_BLOCK)
              .textures(texture -> texture
                      .put(TextureKey.ALL, fullGrassBlockId)
              )
              .upload(JinericBlocks.FULL_GRASS_BLOCK, blockStateModelGenerator.modelCollector);
      List<BlockStateVariant> list = Arrays.asList(createModelVariantWithRandomHorizontalRotations(fullGrassBlock));

      TextureMap textureMap = new TextureMap()
              .put(TextureKey.TOP, fullGrassBlockId)
              .put(TextureKey.SIDE, fullGrassBlockId)
              .put(TextureKey.of("overlay"), TextureMap.getSubId(JinericBlocks.FULL_GRASS_BLOCK, "_snow"))
              .put(TextureKey.BOTTOM, fullGrassBlockId)
              .inherit(TextureKey.BOTTOM, TextureKey.PARTICLE);

      BlockStateVariant snowyVariant = BlockStateVariant.create()
              .put(VariantSettings.MODEL, Models.CUBE_BOTTOM_TOP
                      .upload(
                              JinericBlocks.FULL_GRASS_BLOCK,
                              "_snow",
                              textureMap,
                              blockStateModelGenerator.modelCollector
                      )
              );
      blockStateModelGenerator.blockStateCollector
              .accept(VariantsBlockStateSupplier.create(JinericBlocks.FULL_GRASS_BLOCK)
                      .coordinate(BlockStateVariantMap.create(Properties.SNOWY)
                              .register(true, snowyVariant)
                              .register(false, list)
      ));
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

   private boolean isJineric(Block block) {
      return block != null && Registries.BLOCK.getId(block).getNamespace().equals("jineric");
   }

   @Override
   public String getName() {
      return "jineric_models";
   }
}