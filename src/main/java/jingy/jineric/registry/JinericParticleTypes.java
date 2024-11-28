package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class JinericParticleTypes {
   public static final SimpleParticleType RED_DANDELION_SEED = register("blossomed_dandelion_seed", false);

   private static SimpleParticleType register(String name, boolean alwaysShow) {
      return Registry.register(Registries.PARTICLE_TYPE, JinericMain.ofJineric(name), FabricParticleTypes.simple(alwaysShow));
   }

   public static void init() {
   }
}
