package net.vlldzlv.goblinstribes.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vlldzlv.goblinstribes.GoblinsTribes;

public class ModEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GoblinsTribes.MOD_ID);

	public static final RegistryObject<EntityType<Nyufler>> NYUFLER = ENTITY_TYPES.register("nyufler",
			() -> EntityType.Builder.of(Nyufler::new, MobCategory.CREATURE)
					.sized(1.9F, 1.75F)
					.build("goblinstribes:nyufler"));
}
