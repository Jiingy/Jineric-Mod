package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import jingy.jineric.block.WoodenChestBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CopperChestBlock;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Optional;

@Mixin(targets = "net/minecraft/block/ChestBlock$2")
public abstract class ChestBlock$DoubleBlockProperties$PropertyRetrieverMixin {
	
	@WrapOperation(
			method = "getFromBoth(Lnet/minecraft/block/entity/ChestBlockEntity;Lnet/minecraft/block/entity/ChestBlockEntity;)Ljava/util/Optional;",
			at = @At(
					value = "INVOKE",
					target = "Ljava/util/Optional;of(Ljava/lang/Object;)Ljava/util/Optional;")
	)
	private static Optional<Object> addChestTypeToScreenName(
			Object value,
			Operation<Optional<Object>> operation,
			ChestBlockEntity chestBlockEntity, ChestBlockEntity chestBlockEntity2
	) {
		return Optional.of(new NamedScreenHandlerFactory() {
			
			@Override
			public Text getDisplayName() {
				Block chestBlock = chestBlockEntity.getCachedState().getBlock();
				if (chestBlockEntity.hasCustomName()) {
					return chestBlockEntity.getDisplayName();
				} else if (chestBlockEntity2.hasCustomName()) {
					return chestBlockEntity2.getDisplayName();
				} else {
					if (chestBlock instanceof WoodenChestBlock woodenChest) {
							return Text.translatable("container.double_" + woodenChest.getWoodType().name() + "_chest");
					} else if (chestBlock instanceof CopperChestBlock copperChestBlock) {
						return Text.translatable("container.double_" + copperChestBlock.getOxidationLevel().name().toLowerCase() + "_copper_chest");
					}
				}
				return Text.translatable("container.chestDouble");
			}
			
			@Override
			public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
				return ((NamedScreenHandlerFactory)value).createMenu(syncId, playerInventory, player);
			}
		});
	}
}