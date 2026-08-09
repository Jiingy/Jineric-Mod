package jingy.jineric.world.gen.feature.entity;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

public class JmEntityTypeIds {

    private static ResourceKey<EntityType<?>> create(final String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, JinericMain.ofJineric(name));
    }
}
