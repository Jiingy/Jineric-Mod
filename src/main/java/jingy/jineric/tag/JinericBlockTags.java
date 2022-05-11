package jingy.jineric.tag;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JinericBlockTags {
   public static final TagKey<Block> JINERIC_WALLS = register("jineric:jineric_walls");
   public static final TagKey<Block> BOREAL_LOGS = register("jineric:boreal_logs");
   public static final TagKey<Block> FULL_GRASS_REPLACEABLE = register("jineric:full_grass_block_replaceable");
   public static final TagKey<Block> BOOKSHELVES = register("jineric:bookshelves");
   //public static final TagKey<Block> SLIPPERY_BLOCKS = register("jineric:slippery_blocks");
   //public static final TagKey<Block> JINERIC_CAMPFIRES = register("jineric:jineric_campfire");

   private static TagKey<Block> register(String id) {
      return TagKey.of(Registry.BLOCK_KEY, new Identifier(id));
   }

   private JinericBlockTags() {
   }
}
