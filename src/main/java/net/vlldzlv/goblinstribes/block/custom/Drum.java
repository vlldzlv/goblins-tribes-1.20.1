package net.vlldzlv.goblinstribes.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class Drum extends Block {
	public Drum(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos,
								 Player player, InteractionHand hand, BlockHitResult hit) {
		level.playSound(player, pos, SoundEvents.NOTE_BLOCK_BASEDRUM.get(), SoundSource.BLOCKS, 3.0F, 5.0F);
		return InteractionResult.sidedSuccess(level.isClientSide);
	}
}
