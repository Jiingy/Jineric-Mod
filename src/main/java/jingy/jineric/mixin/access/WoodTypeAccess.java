package jingy.jineric.mixin.access;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(WoodType.class)
public interface WoodTypeAccess {

   //TODO: ADD SPECIFIC FAIL MESSAGE FOR THROWN ERRORS
   @Invoker("<init>")
   static WoodType jineric$newSignType(String name, BlockSetType blockSetType) {
      throw new Error("Mixin did not apply!");
   }

   @Invoker("register")
   static WoodType jineric$registerNew(WoodType signType) {
      throw new Error("Mixin did not apply!");
   }
}
