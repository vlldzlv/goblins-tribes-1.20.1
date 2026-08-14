package net.vlldzlv.goblinstribes.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.vlldzlv.goblinstribes.entity.ModEntities;
import net.vlldzlv.goblinstribes.entity.Nyufler;

public class NyuflerSpawnEggItem extends Item {
	public NyuflerSpawnEggItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		if (!level.isClientSide) {
			BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
			EntityType<Nyufler> type = ModEntities.NYUFLER.get();
			Nyufler nyufler = type.create(level);
			if (nyufler != null) {
				nyufler.moveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D,
						level.getRandom().nextFloat() * 360.0F, 0.0F);
				nyufler.setYHeadRot(nyufler.getYRot());
				nyufler.setYBodyRot(nyufler.getYRot());
				nyufler.finalizeSpawn((ServerLevel) level, level.getCurrentDifficultyAt(pos),
						MobSpawnType.SPAWN_EGG, null, null);
				level.addFreshEntity(nyufler);
				context.getItemInHand().shrink(1);
			}
		}
		return InteractionResult.sidedSuccess(level.isClientSide);
	}
}
