package jingy.jineric.base.injected_interfaces;

import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;

//TODO: 26.2 - Probably useless now
public interface JmSmithingTransformRecipeBuilderAccess {
    default SmithingTransformRecipeBuilder jineric$componentChanges(DataComponentPatch componentChanges) {
        throw new RuntimeException("Failed to apply jineric$componentChanges");
    }
}
