package jingy.jineric.item;

import net.minecraft.item.HorseArmorItem;
import net.minecraft.util.Identifier;

public class JinericHorseArmorItem extends HorseArmorItem {
   private static final String ENTITY_TEXTURE_PREFIX = "jineric:textures/entity/horse/armor/horse_armor_";
   private final int bonus;
   private final String entityTexture;

   public JinericHorseArmorItem(int bonus, String name, Settings settings) {
      super(bonus, name, settings);
      this.bonus = bonus;
      this.entityTexture = ENTITY_TEXTURE_PREFIX + name + ".png";
   }

   @Override
   public Identifier getEntityTexture() {
      return new Identifier(this.entityTexture);
   }

   @Override
   public int getBonus() {
      return this.bonus;
   }
}
