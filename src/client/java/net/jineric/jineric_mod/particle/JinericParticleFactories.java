package net.jineric.jineric_mod.particle;

import net.jineric.jineric_mod.mixin.client.access.LeavesParticleAccess;
import jingy.jineric.registry.JinericParticleTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class JinericParticleFactories {
	public static void initialize() {
		ParticleFactoryRegistry.getInstance().register(JinericParticleTypes.BLOSSOMED_DANDELION_SEED, FlowerSeedParticle.Factory::new);
		// Saved for next MC release where this functionality was added for other leaves.
//		ParticleFactoryRegistry.getInstance().register(JinericParticleTypes.PETRIFIED_OAK_LEAVES, JinericParticleFactories.PetrifiedOakLeavesFactory::new);
	}
	
	@Environment(EnvType.CLIENT)
	public static class PetrifiedOakLeavesFactory implements ParticleFactory<SimpleParticleType> {
		private final SpriteProvider spriteProvider;
		
		public PetrifiedOakLeavesFactory(SpriteProvider spriteProvider) {
			this.spriteProvider = spriteProvider;
		}
		
		@Override
		public @Nullable Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, Random random) {
			return LeavesParticleAccess.invokeInit(world, x, y, z, this.spriteProvider.getSprite(random), 0.25F, 2.0F, false, true, 1.0F, 0.0F);
		}
	}
}
