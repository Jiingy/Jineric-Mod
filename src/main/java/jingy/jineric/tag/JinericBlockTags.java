package jingy.jineric.tag;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JinericBlockTags {
   public static final TagKey<Block> JINERIC_WALLS = register("jineric_walls");

   private JinericBlockTags() {
   }

   private static TagKey<Block> register(String id) {
      return TagKey.of(Registry.BLOCK_KEY, new Identifier(id));
   }
}
