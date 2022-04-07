package jingy.jineric.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.SpawnEggItem;

public class JinericSpawnEggItem extends SpawnEggItem {
   public JinericSpawnEggItem(EntityType<? extends MobEntity> type, int primaryColor, int secondaryColor, Settings settings) {
      super(type, primaryColor, secondaryColor, settings);
   }
}
