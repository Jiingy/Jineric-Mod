package jingy.jineric.tag;

import jingy.jineric.base.JinericMain;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;

public class JinericItemTags {
   public static final TagKey<Item> CHESTS = registerItemTag("chests");
   public static final TagKey<Item> WOODEN_BOOKSHELVES = registerItemTag("wooden_bookshelves");
   public static final TagKey<Item> WOODEN_CHESTS = registerItemTag("wooden_chests");
   public static final TagKey<Item> WOODEN_LADDERS = registerItemTag("wooden_ladders");
   public static final TagKey<Item> WOODEN_TRAPPED_CHESTS = registerItemTag("wooden_trapped_chests");
   //TODO: POOR IMPLEMENTATION FOR REFINERY
   public static final TagKey<Item> REFINING_MISC = registerItemTag("refining_misc");

   private static TagKey<Item> registerItemTag(String id) {
      return TagKey.of(Registries.ITEM.getKey(), JinericMain.ofJineric(id));
   }

   public static void jinericItemTags() {
   }
}
