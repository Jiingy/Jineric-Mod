package jingy.jineric.references;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.WeatheringCopperCollection;

public class JmBlockItemIds {
    public static final WeatheringCopperCollection<BlockItemId> CUT_COPPER_WALL = createSimpleCopper("cut_copper_wall");
    public static final BlockItemId GRASS_BLOCK = create("grass_block");
    public static final BlockItemId SPRUCE_CHEST = create("spruce_chest");
    public static final BlockItemId BIRCH_CHEST = create("birch_chest");
    public static final BlockItemId JUNGLE_CHEST = create("jungle_chest");
    public static final BlockItemId ACACIA_CHEST = create("acacia_chest");
    public static final BlockItemId DARK_OAK_CHEST = create("dark_oak_chest");
    public static final BlockItemId MANGROVE_CHEST = create("mangrove_chest");
    public static final BlockItemId CHERRY_CHEST = create("cherry_chest");
    public static final BlockItemId BAMBOO_CHEST = create("bamboo_chest");
    public static final BlockItemId PALE_OAK_CHEST = create("pale_oak_chest");
    public static final BlockItemId POPLAR_CHEST = create("poplar_chest");
    public static final BlockItemId CRIMSON_CHEST = create("crimson_chest");
    public static final BlockItemId WARPED_CHEST = create("warped_chest");
    public static final BlockItemId TRAPPED_SPRUCE_CHEST = create("trapped_spruce_chest");
    public static final BlockItemId TRAPPED_BIRCH_CHEST = create("trapped_birch_chest");
    public static final BlockItemId TRAPPED_JUNGLE_CHEST = create("trapped_jungle_chest");
    public static final BlockItemId TRAPPED_ACACIA_CHEST = create("trapped_acacia_chest");
    public static final BlockItemId TRAPPED_DARK_OAK_CHEST = create("trapped_dark_oak_chest");
    public static final BlockItemId TRAPPED_MANGROVE_CHEST = create("trapped_mangrove_chest");
    public static final BlockItemId TRAPPED_CHERRY_CHEST = create("trapped_cherry_chest");
    public static final BlockItemId TRAPPED_BAMBOO_CHEST = create("trapped_bamboo_chest");
    public static final BlockItemId TRAPPED_PALE_OAK_CHEST = create("trapped_pale_oak_chest");
    public static final BlockItemId TRAPPED_POPLAR_CHEST = create("trapped_poplar_chest");
    public static final BlockItemId TRAPPED_CRIMSON_CHEST = create("trapped_crimson_chest");
    public static final BlockItemId TRAPPED_WARPED_CHEST = create("trapped_warped_chest");
    public static final BlockItemId SPRUCE_LADDER = create("spruce_ladder");
    public static final BlockItemId BIRCH_LADDER = create("birch_ladder");
    public static final BlockItemId JUNGLE_LADDER = create("jungle_ladder");
    public static final BlockItemId ACACIA_LADDER = create("acacia_ladder");
    public static final BlockItemId DARK_OAK_LADDER = create("dark_oak_ladder");
    public static final BlockItemId MANGROVE_LADDER = create("mangrove_ladder");
    public static final BlockItemId CHERRY_LADDER = create("cherry_ladder");
    public static final BlockItemId BAMBOO_LADDER = create("bamboo_ladder");
    public static final BlockItemId PALE_OAK_LADDER = create("pale_oak_ladder");
    public static final BlockItemId POPLAR_LADDER = create("poplar_ladder");
    public static final BlockItemId CRIMSON_LADDER = create("crimson_ladder");
    public static final BlockItemId WARPED_LADDER = create("warped_ladder");
    public static final BlockItemId SPRUCE_BOOKSHELF = create("spruce_bookshelf");
    public static final BlockItemId BIRCH_BOOKSHELF = create("birch_bookshelf");
    public static final BlockItemId JUNGLE_BOOKSHELF = create("jungle_bookshelf");
    public static final BlockItemId ACACIA_BOOKSHELF = create("acacia_bookshelf");
    public static final BlockItemId DARK_OAK_BOOKSHELF = create("dark_oak_bookshelf");
    public static final BlockItemId MANGROVE_BOOKSHELF = create("mangrove_bookshelf");
    public static final BlockItemId CHERRY_BOOKSHELF = create("cherry_bookshelf");
    public static final BlockItemId BAMBOO_BOOKSHELF = create("bamboo_bookshelf");
    public static final BlockItemId PALE_OAK_BOOKSHELF = create("pale_oak_bookshelf");
    public static final BlockItemId POPLAR_BOOKSHELF = create("poplar_bookshelf");
    public static final BlockItemId CRIMSON_BOOKSHELF = create("crimson_bookshelf");
    public static final BlockItemId WARPED_BOOKSHELF = create("warped_bookshelf");
    public static final BlockItemId REFINERY = create("refinery");
    public static final BlockItemId REDSTONE_LANTERN = create("redstone_lantern");
    public static final BlockItemId BLAZE_ROD_BLOCK = create("blaze_rod_block");
    public static final BlockItemId EGG_BLOCK = create("egg_block");
    public static final BlockItemId SUGAR_BLOCK = create("sugar_block");
    public static final BlockItemId PRISMARINE_CRYSTAL_BLOCK = create("prismarine_crystal_block");
    public static final BlockItemId BONE_MEAL_BLOCK = create("bone_meal_block");
    public static final BlockItemId ROTTEN_FLESH_BLOCK = create("rotten_flesh_block");
    public static final BlockItemId STICK_BLOCK = create("stick_block");
    public static final BlockItemId PAPER_BLOCK = create("paper_block");
    public static final BlockItemId FLINT_BLOCK = create("flint_block");
    public static final BlockItemId CHARCOAL_BLOCK = create("charcoal_block");
    public static final BlockItemId STONE_BRICK_PILLAR = create("stone_brick_pillar");
    public static final BlockItemId TUFF_BRICK_PILLAR = create("tuff_brick_pillar");
    public static final BlockItemId DRIPSTONE_BRICK_PILLAR = create("dripstone_brick_pillar");
    public static final BlockItemId SNOW_BRICK_WALL  = create("snow_brick_wall");
    public static final BlockItemId SNOW_WALL = create("snow_wall");
    public static final BlockItemId PACKED_ICE_STAIRS = create("packed_ice_stairs");
    public static final BlockItemId PACKED_ICE_SLAB = create("packed_ice_slab");
    public static final BlockItemId PACKED_ICE_WALL = create("packed_ice_wall");
    public static final BlockItemId REDSTONE_CAMPFIRE = create("redstone_campfire");
    public static final BlockItemId SOUL_JACK_O_LANTERN = create("soul_jack_o_lantern");

    private static WeatheringCopperCollection<BlockItemId> createSimpleCopper(final String baseName) {
        return WeatheringCopperCollection.prefixWithState(WeatheringCopperCollection.create(baseName)).map(JmBlockItemIds::create);
    }

    public static BlockItemId create(final Identifier blockId, final Identifier itemId) {
        return new BlockItemId(ResourceKey.create(Registries.BLOCK, blockId), ResourceKey.create(Registries.ITEM, itemId));
    }

    public static BlockItemId create(final String name) {
        Identifier id = JinericMain.ofJineric(name);
        return create(id, id);
    }
}
