package jingy.jineric.base;

import jingy.jineric.entity.JinericPaintingMotive;
import jingy.jineric.entity.JinericStatusEffects;
import jingy.jineric.potion.JinericPotions;
import jingy.jineric.recipe.JinericRecipeType;
import jingy.jineric.recipe.RefiningRecipe;
import jingy.jineric.registry.*;
import jingy.jineric.screen.JinericScreenHandlerType;
import jingy.jineric.util.RegistryObject;
import jingy.jineric.world.JinericSurfaceRules;
import jingy.jineric.world.JmDefaultOverworldRegion;
import jingy.jineric.world.biome.JinericBiomes;
import jingy.jineric.world.feature.JinericConfiguredFeatures;
import jingy.jineric.world.feature.JinericTreeConfiguredFeatures;
import jingy.jineric.world.gen.JinericWorldGen;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

import java.util.Collection;

public class JinericMain implements ModInitializer, TerraBlenderApi {

	public static final boolean BIOMES = true;
	public static final boolean SIGNS = false;
	//MOD
	public static final Logger LOGGER = LogManager.getLogger("Jineric Mod");
	public static final String MOD_ID = "jineric";
	public static Identifier id(String path) {
	return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
	LOGGER.info("Jineric Mod Main - Starting initialization");
		//MUST BE AT TOP
		JinericTreeConfiguredFeatures.registerTreeConfiguredFeatures();

		JinericSurfaceRules.registerSurfaceRules();
		JmDefaultOverworldRegion.init();
		registryBootStrap();
		JinericRegistries.registerJinericMod();
		JinericPaintingMotive.init();
		JinericBlocks.blockRegistry();
		JinericItems.itemRegistry();
		JinericItemGroups.init();
//		JinericSounds.initializeSounds();
		JinericStatusEffects.RegisterEffects();
		JinericPotions.registerPotions();
		JinericConfiguredFeatures.getDefaultConfiguredFeature();
		JinericWorldGen.generateJinericWorldGen();
		JinericBlockEntityType.registerBlockEntities();
		RefiningRecipe.registerRefiningRecipe();
		JinericRecipeType.register();
		JinericScreenHandlerType.registerScreenHandlers();

		System.out.println("Jineric Mod Main - Finished initialization");
	}

	private void registryBootStrap() {
		register(BuiltinRegistries.BIOME, JinericBiomes.bootStrap());
		register(Registry.ENTITY_TYPE, JinericEntities.bootStrap());
	}

	private static <T> void register(Registry<T> registry, Collection<RegistryObject<T>> objects) {
		for (RegistryObject<T> object : objects) {
			Registry.register(registry, createLocation(object.id()), object.object());
		}
		JinericMain.LOGGER.info("Jineric registered: " + registry.toString());
	}

	@Override
	public void onTerraBlenderInitialized() {
		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, JinericMain.MOD_ID, JinericSurfaceRules.OVERWORLD_SURFACE_RULES);
		Regions.register(new JmDefaultOverworldRegion(new Identifier(MOD_ID, "overworld"), 2));
	}

	public static Identifier createLocation(String path) {
		return new Identifier(MOD_ID, path);
	}
}
