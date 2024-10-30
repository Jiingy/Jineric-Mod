package jingy.jineric.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.Saddleable;
import net.minecraft.entity.SaddledComponent;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TurtleEntity.class)
public abstract class TurtleEntityMixin extends AnimalEntity implements Saddleable {
   @Unique private static final TrackedData<Integer> JINERIC_BOOST_TIME = DataTracker.registerData(TurtleEntityMixin.class, TrackedDataHandlerRegistry.INTEGER);
   @Unique private static final TrackedData<Boolean> JINERIC_SADDLED = DataTracker.registerData(TurtleEntityMixin.class, TrackedDataHandlerRegistry.BOOLEAN);
   @Unique private final SaddledComponent jineric$saddledComponent = new SaddledComponent(this.dataTracker, JINERIC_BOOST_TIME, JINERIC_SADDLED);

   protected TurtleEntityMixin(EntityType<? extends TurtleEntity> entityType, World world) {
      super(entityType, world);
   }

   @Inject(method = "initDataTracker", at = @At("HEAD"))
   protected void jineric$initDataTracker(DataTracker.Builder builder, CallbackInfo ci) {
      super.initDataTracker(builder);
      builder.add(JINERIC_BOOST_TIME, 0);
      builder.add(JINERIC_SADDLED, false);
   }

   // Write saddle-able NBT data
   @Inject(method = "writeCustomDataToNbt", at = @At("HEAD"))
      public void jineric$writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
      NbtCompound saddled = new NbtCompound();
      jineric$saddledComponent.writeNbt(saddled);
      nbt.put("JinericSaddled", saddled);
   }

   // Reads saddle-able NBT data
   @Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
   public void jineric$readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
      NbtCompound saddled = nbt.getCompound("JinericSaddled");
      jineric$saddledComponent.readNbt(saddled);
   }

   @Override
   protected void dropInventory(ServerWorld world) {
      super.dropInventory(world);
      if (this.isSaddled()) {
         this.dropItem(world, Items.SADDLE);
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
   public void saddle(ItemStack stack, @Nullable SoundCategory soundCategory) {
      this.jineric$saddledComponent.setSaddled(true);
      if (soundCategory != null) {
         this.getWorld().playSoundFromEntity(null, this, SoundEvents.ENTITY_PIG_SADDLE, soundCategory, 0.5F, 1.0F);
      }
   }

   @Override
   public SoundEvent getSaddleSound() {
      return Saddleable.super.getSaddleSound();
   }

   @Override
   public void onTrackedDataSet(TrackedData<?> data) {
      if (JINERIC_BOOST_TIME.equals(data) && this.getWorld().isClient) {
         this.jineric$saddledComponent.boost();
      }

      super.onTrackedDataSet(data);
   }

   @Override
   public ActionResult interactMob(PlayerEntity player, Hand hand) {
      boolean bl = this.isBreedingItem(player.getStackInHand(hand));
      if (!bl && this.isSaddled() && !this.hasPassengers() && !player.shouldCancelInteraction()) {
         if (!this.getWorld().isClient) {
            player.startRiding(this);
         }

         return ActionResult.SUCCESS;
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
}
