package jingy.jineric.item;

import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class JinericElytraItem extends ElytraItem implements FabricElytraItem {
   public JinericElytraItem(Item.Settings settings) {
      super(settings);
      DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
   }

   public static boolean isUsable(ItemStack stack) {
      return stack.getDamage() < stack.getMaxDamage() - 1;
   }

   public boolean useCustomElytra(LivingEntity entity, ItemStack chestStack, boolean tickElytra) {
      if (JinericElytraItem.isUsable(chestStack)) {
         if (tickElytra) {
            doVanillaElytraTick(entity, chestStack);
         }

         return true;
      }

      return false;
   }

   public void doVanillaElytraTick(LivingEntity entity, ItemStack chestStack) {
      int nextRoll = entity.getRoll() + 1;

      if (!entity.world.isClient && nextRoll % 10 == 0) {
         if ((nextRoll / 10) % 2 == 0) {
            chestStack.damage(1, entity, p -> p.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
         }

         entity.emitGameEvent(GameEvent.ELYTRA_GLIDE);
      }
   }

   @Override
   public boolean canRepair(ItemStack stack, ItemStack ingredient) {
      return ingredient.isOf(Items.PHANTOM_MEMBRANE);
   }

   @Override
   public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
      ItemStack itemStack = user.getStackInHand(hand);
      EquipmentSlot equipmentSlot = MobEntity.getPreferredEquipmentSlot(itemStack);
      ItemStack itemStack2 = user.getEquippedStack(equipmentSlot);
      if (itemStack2.isEmpty()) {
         user.equipStack(equipmentSlot, itemStack.copy());
         if (!world.isClient()) {
            user.incrementStat(Stats.USED.getOrCreateStat(this));
         }

         itemStack.setCount(0);
         return TypedActionResult.success(itemStack, world.isClient());
      } else {
         return TypedActionResult.fail(itemStack);
      }
   }

   @Nullable
   @Override
   public SoundEvent getEquipSound() {
      return SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA;
   }
}
