package jingy.jineric.tag;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class JinericBlockTags {
   public static final TagKey<Block> SPECIALTY_WALLS = register("jineric:specialty_walls");
   public static final TagKey<Block> FULL_GRASS_REPLACEABLE = register("jineric:full_grass_block_replaceable");
   public static final TagKey<Block> WOODEN_BOOKSHELVES = register("jineric:wooden_bookshelves");
   public static final TagKey<Block> FULL_GRASSY_BLOCKS = register("jineric:full_grassy_blocks");

   private static TagKey<Block> register(String id) {
      return TagKey.of(Registries.BLOCK.getKey(), new Identifier(id));
   }

   private JinericBlockTags() {
   }
}
