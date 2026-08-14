package net.vlldzlv.goblinstribes.util;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.vlldzlv.goblinstribes.item.ModItems;

import java.util.EnumMap;
import java.util.function.Supplier;

public record ModArmorMaterial(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protection,
		int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance,
		Supplier<Ingredient> repairIngredient) implements ArmorMaterial {

	public static final ModArmorMaterial LADITE = new ModArmorMaterial(
			"goblinstribes:ladite",
			22,
			createProtection(2, 7, 5, 2),
			10,
			SoundEvents.ARMOR_EQUIP_IRON,
			1.0F,
			0.0F,
			() -> Ingredient.of(ModItems.LADITE.get()));

	private static EnumMap<ArmorItem.Type, Integer> createProtection(int helmet, int chestplate, int leggings, int boots) {
		EnumMap<ArmorItem.Type, Integer> map = new EnumMap<>(ArmorItem.Type.class);
		map.put(ArmorItem.Type.HELMET, helmet);
		map.put(ArmorItem.Type.CHESTPLATE, chestplate);
		map.put(ArmorItem.Type.LEGGINGS, leggings);
		map.put(ArmorItem.Type.BOOTS, boots);
		return map;
	}

	@Override
	public int getDurabilityForType(ArmorItem.Type type) {
		return switch (type) {
			case HELMET -> 11 * this.durabilityMultiplier;
			case CHESTPLATE -> 16 * this.durabilityMultiplier;
			case LEGGINGS -> 15 * this.durabilityMultiplier;
			case BOOTS -> 13 * this.durabilityMultiplier;
		};
	}

	@Override
	public int getDefenseForType(ArmorItem.Type type) {
		return this.protection.get(type);
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
