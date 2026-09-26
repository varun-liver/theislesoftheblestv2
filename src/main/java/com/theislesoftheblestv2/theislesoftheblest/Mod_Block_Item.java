package com.theislesoftheblestv2.theislesoftheblest;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

public class Mod_Block_Item {
    public static final ResourceKey<Item> JAGJ_PORTAL_BLOCK_ITEM_KEY = ResourceKey.create(
        Registries.ITEM,
        Identifier.fromNamespaceAndPath("theislesoftheblestv2", "jagj_portal_block")
    );

    public static final BlockItem JAGJ_PORTAL_BLOCK_ITEM = Registry.register(
        BuiltInRegistries.ITEM,
        JAGJ_PORTAL_BLOCK_ITEM_KEY,
        new BlockItem(Mod_Blocks.JAGJ_PORTAL_BLOCK, new Item.Properties().setId(JAGJ_PORTAL_BLOCK_ITEM_KEY).useBlockDescriptionPrefix())
    );

    public static final ResourceKey<Item> CASA_LEAVES_ITEM_KEY = ResourceKey.create(
        Registries.ITEM,
        Identifier.fromNamespaceAndPath("theislesoftheblestv2", "casa_leaves")
    );

    public static final BlockItem CASA_LEAVES_ITEM = Registry.register(
        BuiltInRegistries.ITEM,
        CASA_LEAVES_ITEM_KEY,
        new BlockItem(Mod_Blocks.CASA_LEAVES, new Item.Properties().setId(CASA_LEAVES_ITEM_KEY).useBlockDescriptionPrefix())
    );
}
