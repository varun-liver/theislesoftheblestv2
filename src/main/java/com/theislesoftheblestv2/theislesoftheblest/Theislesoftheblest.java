package com.theislesoftheblestv2.theislesoftheblest;

import com.theislesoftheblestv2.theislesoftheblest.networking.ActionBarDurationPayload;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.level.ServerPlayer;

public class Theislesoftheblest implements ModInitializer {

    private static final String WELCOME_BAR_ID = "welcome";

    @Override
    public void onInitialize() {
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
    functions.clearPlayer(handler.player);
});

ServerTickEvents.END_SERVER_TICK.register(server -> {
    if (server.getTickCount() % 1 == 0) { // once every tick
        server.getPlayerList().getPlayers().forEach(functions::tick);
    }
});
        PayloadTypeRegistry.clientboundPlay().register(ActionBarDurationPayload.TYPE, ActionBarDurationPayload.CODEC);
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            functions.actionbarStart(handler.player, WELCOME_BAR_ID, "Welcome to The Isles of the Blest!");
        });

        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
    if (!world.isClientSide() && player instanceof ServerPlayer serverPlayer) {
        functions.actionbarEnd(serverPlayer, WELCOME_BAR_ID, true);
    }
});

    }
}
