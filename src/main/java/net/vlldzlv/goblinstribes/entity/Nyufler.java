package net.vlldzlv.goblinstribes.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Saddleable;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import javax.annotation.Nullable;
public class Nyufler extends Sniffer implements Saddleable {
	private static final EntityDataAccessor<Boolean> DATA_SADDLE_ID =
			SynchedEntityData.defineId(Nyufler.class, EntityDataSerializers.BOOLEAN);

	public Nyufler(EntityType<? extends Nyufler> entityType, Level level) {
		super(entityType, level);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Animal.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 30.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.30D);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_SADDLE_ID, false);
	}

	@Override
	public boolean isSaddleable() {
		return this.isAlive() && !this.isBaby();
	}

	@Override
	public boolean isSaddled() {
		return this.entityData.get(DATA_SADDLE_ID);
	}

	@Override
	public void equipSaddle(@Nullable SoundSource soundSource) {
		this.entityData.set(DATA_SADDLE_ID, true);
		if (soundSource != null) {
			this.level().playSound(null, this, SoundEvents.PIG_SADDLE, soundSource, 0.5F, 1.0F);
		}
	}

	@Override
	@Nullable
	public LivingEntity getControllingPassenger() {
		Entity entity = this.getFirstPassenger();
		if (entity instanceof Player player) {
			return player;
		}
		return null;
	}

	@Override
	public void travel(Vec3 travelVector) {
		if (this.isAlive()) {
			LivingEntity livingEntity = this.getControllingPassenger();
			if (this.isVehicle() && livingEntity instanceof Player player) {
				this.setYRot(player.getYRot());
				this.yRotO = this.getYRot();
				this.setXRot(player.getXRot() * 0.5F);
				this.setRot(this.getYRot(), this.getXRot());
				this.yBodyRot = this.getYRot();
				this.yHeadRot = this.getYRot();
				float f = player.xxa * 0.5F;
				float f1 = player.zza;
				if (f1 <= 0.0F) {
					f1 *= 0.25F;
				}
				if (this.isControlledByLocalInstance()) {
					this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
					super.travel(new Vec3((double) f, travelVector.y, (double) f1));
				} else if (player instanceof ServerPlayer) {
					this.setDeltaMovement(Vec3.ZERO);
				}
				this.calculateEntityAnimation(true);
			} else {
				super.travel(travelVector);
			}
		}
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemStack = player.getItemInHand(hand);
		if (itemStack.is(Items.SADDLE) && this.isSaddleable() && !this.isSaddled()) {
			itemStack.shrink(1);
			this.equipSaddle(SoundSource.PLAYERS);
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		}
		if (this.isSaddled() && !this.isVehicle() && !player.isSecondaryUseActive()) {
			if (!this.level().isClientSide) {
				player.startRiding(this);
			}
			return InteractionResult.sidedSuccess(this.level().isClientSide);
		}
		return super.mobInteract(player, hand);
	}

	@Override
	protected void dropEquipment() {
		super.dropEquipment();
		if (this.isSaddled()) {
			this.spawnAtLocation(Items.SADDLE);
		}
	}
}
