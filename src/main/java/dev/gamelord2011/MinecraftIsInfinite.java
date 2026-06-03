package dev.gamelord2011;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinecraftIsInfinite implements ModInitializer {
	public static final String MOD_ID = "minecraftisinfinite";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("MinecraftIsInfinite Initalized.");
	}
}