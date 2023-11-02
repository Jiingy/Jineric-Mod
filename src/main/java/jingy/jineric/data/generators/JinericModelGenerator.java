package jingy.jineric.data.generators;

import jingy.jineric.block.JinericBlocks;
import jingy.jineric.registry.JinericWoodType;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.WoodType;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

//TODO: Move builder methods to it's own class
public class JinericModelGenerator extends FabricModelProvider {
   public JinericModelGenerator(FabricDataOutput output) {
      super(output);
   }

   @Override
   public void generateBlockStateModels(BlockStateModelGenerator blockModelGenerator) {
      registerSimpleBlockSet(JinericBlocks.SNOW_BRICKS, JinericBlocks.SNOW_BRICK_STAIRS, JinericBlocks.SNOW_BRICK_SLAB, JinericBlocks.SNOW_BRICK_WALL, blockModelGenerator);
      registerSimpleBlockSet(JinericBlocks.CRACKED_DRIPSTONE_TILES, JinericBlocks.CRACKED_DRIPSTONE_TILE_STAIRS, JinericBlocks.CRACKED_DRIPSTONE_TILE_SLAB, JinericBlocks.CRACKED_DRIPSTONE_TILE_WALL, blockModelGenerator);
      registerSimpleBlockSet(JinericBlocks.CRACKED_DRIPSTONE_BRICKS, JinericBlocks.CRACKED_DRIPSTONE_BRICK_STAIRS, JinericBlocks.CRACKED_DRIPSTONE_BRICK_SLAB, JinericBlocks.CRACKED_DRIPSTONE_BRICK_WALL, blockModelGenerator);
      registerSimpleBlockSet(JinericBlocks.CRACKED_TUFF_TILES, JinericBlocks.CRACKED_TUFF_TILE_STAIRS, JinericBlocks.CRACKED_TUFF_TILE_SLAB, JinericBlocks.CRACKED_TUFF_TILE_WALL, blockModelGenerator);
      registerSimpleBlockSet(JinericBlocks.CRACKED_STONE_TILES, JinericBlocks.CRACKED_STONE_TILE_STAIRS, JinericBlocks.CRACKED_STONE_TILE_SLAB, JinericBlocks.CRACKED_STONE_TILE_WALL, blockModelGenerator);
      registerWoodSet(JinericWoodType.VERTRAUT, blockModelGenerator);
   }

   @Override
   public void generateItemModels(ItemModelGenerator itemModelGenerator) {
      //NOTE: DOES NOT NEED TO BE USED FOR ITEMS FOR BLOCKS
   }

   public void registerSimpleBlockSet(Block blockTexture, Block stairBlock, Block slabBlock, Block wallBlock, BlockStateModelGenerator blockStateModelGenerator) {
      blockStateModelGenerator.registerSimpleCubeAll(blockTexture);
      registerStairs(stairBlock, blockTexture, blockStateModelGenerator);
      registerSlab(slabBlock, blockTexture, blockStateModelGenerator);
      registerWall(wallBlock, blockTexture, blockStateModelGenerator);
   }

   public void registerWoodSet(WoodType woodTypeIn, BlockStateModelGenerator blockModelGenerator) {
      String woodType = woodTypeIn.name();
//      blockModelGenerator.registerLog(byId(woodType + "_log")).log(byId(woodType + "_log")).wood(byId(woodType + "_wood"));
//      blockModelGenerator.registerLog(byId("stripped_" + woodType + "_log")).log(byId("stripped_" + woodType + "_log")).wood(byId("stripped_" + woodType + "_wood"));
      blockModelGenerator.registerSimpleCubeAll(byId(woodType + "_planks"));
      registerStairs(JinericBlocks.VERTRAUT_STAIRS, JinericBlocks.VERTRAUT_PLANKS, blockModelGenerator);
      registerSlab(JinericBlocks.VERTRAUT_SLAB, JinericBlocks.VERTRAUT_PLANKS, blockModelGenerator);
      registerFence(JinericBlocks.VERTRAUT_FENCE, JinericBlocks.VERTRAUT_PLANKS, blockModelGenerator);

      blockModelGenerator.registerDoor(byId(woodType + "_door"));
      blockModelGenerator.registerTrapdoor(byId(woodType + "_trapdoor"));
//      registerPressurePlate(byId(woodType + "_pressure_plate"), blockModelGenerator);
//      registerButton(byId(woodType + "_button"), woodTypeIn, blockModelGenerator);
      blockModelGenerator.registerSimpleCubeAll(byId(woodType + "_leaves"));
   }

   public static Block byId(String id) {
      Identifier blockId = Identifier.tryParse(id);
      return (Block)Registries.BLOCK.get(blockId);
   }

   //TODO: Remove redundancies of having to use 'Block' so often
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

   public void registerFence(Block fenceBlock, Block fenceBlockTexture, BlockStateModelGenerator blockStateModelGenerator) {
      TextureMap textureMap = TextureMap.all(TextureMap.getId(fenceBlockTexture));
      Identifier postModelId = Models.FENCE_POST.upload(fenceBlock, textureMap, blockStateModelGenerator.modelCollector);
      Identifier sideModelId = Models.FENCE_SIDE.upload(fenceBlock, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createFenceBlockState(fenceBlock, postModelId, sideModelId));
      Identifier fenceInventory = Models.FENCE_INVENTORY.upload(fenceBlock, textureMap, blockStateModelGenerator.modelCollector);
      blockStateModelGenerator.registerParentedItemModel(fenceBlock, fenceInventory);
   }



//   public void registerPressurePlate(Block blockIn, BlockStateModelGenerator blockModelGenerator) {
//      TextureMap textureMap = TextureMap.all(TextureMap.getId(blockIn));
//      Identifier upModelId = Models.PRESSURE_PLATE_UP.upload(blockIn, textureMap, blockModelGenerator.modelCollector);
//      Identifier downModelId = Models.PRESSURE_PLATE_DOWN.upload(blockIn, textureMap, blockModelGenerator.modelCollector);
//      blockModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createPressurePlateBlockState(blockIn, upModelId, downModelId));
//   }

//   public void registerButton(Block block, WoodType woodType, BlockStateModelGenerator blockModelGenerator) {
//      TextureMap pressurePlateTextureMap = TextureMap.all(TextureMap.getId(byId(woodType + "_planks")));
//      Identifier buttonId = Models.BUTTON.upload(block, pressurePlateTextureMap, blockModelGenerator.modelCollector);
//      Identifier pressedButtonId = Models.BUTTON_PRESSED.upload(block, pressurePlateTextureMap, blockModelGenerator.modelCollector);
//      blockModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createButtonBlockState(block, buttonId, pressedButtonId));
//      Identifier buttonInventory = Models.BUTTON_INVENTORY.upload(block, pressurePlateTextureMap, blockModelGenerator.modelCollector);
//      blockModelGenerator.registerParentedItemModel(block, buttonInventory);
//   }
}