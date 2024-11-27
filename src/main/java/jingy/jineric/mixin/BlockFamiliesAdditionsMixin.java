package jingy.jineric.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyReceiver;
import jingy.jineric.block.JinericBlocks;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BlockFamilies.class)
public abstract class BlockFamiliesAdditionsMixin {
   //TODO: .polished() REMOVED FROM CUT SANDSTONE AND RED SANDSTONE DUE TO ISSUES WITH STONECUTTING RECIPE GEN

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "STONE", field = "Lnet/minecraft/data/family/BlockFamilies;STONE:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("STONE = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyStoneFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.STONE_WALL)
              // MIGHT BREAK RECIPE OF STONE BRICKS
              .polished(JinericBlocks.POLISHED_STONE);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "QUARTZ_BLOCK", field = "Lnet/minecraft/data/family/BlockFamilies;QUARTZ_BLOCK:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("QUARTZ_BLOCK = @(?.build())")
   @ModifyReceiver(method = "<clinit>", at = @At("MIXINEXTRAS:EXPRESSION"))
   private static BlockFamily.Builder modifyQuartzFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.QUARTZ_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "SMOOTH_QUARTZ", field = "Lnet/minecraft/data/family/BlockFamilies;SMOOTH_QUARTZ:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("SMOOTH_QUARTZ = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifySmoothQuartzFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.SMOOTH_QUARTZ_WALL);
   }

   // TODO: NEED TO MIXIN TO createFenceRecipe() BECAUSE FENCE RECIPES ARE HARD CODED FOR SOME REASON
//   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
//   @Definition(id = "RED_NETHER_BRICK", field = "Lnet/minecraft/data/family/BlockFamilies;RED_NETHER_BRICK:Lnet/minecraft/data/family/BlockFamily;")
//   @Expression("RED_NETHER_BRICK = @(?.build())")
//   @ModifyReceiver(
//           method = "<clinit>",
//           at = @At("MIXINEXTRAS:EXPRESSION")
//   )
//   private static BlockFamily.Builder modifyRedNetherBRickFamily(BlockFamily.Builder instance) {
//      return instance.wall(JinericBlocks.RED_NETHER_BRICK_FENCE);
//   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "PRISMARINE_BRICK", field = "Lnet/minecraft/data/family/BlockFamilies;PRISMARINE_BRICK:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("PRISMARINE_BRICK = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyPrismarineBrickFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.PRISMARINE_BRICK_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "DARK_PRISMARINE", field = "Lnet/minecraft/data/family/BlockFamilies;DARK_PRISMARINE:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("DARK_PRISMARINE = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyDarkPrismarineFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.DARK_PRISMARINE_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "POLISHED_ANDESITE", field = "Lnet/minecraft/data/family/BlockFamilies;POLISHED_ANDESITE:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("POLISHED_ANDESITE = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyPolishedAndesiteFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.POLISHED_ANDESITE_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "POLISHED_DIORITE", field = "Lnet/minecraft/data/family/BlockFamilies;POLISHED_DIORITE:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("POLISHED_DIORITE = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyPolishedDioriteFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.POLISHED_DIORITE_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "POLISHED_GRANITE", field = "Lnet/minecraft/data/family/BlockFamilies;POLISHED_GRANITE:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("POLISHED_GRANITE = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyPolishedGraniteFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.POLISHED_GRANITE_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "SMOOTH_SANDSTONE", field = "Lnet/minecraft/data/family/BlockFamilies;SMOOTH_SANDSTONE:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("SMOOTH_SANDSTONE = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifySmoothSandstoneFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.SMOOTH_SANDSTONE_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "CUT_SANDSTONE", field = "Lnet/minecraft/data/family/BlockFamilies;CUT_SANDSTONE:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("CUT_SANDSTONE = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyCutSandstoneFamily(BlockFamily.Builder instance) {
      return instance.stairs(JinericBlocks.CUT_SANDSTONE_STAIRS).wall(JinericBlocks.CUT_SANDSTONE_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "SMOOTH_RED_SANDSTONE", field = "Lnet/minecraft/data/family/BlockFamilies;SMOOTH_RED_SANDSTONE:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("SMOOTH_RED_SANDSTONE = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifySmoothRedSandstoneFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.SMOOTH_RED_SANDSTONE_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "CUT_RED_SANDSTONE", field = "Lnet/minecraft/data/family/BlockFamilies;CUT_RED_SANDSTONE:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("CUT_RED_SANDSTONE = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyCutRedSandstoneFamily(BlockFamily.Builder instance) {
      return instance.stairs(JinericBlocks.CUT_RED_SANDSTONE_STAIRS).wall(JinericBlocks.CUT_RED_SANDSTONE_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "TUFF_BRICK", field = "Lnet/minecraft/data/family/BlockFamilies;TUFF_BRICK:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("TUFF_BRICK = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyTuffBrickFamily(BlockFamily.Builder instance) {
      return instance.cracked(JinericBlocks.CRACKED_TUFF_BRICKS);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "PURPUR", field = "Lnet/minecraft/data/family/BlockFamilies;PURPUR:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("PURPUR = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modify_Family(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.PURPUR_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "CUT_COPPER", field = "Lnet/minecraft/data/family/BlockFamilies;CUT_COPPER:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("CUT_COPPER = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyCutCopperFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.CUT_COPPER_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "EXPOSED_CUT_COPPER", field = "Lnet/minecraft/data/family/BlockFamilies;EXPOSED_CUT_COPPER:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("EXPOSED_CUT_COPPER = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyExposedCutCopperFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.EXPOSED_CUT_COPPER_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "WEATHERED_CUT_COPPER", field = "Lnet/minecraft/data/family/BlockFamilies;WEATHERED_CUT_COPPER:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("WEATHERED_CUT_COPPER = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyWeatheredCutCopperFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.WEATHERED_CUT_COPPER_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "OXIDIZED_CUT_COPPER", field = "Lnet/minecraft/data/family/BlockFamilies;OXIDIZED_CUT_COPPER:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("OXIDIZED_CUT_COPPER = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyOxidizedCutCopperFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.OXIDIZED_CUT_COPPER_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "WAXED_CUT_COPPER", field = "Lnet/minecraft/data/family/BlockFamilies;WAXED_CUT_COPPER:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("WAXED_CUT_COPPER = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyWaxedCutCopperFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.WAXED_CUT_COPPER_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "WAXED_EXPOSED_CUT_COPPER", field = "Lnet/minecraft/data/family/BlockFamilies;WAXED_EXPOSED_CUT_COPPER:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("WAXED_EXPOSED_CUT_COPPER = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyWaxedExposedCutCopperFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.WAXED_EXPOSED_CUT_COPPER_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "WAXED_WEATHERED_CUT_COPPER", field = "Lnet/minecraft/data/family/BlockFamilies;WAXED_WEATHERED_CUT_COPPER:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("WAXED_WEATHERED_CUT_COPPER = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyWaxedWeatheredCutCopperFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.WAXED_WEATHERED_CUT_COPPER_WALL);
   }

   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
   @Definition(id = "WAXED_OXIDIZED_CUT_COPPER", field = "Lnet/minecraft/data/family/BlockFamilies;WAXED_OXIDIZED_CUT_COPPER:Lnet/minecraft/data/family/BlockFamily;")
   @Expression("WAXED_OXIDIZED_CUT_COPPER = @(?.build())")
   @ModifyReceiver(
           method = "<clinit>",
           at = @At("MIXINEXTRAS:EXPRESSION")
   )
   private static BlockFamily.Builder modifyWaxedOxidizedCutCopperFamily(BlockFamily.Builder instance) {
      return instance.wall(JinericBlocks.WAXED_OXIDIZED_CUT_COPPER_WALL);
   }

//   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
//   @Expression("COPPER = @(?.build())")
//   @ModifyReceiver(
//           method = "<clinit>",
//           at = @At("MIXINEXTRAS:EXPRESSION")
//   )
//   private static BlockFamily.Builder modifyCopperFamily(BlockFamily.Builder instance) {
//      return instance.wall(JinericBlocks.COPPER);
//   }

//   @Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
//   @Expression(" = @(?.build())")
//   @ModifyReceiver(
//           method = "<clinit>",
//           at = @At("MIXINEXTRAS:EXPRESSION")
//   )
//   private static BlockFamily.Builder modify_Family(BlockFamily.Builder instance) {
//      return instance.wall(JinericBlocks.);
//   }
}
