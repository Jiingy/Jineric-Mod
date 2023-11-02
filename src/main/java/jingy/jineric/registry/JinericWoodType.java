package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;

public class JinericWoodType {
   public static final WoodType VERTRAUT = register("vertraut", WoodTypeBuilder.copyOf(WoodType.OAK), JinericBlockSetTypes.VERTRAUT);

   public static WoodType register(String id, WoodTypeBuilder woodTypeBuilder, BlockSetType blockSetType) {
      return woodTypeBuilder.build(JinericMain.jinericId(id), blockSetType);
   }
}
