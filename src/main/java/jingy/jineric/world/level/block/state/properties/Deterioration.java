package jingy.jineric.world.level.block.state.properties;

import net.minecraft.util.StringRepresentable;

public enum Deterioration implements StringRepresentable {
    NONE("none"),
    CHIPPED("chipped"),
    CRACKED("cracked"),
    SHATTERED("shattered");

    private final String name;

    Deterioration(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
