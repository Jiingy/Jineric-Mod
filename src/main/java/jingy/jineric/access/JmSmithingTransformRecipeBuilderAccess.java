package jingy.jineric.access;

import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;

public interface JmSmithingTransformRecipeBuilderAccess {
    default SmithingTransformRecipeBuilder jineric$componentChanges(DataComponentPatch componentChanges) {
        throw new RuntimeException("Failed to apply jineric$componentChanges");
    }
}
