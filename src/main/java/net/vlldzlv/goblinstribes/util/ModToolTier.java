package net.vlldzlv.goblinstribes.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.vlldzlv.goblinstribes.GoblinsTribes;
import net.vlldzlv.goblinstribes.item.ModItems;

import java.util.List;

public class ModToolTier {
	public static final Tier LADITE = TierSortingRegistry.registerTier(
			new ForgeTier(3, 650, 7.0F, 2.5F, 10,
					TagKey.create(Registries.BLOCK, new ResourceLocation("minecraft:needs_diamond_tool")),
					() -> Ingredient.of(ModItems.LADITE.get())),
			new ResourceLocation(GoblinsTribes.MOD_ID, "ladite"),
			List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

	public static final Tier MELODY = TierSortingRegistry.registerTier(
			new ForgeTier(3, 1400, 7.0F, 3.5F, 12,
					TagKey.create(Registries.BLOCK, new ResourceLocation("minecraft:needs_diamond_tool")),
					() -> Ingredient.of(net.minecraft.world.item.Items.DIAMOND)),
			new ResourceLocation(GoblinsTribes.MOD_ID, "melody"),
			List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));
}
