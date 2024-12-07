package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.WoodType;
import net.minecraft.client.data.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.stream.Stream;

import static net.minecraft.client.data.BlockStateModelGenerator.createSingletonBlockState;

public class JinericModelGenerator extends FabricModelProvider {
   public JinericModelGenerator(FabricDataOutput output) {
      super(output);
   }

   @Override
   public void generateBlockStateModels(BlockStateModelGenerator blockModelGenerator) {
      this.genVanillaWoodFamilyAdditions(blockModelGenerator);
      Stream<BlockFamily> blockFamilies = BlockFamilies.getFamilies();
      blockFamilies
              .filter(BlockFamily::shouldGenerateModels)
              .forEach(blockFamily -> {
                 Block baseBlock = blockFamily.getBaseBlock();
                 if (Registries.BLOCK.getId(baseBlock).getNamespace().equals("jineric")) {
                    blockModelGenerator.registerCubeAllModelTexturePool(baseBlock).family(blockFamily);
                 }
//                 Map<BlockFamily.Variant, Block> blockVariant = blockFamily.getVariants();
//                 blockVariant.forEach((variant, block) -> {
//                    if (Registries.BLOCK.getId(block).getNamespace().equals("jineric")) {
//                       blockModelGenerator.registerSimpleCubeAll(baseBlock);
//                    }
//                 });
              });
      blockModelGenerator.registerSimpleCubeAll(JinericBlocks.PRISMARINE_CRYSTAL_BLOCK);
      blockModelGenerator.registerSimpleCubeAll(JinericBlocks.SUGAR_BLOCK);
      blockModelGenerator.registerSimpleCubeAll(JinericBlocks.CHARCOAL_BLOCK);
      blockModelGenerator.registerSimpleCubeAll(JinericBlocks.FLINT_BLOCK);
      blockModelGenerator.registerSimpleCubeAll(JinericBlocks.EGG_BLOCK);
      blockModelGenerator.registerSimpleCubeAll(JinericBlocks.ROTTEN_FLESH_BLOCK);
      blockModelGenerator.registerSimpleCubeAll(JinericBlocks.ENDER_PEARL_BLOCK);
      blockModelGenerator.registerSimpleCubeAll(JinericBlocks.BONE_MEAL_BLOCK);
      // TODO: AFAIK THERE IS NO VANILLA METHOD TO GEN BLOCKS LIKE PAPER_BLOCK AND BLAZE_ROD_BLOCK
      blockModelGenerator.registerSimpleState(JinericBlocks.PAPER_BLOCK);
      blockModelGenerator.registerSimpleState(JinericBlocks.BLAZE_ROD_BLOCK);
      blockModelGenerator.registerAxisRotated(JinericBlocks.STICK_BLOCK, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
      blockModelGenerator.registerAxisRotated(JinericBlocks.TUFF_BRICK_PILLAR, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
   }

   public void genVanillaWoodFamilyAdditions(BlockStateModelGenerator blockStateModelGenerator) {
      DefaultedRegistry<Block> blockRegistry = Registries.BLOCK;
      List<WoodType> woodTypes = WoodType.stream().toList();
      woodTypes.forEach(woodType -> blockRegistry.stream()
              .filter(block -> blockRegistry.getId(block).getNamespace().equals("jineric"))
              .forEach(block -> {
                 Block plank = blockRegistry.get(Identifier.of(woodType.name() + "_planks"));
                 String blockKey = block.getTranslationKey();
                 String trimmedBlockKey = blockKey
                         .replace("block.jineric.", "")
                         .replace("_ladder", "")
                         .replace("trapped_", "").replace("_chest", "")
                         .replace("_bookshelf", "");
                 if (trimmedBlockKey.equals(woodType.name())) {
                    this.offerWoodTypeBlock(blockKey, plank, block, blockStateModelGenerator);
                 }
              })
      );
   }

   public void offerWoodTypeBlock(String blockKey, Block plank, Block checkedBlock, BlockStateModelGenerator blockStateModelGenerator) {
      if (blockKey.contains("_chest")) {
         if (blockKey.contains("trapped_")) {

         } else {
//         blockStateModelGenerator.registerBuiltin(ModelIds.getMinecraftNamespacedBlock("chest"), plank).includeWithoutItem(Blocks.CHEST, Blocks.TRAPPED_CHEST);
         }
      } else if (blockKey.contains("_ladder")) {
//         blockStateModelGenerator.registerNorthDefaultHorizontalRotation(checkedBlock);
//         blockStateModelGenerator.registerItemModel(checkedBlock);
      } else if (blockKey.contains("_bookshelf")) {
         this.registerBookshelf(checkedBlock, plank, blockStateModelGenerator);
      }
   }

   @Override
   public void generateItemModels(ItemModelGenerator itemModelGenerator) {
      //TODO: 1.21.4: ALL ITEM MODELS ARE BROKEN AND NEED TO BE MIGRATED TO DATA-GEN
   }

   public void registerSimpleBlockSet(Block blockTexture, Block stairBlock, Block slabBlock, Block wallBlock, BlockStateModelGenerator blockStateModelGenerator) {
      blockStateModelGenerator.registerSimpleCubeAll(blockTexture);
      registerStairs(stairBlock, blockTexture, blockStateModelGenerator);
      registerSlab(slabBlock, blockTexture, blockStateModelGenerator);
      registerWall(wallBlock, blockTexture, blockStateModelGenerator);
   }

   public void registerStairs(Block stairsBlock, Block stairsBlockTexture, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap stairTextureMap = TextureMap.all(TextureMap.getId(stairsBlockTexture));
      Identifier regularModelId = Models.STAIRS.upload(stairsBlock, stairTextureMap, blockStateModelGenerator.modelCollector);
      Identifier innerModelId = Models.INNER_STAIRS.upload(stairsBlock, stairTextureMap, blockStateModelGenerator.modelCollector);
      Identifier outerModelId = Models.OUTER_STAIRS.upload(stairsBlock, stairTextureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(stairsBlock, innerModelId, regularModelId, outerModelId));
   }
   public void registerSlab(Block slabBlock, Block slabBlockTexture, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap slabTextureMap = TextureMap.all(TextureMap.getId(slabBlockTexture));
      TextureMap slabTextureMapSide = TextureMap.sideEnd(slabTextureMap.getTexture(TextureKey.SIDE), slabTextureMap.getTexture(TextureKey.TOP));
      Identifier bottomModelId = Models.SLAB.upload(slabBlock, slabTextureMapSide, blockStateModelGenerator.modelCollector);
      Identifier topModelId = Models.SLAB_TOP.upload(slabBlock, slabTextureMapSide, blockStateModelGenerator.modelCollector);
      Identifier doubleModelId = Models.CUBE_COLUMN.uploadWithoutVariant(slabBlock, "_double", slabTextureMapSide, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(slabBlock, bottomModelId, topModelId, doubleModelId));
   }
   public void registerWall( Block wallBlock, Block wallBlockTexture, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap wallTextureMap = TextureMap.all(TextureMap.getId(wallBlockTexture));
      Identifier postModelId = Models.TEMPLATE_WALL_POST.upload(wallBlock, wallTextureMap, blockStateModelGenerator.modelCollector);
      Identifier sideModelId = Models.TEMPLATE_WALL_SIDE.upload(wallBlock, wallTextureMap, blockStateModelGenerator.modelCollector);
      Identifier sideTallModelId = Models.TEMPLATE_WALL_SIDE_TALL.upload(wallBlock, wallTextureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(wallBlock, postModelId, sideModelId, sideTallModelId));
      Identifier wallInventory = Models.WALL_INVENTORY.upload(wallBlock, wallTextureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.registerParentedItemModel(wallBlock, wallInventory);
   }

   private void registerBookshelf(Block bookshelf, Block plank, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap textureMap = TextureMap.sideEnd(TextureMap.getId(bookshelf), TextureMap.getId(plank));
      Identifier identifier = Models.CUBE_COLUMN.upload(bookshelf, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(bookshelf, identifier));
   }

   public void registerFence(Block fenceBlock, Block fenceBlockTexture, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap fenceTextureMap = TextureMap.all(TextureMap.getId(fenceBlockTexture));
      Identifier postModelId = Models.FENCE_POST.upload(fenceBlock, fenceTextureMap, blockStateModelGenerator.modelCollector);
      Identifier sideModelId = Models.FENCE_SIDE.upload(fenceBlock, fenceTextureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createFenceBlockState(fenceBlock, postModelId, sideModelId));
      Identifier fenceInventory = Models.FENCE_INVENTORY.upload(fenceBlock, fenceTextureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.registerParentedItemModel(fenceBlock, fenceInventory);
   }

   @Override
   public String getName() {
      return "jineric_model";
   }
}