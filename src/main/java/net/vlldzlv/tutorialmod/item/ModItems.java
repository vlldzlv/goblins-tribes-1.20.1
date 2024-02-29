package net.vlldzlv.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vlldzlv.tutorialmod.TutorialMod;

public class ModItems {
    public static final Item MANA_CRYSTAL = registerItem("mana_crystal", new Item(new FabricItemSettings()));
    public static final Item RAW_MANA_CRYSTAL = registerItem("raw_mana_crystal", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup (FabricItemGroupEntries entries) {
        entries.add(MANA_CRYSTAL);
        entries.add(RAW_MANA_CRYSTAL);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
