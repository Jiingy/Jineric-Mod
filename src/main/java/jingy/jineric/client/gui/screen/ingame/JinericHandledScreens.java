package jingy.jineric.client.gui.screen.ingame;

/*
public class JinericHandledScreens {
	private static final Logger LOGGER = LogUtils.getLogger();
	private static final Map<ScreenHandlerType<?>, JinericHandledScreens.Provider<?, ?>> PROVIDERS = Maps.newHashMap();

	public JinericHandledScreens() {
	}

	public static <T extends ScreenHandler> void open(@Nullable JinericScreenHandlerType<T> type, MinecraftClient client, int id, Text title) {
		if (type == null) {
			LOGGER.warn("Trying to open invalid screen with name: {}", title.getString());
		} else {
			JinericHandledScreens.Provider<T, ?> provider = getProvider(type);
			if (provider == null) {
				LOGGER.warn("Failed to create screen for menu type: {}", Registry.SCREEN_HANDLER.getId(type));
			} else {
				provider.open(title, type, client, id);
			}
		}
	}

	@Nullable
	private static <T extends ScreenHandler> JinericHandledScreens.Provider<T, ?> getProvider(ScreenHandlerType<T> type) {
		return (JinericHandledScreens.Provider)PROVIDERS.get(type);
	}

	private static <M extends ScreenHandler, U extends Screen & ScreenHandlerProvider<M>> void register(ScreenHandlerType<? extends M> type, JinericHandledScreens.Provider<M, U> provider) {
		JinericHandledScreens.Provider<?, ?> provider2 = (JinericHandledScreens.Provider)PROVIDERS.put(type, provider);
		if (provider2 != null) {
			throw new IllegalStateException("Duplicate registration for " + Registry.SCREEN_HANDLER.getId(type));
		}
	}

	public static boolean isMissingScreens() {
		boolean bl = false;
		Iterator var1 = Registry.SCREEN_HANDLER.iterator();

		while(var1.hasNext()) {
			JinericScreenHandlerType<?> jinericScreenHandlerType = (JinericScreenHandlerType)var1.next();
			if (!PROVIDERS.containsKey(jinericScreenHandlerType)) {
				LOGGER.debug("Menu {} has no matching screen", Registry.SCREEN_HANDLER.getId(jinericScreenHandlerType));
				bl = true;
			}
		}

		return bl;
	}

	static {
		register(JinericScreenHandlerType.JINERIC_GENERIC_9X9, JinericGenericContainerScreen::new);
	}

	@Environment(EnvType.CLIENT)
	private interface Provider<T extends ScreenHandler, U extends Screen & ScreenHandlerProvider<T>> {
		default void open(Text name, ScreenHandlerType<T> type, MinecraftClient client, int id) {
			U screen = this.create(type.create(id, client.player.getInventory()), client.player.getInventory(), name);
			client.player.currentScreenHandler = ((ScreenHandlerProvider)screen).getScreenHandler();
			client.setScreen(screen);
		}

		U create(T handler, PlayerInventory playerInventory, Text title);
	}
}
*/
