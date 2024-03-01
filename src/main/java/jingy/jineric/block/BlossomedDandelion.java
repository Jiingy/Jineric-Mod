package jingy.jineric.block;

import jingy.jineric.registry.JinericParticleTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class BlossomedDandelion extends FlowerBlock {

   public BlossomedDandelion(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
      super(suspiciousStewEffect, effectDuration, settings);
   }

   @Override
   public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
      VoxelShape voxelShape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
      Vec3d vec3d = voxelShape.getBoundingBox().getCenter();

      if (random.nextInt(12) == 0) {
         double d = (double)pos.getX() + vec3d.x;
         double e = (double)pos.getZ() + vec3d.z;

         world.addParticle(
                 JinericParticleTypes.RED_DANDELION_SEED, d + random.nextDouble() / 5.0, (double)pos.getY() + (0.5 - random.nextDouble()), e + random.nextDouble() / 5.0, 0.0, 0.0, 0.0
//                 ParticleTypes.HEART, pos.getX() + 0.3, pos.getY() + 0.3, pos.getZ() + 0.3, random.nextInt(), random.nextInt(), random.nextInt()
         );
      }
   }
}
