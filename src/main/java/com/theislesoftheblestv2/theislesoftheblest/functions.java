package com.theislesoftheblestv2.theislesoftheblest;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import com.theislesoftheblestv2.theislesoftheblest.networking.ActionBarDurationPayload;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class functions {
    private static final Map<UUID, String> ACTIVE_ID = new ConcurrentHashMap<>();
    private static final Map<UUID, String> ACTIVE_TEXT = new ConcurrentHashMap<>();
    private static final int RESEND_DURATION = 30; // ticks; must be >= tick-loop interval below

    public static void actionbar(ServerPlayer player, String text, int duration) {
        send(player, text, duration);
    }

    public static void actionbarStart(ServerPlayer player, String id, String text) {
        ACTIVE_ID.put(player.getUUID(), id);
        ACTIVE_TEXT.put(player.getUUID(), text);
        send(player, text, RESEND_DURATION);
    }

    public static void actionbarEnd(ServerPlayer player, String id) {
        UUID uuid = player.getUUID();
        if (!id.equals(ACTIVE_ID.get(uuid))) return; // only the owner of the current bar can clear it
        ACTIVE_ID.remove(uuid);
        ACTIVE_TEXT.remove(uuid);
        send(player, "", 0);
    }

    // called periodically so the overlay doesn't decay between explicit updates
    public static void tick(ServerPlayer player) {
        String text = ACTIVE_TEXT.get(player.getUUID());
        if (text != null) {
            send(player, text, RESEND_DURATION);
        }
    }

    public static void clearPlayer(ServerPlayer player) {
        ACTIVE_ID.remove(player.getUUID());
        ACTIVE_TEXT.remove(player.getUUID());
    }

    private static void send(ServerPlayer player, String text, int duration) {
        player.sendOverlayMessage(Component.literal(text));
        ServerPlayNetworking.send(player, new ActionBarDurationPayload(duration));
    }
}
