package net.jineric.jineric_mod.data.generation;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;

public class JinericModPackModelGenerator extends FabricModelProvider {
	public JinericModPackModelGenerator(FabricPackOutput output) {
		super(output);
	}
	
	@Override
	public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
	}
	
	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {
	}
}
