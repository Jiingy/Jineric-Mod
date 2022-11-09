package jingy.jineric.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.Saddleable;
import net.minecraft.entity.SaddledComponent;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TurtleEntity.class)
public class TurtleEntityMixin extends AnimalEntity implements Saddleable {
   private static final TrackedData<Integer> BOOST_TIME = DataTracker.registerData(TurtleEntityMixin.class, TrackedDataHandlerRegistry.INTEGER);
   private static final TrackedData<Boolean> SADDLED = DataTracker.registerData(TurtleEntityMixin.class, TrackedDataHandlerRegistry.BOOLEAN);
   private final SaddledComponent jineric$saddledComponent = new SaddledComponent(this.dataTracker, BOOST_TIME, SADDLED);

   protected TurtleEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
      super(entityType, world);
   }

   @Inject(method = "initDataTracker", at = @At("HEAD"))
   protected void jineric$initDataTracker(CallbackInfo ci) {
      this.dataTracker.startTracking(BOOST_TIME, 0);
      this.dataTracker.startTracking(SADDLED, false);
   }

   // Write saddle-able NBT data
   @Inject(method = "writeCustomDataToNbt", at = @At("HEAD"))
      public void jineric$writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
      NbtCompound jinericSaddled = new NbtCompound();
      jineric$saddledComponent.writeNbt(jinericSaddled);
      nbt.put("JinericSaddled", jinericSaddled);
   }

   // Reads saddle-able NBT data
   @Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
   public void jineric$readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
      NbtCompound jinericSaddled = nbt.getCompound("JinericSaddled");
      jineric$saddledComponent.readNbt(jinericSaddled);
   }

   @Override
   protected void dropInventory() {
      super.dropInventory();
      if (this.isSaddled()) {
         this.dropItem(Items.SADDLE);
      }
   }

   @Override
   public boolean isSaddled() {
      return this.jineric$saddledComponent.isSaddled();
   }

   @Override
   public boolean canBeSaddled() {
      return this.isAlive() && !this.isBaby();
   }

   @Override
   public void saddle(@Nullable SoundCategory sound) {
      this.jineric$saddledComponent.setSaddled(true);
      if (sound != null) {
         this.world.playSoundFromEntity((PlayerEntity)null, this, SoundEvents.ENTITY_STRIDER_SADDLE, sound, 0.5F, 1.0F);
      }
   }

   @Override
   public void onTrackedDataSet(TrackedData<?> data) {
      if (BOOST_TIME.equals(data) && this.world.isClient) {
         this.jineric$saddledComponent.boost();
      }

      super.onTrackedDataSet(data);
   }

   @Override
   public ActionResult interactMob(PlayerEntity player, Hand hand) {
      boolean bl = this.isBreedingItem(player.getStackInHand(hand));
      if (!bl && this.isSaddled() && !this.hasPassengers() && !player.shouldCancelInteraction()) {
         if (!this.world.isClient) {
            player.startRiding(this);
         }

         return ActionResult.success(this.world.isClient);
      } else {
         ActionResult actionResult = super.interactMob(player, hand);
         if (!actionResult.isAccepted()) {
            ItemStack itemStack = player.getStackInHand(hand);
            return itemStack.isOf(Items.SADDLE) ? itemStack.useOnEntity(player, this, hand) : ActionResult.PASS;
         } else {
            return actionResult;
         }
      }
   }

   public boolean canBeRiddenInWater() {
      return true;
   }

   @Nullable
   @Override
   public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
      return EntityType.TURTLE.create(world);
   }

}
