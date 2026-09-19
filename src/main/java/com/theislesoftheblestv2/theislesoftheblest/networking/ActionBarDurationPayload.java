package com.theislesoftheblestv2.theislesoftheblest.networking;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record ActionBarDurationPayload(int duration) implements CustomPacketPayload {
    public static final Type<ActionBarDurationPayload> TYPE =
            new Type<>(Identifier.fromNamespaceAndPath("theislesoftheblest", "action_bar_duration"));

    public static final StreamCodec<ByteBuf, ActionBarDurationPayload> CODEC =
            ByteBufCodecs.VAR_INT.map(ActionBarDurationPayload::new, ActionBarDurationPayload::duration);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
