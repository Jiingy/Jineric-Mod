package jingy.jineric.client.particle;

import jingy.jineric.mixin.access.LeavesParticleAccess;
import jingy.jineric.registry.JinericParticleTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

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
		
		public Particle createParticle(SimpleParticleType simpleParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
			return LeavesParticleAccess.invokeInit(clientWorld, d, e, f, this.spriteProvider, 0.25F, 2.0F, false, true, 1.0F, 0.0F);
		}
	}
}
