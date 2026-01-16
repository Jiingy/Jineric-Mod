package jingy.jineric.access;

import net.minecraft.component.ComponentChanges;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;

public interface SmithingTransformRecipeJsonBuilderAccess {
    default SmithingTransformRecipeJsonBuilder jineric$componentChanges(ComponentChanges componentChanges) {
        throw new RuntimeException("Failed to apply jineric$componentChanges");
    }
}
