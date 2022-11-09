package jingy.jineric.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LightningEntity.class)
public abstract class LightningEntityMixin extends Entity {

   public LightningEntityMixin(EntityType<?> type, World world) {
      super(type, world);
   }
}
