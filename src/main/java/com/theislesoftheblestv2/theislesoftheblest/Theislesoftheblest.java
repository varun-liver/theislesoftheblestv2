package com.theislesoftheblestv2.theislesoftheblest;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import com.theislesoftheblestv2.theislesoftheblest.networking.ActionBarDurationPayload;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class Theislesoftheblest implements ModInitializer {

    @Override
    public void onInitialize() {
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
    functions.clearPlayer(handler.player);
});

ServerTickEvents.END_SERVER_TICK.register(server -> {
    if (server.getTickCount() % 20 == 0) { // once a second
        server.getPlayerList().getPlayers().forEach(functions::tick);
    }
});
        PayloadTypeRegistry.clientboundPlay().register(ActionBarDurationPayload.TYPE, ActionBarDurationPayload.CODEC);
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            functions.actionbar(handler.player, "Welcome to The Isles of the Blest!",200);
        });
    }
}
