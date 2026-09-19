package com.theislesoftheblestv2.theislesoftheblest;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import com.theislesoftheblestv2.theislesoftheblest.networking.ActionBarDurationPayload;

public class functions {
    public static void actionbar(ServerPlayer player, String text, int duration) {
        player.sendOverlayMessage(Component.literal(text));
        ServerPlayNetworking.send(player, new ActionBarDurationPayload(duration));
    }
}
