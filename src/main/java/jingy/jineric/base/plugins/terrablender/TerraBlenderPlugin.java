package jingy.jineric.base.plugins.terrablender;

import jingy.jineric.base.JinericMain;
import jingy.jineric.world.biome.JinericForestRegion;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class TerraBlenderPlugin implements TerraBlenderApi {

   @Override
   public void onTerraBlenderInitialized() {
	   SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, JinericMain.MOD_ID, JinericMaterialRules.makeRules());
	   Regions.register(new JinericForestRegion(JinericMain.ofJineric("overworld_region"), 1));
   }
}
