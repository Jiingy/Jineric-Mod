package jingy.jineric.block.custom.campfire;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.Random;

import static jingy.jineric.registry.JinericBlocks.JINERIC_CAMPFIRE_ENTITY;

public class JinericCampfireBlock extends CampfireBlock implements Waterloggable {

   protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 7.0, 16.0);
   public static final BooleanProperty LIT = Properties.LIT;
   public static final BooleanProperty SIGNAL_FIRE = Properties.SIGNAL_FIRE;
   public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
   public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
   private static final VoxelShape SMOKEY_SHAPE = Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);

   private static final int field_31049 = 5;
   private final boolean emitsParticles;
   private final int fireDamage;

   public JinericCampfireBlock(boolean emitsParticles, int fireDamage, Settings settings) {
      super(emitsParticles, fireDamage, settings);
      this.emitsParticles = emitsParticles;
      this.fireDamage = fireDamage;
      this.setDefaultState(
           this.stateManager
                .getDefaultState()
                .with(LIT, Boolean.TRUE)
                .with(SIGNAL_FIRE, Boolean.FALSE)
                .with(WATERLOGGED, Boolean.FALSE)
                .with(FACING, Direction.NORTH)
      );
   }

   @Override
   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      if (blockEntity instanceof JinericCampfireBlockEntity) {
         JinericCampfireBlockEntity JinericCampfireBlock = (JinericCampfireBlockEntity)blockEntity;
         ItemStack itemStack = player.getStackInHand(hand);
         Optional<CampfireCookingRecipe> optional = JinericCampfireBlock.getRecipeFor(itemStack);
         if (optional.isPresent()) {
            if (!world.isClient
                    && JinericCampfireBlock.addItem(player.getAbilities().creativeMode ? itemStack.copy() : itemStack, ((CampfireCookingRecipe)optional.get()).getCookTime())) {
               player.incrementStat(Stats.INTERACT_WITH_CAMPFIRE);
               return ActionResult.SUCCESS;
            }

            return ActionResult.CONSUME;
         }
      }

      return ActionResult.PASS;
   }

   @Override
   public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
      if (!entity.isFireImmune() && state.get(LIT) && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
         entity.damage(DamageSource.IN_FIRE, (float)this.fireDamage);
      }

      super.onEntityCollision(state, world, pos, entity);
   }

   @Override
   public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
      if (!state.isOf(newState.getBlock())) {
         BlockEntity blockEntity = world.getBlockEntity(pos);
         if (blockEntity instanceof JinericCampfireBlockEntity) {
            ItemScatterer.spawn(world, pos, ((JinericCampfireBlockEntity)blockEntity).getItemsBeingCooked());
         }

         super.onStateReplaced(state, world, pos, newState, moved);
      }
   }

   @Nullable
   @Override
   public BlockState getPlacementState(ItemPlacementContext ctx) {
      WorldAccess worldAccess = ctx.getWorld();
      BlockPos blockPos = ctx.getBlockPos();
      boolean bl = worldAccess.getFluidState(blockPos).getFluid() == Fluids.WATER;
      return this.getDefaultState()
              .with(WATERLOGGED, bl)
              .with(SIGNAL_FIRE, this.doesBlockCauseSignalFire(worldAccess.getBlockState(blockPos.down())))
              .with(LIT, !bl)
              .with(FACING, ctx.getPlayerFacing());
   }

   @Override
   public BlockState getStateForNeighborUpdate(
           BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
   ) {
      if (state.get(WATERLOGGED)) {
         world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
      }

      return direction == Direction.DOWN
              ? state.with(SIGNAL_FIRE, this.doesBlockCauseSignalFire(neighborState))
              : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
   }

   private boolean doesBlockCauseSignalFire(BlockState state) {
      return state.isOf(Blocks.HAY_BLOCK);
   }

   @Override
   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
      return SHAPE;
   }

   @Override
   public BlockRenderType getRenderType(BlockState state) {
      return BlockRenderType.MODEL;
   }

   @Override
   public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
      if (state.get(LIT)) {
         if (random.nextInt(10) == 0) {
            world.playSound(
                    (double)pos.getX() + 0.5,
                    (double)pos.getY() + 0.5,
                    (double)pos.getZ() + 0.5,
                    SoundEvents.BLOCK_CAMPFIRE_CRACKLE,
                    SoundCategory.BLOCKS,
                    0.5F + random.nextFloat(),
                    random.nextFloat() * 0.7F + 0.6F,
                    false
            );
         }

         if (this.emitsParticles && random.nextInt(5) == 0) {
            for(int i = 0; i < random.nextInt(1) + 1; ++i) {
               world.addParticle(
                       ParticleTypes.LAVA,
                       (double)pos.getX() + 0.5,
                       (double)pos.getY() + 0.5,
                       (double)pos.getZ() + 0.5,
                       (double)(random.nextFloat() / 2.0F),
                       5.0E-5,
                       (double)(random.nextFloat() / 2.0F)
               );
            }
         }

      }
   }

   public static void extinguish(@Nullable Entity entity, WorldAccess world, BlockPos pos, BlockState state) {
      if (world.isClient()) {
         for(int i = 0; i < 20; ++i) {
            spawnSmokeParticle((World)world, pos, state.get(SIGNAL_FIRE), true);
         }
      }

      BlockEntity blockEntity = world.getBlockEntity(pos);
      if (blockEntity instanceof JinericCampfireBlockEntity) {
         ((JinericCampfireBlockEntity)blockEntity).spawnItemsBeingCooked();
      }

      world.emitGameEvent(entity, GameEvent.BLOCK_CHANGE, pos);
   }

   @Override
   public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
      if (!state.get(Properties.WATERLOGGED) && fluidState.getFluid() == Fluids.WATER) {
         boolean bl = state.get(LIT);
         if (bl) {
            if (!world.isClient()) {
               world.playSound((PlayerEntity)null, pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }

            extinguish((Entity)null, world, pos, state);
         }

         world.setBlockState(pos, state.with(WATERLOGGED, Boolean.TRUE).with(LIT, Boolean.FALSE), Block.NOTIFY_ALL);
         world.createAndScheduleFluidTick(pos, fluidState.getFluid(), fluidState.getFluid().getTickRate(world));
         return true;
      } else {
         return false;
      }
   }

   @Override
   public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
      BlockPos blockPos = hit.getBlockPos();
      if (!world.isClient && projectile.isOnFire() && projectile.canModifyAt(world, blockPos) && !state.get(LIT) && !state.get(WATERLOGGED)) {
         world.setBlockState(blockPos, state.with(Properties.LIT, Boolean.TRUE), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
      }

   }

   public static void spawnSmokeParticle(World world, BlockPos pos, boolean isSignal, boolean lotsOfSmoke) {
      Random random = world.getRandom();
      DefaultParticleType defaultParticleType = isSignal ? ParticleTypes.CAMPFIRE_SIGNAL_SMOKE : ParticleTypes.CAMPFIRE_COSY_SMOKE;
      world.addImportantParticle(
              defaultParticleType,
              true,
              (double)pos.getX() + 0.5 + random.nextDouble() / 3.0 * (double)(random.nextBoolean() ? 1 : -1),
              (double)pos.getY() + random.nextDouble() + random.nextDouble(),
              (double)pos.getZ() + 0.5 + random.nextDouble() / 3.0 * (double)(random.nextBoolean() ? 1 : -1),
              0.0,
              0.07,
              0.0
      );
      if (lotsOfSmoke) {
         world.addParticle(
                 ParticleTypes.SMOKE,
                 (double)pos.getX() + 0.5 + random.nextDouble() / 4.0 * (double)(random.nextBoolean() ? 1 : -1),
                 (double)pos.getY() + 0.4,
                 (double)pos.getZ() + 0.5 + random.nextDouble() / 4.0 * (double)(random.nextBoolean() ? 1 : -1),
                 0.0,
                 0.005,
                 0.0
         );
      }

   }

   public static boolean isLitCampfireInRange(World world, BlockPos pos) {
      for(int i = 1; i <= 5; ++i) {
         BlockPos blockPos = pos.down(i);
         BlockState blockState = world.getBlockState(blockPos);
         if (isLitCampfire(blockState)) {
            return true;
         }

         boolean bl = VoxelShapes.matchesAnywhere(SMOKEY_SHAPE, blockState.getCollisionShape(world, pos, ShapeContext.absent()), BooleanBiFunction.AND);
         if (bl) {
            BlockState blockState2 = world.getBlockState(blockPos.down());
            return isLitCampfire(blockState2);
         }
      }

      return false;
   }

   public static boolean isLitCampfire(BlockState state) {
      return state.contains(LIT) && state.isIn(BlockTags.CAMPFIRES) && state.get(LIT);
   }

   @Override
   public FluidState getFluidState(BlockState state) {
      return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
   }

   @Override
   public BlockState rotate(BlockState state, BlockRotation rotation) {
      return state.with(FACING, rotation.rotate(state.get(FACING)));
   }

   @Override
   public BlockState mirror(BlockState state, BlockMirror mirror) {
      return state.rotate(mirror.getRotation(state.get(FACING)));
   }

   @Override
   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
      builder.add(LIT, SIGNAL_FIRE, WATERLOGGED, FACING);
   }

   @Override
   public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
      return new JinericCampfireBlockEntity(pos, state);
   }

   @Nullable
   @Override
   public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
      if (world.isClient) {
         return state.get(LIT) ? checkType(type, JINERIC_CAMPFIRE_ENTITY, JinericCampfireBlockEntity::clientTick) : null;
      } else {
         return state.get(LIT)
                 ? checkType(type, JINERIC_CAMPFIRE_ENTITY, JinericCampfireBlockEntity::litServerTick)
                 : checkType(type, JINERIC_CAMPFIRE_ENTITY, JinericCampfireBlockEntity::unlitServerTick);
      }
   }

   @Override
   public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
      return false;
   }

   public static boolean canBeLit(BlockState state) {
      return state.isIn(BlockTags.CAMPFIRES, statex -> statex.contains(WATERLOGGED) && statex.contains(LIT)) && !state.get(WATERLOGGED) && !state.get(LIT);
   }
}
