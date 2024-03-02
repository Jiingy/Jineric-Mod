package jingy.jineric.block;

import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.Items;

public class JinericCauldronBehaviors {
   public static void registerCauldronBehaviors() {
      CauldronBehavior.WATER_CAULDRON_BEHAVIOR.map().put(Items.BUNDLE, CauldronBehavior.CLEAN_DYEABLE_ITEM);
   }
}
