package net.red108.manaverba.block;

import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import com.mojang.serialization.MapCodec;

public class LongaevaLeavesBlock extends LeavesBlock {

    public LongaevaLeavesBlock(BlockBehaviour.Properties properties) {
        super(0.05f, properties); // set your leaf particle chance
    }

    @Override
    public MapCodec<? extends LongaevaLeavesBlock> codec() {
        return MapCodec.unit(this); // simplest codec
    }

    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {
        // optional: spawn vanilla falling leaf particles
    }
}
