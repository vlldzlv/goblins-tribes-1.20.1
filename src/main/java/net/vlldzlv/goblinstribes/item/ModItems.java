package net.vlldzlv.goblinstribes.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vlldzlv.goblinstribes.GoblinsTribes;
import net.vlldzlv.goblinstribes.util.ModArmorMaterial;
import net.vlldzlv.goblinstribes.util.ModToolTier;

import java.util.List;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS =
			DeferredRegister.create(ForgeRegistries.ITEMS, GoblinsTribes.MOD_ID);

	private static final ResourceLocation EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
	private static final ResourceLocation EMPTY_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
	private static final ResourceLocation EMPTY_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
	private static final ResourceLocation EMPTY_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
	private static final ResourceLocation EMPTY_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
	private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_slot_helmet");
	private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_slot_chestplate");
	private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_slot_leggings");
	private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_slot_boots");
	private static final ResourceLocation EMPTY_SLOT_INGOT = new ResourceLocation("item/empty_slot_ingot");

	public static final RegistryObject<Item> LADITE = ITEMS.register("ladite",
			() -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> LADITE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("ladite_upgrade_smithing_template",
			() -> new SmithingTemplateItem(
					Component.translatable("item.goblinstribes.smithing_template.ladite_upgrade.applies_to"),
					Component.translatable("item.goblinstribes.smithing_template.ladite_upgrade.ingredients"),
					Component.translatable("upgrade.goblinstribes.ladite_upgrade"),
					Component.translatable("item.goblinstribes.smithing_template.ladite_upgrade.base_slot_description"),
					Component.translatable("item.goblinstribes.smithing_template.ladite_upgrade.additions_slot_description"),
					List.of(EMPTY_SLOT_SWORD, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_AXE, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL,
							EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS),
					List.of(EMPTY_SLOT_INGOT)));

	public static final RegistryObject<Item> LADITE_SWORD = ITEMS.register("ladite_sword",
			() -> new SwordItem(ModToolTier.LADITE, 3, -2.4F, new Item.Properties()));

	public static final RegistryObject<Item> MELODY_SWORD = ITEMS.register("melody_sword",
			() -> new MelodySwordItem(ModToolTier.MELODY, 3, -1.8F, new Item.Properties()));

	public static final RegistryObject<Item> NYUFLER_SPAWN_EGG = ITEMS.register("nyufler_spawn_egg",
			() -> new NyuflerSpawnEggItem(new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> LADITE_PICKAXE = ITEMS.register("ladite_pickaxe",
			() -> new PickaxeItem(ModToolTier.LADITE, 1, -2.8F, new Item.Properties()));
	public static final RegistryObject<Item> LADITE_AXE = ITEMS.register("ladite_axe",
			() -> new AxeItem(ModToolTier.LADITE, 5.5F, -3.1F, new Item.Properties()));
	public static final RegistryObject<Item> LADITE_SHOVEL = ITEMS.register("ladite_shovel",
			() -> new ShovelItem(ModToolTier.LADITE, 1.5F, -3.0F, new Item.Properties()));
	public static final RegistryObject<Item> LADITE_HOE = ITEMS.register("ladite_hoe",
			() -> new HoeItem(ModToolTier.LADITE, -1, -2.0F, new Item.Properties()));

	public static final RegistryObject<Item> LADITE_HELMET = ITEMS.register("ladite_helmet",
			() -> new ArmorItem(ModArmorMaterial.LADITE, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> LADITE_CHESTPLATE = ITEMS.register("ladite_chestplate",
			() -> new ArmorItem(ModArmorMaterial.LADITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> LADITE_LEGGINGS = ITEMS.register("ladite_leggings",
			() -> new ArmorItem(ModArmorMaterial.LADITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> LADITE_BOOTS = ITEMS.register("ladite_boots",
			() -> new ArmorItem(ModArmorMaterial.LADITE, ArmorItem.Type.BOOTS, new Item.Properties()));
}
