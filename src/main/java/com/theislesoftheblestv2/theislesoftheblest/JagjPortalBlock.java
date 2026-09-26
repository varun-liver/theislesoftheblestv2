package com.theislesoftheblestv2.theislesoftheblest;

import java.util.Set;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class JagjPortalBlock extends Block {
    public static final ResourceKey<Level> AGAF_DIMENSION = ResourceKey.create(
        Registries.DIMENSION,
        Identifier.fromNamespaceAndPath("theislesoftheblestv2", "agaf")
    );

    public JagjPortalBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean movedByPiston) {
        if (!(level instanceof ServerLevel serverLevel) || !(entity instanceof ServerPlayer player) || entity.isOnPortalCooldown()) {
            return;
        }

        ResourceKey<Level> destination = serverLevel.dimension() == AGAF_DIMENSION ? Level.OVERWORLD : AGAF_DIMENSION;
        ServerLevel targetLevel = serverLevel.getServer().getLevel(destination);
        if (targetLevel == null || targetLevel == level) {
            return;
        }

        entity.setPortalCooldown();
        player.teleportTo(targetLevel, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, Set.of(), player.getYRot(), player.getXRot(), false);
    }
}
