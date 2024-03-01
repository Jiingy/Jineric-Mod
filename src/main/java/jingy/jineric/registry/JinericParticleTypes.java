package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class JinericParticleTypes {
   public static final DefaultParticleType RED_DANDELION_SEED = register("blossomed_dandelion_seed", false);

   private static DefaultParticleType register(String name, boolean alwaysShow) {
      return Registry.register(Registries.PARTICLE_TYPE, JinericMain.jinericId(name), FabricParticleTypes.simple(alwaysShow));
   }

   public static void init() {
   }
}
