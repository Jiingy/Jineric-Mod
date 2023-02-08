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

   public void registerStairs(Block stairBlock, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap stairTextureMap = TextureMap.all(TextureMap.getId(stairBlock));
      Identifier regularModelId = Models.STAIRS.upload(stairBlock, stairTextureMap, blockStateModelGenerator.modelCollector);
      Identifier innerModelId = Models.INNER_STAIRS.upload(stairBlock, stairTextureMap, blockStateModelGenerator.modelCollector);
      Identifier outerModelId = Models.OUTER_STAIRS.upload(stairBlock, stairTextureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(stairBlock, innerModelId, regularModelId, outerModelId));
   }
   public void registerSlab(Block slabBlock, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap slabTextureMap = TextureMap.all(TextureMap.getId(slabBlock));
      TextureMap slabTextureMapSide = TextureMap.sideEnd(TextureMap.getSubId(slabBlock, "_side"), slabTextureMap.getTexture(TextureKey.TOP));

      Identifier bottomModelId = Models.SLAB.upload(slabBlock, slabTextureMapSide, blockStateModelGenerator.modelCollector);
      Identifier topModelId = Models.SLAB_TOP.upload(slabBlock, slabTextureMapSide, blockStateModelGenerator.modelCollector);
      Identifier doubleModelId = Models.CUBE_COLUMN.uploadWithoutVariant(slabBlock, "_double", slabTextureMapSide, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(slabBlock, bottomModelId, topModelId, doubleModelId));
//         blockStateModelGenerator.registerParentedItemModel(slabBlock, );
   }
   public void registerWall(Block wallBlock, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap wallTextureMap = TextureMap.all(TextureMap.getId(wallBlock));
      Identifier postModelId = Models.TEMPLATE_WALL_POST.upload(wallBlock, wallTextureMap, blockStateModelGenerator.modelCollector);
      Identifier sideModelId = Models.TEMPLATE_WALL_SIDE.upload(wallBlock, wallTextureMap, blockStateModelGenerator.modelCollector);
      Identifier sideTallModelId = Models.TEMPLATE_WALL_SIDE_TALL.upload(wallBlock, wallTextureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(wallBlock, postModelId, sideModelId, sideTallModelId));
      Identifier wallInventory = Models.WALL_INVENTORY.upload(wallBlock, wallTextureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.registerParentedItemModel(wallBlock, wallInventory);
   }
}