package jingy.jineric.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.SmokerBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SmokerBlock.class)
public abstract class SmokerBlockMixin {

   private static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

   @Inject(at = @At("TAIL"), method = "randomDisplayTick", cancellable = true)
   public void jineric$randomDisplayTick(BlockState state, World world, BlockPos pos, Random random, CallbackInfo ci) {
         Direction direction = state.get(FACING);
         Direction.Axis axis = direction.getAxis();
         double d = (double)pos.getX() + 0.5;
         double e = (double)pos.getY();
         double f = (double)pos.getZ() + 0.5;
         double h = random.nextDouble() * 0.6 - 0.3;
         double i = axis == Direction.Axis.X ? (double)direction.getOffsetX() * 0.52 : h;
         double j = random.nextDouble() * 6.0 / 16.0;
         double k = axis == Direction.Axis.Z ? (double)direction.getOffsetZ() * 0.52 : h;
         world.addParticle(ParticleTypes.FLAME, d + i, e + j, f + k, 0.0, 0.0, 0.0);
      ci.cancel();
   }
}
