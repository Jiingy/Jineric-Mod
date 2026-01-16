package jingy.jineric.mixin.change;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.SmokerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SmokerBlock.class)
public abstract class SmokerBlockEmitParticlesMixin extends AbstractFurnaceBlock {
	protected SmokerBlockEmitParticlesMixin(Properties settings) {
		super(settings);
	}
	
	@Inject(
			at = @At("TAIL"),
			method = "animateTick",
			cancellable = true
	)
	public void jineric$randomDisplayTick(BlockState state, Level world, BlockPos pos, RandomSource random, CallbackInfo ci) {
		Direction direction = state.getValue(FACING);
		Direction.Axis axis = direction.getAxis();
		double d = (double) pos.getX() + 0.5;
		double e = (double) pos.getY();
		double f = (double) pos.getZ() + 0.5;
		double h = random.nextDouble() * 0.6 - 0.3;
		double i = axis == Direction.Axis.X ? (double) direction.getStepX() * 0.52 : h;
		double j = random.nextDouble() * 6.0 / 16.0;
		double k = axis == Direction.Axis.Z ? (double) direction.getStepZ() * 0.52 : h;
		world.addParticle(ParticleTypes.FLAME, d + i, e + j, f + k, 0.0, 0.0, 0.0);
		ci.cancel();
	}
}
