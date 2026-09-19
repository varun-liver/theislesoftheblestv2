package com.theislesoftheblestv2.theislesoftheblest.mixin.client;

import net.minecraft.client.gui.Hud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import com.theislesoftheblestv2.theislesoftheblest.client.OverlayDurationSetter;

@Mixin(Hud.class)
public class HudMixin implements OverlayDurationSetter {

    @Shadow
    private int overlayMessageTime;

    @Override
    @Unique
    public void theislesoftheblest$setOverlayDuration(int ticks) {
        this.overlayMessageTime = ticks;
    }
}
