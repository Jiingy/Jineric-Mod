package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtanEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class JinericEntities {

    public static final EntityType<ManxLoaghtanEntity> MANX_LOAGHTAN = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(JinericMain.MOD_ID, "manx_loaghtan"),
            FabricEntityType.Builder.createLiving(
                    ManxLoaghtanEntity::new,
                    SpawnGroup.CREATURE,
                    UnaryOperator.identity()
            )
                    .dimensions(0.9F, 1.3F)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(JinericMain.MOD_ID, "manx_loaghtan"))
            )
    );
}
