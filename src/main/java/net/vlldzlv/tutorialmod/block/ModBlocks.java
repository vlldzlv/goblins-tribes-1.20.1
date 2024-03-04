package net.vlldzlv.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.vlldzlv.tutorialmod.TutorialMod;
import net.vlldzlv.tutorialmod.block.custom.Drum;

public class ModBlocks {
    public static final Block MANA_CRYSTAL_BLOCK = registerBlock("mana_crystal_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
public static final Block RAW_MANA_CRYSTAL_BLOCK = registerBlock("raw_mana_crystal_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));

public static final Block STONE_MANA_CRYSTAL_ORE = registerBlock("stone_mana_crystal_ore",
        new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2,5)));
public static final Block DEEPSLATE_MANA_CRYSTAL_ORE = registerBlock("deepslate_mana_crystal_ore",
        new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(3f), UniformIntProvider.create(2,5)));
public static final Block DRUM = registerBlock("drum",
        new Drum(FabricBlockSettings.copyOf(Blocks.NOTE_BLOCK)));





    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID,name), block);
    }
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering ModBlock for " + TutorialMod.MOD_ID);
    }
}
