package jingy.jineric.mixin.access;

import net.minecraft.util.SignType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SignType.class)
public interface SignTypeAccess {

   @Invoker("<init>")
   static SignType jineric$newSignType(String name) {
      throw new Error("Mixin did not apply!");
   }

   @Invoker("register")
   static SignType jineric$registerNew(SignType signType) {
      throw new Error("Mixin did not apply!");
   }
}
