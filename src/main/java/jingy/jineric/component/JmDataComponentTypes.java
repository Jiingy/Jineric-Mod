package jingy.jineric.component;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import java.util.function.UnaryOperator;

public class JmDataComponentTypes {

	private static <T> DataComponentType<T> register(Identifier id, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
		return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, id, (builderOperator.apply(DataComponentType.builder())).build());
	}
	
	public static void initDataComponentTypes() {
	}
}
