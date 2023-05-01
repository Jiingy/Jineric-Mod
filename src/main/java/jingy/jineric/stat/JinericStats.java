package jingy.jineric.stat;

import jingy.jineric.base.JinericMain;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;

public class JinericStats {
   public static final Identifier INTERACT_WITH_REFINERY = register("interact_with_refinery", StatFormatter.DEFAULT);

   private static Identifier register(String id, StatFormatter formatter) {
      Identifier identifier = new Identifier(JinericMain.MOD_ID, id);
      Registry.register(Registries.CUSTOM_STAT, identifier, identifier);
      Stats.CUSTOM.getOrCreateStat(identifier, formatter);
      return identifier;
   }

   public static void registerStats() {
   }
}
