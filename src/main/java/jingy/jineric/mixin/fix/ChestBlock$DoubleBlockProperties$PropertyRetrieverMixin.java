package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.block.WoodenChestBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CopperChestBlock;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Optional;

@Mixin(targets = "net/minecraft/world/level/block/ChestBlock$2")
public abstract class ChestBlock$DoubleBlockProperties$PropertyRetrieverMixin {
	
	@WrapOperation(
			method = "acceptDouble(Lnet/minecraft/world/level/block/entity/ChestBlockEntity;Lnet/minecraft/world/level/block/entity/ChestBlockEntity;)Ljava/util/Optional;",
			at = @At(
					value = "INVOKE",
					target = "Ljava/util/Optional;of(Ljava/lang/Object;)Ljava/util/Optional;")
	)
	private static Optional<Object> addChestTypeToScreenName(
			Object value,
			Operation<Optional<Object>> operation,
			ChestBlockEntity chestBlockEntity, ChestBlockEntity chestBlockEntity2
	) {
		return Optional.of(new MenuProvider() {
			
			@Override
			public Component getDisplayName() {
				Block chestBlock = chestBlockEntity.getBlockState().getBlock();
				if (chestBlockEntity.hasCustomName()) {
					return chestBlockEntity.getDisplayName();
				} else if (chestBlockEntity2.hasCustomName()) {
					return chestBlockEntity2.getDisplayName();
				} else {
					if (chestBlock instanceof WoodenChestBlock woodenChest) {
							return Component.translatable("container.double_" + woodenChest.getWoodType().name() + "_chest");
					} else if (chestBlock instanceof CopperChestBlock copperChestBlock) {
						return Component.translatable("container.double_" + copperChestBlock.getState().name().toLowerCase() + "_copper_chest");
					}
				}
				return Component.translatable("container.chestDouble");
			}
			
			@Override
			public @Nullable AbstractContainerMenu createMenu(int syncId, Inventory playerInventory, Player player) {
				return ((MenuProvider)value).createMenu(syncId, playerInventory, player);
			}
		});
	}
}