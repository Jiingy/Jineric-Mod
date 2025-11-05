package jingy.jineric.access;

import net.minecraft.component.ComponentChanges;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;

public interface ShapedRecipeJsonBuilderAccess {

    default ShapedRecipeJsonBuilder jineric$componentChanges(ComponentChanges componentChanges) {
        throw new RuntimeException("Failed to apply jineric$offerToWithItemStack");
    }
}
