package com.theislesoftheblestv2.theislesoftheblest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.level.ServerPlayer;

public class Storyline {

    public static void init() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerPlayer player = handler.player;
            int firstDuration = 40; // ticks

            functions.actionbar(player, "Welcome to the Isles of the Blest!", firstDuration);

            CompletableFuture.delayedExecutor(firstDuration * 50L, TimeUnit.MILLISECONDS)
                .execute(() -> server.execute(() ->
                    functions.actionbar(player, "Start by breaking a block!", 40)
                ));
        });
    }
}
