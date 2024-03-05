package net.vlldzlv.goblinstribes.block;

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
import net.vlldzlv.goblinstribes.GoblinsTribes;
import net.vlldzlv.goblinstribes.GoblinsTribes;
import net.vlldzlv.goblinstribes.block.custom.Drum;

public class ModBlocks {
    public static final Block LADITE_BLOCK = registerBlock("ladite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
public static final Block STONE_LADITE_ORE = registerBlock("stone_ladite_ore",
        new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2,5)));
public static final Block DEEPSLATE_LADITE_ORE = registerBlock("deepslate_ladite_ore",
        new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(3f), UniformIntProvider.create(2,5)));
public static final Block DRUM = registerBlock("drum",
        new Drum(FabricBlockSettings.copyOf(Blocks.NOTE_BLOCK)));





    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(GoblinsTribes.MOD_ID,name), block);
    }
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, new Identifier(GoblinsTribes.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        GoblinsTribes.LOGGER.info("Registering ModBlock for " + GoblinsTribes.MOD_ID);
    }
}
