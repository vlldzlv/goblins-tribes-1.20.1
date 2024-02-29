package net.vlldzlv.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.vlldzlv.tutorialmod.block.ModBlocks;
import net.vlldzlv.tutorialmod.item.ModItems;
import net.vlldzlv.tutorialmod.item.ModItemsGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemsGroups.registerItemGroup();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}