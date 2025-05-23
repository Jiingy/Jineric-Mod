package jingy.jineric.mixin.fix;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyReceiver;
import jingy.jineric.block.JinericBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BlockFamilies.class)
public abstract class BlockFamilyModificationMixin {
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "OAK", field = "Lnet/minecraft/data/family/BlockFamilies;OAK:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("OAK = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyOakFamily(BlockFamily.Builder instance) {
		return instance
				.bookshelf$jineric(Blocks.BOOKSHELF)
				.ladder$jineric(Blocks.LADDER);
	}
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "BIRCH", field = "Lnet/minecraft/data/family/BlockFamilies;BIRCH:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("BIRCH = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyBirchFamily(BlockFamily.Builder instance) {
		return instance
				.bookshelf$jineric(JinericBlocks.BIRCH_BOOKSHELF)
				.chest$jineric(JinericBlocks.BIRCH_CHEST)
				.trappedChest$jineric(JinericBlocks.TRAPPED_BIRCH_CHEST)
				.ladder$jineric(JinericBlocks.BIRCH_LADDER);
	}
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "SPRUCE", field = "Lnet/minecraft/data/family/BlockFamilies;SPRUCE:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("SPRUCE = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifySpruceFamily(BlockFamily.Builder instance) {
		return instance
				.bookshelf$jineric(JinericBlocks.SPRUCE_BOOKSHELF)
				.chest$jineric(JinericBlocks.SPRUCE_CHEST)
				.trappedChest$jineric(JinericBlocks.TRAPPED_SPRUCE_CHEST)
				.ladder$jineric(JinericBlocks.SPRUCE_LADDER);
	}
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "DARK_OAK", field = "Lnet/minecraft/data/family/BlockFamilies;DARK_OAK:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("DARK_OAK = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyDarkOakFamily(BlockFamily.Builder instance) {
		return instance
				.bookshelf$jineric(JinericBlocks.DARK_OAK_BOOKSHELF)
				.chest$jineric(JinericBlocks.DARK_OAK_CHEST)
				.trappedChest$jineric(JinericBlocks.TRAPPED_DARK_OAK_CHEST)
				.ladder$jineric(JinericBlocks.DARK_OAK_LADDER);
	}
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "ACACIA", field = "Lnet/minecraft/data/family/BlockFamilies;ACACIA:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("ACACIA = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyAcaciaFamily(BlockFamily.Builder instance) {
		return instance
				.bookshelf$jineric(JinericBlocks.ACACIA_BOOKSHELF)
				.chest$jineric(JinericBlocks.ACACIA_CHEST)
				.trappedChest$jineric(JinericBlocks.TRAPPED_ACACIA_CHEST)
				.ladder$jineric(JinericBlocks.ACACIA_LADDER);
	}
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "JUNGLE", field = "Lnet/minecraft/data/family/BlockFamilies;JUNGLE:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("JUNGLE = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyJungleFamily(BlockFamily.Builder instance) {
		return instance
				.bookshelf$jineric(JinericBlocks.JUNGLE_BOOKSHELF)
				.chest$jineric(JinericBlocks.JUNGLE_CHEST)
				.trappedChest$jineric(JinericBlocks.TRAPPED_JUNGLE_CHEST)
				.ladder$jineric(JinericBlocks.JUNGLE_LADDER);
	}
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "BAMBOO", field = "Lnet/minecraft/data/family/BlockFamilies;BAMBOO:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("BAMBOO = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyBambooFamily(BlockFamily.Builder instance) {
		return instance
				.bookshelf$jineric(JinericBlocks.BAMBOO_BOOKSHELF)
				.chest$jineric(JinericBlocks.BAMBOO_CHEST)
				.trappedChest$jineric(JinericBlocks.TRAPPED_BAMBOO_CHEST)
				.ladder$jineric(JinericBlocks.BAMBOO_LADDER);
	}
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "MANGROVE", field = "Lnet/minecraft/data/family/BlockFamilies;MANGROVE:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("MANGROVE = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyMangroveFamily(BlockFamily.Builder instance) {
		return instance
				.bookshelf$jineric(JinericBlocks.MANGROVE_BOOKSHELF)
				.chest$jineric(JinericBlocks.MANGROVE_CHEST)
				.trappedChest$jineric(JinericBlocks.TRAPPED_MANGROVE_CHEST)
				.ladder$jineric(JinericBlocks.MANGROVE_LADDER);
	}
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "CHERRY", field = "Lnet/minecraft/data/family/BlockFamilies;CHERRY:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("CHERRY = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyCherryFamily(BlockFamily.Builder instance) {
		return instance
				.bookshelf$jineric(JinericBlocks.CHERRY_BOOKSHELF)
				.chest$jineric(JinericBlocks.CHERRY_CHEST)
				.trappedChest$jineric(JinericBlocks.TRAPPED_CHERRY_CHEST)
				.ladder$jineric(JinericBlocks.CHERRY_LADDER);
	}
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "WARPED", field = "Lnet/minecraft/data/family/BlockFamilies;WARPED:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("WARPED = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyWarpedFamily(BlockFamily.Builder instance) {
		return instance
				.bookshelf$jineric(JinericBlocks.WARPED_BOOKSHELF)
				.chest$jineric(JinericBlocks.WARPED_CHEST)
				.trappedChest$jineric(JinericBlocks.TRAPPED_WARPED_CHEST)
				.ladder$jineric(JinericBlocks.WARPED_LADDER);
	}
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "CRIMSON", field = "Lnet/minecraft/data/family/BlockFamilies;CRIMSON:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("CRIMSON = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyCrimsonFamily(BlockFamily.Builder instance) {
		return instance
				.bookshelf$jineric(JinericBlocks.CRIMSON_BOOKSHELF)
				.chest$jineric(JinericBlocks.CRIMSON_CHEST)
				.trappedChest$jineric(JinericBlocks.TRAPPED_CRIMSON_CHEST)
				.ladder$jineric(JinericBlocks.CRIMSON_LADDER);
	}
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "STONE", field = "Lnet/minecraft/data/family/BlockFamilies;STONE:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("STONE = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyStoneFamily(BlockFamily.Builder instance) {
		return instance.wall(JinericBlocks.STONE_WALL);
				// MIGHT BREAK RECIPE OF STONE BRICKS
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
		return instance
				.stairs(JinericBlocks.CUT_SANDSTONE_STAIRS)
				.wall(JinericBlocks.CUT_SANDSTONE_WALL)
				.noGenerateModels();
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
		return instance
				.stairs(JinericBlocks.CUT_RED_SANDSTONE_STAIRS)
				.wall(JinericBlocks.CUT_RED_SANDSTONE_WALL)
				.noGenerateModels();
	}
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "PURPUR", field = "Lnet/minecraft/data/family/BlockFamilies;PURPUR:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("PURPUR = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyPurPurFamily(BlockFamily.Builder instance) {
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
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "RED_NETHER_BRICK", field = "Lnet/minecraft/data/family/BlockFamilies;RED_NETHER_BRICK:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("RED_NETHER_BRICK = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyRedNetherBrickFamily(BlockFamily.Builder instance) {
		return instance.customFence(JinericBlocks.RED_NETHER_BRICK_FENCE);
	}
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "STONE_BRICK", field = "Lnet/minecraft/data/family/BlockFamilies;STONE_BRICK:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("STONE_BRICK = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyStoneBrickFamily(BlockFamily.Builder instance) {
		return instance.pillar$jineric(JinericBlocks.STONE_BRICK_PILLAR);
	}
	
	@Definition(id = "build", method = "Lnet/minecraft/data/family/BlockFamily$Builder;build()Lnet/minecraft/data/family/BlockFamily;")
	@Definition(id = "TUFF_BRICK", field = "Lnet/minecraft/data/family/BlockFamilies;TUFF_BRICK:Lnet/minecraft/data/family/BlockFamily;")
	@Expression("TUFF_BRICK = @(?.build())")
	@ModifyReceiver(
			method = "<clinit>",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static BlockFamily.Builder modifyTuffBrickFamily(BlockFamily.Builder instance) {
		return instance.pillar$jineric(JinericBlocks.TUFF_BRICK_PILLAR);
	}
}
