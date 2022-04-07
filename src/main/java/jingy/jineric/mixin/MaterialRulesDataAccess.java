package jingy.jineric.mixin;

import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(VanillaSurfaceRules.class)
public interface MaterialRulesDataAccess {

   @Invoker("surfaceNoiseThreshold")
   static MaterialRules.MaterialCondition jineric$invokesurfaceNoiseThreshold(double d) {
      throw new Error("Mixin did not apply!");
   }
}
