package jingy.jineric.tag;

import jingy.jineric.base.JinericMain;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;

public class JinericBlockTags {
   public static final TagKey<Block> SPECIALTY_WALLS = registerBlockTag("specialty_walls");
   public static final TagKey<Block> IS_SLIPPERY = registerBlockTag("is_slippery");
   public static final TagKey<Block> FULL_GRASS_REPLACEABLE = registerBlockTag("full_grass_block_replaceable");
   public static final TagKey<Block> PETRIFIED_OAK_LOGS = registerBlockTag("petrified_oak_logs");
   public static final TagKey<Block> WOODEN_BOOKSHELVES = registerBlockTag("wooden_bookshelves");
   public static final TagKey<Block> CHESTS = registerBlockTag("chests");
   public static final TagKey<Block> WOODEN_CHESTS = registerBlockTag("wooden_chests");
   public static final TagKey<Block> WOODEN_TRAPPED_CHESTS = registerBlockTag("wooden_trapped_chests");
   public static final TagKey<Block> WOODEN_LADDERS = registerBlockTag("wooden_ladders");
   public static final TagKey<Block> FULL_GRASSY_BLOCKS = registerBlockTag("full_grassy_blocks");

   private static TagKey<Block> registerBlockTag(String id) {
      return TagKey.of(Registries.BLOCK.getKey(), JinericMain.jinericId(id));
   }

   private JinericBlockTags() {
   }
}
