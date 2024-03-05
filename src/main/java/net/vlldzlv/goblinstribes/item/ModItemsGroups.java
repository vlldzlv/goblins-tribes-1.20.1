package net.vlldzlv.goblinstribes.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.vlldzlv.goblinstribes.GoblinsTribes;
import net.vlldzlv.goblinstribes.block.ModBlocks;

public class ModItemsGroups {
    public static final ItemGroup MANA_CRYSTAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(GoblinsTribes.MOD_ID, "ladite"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ladite"))
                    .icon(() -> new ItemStack(ModItems.LADITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.LADITE);

                        entries.add(ModBlocks.LADITE_BLOCK);

                        entries.add(ModBlocks.STONE_LADITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_LADITE_ORE);

                        entries.add(ModBlocks.DRUM);

                    }).build());

        public static void registerItemGroup(){
            GoblinsTribes.LOGGER.info("Registering Item Group for " +GoblinsTribes.MOD_ID);
        }
}
