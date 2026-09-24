package com.theislesoftheblestv2.theislesoftheblest;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Mod_Blocks {
    public static final ResourceKey<Block> JAGJ_PORTAL_BLOCK_KEY = ResourceKey.create(
        Registries.BLOCK,
        Identifier.fromNamespaceAndPath("theislesoftheblestv2", "jagj_portal_block")
    );

    public static final Block JAGJ_PORTAL_BLOCK = Registry.register(
        BuiltInRegistries.BLOCK,
        JAGJ_PORTAL_BLOCK_KEY,
        new Block(BlockBehaviour.Properties.of().setId(JAGJ_PORTAL_BLOCK_KEY).strength(-1.0f, 3600000.0f).noCollision().lightLevel(state -> 15))
    );
}
