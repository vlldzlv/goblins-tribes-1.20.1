package net.vlldzlv.goblinstribes.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.vlldzlv.goblinstribes.GoblinsTribes;
import net.vlldzlv.goblinstribes.block.ModBlocks;

public class ModItemsGroups {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GoblinsTribes.MOD_ID);

	public static final RegistryObject<CreativeModeTab> GOBLINS_TRIBES_TAB = CREATIVE_MODE_TABS.register("goblins_tribes_tab",
			() -> CreativeModeTab.builder()
					.icon(() -> new ItemStack(ModItems.LADITE.get()))
					.title(Component.translatable("itemGroup.goblinstribes"))
					.displayItems((parameters, output) -> {
						output.accept(ModItems.LADITE.get());
						output.accept(ModItems.LADITE_UPGRADE_SMITHING_TEMPLATE.get());
						output.accept(ModBlocks.LADITE_BLOCK.get());
						output.accept(ModBlocks.STONE_LADITE_ORE.get());
						output.accept(ModBlocks.DEEPSLATE_LADITE_ORE.get());
						output.accept(ModBlocks.DRUM.get());
						output.accept(ModItems.LADITE_SWORD.get());
						output.accept(ModItems.MELODY_SWORD.get());
						output.accept(ModItems.LADITE_PICKAXE.get());
						output.accept(ModItems.LADITE_AXE.get());
						output.accept(ModItems.LADITE_SHOVEL.get());
						output.accept(ModItems.LADITE_HOE.get());
						output.accept(ModItems.LADITE_HELMET.get());
						output.accept(ModItems.LADITE_CHESTPLATE.get());
						output.accept(ModItems.LADITE_LEGGINGS.get());
						output.accept(ModItems.LADITE_BOOTS.get());
						output.accept(ModItems.NYUFLER_SPAWN_EGG.get());
					})
					.build());
}
