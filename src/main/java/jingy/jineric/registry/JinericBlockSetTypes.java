package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.block.BlockSetType;

public class JinericBlockSetTypes {
   public static final BlockSetType PETRIFIED_OAK = register("petrified_oak", BlockSetTypeBuilder.copyOf(BlockSetType.OAK));

   private static BlockSetType register(String id, BlockSetTypeBuilder blockSetTypeBuilder) {
      return blockSetTypeBuilder.build(JinericMain.jinericId(id));
   }
}
