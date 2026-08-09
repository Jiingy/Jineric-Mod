package net.jineric.jineric_mod.renderer.special;

import jingy.jineric.base.JinericMain;
import net.minecraft.client.renderer.MultiblockChestResources;
import net.minecraft.resources.Identifier;

public class JmChestSpecialRenderer {
    public static final MultiblockChestResources<Identifier> SPRUCE = createDefaultTextures("spruce");
    public static final MultiblockChestResources<Identifier> BIRCH = createDefaultTextures("birch");
    public static final MultiblockChestResources<Identifier> JUNGLE = createDefaultTextures("jungle");
    public static final MultiblockChestResources<Identifier> ACACIA = createDefaultTextures("acacia");
    public static final MultiblockChestResources<Identifier> DARK_OAK = createDefaultTextures("dark_oak");
    public static final MultiblockChestResources<Identifier> MANGROVE = createDefaultTextures("mangrove");
    public static final MultiblockChestResources<Identifier> CHERRY = createDefaultTextures("cherry");
    public static final MultiblockChestResources<Identifier> PALE_OAK = createDefaultTextures("pale_oak");
    public static final MultiblockChestResources<Identifier> POPLAR = createDefaultTextures("poplar");
    public static final MultiblockChestResources<Identifier> BAMBOO = createDefaultTextures("bamboo");
    public static final MultiblockChestResources<Identifier> CRIMSON = createDefaultTextures("crimson");
    public static final MultiblockChestResources<Identifier> WARPED = createDefaultTextures("warped");
    public static final MultiblockChestResources<Identifier> TRAPPED_SPRUCE = createDefaultTextures("trapped_spruce");
    public static final MultiblockChestResources<Identifier> TRAPPED_BIRCH = createDefaultTextures("trapped_birch");
    public static final MultiblockChestResources<Identifier> TRAPPED_JUNGLE = createDefaultTextures("trapped_jungle");
    public static final MultiblockChestResources<Identifier> TRAPPED_ACACIA = createDefaultTextures("trapped_acacia");
    public static final MultiblockChestResources<Identifier> TRAPPED_DARK_OAK = createDefaultTextures("trapped_dark_oak");
    public static final MultiblockChestResources<Identifier> TRAPPED_MANGROVE = createDefaultTextures("trapped_mangrove");
    public static final MultiblockChestResources<Identifier> TRAPPED_CHERRY = createDefaultTextures("trapped_cherry");
    public static final MultiblockChestResources<Identifier> TRAPPED_PALE_OAK = createDefaultTextures("trapped_pale_oak");
    public static final MultiblockChestResources<Identifier> TRAPPED_POPLAR = createDefaultTextures("trapped_poplar");
    public static final MultiblockChestResources<Identifier> TRAPPED_BAMBOO = createDefaultTextures("trapped_bamboo");
    public static final MultiblockChestResources<Identifier> TRAPPED_CRIMSON = createDefaultTextures("trapped_crimson");
    public static final MultiblockChestResources<Identifier> TRAPPED_WARPED = createDefaultTextures("trapped_warped");

    private static MultiblockChestResources<Identifier> createDefaultTextures(final String prefix) {
        return new MultiblockChestResources<>(
                JinericMain.ofJineric(prefix),
                JinericMain.ofJineric(prefix + "_left"),
                JinericMain.ofJineric(prefix + "_right")
        );
    }
}
