package net.vlldzlv.goblinstribes;

import net.fabricmc.api.ModInitializer;

import net.vlldzlv.goblinstribes.block.ModBlocks;
import net.vlldzlv.goblinstribes.item.ModItems;
import net.vlldzlv.goblinstribes.item.ModItemsGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoblinsTribes implements ModInitializer {
	public static final String MOD_ID = "goblinstribes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemsGroups.registerItemGroup();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}