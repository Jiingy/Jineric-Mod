
package jingy.jineric.screen;


/*
public class JinericScreenHandlerType<T extends ScreenHandler> {


	public static final JinericScreenHandlerType<ShulkerChestScreenHandler> SHULKER_CHEST = register("shulker_chest", ShulkerChestScreenHandler::new);
	public static final JinericScreenHandlerType<GenericContainerScreenHandler> JINERIC_GENERIC_9X9 = register("generic_9x9", JinericGenericContainerScreenHandler::createGeneric9x6);

	private final JinericScreenHandlerType.Factory<T> factory;

	public static <T extends ScreenHandler> JinericScreenHandlerType<T> register(String id, JinericScreenHandlerType.Factory<T> factory) {
		return (ScreenHandler) Registry.register(Registry.SCREEN_HANDLER, id, new JinericScreenHandlerType(factory));
	}

	private JinericScreenHandlerType(JinericScreenHandlerType.Factory<T> factory) {
		this.factory = factory;
	}

	public T create(int syncId, PlayerInventory playerInventory) {
		return this.factory.create(syncId, playerInventory);
	}

	interface Factory<T extends ScreenHandler> {
		T create(int syncId, PlayerInventory playerInventory);
	}
}
*/
