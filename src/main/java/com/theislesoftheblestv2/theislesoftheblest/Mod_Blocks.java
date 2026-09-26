package com.theislesoftheblestv2.theislesoftheblest;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Mod_Blocks {
    public static final ResourceKey<Block> JAGJ_PORTAL_BLOCK_KEY = ResourceKey.create(
        Registries.BLOCK,
        Identifier.fromNamespaceAndPath("theislesoftheblestv2", "jagj_portal_block")
    );

    public static final Block JAGJ_PORTAL_BLOCK = Registry.register(
        BuiltInRegistries.BLOCK,
        JAGJ_PORTAL_BLOCK_KEY,
        new JagjPortalBlock(BlockBehaviour.Properties.of().setId(JAGJ_PORTAL_BLOCK_KEY).strength(-1.0f, 3600000.0f).noCollision().lightLevel(state -> 15))
    );

    public static final ResourceKey<Block> CASA_LEAVES_KEY = ResourceKey.create(
        Registries.BLOCK,
        Identifier.fromNamespaceAndPath("theislesoftheblestv2", "casa_leaves")
    );

    public static final Block CASA_LEAVES = Registry.register(
        BuiltInRegistries.BLOCK,
        CASA_LEAVES_KEY,
        new LeavesBlock(
            AmbientLeavesBlockSoundPlayer.noAmbientSound(),
            BlockBehaviour.Properties.of().setId(CASA_LEAVES_KEY).strength(0.2f).sound(SoundType.GRASS).randomTicks().noOcclusion()
        )
    );
}
