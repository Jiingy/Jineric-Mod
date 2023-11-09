package jingy.jineric.data.generators;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.data.family.JinericBlockFamilies;
import jingy.jineric.item.JinericItems;
import jingy.jineric.registry.JinericWoodType;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.WoodType;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

//TODO: Move builder methods to it's own class
public class JinericModelGenerator extends FabricModelProvider {

   public JinericModelGenerator(FabricDataOutput output) {
      super(output);
   }

   @Override
   public void generateBlockStateModels(BlockStateModelGenerator generator) {
      registerSimpleBlockSet(JinericBlocks.SNOW_BRICKS, JinericBlocks.SNOW_BRICK_STAIRS, JinericBlocks.SNOW_BRICK_SLAB, JinericBlocks.SNOW_BRICK_WALL, generator);
      registerSimpleBlockSet(JinericBlocks.CRACKED_DRIPSTONE_TILES, JinericBlocks.CRACKED_DRIPSTONE_TILE_STAIRS, JinericBlocks.CRACKED_DRIPSTONE_TILE_SLAB, JinericBlocks.CRACKED_DRIPSTONE_TILE_WALL, generator);
      registerSimpleBlockSet(JinericBlocks.CRACKED_DRIPSTONE_BRICKS, JinericBlocks.CRACKED_DRIPSTONE_BRICK_STAIRS, JinericBlocks.CRACKED_DRIPSTONE_BRICK_SLAB, JinericBlocks.CRACKED_DRIPSTONE_BRICK_WALL, generator);
      registerSimpleBlockSet(JinericBlocks.CRACKED_TUFF_TILES, JinericBlocks.CRACKED_TUFF_TILE_STAIRS, JinericBlocks.CRACKED_TUFF_TILE_SLAB, JinericBlocks.CRACKED_TUFF_TILE_WALL, generator);
      registerSimpleBlockSet(JinericBlocks.CRACKED_STONE_TILES, JinericBlocks.CRACKED_STONE_TILE_STAIRS, JinericBlocks.CRACKED_STONE_TILE_SLAB, JinericBlocks.CRACKED_STONE_TILE_WALL, generator);
      registerWoodSet(JinericWoodType.PETRIFIED_OAK, generator);

      JinericBlockFamilies.getFamilies().filter(BlockFamily::shouldGenerateModels).forEach((family) -> {
         generator.registerCubeAllModelTexturePool(family.getBaseBlock()).family(family);
      });
   }

   @Override
   public void generateItemModels(ItemModelGenerator generator) {
      generator.register(JinericItems.PETRIFIED_OAK_BOAT, Models.GENERATED);
      generator.register(JinericItems.PETRIFIED_OAK_CHEST_BOAT, Models.GENERATED);
   }

   public void registerSimpleBlockSet(Block blockTexture, Block stairBlock, Block slabBlock, Block wallBlock, BlockStateModelGenerator blockStateModelGenerator) {
      blockStateModelGenerator.registerSimpleCubeAll(blockTexture);
      registerStairs(stairBlock, blockTexture, blockStateModelGenerator);
      registerSlab(slabBlock, blockTexture, blockStateModelGenerator);
      registerWall(wallBlock, blockTexture, blockStateModelGenerator);
   }

   public void registerWoodSet(WoodType woodTypeIn, BlockStateModelGenerator generator) {
      String stripped = "stripped_";
      String woodType = woodTypeIn.name().replace("jineric:", "");
      generator.registerLog(byId(woodType + "_log")).log(byId(woodType + "_log")).wood(byId(woodType + "_wood"));
      generator.registerLog(byId(stripped + woodType + "_log")).log(byId(stripped + woodType + "_log")).wood(byId(stripped + woodType + "_wood"));
      generator.registerSingleton(byId(woodType + "_leaves"), TexturedModel.LEAVES);
      generator.registerFlowerPotPlant(JinericBlocks.PETRIFIED_OAK_SAPLING, JinericBlocks.POTTED_PETRIFIED_OAK_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
      generator.registerNorthDefaultHorizontalRotation(byId(woodType + "_ladder"));
      generator.registerItemModel(byId(woodType + "_ladder"));
      this.registerBookshelf(byId(woodType + "_bookshelf"), byId(woodType + "_planks"), generator);
      generator.registerHangingSign(JinericBlocks.STRIPPED_PETRIFIED_OAK_LOG, JinericBlocks.PETRIFIED_OAK_HANGING_SIGN, JinericBlocks.PETRIFIED_OAK_WALL_HANGING_SIGN);
   }

   static Block byId(String id) {
      final Identifier identifier = new Identifier(JinericMain.MOD_ID, id);
      if (!Registries.BLOCK.containsId(identifier)) {
         throw new IllegalStateException("Block is not registered: " + identifier);
      }
      return Registries.BLOCK.get(identifier);
   }

   public void registerStairs(Block stairsBlock, Block stairsBlockTexture, BlockStateModelGenerator generator) {
      TextureMap stairTextureMap = TextureMap.all(TextureMap.getId(stairsBlockTexture));
      Identifier regularModelId = Models.STAIRS.upload(stairsBlock, stairTextureMap, generator.modelCollector);
      Identifier innerModelId = Models.INNER_STAIRS.upload(stairsBlock, stairTextureMap, generator.modelCollector);
      Identifier outerModelId = Models.OUTER_STAIRS.upload(stairsBlock, stairTextureMap, generator.modelCollector);
      generator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(stairsBlock, innerModelId, regularModelId, outerModelId));
   }
   public void registerSlab(Block blockIn, Block slabTexture, BlockStateModelGenerator generator) {
      TextureMap slabTextureMap = TextureMap.all(TextureMap.getId(slabTexture));
      TextureMap slabTextureMapSide = TextureMap.sideEnd(slabTextureMap.getTexture(TextureKey.SIDE), slabTextureMap.getTexture(TextureKey.TOP));
      Identifier bottomModelId = Models.SLAB.upload(blockIn, slabTextureMapSide, generator.modelCollector);
      Identifier topModelId = Models.SLAB_TOP.upload(blockIn, slabTextureMapSide, generator.modelCollector);
      Identifier doubleModelId = Models.CUBE_COLUMN.uploadWithoutVariant(blockIn, "_double", slabTextureMapSide, generator.modelCollector);
      generator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(blockIn, bottomModelId, topModelId, doubleModelId));
   }
   public void registerWall( Block blockIn, Block wallTexture, BlockStateModelGenerator generator) {
      TextureMap wallTextureMap = TextureMap.all(TextureMap.getId(wallTexture));
      Identifier postModelId = Models.TEMPLATE_WALL_POST.upload(blockIn, wallTextureMap, generator.modelCollector);
      Identifier sideModelId = Models.TEMPLATE_WALL_SIDE.upload(blockIn, wallTextureMap, generator.modelCollector);
      Identifier sideTallModelId = Models.TEMPLATE_WALL_SIDE_TALL.upload(blockIn, wallTextureMap, generator.modelCollector);
      generator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(blockIn, postModelId, sideModelId, sideTallModelId));
      Identifier wallInventory = Models.WALL_INVENTORY.upload(blockIn, wallTextureMap, generator.modelCollector);
      generator.registerParentedItemModel(blockIn, wallInventory);
   }

   public void registerFence(Block blockIn, Block fenceTexture, BlockStateModelGenerator generator) {
      TextureMap textureMap = TextureMap.all(TextureMap.getId(fenceTexture));
      Identifier postModelId = Models.FENCE_POST.upload(blockIn, textureMap, generator.modelCollector);
      Identifier sideModelId = Models.FENCE_SIDE.upload(blockIn, textureMap, generator.modelCollector);
      generator.blockStateCollector.accept(BlockStateModelGenerator.createFenceBlockState(blockIn, postModelId, sideModelId));
      Identifier fenceInventory = Models.FENCE_INVENTORY.upload(blockIn, textureMap, generator.modelCollector);
      generator.registerParentedItemModel(blockIn, fenceInventory);
   }

   public void registerFenceGate(Block fenceGateBlock, Block fenceGateTexture, BlockStateModelGenerator generator) {
      TextureMap textureMap = TextureMap.all(TextureMap.getId(fenceGateTexture));
      Identifier identifier = Models.TEMPLATE_FENCE_GATE_OPEN.upload(fenceGateBlock, textureMap, generator.modelCollector);
      Identifier identifier2 = Models.TEMPLATE_FENCE_GATE.upload(fenceGateBlock, textureMap, generator.modelCollector);
      Identifier identifier3 = Models.TEMPLATE_FENCE_GATE_WALL_OPEN.upload(fenceGateBlock, textureMap, generator.modelCollector);
      Identifier identifier4 = Models.TEMPLATE_FENCE_GATE_WALL.upload(fenceGateBlock, textureMap, generator.modelCollector);
      generator.blockStateCollector.accept(BlockStateModelGenerator.createFenceGateBlockState(fenceGateBlock, identifier, identifier2, identifier3, identifier4, true));
   }

   public void registerPressurePlate(Block blockIn, Block pressurePlateTexture, BlockStateModelGenerator generator) {
      TextureMap textureMap = TextureMap.all(TextureMap.getId(pressurePlateTexture));
      Identifier upModelId = Models.PRESSURE_PLATE_UP.upload(blockIn, textureMap, generator.modelCollector);
      Identifier downModelId = Models.PRESSURE_PLATE_DOWN.upload(blockIn, textureMap, generator.modelCollector);
      generator.blockStateCollector.accept(BlockStateModelGenerator.createPressurePlateBlockState(blockIn, upModelId, downModelId));
   }

   public void registerButton(Block blockIn, Block buttonTexture, BlockStateModelGenerator generator) {
      TextureMap pressurePlateTextureMap = TextureMap.all(TextureMap.getId(buttonTexture));
      Identifier buttonId = Models.BUTTON.upload(blockIn, pressurePlateTextureMap, generator.modelCollector);
      Identifier pressedButtonId = Models.BUTTON_PRESSED.upload(blockIn, pressurePlateTextureMap, generator.modelCollector);
      generator.blockStateCollector.accept(BlockStateModelGenerator.createButtonBlockState(blockIn, buttonId, pressedButtonId));
      Identifier buttonInventory = Models.BUTTON_INVENTORY.upload(blockIn, pressurePlateTextureMap, generator.modelCollector);
      generator.registerParentedItemModel(blockIn, buttonInventory);
   }

   private void registerBookshelf(Block blockIn, Block bookshelfTexture, BlockStateModelGenerator generator) {
      TextureMap textureMap = TextureMap.sideEnd(TextureMap.getId(blockIn), TextureMap.getId(bookshelfTexture));
      Identifier identifier = Models.CUBE_COLUMN.upload(blockIn, textureMap, generator.modelCollector);
      generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(blockIn, identifier));
   }
}