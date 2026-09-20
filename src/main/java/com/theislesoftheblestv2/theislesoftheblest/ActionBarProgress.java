package com.theislesoftheblestv2.theislesoftheblest;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.storage.LevelResource;

public class ActionBarProgress {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String FILE_NAME = "theislesoftheblest_actionbar_progress.json";

    private static Map<String, Boolean> ranFlags;
    private static Path filePath;

    private static synchronized void ensureLoaded(MinecraftServer server) {
        Path expectedPath = server.getWorldPath(LevelResource.ROOT).resolve(FILE_NAME);
        if (ranFlags != null && expectedPath.equals(filePath)) return;

        filePath = expectedPath;
        ranFlags = new ConcurrentHashMap<>();
        if (Files.exists(filePath)) {
            try (Reader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
                Map<String, Boolean> loaded = GSON.fromJson(reader, new TypeToken<Map<String, Boolean>>() {}.getType());
                if (loaded != null) ranFlags.putAll(loaded);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load action bar progress from " + filePath, e);
            }
        }
    }

    private static synchronized void save() {
        try (Writer writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
            GSON.toJson(ranFlags, writer);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save action bar progress to " + filePath, e);
        }
    }

    private static String key(UUID playerId, String id) {
        return playerId + "|" + id;
    }

    public static boolean hasRan(MinecraftServer server, UUID playerId, String id) {
        ensureLoaded(server);
        return ranFlags.getOrDefault(key(playerId, id), false);
    }

    public static void setRan(MinecraftServer server, UUID playerId, String id, boolean isRan) {
        ensureLoaded(server);
        ranFlags.put(key(playerId, id), isRan);
        save();
    }
}
