package jingy.jineric.util;

import jingy.jineric.mixin.access.WoodTypeAccess;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;

public class JinericSignType {
   public static final WoodType BOREAL = WoodTypeAccess.jineric$registerNew(WoodTypeAccess.jineric$newSignType("boreal", BlockSetType.OAK));

}
