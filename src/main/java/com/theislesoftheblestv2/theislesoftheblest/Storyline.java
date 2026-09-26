package com.theislesoftheblestv2.theislesoftheblest;

import com.theislesoftheblestv2.theislesoftheblest.networking.ActionBarDurationPayload;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.level.ServerPlayer;

public class Storyline {

    public static void init() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            functions.actionbar(handler.player, "Welcome to the Isles of the Blest!", 40); // duration in ticks
        });
    }
}
