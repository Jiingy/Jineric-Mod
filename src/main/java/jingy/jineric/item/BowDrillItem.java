package jingy.jineric.item;

import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class BowDrillItem extends FlintAndSteelItem {
    public BowDrillItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        return super.useOnBlock(context) == ActionResult.SUCCESS ? this.breakBowDrill(context) : ActionResult.FAIL;
    }

    public ActionResult breakBowDrill(ItemUsageContext context) {
        ItemStack itemStack = context.getStack();
        World world = context.getWorld();
        itemStack.decrement(itemStack.getCount());
        return ActionResult.SUCCESS;
    }
}
