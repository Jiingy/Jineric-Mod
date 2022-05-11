package jingy.jineric.client.render.blockentity;

import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import jingy.jineric.client.render.JinericTextureRenderLayers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.block.ChestAnimationProgress;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.LightmapCoordinatesRetriever;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;

import java.util.Calendar;

@Environment(EnvType.CLIENT)
public class GenericChestBlockEntityRenderer<T extends BlockEntity & ChestAnimationProgress> implements BlockEntityRenderer<T> {
   private static final String BASE = "bottom";
   private static final String LID = "lid";
   private static final String LATCH = "lock";
   private final ModelPart singleChestLid;
   private final ModelPart singleChestBase;
   private final ModelPart singleChestLatch;
   private final ModelPart doubleChestLeftLid;
   private final ModelPart doubleChestLeftBase;
   private final ModelPart doubleChestLeftLatch;
   private final ModelPart doubleChestRightLid;
   private final ModelPart doubleChestRightBase;
   private final ModelPart doubleChestRightLatch;
   private boolean christmas;

   public GenericChestBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
      Calendar calendar = Calendar.getInstance();
      if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
         this.christmas = true;
      }

      ModelPart modelPart = context.getLayerModelPart(EntityModelLayers.CHEST);
      this.singleChestBase = modelPart.getChild("bottom");
      this.singleChestLid = modelPart.getChild("lid");
      this.singleChestLatch = modelPart.getChild("lock");
      ModelPart modelPart2 = context.getLayerModelPart(EntityModelLayers.DOUBLE_CHEST_LEFT);
      this.doubleChestLeftBase = modelPart2.getChild("bottom");
      this.doubleChestLeftLid = modelPart2.getChild("lid");
      this.doubleChestLeftLatch = modelPart2.getChild("lock");
      ModelPart modelPart3 = context.getLayerModelPart(EntityModelLayers.DOUBLE_CHEST_RIGHT);
      this.doubleChestRightBase = modelPart3.getChild("bottom");
      this.doubleChestRightLid = modelPart3.getChild("lid");
      this.doubleChestRightLatch = modelPart3.getChild("lock");
   }

   public static TexturedModelData getSingleTexturedModelData() {
      ModelData modelData = new ModelData();
      ModelPartData modelPartData = modelData.getRoot();
      modelPartData.addChild("bottom", ModelPartBuilder.create().uv(0, 19).cuboid(1.0F, 0.0F, 1.0F, 14.0F, 10.0F, 14.0F), ModelTransform.NONE);
      modelPartData.addChild("lid", ModelPartBuilder.create().uv(0, 0).cuboid(1.0F, 0.0F, 0.0F, 14.0F, 5.0F, 14.0F), ModelTransform.pivot(0.0F, 9.0F, 1.0F));
      modelPartData.addChild("lock", ModelPartBuilder.create().uv(0, 0).cuboid(7.0F, -1.0F, 15.0F, 2.0F, 4.0F, 1.0F), ModelTransform.pivot(0.0F, 8.0F, 0.0F));
      return TexturedModelData.of(modelData, 64, 64);
   }

   public static TexturedModelData getRightDoubleTexturedModelData() {
      ModelData modelData = new ModelData();
      ModelPartData modelPartData = modelData.getRoot();
      modelPartData.addChild("bottom", ModelPartBuilder.create().uv(0, 19).cuboid(1.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F), ModelTransform.NONE);
      modelPartData.addChild("lid", ModelPartBuilder.create().uv(0, 0).cuboid(1.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F), ModelTransform.pivot(0.0F, 9.0F, 1.0F));
      modelPartData.addChild("lock", ModelPartBuilder.create().uv(0, 0).cuboid(15.0F, -1.0F, 15.0F, 1.0F, 4.0F, 1.0F), ModelTransform.pivot(0.0F, 8.0F, 0.0F));
      return TexturedModelData.of(modelData, 64, 64);
   }

   public static TexturedModelData getLeftDoubleTexturedModelData() {
      ModelData modelData = new ModelData();
      ModelPartData modelPartData = modelData.getRoot();
      modelPartData.addChild("bottom", ModelPartBuilder.create().uv(0, 19).cuboid(0.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F), ModelTransform.NONE);
      modelPartData.addChild("lid", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F), ModelTransform.pivot(0.0F, 9.0F, 1.0F));
      modelPartData.addChild("lock", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -1.0F, 15.0F, 1.0F, 4.0F, 1.0F), ModelTransform.pivot(0.0F, 8.0F, 0.0F));
      return TexturedModelData.of(modelData, 64, 64);
   }

   @Override
   public void render(T chestEntity, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int light, int overlay) {
      World world = chestEntity.getWorld();
      boolean bl = world != null;
      BlockState blockState = bl ? chestEntity.getCachedState() : Blocks.CHEST.getDefaultState().with(ChestBlock.FACING, Direction.SOUTH);
      ChestType chestType = blockState.contains(ChestBlock.CHEST_TYPE) ? blockState.get(ChestBlock.CHEST_TYPE) : ChestType.SINGLE;
      Block block = blockState.getBlock();

      if (block instanceof AbstractChestBlock<?> abstractChestBlock) {
         boolean isDoubleChest = chestType != ChestType.SINGLE;
         matrixStack.push();
         float f = ((Direction)blockState.get(ChestBlock.FACING)).asRotation();
         matrixStack.translate(0.5, 0.5, 0.5);
         matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(-f));
         matrixStack.translate(-0.5, -0.5, -0.5);
         DoubleBlockProperties.PropertySource<? extends ChestBlockEntity> propertySource;

         if (bl) {
            propertySource = abstractChestBlock.getBlockEntitySource(blockState, world, chestEntity.getPos(), true);
         } else {
            propertySource = DoubleBlockProperties.PropertyRetriever::getFallback;
         }

         float g = propertySource.<Float2FloatFunction>apply(ChestBlock.getAnimationProgressRetriever(chestEntity)).get(tickDelta);
         g = 1.0F - g;
         g = 1.0F - g * g * g;
         int i = propertySource.<Int2IntFunction>apply(new LightmapCoordinatesRetriever<>()).applyAsInt(light);

         SpriteIdentifier sprite = JinericTextureRenderLayers.getChestTexture(chestEntity, chestType, this.christmas);
         VertexConsumer vertexConsumer = sprite.getVertexConsumer(vertexConsumers, RenderLayer::getEntityCutout);
         if (isDoubleChest) {
            if (chestType == ChestType.RIGHT) {
               this.render(matrixStack, vertexConsumer, this.doubleChestRightLid, this.doubleChestRightLatch, this.doubleChestRightBase, g, i, overlay);
            } else {
               this.render(matrixStack, vertexConsumer, this.doubleChestLeftLid, this.doubleChestLeftLatch, this.doubleChestLeftBase, g, i, overlay);
            }
         } else {
            this.render(matrixStack, vertexConsumer, this.singleChestLid, this.singleChestLatch, this.singleChestBase, g, i, overlay);
         }

         matrixStack.pop();
      }
   }

//   public final SpriteIdentifier getTextureFinal(T type, ChestType chestType) {
//      if(christmas)
//         return TexturedRenderLayers.getChestTexture(type, chestType, true);
//      return getTexture(type, chestType);
//   }
//
//   public SpriteIdentifier getTexture(T blockEntity, ChestType chestType) {
//      if (blockEntity instanceof ShulkerChestBlockEntity) {
//         return JinericTextureRenderLayers.SHULKER;
//      } else {
//         return blockEntity instanceof JinericChestBlockEntity
//                 ? getChestTexture(chestType,
//                 JinericTextureRenderLayers.BOREAL_CHEST,
//                 JinericTextureRenderLayers.BOREAL_CHEST_LEFT,
//                 JinericTextureRenderLayers.BOREAL_CHEST_RIGHT)
//
//                 : getChestTexture(chestType,
//                 JinericTextureRenderLayers.SPRUCE_CHEST,
//                 JinericTextureRenderLayers.SPRUCE_CHEST_LEFT,
//                 JinericTextureRenderLayers.SPRUCE_CHEST_RIGHT);
//      }
//   }

   private void render(MatrixStack matrices, VertexConsumer vertices, ModelPart lid, ModelPart latch, ModelPart base, float openFactor, int light, int overlay) {
      lid.pitch = -(openFactor * (float) (Math.PI / 2));
      latch.pitch = lid.pitch;
      lid.render(matrices, vertices, light, overlay);
      latch.render(matrices, vertices, light, overlay);
      base.render(matrices, vertices, light, overlay);
   }
}
