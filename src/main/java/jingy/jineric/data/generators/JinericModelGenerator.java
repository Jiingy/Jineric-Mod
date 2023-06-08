package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class JinericModelGenerator extends FabricModelProvider {
   public JinericModelGenerator(FabricDataOutput output) {
      super(output);
   }


   @Override
   public void generateBlockStateModels(BlockStateModelGenerator blockModelGenerator) {
      //SNOW BRICKS
      registerSimpleBlockSet(
              JinericBlocks.SNOW_BRICKS,
              JinericBlocks.SNOW_BRICK_STAIRS,
              JinericBlocks.SNOW_BRICK_SLAB,
              JinericBlocks.SNOW_BRICK_WALL,
              blockModelGenerator
      );
   }

   @Override
   public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//      itemModelGenerator.register(JinericItems.SNOW_BRICKS, JinericItems.SNOW_BRICKS, Models.GENERATED);
//      itemModelGenerator.register(JinericItems.SNOW_BRICK_STAIRS, JinericItems.SNOW_BRICKS, Models.STAIRS);
//      itemModelGenerator.register(JinericItems.SNOW_BRICK_SLAB, JinericItems.SNOW_BRICKS, Models.SLAB);
//      itemModelGenerator.register(JinericItems.SNOW_BRICK_WALL, JinericItems.SNOW_BRICKS, Models.WALL_INVENTORY);
   }

   public void registerSimpleBlockSet(Block blockTexture, Block stairBlock, Block slabBlock, Block wallBlock, BlockStateModelGenerator blockStateModelGenerator) {
      blockStateModelGenerator.registerSimpleCubeAll(blockTexture);
      registerStairs(stairBlock, blockTexture, blockStateModelGenerator);
      registerSlab(slabBlock, blockTexture, blockStateModelGenerator);
      registerWall(wallBlock, blockTexture, blockStateModelGenerator);
   }

   private static TextureMap getBlock(Block block) {
      return TextureMap.all(block);
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
//      TextureMap slabTextureMapSide = TextureMap.sideEnd(TextureMap.getSubId(slabBlock, "_side"), slabTextureMap.getTexture(TextureKey.TOP));
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

   public void registerFence(Block fenceBlock, Block fenceBlockTexture, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap fenceTextureMap = TextureMap.all(TextureMap.getId(fenceBlockTexture));
      Identifier postModelId = Models.FENCE_POST.upload(fenceBlock, fenceTextureMap, blockStateModelGenerator.modelCollector);
      Identifier sideModelId = Models.FENCE_SIDE.upload(fenceBlock, fenceTextureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createFenceBlockState(fenceBlock, postModelId, sideModelId));
      Identifier fenceInventory = Models.FENCE_INVENTORY.upload(fenceBlock, fenceTextureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.registerParentedItemModel(fenceBlock, fenceInventory);
   }
}