package jingy.jineric.block.entity;

import jingy.jineric.recipe.JinericRecipeTypes;
import jingy.jineric.registry.JinericBlockEntityType;
import jingy.jineric.screen.KilnScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class KilnBlockEntity extends AbstractFurnaceBlockEntity {
	private static final Text CONTAINER_NAME = Text.translatable("container.jineric.kiln");
	
	public KilnBlockEntity(BlockPos pos, BlockState state) {
		super(JinericBlockEntityType.KILN, pos, state, JinericRecipeTypes.KILN_FIRING);
	}
	
	@Override
	protected Text getContainerName() {
		return CONTAINER_NAME;
	}
	
	@Override
	protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
		return new KilnScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
	}
}
