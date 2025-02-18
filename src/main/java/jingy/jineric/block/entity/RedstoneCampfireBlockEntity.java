package jingy.jineric.block.entity;

import jingy.jineric.block.RedstoneCampfireBlock;
import jingy.jineric.registry.JinericBlockEntityType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Clearable;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class RedstoneCampfireBlockEntity extends BlockEntity implements Clearable {
   private final DefaultedList<ItemStack> itemsBeingCooked = DefaultedList.ofSize(4, ItemStack.EMPTY);
   private final int[] cookingTimes = new int[4];
   private final int[] cookingTotalTimes = new int[4];

   public RedstoneCampfireBlockEntity(BlockPos pos, BlockState state) {
      super(JinericBlockEntityType.REDSTONE_CAMPFIRE, pos, state);
   }

   public static void litServerTick(ServerWorld world, BlockPos pos, BlockState state, RedstoneCampfireBlockEntity blockEntity, ServerRecipeManager.MatchGetter<SingleStackRecipeInput, CampfireCookingRecipe> recipeMatchGetter) {
      boolean bl = false;
      boolean powered = state.get(Properties.POWERED);
      for(int i = 0; i < blockEntity.itemsBeingCooked.size(); ++i) {
         ItemStack itemStack = blockEntity.itemsBeingCooked.get(i);
         if (!itemStack.isEmpty()) {
            bl = true;
            blockEntity.cookingTimes[i]++;
            if (blockEntity.cookingTimes[i] >= blockEntity.cookingTotalTimes[i]) {
               SingleStackRecipeInput singleStackRecipeInput = new SingleStackRecipeInput(itemStack);
               ItemStack itemStack2 = recipeMatchGetter.getFirstMatch(singleStackRecipeInput, world).map(
                       (recipeEntry) -> recipeEntry.value().craft(singleStackRecipeInput, world.getRegistryManager())
               ).orElse(itemStack);
               if (itemStack2.isItemEnabled(world.getEnabledFeatures())) {
                  ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), itemStack2);
                  blockEntity.itemsBeingCooked.set(i, ItemStack.EMPTY);
                  world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
                  world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(state));
               }
            }
            world.updateNeighborsAlways(pos, blockEntity.getCachedState().getBlock());
         }
      }

      if (blockEntity.isCooking() && !powered) {
         world.setBlockState(pos, state.with(Properties.POWERED, Boolean.valueOf(true)));
      } else if (!blockEntity.isCooking() && powered) {
         world.setBlockState(pos, state.with(Properties.POWERED, Boolean.valueOf(false)));
      }

      if (bl) {
         markDirty(world, pos, state);
      }
   }

   public static void unlitServerTick(World world, BlockPos pos, BlockState state, RedstoneCampfireBlockEntity redstoneCampfire) {
      boolean bl = false;
      for(int i = 0; i < redstoneCampfire.itemsBeingCooked.size(); ++i) {
         if (redstoneCampfire.cookingTimes[i] > 0) {
            bl = true;
            redstoneCampfire.cookingTimes[i] = MathHelper.clamp(redstoneCampfire.cookingTimes[i] - 2, 0, redstoneCampfire.cookingTotalTimes[i]);
         }
      }

      if (bl) {
         markDirty(world, pos, state);
      }
   }

   public static void clientTick(World world, BlockPos pos, BlockState state, RedstoneCampfireBlockEntity campfire) {
      Random random = world.random;
      if (random.nextFloat() < 0.11F) {
         for(int i = 0; i < random.nextInt(2) + 2; ++i) {
            RedstoneCampfireBlock.spawnSmokeParticle(world, pos, state.get(RedstoneCampfireBlock.SIGNAL_FIRE), false);
            if (state.get(Properties.SIGNAL_FIRE) && (state.get(Properties.POWERED))) {
               RedstoneCampfireBlock.spawnRedstoneParticle(world, pos, true);
            }
         }
      }
      int i = state.get(RedstoneCampfireBlock.FACING).getHorizontalQuarterTurns();

      for(int j = 0; j < campfire.itemsBeingCooked.size(); ++j) {
         if (!campfire.itemsBeingCooked.get(j).isEmpty() && random.nextFloat() < 0.2F) {
            Direction direction = Direction.fromHorizontalDegrees(Math.floorMod(j + i, 4));
            float f = 0.3125F;
            double d = (double)pos.getX()
                    + 0.5
                    - (double)((float)direction.getOffsetX() * f)
                    + (double)((float)direction.rotateYClockwise().getOffsetX() * f);
            double e = (double)pos.getY() + 0.5;
            double g = (double)pos.getZ()
                    + 0.5
                    - (double)((float)direction.getOffsetZ() * f)
                    + (double)((float)direction.rotateYClockwise().getOffsetZ() * f);

            for(int k = 0; k < 4; ++k) {
               world.addParticle(ParticleTypes.SMOKE, d, e, g, 0.0, 5.0E-4, 0.0);
            }
         }
      }
   }

   public DefaultedList<ItemStack> getItemsBeingCooked() {
      return this.itemsBeingCooked;
   }

   public boolean isCooking() {
      for (int i = 0; i < this.itemsBeingCooked.size(); ++i) {
         if (!this.itemsBeingCooked.get(i).isEmpty()) {
            return true;
         }
      }
      return false;
   }

   public int getRedstoneOutput() {
      int outputSignal = 0;
      for (int i = 0; i < this.itemsBeingCooked.size(); ++i) {
         ItemStack itemStack = this.itemsBeingCooked.get(i);
         if (!itemStack.isEmpty()) {
            outputSignal = outputSignal + 1;
         }
      }
      return outputSignal * 2;
   }

   @Override
   public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
      super.readNbt(nbt, registries);
      this.itemsBeingCooked.clear();
      Inventories.readNbt(nbt, this.itemsBeingCooked, registries);
      if (nbt.contains("CookingTimes", NbtElement.INT_ARRAY_TYPE)) {
         int[] is = nbt.getIntArray("CookingTimes");
         System.arraycopy(is, 0, this.cookingTimes, 0, Math.min(this.cookingTotalTimes.length, is.length));
      }

      if (nbt.contains("CookingTotalTimes", NbtElement.INT_ARRAY_TYPE)) {
         int[] is = nbt.getIntArray("CookingTotalTimes");
         System.arraycopy(is, 0, this.cookingTotalTimes, 0, Math.min(this.cookingTotalTimes.length, is.length));
      }
   }

   @Override
   protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
      super.writeNbt(nbt, registries);
      Inventories.writeNbt(nbt, this.itemsBeingCooked, registries);
      nbt.putIntArray("CookingTimes", this.cookingTimes);
      nbt.putIntArray("CookingTotalTimes", this.cookingTotalTimes);
   }

   public BlockEntityUpdateS2CPacket toUpdatePacket() {
      return BlockEntityUpdateS2CPacket.create(this);
   }

   @Override
   public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
      NbtCompound nbtCompound = new NbtCompound();
      Inventories.writeNbt(nbtCompound, this.itemsBeingCooked, registries);
      return nbtCompound;
   }

   public boolean addItem(ServerWorld world, @Nullable LivingEntity entity, ItemStack stack) {
      for (int i = 0; i < this.itemsBeingCooked.size(); i++) {
         ItemStack itemStack = this.itemsBeingCooked.get(i);
         if (itemStack.isEmpty()) {
            Optional<RecipeEntry<CampfireCookingRecipe>> optional = world.getRecipeManager()
                    .getFirstMatch(RecipeType.CAMPFIRE_COOKING, new SingleStackRecipeInput(stack), world);
            if (optional.isEmpty()) {
               return false;
            }

            this.cookingTotalTimes[i] = ((CampfireCookingRecipe)((RecipeEntry)optional.get()).value()).getCookingTime();
            this.cookingTimes[i] = 0;
            this.itemsBeingCooked.set(i, stack.splitUnlessCreative(1, entity));
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, this.getPos(), GameEvent.Emitter.of(entity, this.getCachedState()));
            this.updateListeners();
            return true;
         }
      }
      return false;
   }

   private void updateListeners() {
      this.markDirty();
      this.getWorld().updateListeners(this.getPos(), this.getCachedState(), this.getCachedState(), Block.NOTIFY_ALL);
   }

   @Override
   public void clear() {
      this.itemsBeingCooked.clear();
   }
}
