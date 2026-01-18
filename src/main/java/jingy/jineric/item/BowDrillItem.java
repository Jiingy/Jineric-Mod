package jingy.jineric.item;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class BowDrillItem extends FlintAndSteelItem {
    public BowDrillItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return super.useOn(context) == InteractionResult.SUCCESS ? this.breakBowDrill(context) : InteractionResult.FAIL;
    }

    public InteractionResult breakBowDrill(UseOnContext context) {
        ItemStack itemStack = context.getItemInHand();
        Level world = context.getLevel();
        itemStack.shrink(itemStack.getCount());
        return InteractionResult.SUCCESS;
    }
}
