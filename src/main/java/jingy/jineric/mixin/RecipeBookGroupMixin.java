package jingy.jineric.mixin;

import com.chocohead.mm.api.ClassTinkerers;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import jingy.jineric.recipe.JinericRecipeBookGroup;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.recipebook.RecipeBookGroup;
import net.minecraft.recipe.book.RecipeBookCategory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Map;

import static net.minecraft.client.recipebook.RecipeBookGroup.*;

@Mixin(RecipeBookGroup.class)
public abstract class RecipeBookGroupMixin {

   private static final RecipeBookGroup JINERIC_REFINERY_SEARCH = ClassTinkerers.getEnum(RecipeBookGroup.class, "JINERIC_REFINERY_SEARCH");
   private static final RecipeBookGroup JINERIC_REFINERY_BUILDING = ClassTinkerers.getEnum(RecipeBookGroup.class, "JINERIC_REFINERY_BUILDING");
   private static final RecipeBookGroup JINERIC_REFINERY_MISC = ClassTinkerers.getEnum(RecipeBookGroup.class, "JINERIC_REFINERY_MISC");

   @Final
   @Shadow private static RecipeBookGroup CRAFTING_SEARCH;
   @Final
   @Shadow private static RecipeBookGroup FURNACE_SEARCH;
   @Final
   @Shadow private static RecipeBookGroup BLAST_FURNACE_SEARCH;
   @Final
   @Shadow private static RecipeBookGroup SMOKER_SEARCH;
   private static final RecipeBookCategory JINERIC_REFINERY = ClassTinkerers.getEnum(RecipeBookCategory.class, "JINERIC_REFINERY");

   @Shadow
   @Mutable
   @Final
   private static Map<RecipeBookGroup, List<RecipeBookGroup>> SEARCH_MAP;

   static {
      if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
         SEARCH_MAP = ImmutableMap.of(
                 CRAFTING_SEARCH, ImmutableList.of(CRAFTING_EQUIPMENT, CRAFTING_BUILDING_BLOCKS, CRAFTING_MISC, CRAFTING_REDSTONE),
                 FURNACE_SEARCH, ImmutableList.of(FURNACE_FOOD, FURNACE_BLOCKS, FURNACE_MISC),
                 BLAST_FURNACE_SEARCH, ImmutableList.of(BLAST_FURNACE_BLOCKS, BLAST_FURNACE_MISC),
                 SMOKER_SEARCH, ImmutableList.of(SMOKER_FOOD),
                 JINERIC_REFINERY_SEARCH, ImmutableList.of(JINERIC_REFINERY_BUILDING, JINERIC_REFINERY_MISC)
         );
      }
   }

   @Inject(method = "getGroups", at = @At("HEAD"), cancellable = true)
   private static void jineric$checkForRefinery(RecipeBookCategory category, CallbackInfoReturnable<List<RecipeBookGroup>> cir) {
      if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
         if (category == JINERIC_REFINERY) {
            cir.setReturnValue(JinericRecipeBookGroup.JINERIC_REFINERY);
         }
      }
   }
}
