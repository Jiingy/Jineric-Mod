package jingy.jineric.data.generators;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class JinericModPackModelGenerator extends FabricModelProvider {
   public JinericModPackModelGenerator(FabricDataOutput output) {
      super(output);
   }

   @Override
   public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
   }

   @Override
   public void generateItemModels(ItemModelGenerator itemModelGenerator) {
   }
}
