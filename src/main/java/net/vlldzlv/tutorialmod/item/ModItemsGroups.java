package net.vlldzlv.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.vlldzlv.tutorialmod.TutorialMod;
import net.vlldzlv.tutorialmod.block.ModBlocks;

public class ModItemsGroups {
    public static final ItemGroup MANA_CRYSTAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "mana_crystal"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.mana_crystal"))
                    .icon(() -> new ItemStack(ModItems.RAW_MANA_CRYSTAL)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MANA_CRYSTAL);
                        entries.add(ModItems.RAW_MANA_CRYSTAL);

                        entries.add(ModBlocks.MANA_CRYSTAL_BLOCK);
                        entries.add(ModBlocks.RAW_MANA_CRYSTAL_BLOCK);

                        entries.add(ModBlocks.STONE_MANA_CRYSTAL_ORE);
                        entries.add(ModBlocks.DEEPSLATE_MANA_CRYSTAL_ORE);

                    }).build());

        public static void registerItemGroup(){
            TutorialMod.LOGGER.info("Registering Item Group for " +TutorialMod.MOD_ID);
        }
}
