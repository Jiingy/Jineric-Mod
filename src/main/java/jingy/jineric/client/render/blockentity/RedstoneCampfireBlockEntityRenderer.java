package jingy.jineric.client.render.blockentity;

import jingy.jineric.block.custom.RedstoneCampfireBlock;
import jingy.jineric.block.entity.custom.RedstoneCampfireBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class RedstoneCampfireBlockEntityRenderer implements BlockEntityRenderer<RedstoneCampfireBlockEntity> {
   private static final float SCALE = 0.375F;

   public RedstoneCampfireBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
   }

   public void render(RedstoneCampfireBlockEntity redstoneCampfireBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
      Direction direction = redstoneCampfireBlockEntity.getCachedState().get(RedstoneCampfireBlock.FACING);
      DefaultedList<ItemStack> defaultedList = redstoneCampfireBlockEntity.getItemsBeingCooked();
      int k = (int) redstoneCampfireBlockEntity.getPos().asLong();

      for(int l = 0; l < defaultedList.size(); ++l) {
         ItemStack itemStack = defaultedList.get(l);
         if (itemStack != ItemStack.EMPTY) {
            matrixStack.push();
            matrixStack.translate(0.5, 0.44921875, 0.5);
            Direction direction2 = Direction.fromHorizontal((l + direction.getHorizontal()) % 4);
            float g = -direction2.asRotation();
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(g));
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
            matrixStack.translate(-0.3125, -0.3125, 0.0);
            matrixStack.scale(0.375F, 0.375F, 0.375F);
            MinecraftClient.getInstance().getItemRenderer().renderItem(itemStack, ModelTransformation.Mode.FIXED, i, j, matrixStack, vertexConsumerProvider, k + l);
            matrixStack.pop();
         }
      }

   }
}
