package jingy.jineric.registry;

import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtan;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JinericEntities {

    public static final EntityType<ManxLoaghtan> MANX_LOAGHTAN = Registry.register(
            Registries.ENTITY_TYPE, new Identifier("jineric", "manx_loaghtan"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ManxLoaghtan::new).dimensions(EntityDimensions.fixed(0.9F, 1.3F)).build()
   );
}
