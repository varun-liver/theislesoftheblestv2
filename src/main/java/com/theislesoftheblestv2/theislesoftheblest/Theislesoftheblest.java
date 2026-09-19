package com.theislesoftheblestv2.theislesoftheblest;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import com.theislesoftheblestv2.theislesoftheblest.networking.ActionBarDurationPayload;

public class Theislesoftheblest implements ModInitializer {

    @Override
    public void onInitialize() {
        PayloadTypeRegistry.clientboundPlay().register(ActionBarDurationPayload.TYPE, ActionBarDurationPayload.CODEC);
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            functions.actionbar(handler.player, "Welcome to The Isles of the Blest!",200);
        });
    }
}
