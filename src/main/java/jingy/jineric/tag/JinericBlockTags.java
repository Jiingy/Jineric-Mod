package jingy.jineric.tag;

import jingy.jineric.base.JinericMain;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class JinericBlockTags {
   public static final TagKey<Block> SPECIALTY_WALLS = register("specialty_walls");
   public static final TagKey<Block> IS_SLIPPERY = register("is_slippery");
   public static final TagKey<Block> FULL_GRASS_REPLACEABLE = register("full_grass_block_replaceable");
   public static final TagKey<Block> WOODEN_BOOKSHELVES = register("wooden_bookshelves");
   public static final TagKey<Block> CHESTS = register("chests");
   public static final TagKey<Block> WOODEN_CHESTS = register("wooden_chests");
   public static final TagKey<Block> WOODEN_LADDERS = register("wooden_ladders");
   public static final TagKey<Block> FULL_GRASSY_BLOCKS = register("full_grassy_blocks");

   private static TagKey<Block> register(String id) {
      return TagKey.of(Registries.BLOCK.getKey(), new Identifier(JinericMain.MOD_ID, id));
   }

   private JinericBlockTags() {
   }
}
