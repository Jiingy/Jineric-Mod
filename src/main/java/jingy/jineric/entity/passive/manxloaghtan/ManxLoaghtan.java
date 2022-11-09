package jingy.jineric.entity.passive.manxloaghtan;

import com.google.common.collect.Maps;
import jingy.jineric.registry.JinericEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ManxLoaghtan extends AnimalEntity implements Shearable {
   private static final int MAX_GRASS_TIMER = 40;
   private static final TrackedData<Byte> COLOR = DataTracker.registerData(ManxLoaghtan.class, TrackedDataHandlerRegistry.BYTE);
   private static final Map<DyeColor, ItemConvertible> DROPS = Util.make(Maps.newEnumMap(DyeColor.class), map -> {
      map.put(DyeColor.WHITE, Blocks.WHITE_WOOL);
      map.put(DyeColor.GRAY, Blocks.GRAY_WOOL);
      map.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
      map.put(DyeColor.BROWN, Blocks.BROWN_WOOL);
      map.put(DyeColor.BLACK, Blocks.BLACK_WOOL);
   });
   private static final Map<DyeColor, float[]> COLORS = Maps.newEnumMap(
           (Map) Arrays.stream(DyeColor.values()).collect(Collectors.toMap(dyeColor -> dyeColor, ManxLoaghtan::getDyedColor))
   );

   private int eatGrassTimer;
   //TODO: See if mixin to add full grass block is possible for eatGrassGoal
   private EatGrassGoal eatGrassGoal;
   private int headAngle;

   private static float[] getDyedColor(DyeColor color) {
      if (color == DyeColor.BLACK) {
         return new float[]{0.9019608F, 0.9019608F, 0.9019608F};
      } else {
         float[] fs = color.getColorComponents();
         float f = 0.75F;
         return new float[]{fs[0] * 0.75F, fs[1] * 0.75F, fs[2] * 0.75F};
      }
   }

   public ManxLoaghtan(EntityType<? extends ManxLoaghtan> entityType, World world) {
      super(entityType, world);
   }

   public static float[] getRgbColor(DyeColor dyeColor) {
      return (float[])COLORS.get(dyeColor);
   }

   @Override
   protected void initGoals() {
      this.eatGrassGoal = new EatGrassGoal(this);
      this.goalSelector.add(0, new SwimGoal(this));
      this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25));
      this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
      this.goalSelector.add(3, new TemptGoal(this, 1.1, Ingredient.ofItems(Items.WHEAT), false));
      this.goalSelector.add(4, new FollowParentGoal(this, 1.1));
      this.goalSelector.add(5, this.eatGrassGoal);
      this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0));
      this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.add(8, new LookAroundGoal(this));
   }

   @Override
   protected void mobTick() {
      this.eatGrassTimer = this.eatGrassGoal.getTimer();
      super.mobTick();
   }

   @Override
   public void tickMovement() {
      if (this.world.isClient) {
         this.eatGrassTimer = Math.max(0, this.eatGrassTimer -1);
      }
      super.tickMovement();
   }

   public static DefaultAttributeContainer.Builder createManxLoaghtanAttributes() {
      return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23F);
   }

   @Override
   protected void initDataTracker() {
      super.initDataTracker();
      this.dataTracker.startTracking(COLOR, (byte)0);
   }

   @Override
   public void handleStatus(byte status) {
      if (status == 10) {
         this.eatGrassTimer = 40;
      } else {
         super.handleStatus(status);
      }

   }

   public float getNeckAngle(float delta) {
      if (this.eatGrassTimer <= 0) {
         return 0.0F;
      } else if (this.eatGrassTimer >= 4 && this.eatGrassTimer <= 36) {
         return 1.0F;
      } else {
         return this.eatGrassTimer < 4 ? ((float)this.eatGrassTimer - delta) / 4.0F : -((float)(this.eatGrassTimer - 40) - delta) / 4.0F;
      }
   }

   public float getHeadAngle(float delta) {
      if (this.eatGrassTimer > 4 && this.eatGrassTimer <= 36) {
         float f = ((float)(this.eatGrassTimer - 4) - delta) / 32.0F;
         return (float) (Math.PI / 5) + 0.21991149F * MathHelper.sin(f * 28.7F);
      } else {
         return this.eatGrassTimer > 0 ? (float) (Math.PI / 5) : this.getPitch() * (float) (Math.PI / 180.0);
      }
   }

   public float getHeadPitch() {
      return (float)this.headAngle / 20.0F * 30.0F * (float) (Math.PI / 180.0);
   }

   @Override
   public ActionResult interactMob(PlayerEntity player, Hand hand) {
      ItemStack itemStack = player.getStackInHand(hand);
      if (itemStack.isOf(Items.SHEARS)) {
         if (!this.world.isClient && this.isShearable()) {
            this.sheared(SoundCategory.PLAYERS);
            this.emitGameEvent(GameEvent.SHEAR, player);
            itemStack.damage(1, player, playerx -> playerx.sendToolBreakStatus(hand));
            return ActionResult.SUCCESS;
         } else {
            return ActionResult.CONSUME;
         }
      } else {
         return super.interactMob(player, hand);
      }
   }

   @Override
   public void sheared(SoundCategory shearedSoundCategory) {
      this.world.playSoundFromEntity((PlayerEntity)null, this, SoundEvents.ENTITY_SHEEP_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
      this.setSheared(true);
      int i = 1 + this.random.nextInt(3);

      for(int j = 0; j < i; ++j) {
         ItemEntity itemEntity = this.dropItem(Items.BLACK_WOOL, 1);
         if (itemEntity != null) {
            itemEntity.setVelocity(
                    itemEntity.getVelocity()
                            .add(
                                    (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1F),
                                    (double)(this.random.nextFloat() * 0.05F),
                                    (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1F)
                            )
            );
         }
      }

   }

   @Override
   public boolean isShearable() {
      return this.isAlive() && !this.isSheared() && !this.isBaby();
   }

   @Override
   public void writeCustomDataToNbt(NbtCompound nbt) {
      super.writeCustomDataToNbt(nbt);
      nbt.putBoolean("Sheared", this.isSheared());
      nbt.putByte("Color", (byte)this.getColor().getId());
   }

   @Override
   public void readCustomDataFromNbt(NbtCompound nbt) {
      super.readCustomDataFromNbt(nbt);
      this.setSheared(nbt.getBoolean("Sheared"));
      this.setColor(DyeColor.byId(nbt.getByte("Color")));
   }

   @Override
   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_SHEEP_AMBIENT;
   }

   @Override
   protected SoundEvent getHurtSound(DamageSource source) {
      return SoundEvents.ENTITY_SHEEP_HURT;
   }

   @Override
   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_SHEEP_DEATH;
   }

   @Override
   protected void playStepSound(BlockPos pos, BlockState state) {
      this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
   }

   public DyeColor getColor() {
      return DyeColor.byId(this.dataTracker.get(COLOR) & 15);
   }

   	public void setColor(DyeColor color) {
		byte b = this.dataTracker.get(COLOR);
		this.dataTracker.set(COLOR, (byte)(b & 240 | color.getId() & 15));
	}

   public boolean isSheared() {
      return (this.dataTracker.get(COLOR) & 1) != 0;
   }

   public void setSheared(boolean sheared) {
      byte b = this.dataTracker.get(COLOR);
      if (sheared) {
         this.dataTracker.set(COLOR, (byte)(b | 1));
      } else {
         this.dataTracker.set(COLOR, (byte)(b & -2));
      }
   }

   public static DyeColor generateDefaultColor(Random random) {
      int i = random.nextInt(100);
      if (i < 5) {
         return DyeColor.BLACK;
      } else if (i < 10) {
         return DyeColor.GRAY;
      } else if (i < 15) {
         return DyeColor.LIGHT_GRAY;
      } else if (i < 18) {
         return DyeColor.BROWN;
      } else {
         return DyeColor.WHITE;
      }
   }


   @Override
   public ManxLoaghtan createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
      ManxLoaghtan manxLoaghtan = (ManxLoaghtan)passiveEntity;
      ManxLoaghtan manxLoaghtan2 = JinericEntities.MANX_LOAGHTAN.create(serverWorld);
//      manxLoaghtan2.setColor(this.getChildColor(this, manxLoaghtan));
      return manxLoaghtan2;
   }

   @Override
   public void onEatingGrass() {
      this.setSheared(false);
      if (this.isBaby()) {
         this.growUp(60);
      }
   }

   @Nullable
   @Override
   public EntityData initialize(
           ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt
   ) {
      this.setColor(generateDefaultColor(world.getRandom()));
      return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
   }

//   private DyeColor getChildColor(AnimalEntity firstParent, AnimalEntity secondParent) {
//      DyeColor dyeColor = ((SheepEntity)firstParent).getColor();
//      DyeColor dyeColor2 = ((SheepEntity)secondParent).getColor();
//      CraftingInventory craftingInventory = createDyeMixingCraftingInventory(dyeColor, dyeColor2);
//      return (DyeColor)this.world
//              .getRecipeManager()
//              .getFirstMatch(RecipeType.CRAFTING, craftingInventory, this.world)
//              .map(recipe -> recipe.craft(craftingInventory))
//              .map(ItemStack::getItem)
//              .filter(DyeItem.class::isInstance)
//              .map(DyeItem.class::cast)
//              .map(DyeItem::getColor)
//              .orElseGet(() -> this.world.random.nextBoolean() ? dyeColor : dyeColor2);
//   }

//   private static CraftingInventory createDyeMixingCraftingInventory(DyeColor firstColor, DyeColor secondColor) {
//      CraftingInventory craftingInventory = new CraftingInventory(new ScreenHandler((ScreenHandlerType)null, -1) {
//         @Override
//         public boolean canUse(PlayerEntity player) {
//            return false;
//         }
//      }, 2, 1);
//      craftingInventory.setStack(0, new ItemStack(DyeItem.byColor(firstColor)));
//      craftingInventory.setStack(1, new ItemStack(DyeItem.byColor(secondColor)));
//      return craftingInventory;
//   }

   @Override
   protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
      return 0.95F * dimensions.height;
   }
}
