package net.vlldzlv.goblinstribes.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class MelodySwordItem extends SwordItem {
	public MelodySwordItem(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
		super(tier, attackDamageModifier, attackSpeedModifier, properties);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		Level level = target.level();
		if (level instanceof ServerLevel serverLevel) {
			int note = level.getRandom().nextInt(25);
			serverLevel.playSound(null, target.getX(), target.getY() + target.getBbHeight() * 0.5D, target.getZ(),
					SoundEvents.NOTE_BLOCK_HARP.get(), SoundSource.PLAYERS, 1.0F,
					(float) Math.pow(2.0D, (double) (note - 12) / 12.0D));
			for (int i = 0; i < 8; i++) {
				double px = target.getX() + (level.getRandom().nextDouble() - 0.5D) * target.getBbWidth();
				double py = target.getY() + level.getRandom().nextDouble() * target.getBbHeight();
				double pz = target.getZ() + (level.getRandom().nextDouble() - 0.5D) * target.getBbWidth();
				serverLevel.sendParticles(ParticleTypes.NOTE, px, py, pz, 1,
						(double) note / 24.0D, 0.0D, 0.0D, 1.0D);
			}
		}
		return super.hurtEnemy(stack, target, attacker);
	}
}
