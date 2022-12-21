package jingy.jineric.tag;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class JinericItemTags {

   public static final TagKey<Item> WOODEN_BOOKSHELVES = register("jineric:wooden_bookshelves");
   public static final TagKey<Item> WOODEN_LADDERS = register("jineric:wooden_ladders");
   public static final TagKey<Item> WOODEN_CHESTS = register("jineric:wooden_chests");

   private static TagKey<Item> register(String id) {
      return TagKey.of(Registries.ITEM.getKey(), new Identifier(id));
   }

   private JinericItemTags() {
   }
}
