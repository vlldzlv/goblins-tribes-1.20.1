package net.vlldzlv.goblinstribes.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vlldzlv.goblinstribes.GoblinsTribes;
import net.vlldzlv.goblinstribes.block.custom.Drum;
import net.vlldzlv.goblinstribes.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, GoblinsTribes.MOD_ID);

	public static final RegistryObject<Block> LADITE_BLOCK = registerBlock("ladite_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));

	public static final RegistryObject<Block> STONE_LADITE_ORE = registerBlock("stone_ladite_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f), UniformInt.of(2, 5)));

	public static final RegistryObject<Block> DEEPSLATE_LADITE_ORE = registerBlock("deepslate_ladite_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f), UniformInt.of(2, 5)));

	public static final RegistryObject<Block> DRUM = registerBlock("drum",
			() -> new Drum(BlockBehaviour.Properties.copy(Blocks.NOTE_BLOCK)));

	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
		ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
