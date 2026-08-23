package jingy.jineric.component;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs;

import java.util.function.UnaryOperator;

public class JmDataComponentTypes {
	public static final DataComponentType<Integer> MAX_LEVEL = register(
			JinericMain.ofJineric("max_level"), builder -> builder.persistent(ExtraCodecs.POSITIVE_INT).networkSynchronized(ByteBufCodecs.VAR_INT)
	);
	public static final DataComponentType<Integer> LEVEL = register(
			JinericMain.ofJineric("level"), builder -> builder.persistent(ExtraCodecs.NON_NEGATIVE_INT).networkSynchronized(ByteBufCodecs.VAR_INT)
	);
	
	private static <T> DataComponentType<T> register(Identifier id, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
		return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, id, (builderOperator.apply(DataComponentType.builder())).build());
	}
	
	public static void initDataComponentTypes() {
	}
}
