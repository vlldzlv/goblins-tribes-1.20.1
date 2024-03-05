package net.vlldzlv.goblinstribes.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vlldzlv.goblinstribes.GoblinsTribes;
import net.vlldzlv.goblinstribes.GoblinsTribes;

public class ModItems {
    public static final Item LADITE = registerItem("ladite", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup (FabricItemGroupEntries entries) {
        entries.add(LADITE);

    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(GoblinsTribes.MOD_ID, name), item);
    }

    public static void registerModItems(){
        GoblinsTribes.LOGGER.info("Registering Mod Items for " + GoblinsTribes.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
