package com.theislesoftheblestv2.theislesoftheblest;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

public class Mod_Creative_Mod_Tabs {
    public static void init() {
        ResourceKey<CreativeModeTab> op_blocks = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB, Identifier.withDefaultNamespace("op_blocks")
        );
        // force Mod_Block_Item/Mod_Blocks to register now, while mod init still runs before
        // vanilla registries freeze — the tab-content lambda below only runs much later
        // (whenever the creative screen is opened), which is too late to register anything.
        BlockItem jagjPortalBlockItem = Mod_Block_Item.JAGJ_PORTAL_BLOCK_ITEM;
        CreativeModeTabEvents.modifyOutputEvent(op_blocks).register(output ->
            output.accept(jagjPortalBlockItem)
        );
    }
}
