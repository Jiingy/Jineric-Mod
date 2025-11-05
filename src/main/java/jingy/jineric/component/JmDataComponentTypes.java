package jingy.jineric.component;

import jingy.jineric.base.JinericMain;
import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Codecs;

import java.util.function.UnaryOperator;

public class JmDataComponentTypes {
	public static final ComponentType<Integer> MAX_LEVEL = register(
			JinericMain.ofJineric("max_level"), builder -> builder.codec(Codecs.POSITIVE_INT).packetCodec(PacketCodecs.VAR_INT)
	);
	public static final ComponentType<Integer> LEVEL = register(
			JinericMain.ofJineric("level"), builder -> builder.codec(Codecs.NON_NEGATIVE_INT).packetCodec(PacketCodecs.VAR_INT)
	);
	
	private static <T> ComponentType<T> register(Identifier id, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
		return Registry.register(Registries.DATA_COMPONENT_TYPE, id, (builderOperator.apply(ComponentType.builder())).build());
	}
	
	public static void initDataComponentTypes() {
	}
}
