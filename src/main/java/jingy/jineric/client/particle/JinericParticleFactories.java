package jingy.jineric.client.particle;

import jingy.jineric.registry.JinericParticleTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

@Environment(EnvType.CLIENT)
public class JinericParticleFactories {
	public static void initialize() {
		ParticleFactoryRegistry.getInstance().register(JinericParticleTypes.BLOSSOMED_DANDELION_SEED, FlowerSeedParticle.Factory::new);
	}
}
