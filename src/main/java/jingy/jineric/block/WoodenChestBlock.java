package jingy.jineric.block;

import jingy.jineric.block.entity.WoodenChestBlockEntity;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.tag.JinericBlockTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class WoodenChestBlock extends ChestBlock {
	private static final DoubleBlockProperties.PropertyRetriever<WoodenChestBlockEntity, Optional<NamedScreenHandlerFactory>> NAME_RETRIEVER = new DoubleBlockProperties.PropertyRetriever<>() {
		public Optional<NamedScreenHandlerFactory> getFromBoth(WoodenChestBlockEntity woodenChestBlockEntity, WoodenChestBlockEntity woodenChestBlockEntity2) {
			final Inventory inventory = new DoubleInventory(woodenChestBlockEntity, woodenChestBlockEntity2);
			return Optional.of(new NamedScreenHandlerFactory() {
				@Nullable
				@Override
				public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
					if (woodenChestBlockEntity.checkUnlocked(playerEntity) && woodenChestBlockEntity2.checkUnlocked(playerEntity)) {
						woodenChestBlockEntity.generateLoot(playerInventory.player);
						woodenChestBlockEntity2.generateLoot(playerInventory.player);
						return GenericContainerScreenHandler.createGeneric9x6(i, playerInventory, inventory);
					} else {
						return null;
					}
				}
				
				@Override
				public net.minecraft.text.Text getDisplayName() {
					if (woodenChestBlockEntity.hasCustomName()) {
						return woodenChestBlockEntity.getDisplayName();
					} else {
						BlockState blockState = woodenChestBlockEntity.getCachedState();
						WoodType woodType = WoodenChestBlock.getWoodType(blockState.getBlock());
						return (woodenChestBlockEntity2.hasCustomName() ? woodenChestBlockEntity2.getDisplayName() : woodenChestBlockEntity.getChestTypeKey(woodType));
					}
				}
			});
		}
		
		public Optional<NamedScreenHandlerFactory> getFrom(WoodenChestBlockEntity chestBlockEntity) {
			return Optional.of(chestBlockEntity);
		}
		
		public Optional<NamedScreenHandlerFactory> getFallback() {
			return Optional.empty();
		}
	};
	private final WoodType type;
	
	public WoodenChestBlock(Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntityTypeSupplier, Settings settings, WoodType type) {
		super(blockEntityTypeSupplier, SoundEvents.BLOCK_CHEST_OPEN, SoundEvents.BLOCK_CHEST_CLOSE, settings);
		this.type = type;
	}
	
	public WoodenChestBlock(Settings settings, WoodType type) {
		super(() -> JinericBlockEntityType.JINERIC_CHEST, SoundEvents.BLOCK_CHEST_OPEN, SoundEvents.BLOCK_CHEST_CLOSE, settings);
		this.type = type;
	}
	
	public static WoodType getWoodType(Block block) {
		WoodType woodType;
		if (block instanceof WoodenChestBlock) {
			woodType = ((WoodenChestBlock) block).getWoodType();
		} else {
			woodType = WoodType.OAK;
		}
		return woodType;
	}
	
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new WoodenChestBlockEntity(JinericBlockEntityType.JINERIC_CHEST, pos, state);
	}
	
	public WoodType getWoodType() {
		return this.type;
	}
	
	public BlockEntityType<? extends WoodenChestBlockEntity> getExpectedEntityType() {
		return (BlockEntityType) this.entityTypeRetriever.get();
	}
	
	@Override
	public DoubleBlockProperties.PropertySource<? extends WoodenChestBlockEntity> getBlockEntitySource(
			BlockState state, World world, BlockPos pos, boolean ignoreBlocked) {
		BiPredicate<WorldAccess, BlockPos> biPredicate;
		if (ignoreBlocked) {
			biPredicate = (worldx, posx) -> false;
		} else {
			biPredicate = WoodenChestBlock::isChestBlocked;
		}
		return DoubleBlockProperties.toPropertySource(
				(BlockEntityType<? extends WoodenChestBlockEntity>) this.entityTypeRetriever.get(),
				WoodenChestBlock::getDoubleBlockType, WoodenChestBlock::getFacing,
				FACING, state, world, pos, biPredicate
		);
	}
	
	@Nullable
	@Override
	public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
		return (NamedScreenHandlerFactory) ((Optional) this.getBlockEntitySource(state, world, pos, false).apply(NAME_RETRIEVER)).orElse(null);
	}
	
	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		return world.isClient() ? validateTicker(type, this.getExpectedEntityType(), WoodenChestBlockEntity::clientTick) : null;
	}
	
	@Override
	protected boolean keepBlockEntityWhenReplacedWith(BlockState state) {
		return state.isIn(JinericBlockTags.WOODEN_CHESTS);
	}
}
