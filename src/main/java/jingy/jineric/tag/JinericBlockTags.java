package jingy.jineric.tag;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class JinericBlockTags {
   public static final TagKey<Block> JINERIC_WALLS = register("jineric:jineric_walls");
   public static final TagKey<Block> FULL_GRASS_REPLACEABLE = register("jineric:full_grass_block_replaceable");
   public static final TagKey<Block> BOOKSHELVES = register("jineric:bookshelves");

   private static TagKey<Block> register(String id) {
      return TagKey.of(Registries.BLOCK.getKey(), new Identifier(id));
   }

   private JinericBlockTags() {
   }
}
