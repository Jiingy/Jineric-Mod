package jingy.jineric.access;

import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.data.recipes.ShapedRecipeBuilder;

public interface ShapedRecipeJsonBuilderAccess {
    default ShapedRecipeBuilder jineric$componentChanges(DataComponentPatch componentChanges) {
        throw new RuntimeException("Failed to apply jineric$componentChanges");
    }
}
