package net.vlldzlv.goblinstribes;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.vlldzlv.goblinstribes.block.ModBlocks;
import net.vlldzlv.goblinstribes.entity.ModEntities;
import net.vlldzlv.goblinstribes.item.ModItems;
import net.vlldzlv.goblinstribes.item.ModItemsGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(GoblinsTribes.MOD_ID)
public class GoblinsTribes {
	public static final String MOD_ID = "goblinstribes";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public GoblinsTribes() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModItems.ITEMS.register(modEventBus);
		ModBlocks.BLOCKS.register(modEventBus);
		ModEntities.ENTITY_TYPES.register(modEventBus);
		ModItemsGroups.CREATIVE_MODE_TABS.register(modEventBus);
	}
}
