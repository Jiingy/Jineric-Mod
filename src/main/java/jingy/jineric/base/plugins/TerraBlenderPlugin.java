package jingy.jineric.base.plugins;

import jingy.jineric.base.JinericMain;
import jingy.jineric.world.biome.WistfulForest;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class TerraBlenderPlugin implements TerraBlenderApi {

   @Override
   public void onTerraBlenderInitialized() {
	   Regions.register(new WistfulForest(JinericMain.ofJineric("wistful_forest"), 1));
	   Regions.register(new WistfulForest(JinericMain.ofJineric("wistful_flower_forest"), 1));
   }
}
