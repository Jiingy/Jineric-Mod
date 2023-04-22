package jingy.jineric.data.generators;

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
   public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

   }

   @Override
   public void generateItemModels(ItemModelGenerator itemModelGenerator) {
   }

   public void registerBlockSet(Block block, Block stairBlock, Block slabBlock, Block wallBlock, BlockStateModelGenerator blockStateModelGenerator) {
      blockStateModelGenerator.registerSimpleCubeAll(block);
      registerStairs(stairBlock, blockStateModelGenerator);
      registerSlab(slabBlock, blockStateModelGenerator);
      registerWall(wallBlock, blockStateModelGenerator);
   }

   private static TextureMap getBlock(Block block) {
      return TextureMap.all(block);
   }

   public void registerStairs(Block stairBlockTexture, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap stairTextureMap = TextureMap.all(TextureMap.getId(stairBlockTexture));
      Identifier regularModelId = Models.STAIRS.upload(stairBlockTexture, stairTextureMap, blockStateModelGenerator.modelCollector);
      Identifier innerModelId = Models.INNER_STAIRS.upload(stairBlockTexture, stairTextureMap, blockStateModelGenerator.modelCollector);
      Identifier outerModelId = Models.OUTER_STAIRS.upload(stairBlockTexture, stairTextureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(stairBlockTexture, innerModelId, regularModelId, outerModelId));
   }
   public void registerSlab(Block slabBlockTexture, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap slabTextureMap = TextureMap.all(TextureMap.getId(slabBlockTexture));
      TextureMap slabTextureMapSide = TextureMap.sideEnd(TextureMap.getSubId(slabBlockTexture, "_side"), slabTextureMap.getTexture(TextureKey.TOP));
      Identifier bottomModelId = Models.SLAB.upload(slabBlockTexture, slabTextureMapSide, blockStateModelGenerator.modelCollector);
      Identifier topModelId = Models.SLAB_TOP.upload(slabBlockTexture, slabTextureMapSide, blockStateModelGenerator.modelCollector);
      Identifier doubleModelId = Models.CUBE_COLUMN.uploadWithoutVariant(slabBlockTexture, "_double", slabTextureMapSide, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(slabBlockTexture, bottomModelId, topModelId, doubleModelId));
   }
   public void registerWall(Block wallBlockTexture, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap wallTextureMap = TextureMap.all(TextureMap.getId(wallBlockTexture));
      Identifier postModelId = Models.TEMPLATE_WALL_POST.upload(wallBlockTexture, wallTextureMap, blockStateModelGenerator.modelCollector);
      Identifier sideModelId = Models.TEMPLATE_WALL_SIDE.upload(wallBlockTexture, wallTextureMap, blockStateModelGenerator.modelCollector);
      Identifier sideTallModelId = Models.TEMPLATE_WALL_SIDE_TALL.upload(wallBlockTexture, wallTextureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(wallBlockTexture, postModelId, sideModelId, sideTallModelId));
      Identifier wallInventory = Models.WALL_INVENTORY.upload(wallBlockTexture, wallTextureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.registerParentedItemModel(wallBlockTexture, wallInventory);
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