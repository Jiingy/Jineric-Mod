package jingy.jineric.block;

import jingy.jineric.base.JinericMain;
import net.minecraft.util.SignType;

import static jingy.jineric.mixin.access.SignTypeAccess.jineric$create;
import static jingy.jineric.mixin.access.SignTypeAccess.jineric$invokeRegister;

public class JinericSignType {
   public static final SignType BOREAL = register("boreal");

   private static SignType register(String id) {
      return JinericMain.SIGNS ? jineric$invokeRegister(jineric$create(JinericMain.createLocation(id).toString().replace(":", "/"))) : null;
   }
}
