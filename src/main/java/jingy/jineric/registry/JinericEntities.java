package jingy.jineric.registry;

import jingy.jineric.entity.passive.manxloaghtan.ManxLoaghtan;
import jingy.jineric.util.RegistryObject;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class JinericEntities {
   public static Set<RegistryObject<EntityType<?>>> ENTITIES = new HashSet<>();

    public static final EntityType<ManxLoaghtan> MANX_LOAGHTAN = Registry.register(
            Registry.ENTITY_TYPE, new Identifier("jineric", "manx_loaghtan"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ManxLoaghtan::new).dimensions(EntityDimensions.fixed(0.9F, 1.3F)).build()
   );

   public static Collection<RegistryObject<EntityType<?>>> bootStrap() {
      return ENTITIES;
   }
}
