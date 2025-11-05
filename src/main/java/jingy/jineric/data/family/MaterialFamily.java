package jingy.jineric.data.family;

import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;

public class MaterialFamily {
	private EquipmentFamily equipmentFamily;
	private BlockFamily blockFamily;
	
	public static class Builder {
		MaterialFamily materialFamily;
		
		public Builder() {
			this.materialFamily = new MaterialFamily();
		}
		
		public Builder equipmentFamily(EquipmentFamily equipmentFamily) {
			this.materialFamily.equipmentFamily = equipmentFamily;
			return this;
		}
		
		public Builder blockFamily(BlockFamily blockFamily) {
			this.materialFamily.blockFamily = blockFamily;
			return this;
		}
		
		public MaterialFamily build() {
			return new MaterialFamily();
		}
	}
	
	public static class MaterialFamilies {
		
		public static final MaterialFamily OAK = register()
				.equipmentFamily(EquipmentFamilies.WOODEN)
				.blockFamily(BlockFamilies.OAK)
				.build();
		
		public static Builder register() {
			Builder builder = new Builder();
			return builder;
		}
	}
}
