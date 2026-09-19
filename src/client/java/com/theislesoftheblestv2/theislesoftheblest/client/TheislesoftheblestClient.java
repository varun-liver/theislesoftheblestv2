package com.theislesoftheblestv2.theislesoftheblest.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import com.theislesoftheblestv2.theislesoftheblest.networking.ActionBarDurationPayload;

public class TheislesoftheblestClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(ActionBarDurationPayload.TYPE, (payload, context) -> {
    context.client().execute(() ->
        ((OverlayDurationSetter) context.client().gui.hud).theislesoftheblest$setOverlayDuration(payload.duration())
    );
});
    }
}
