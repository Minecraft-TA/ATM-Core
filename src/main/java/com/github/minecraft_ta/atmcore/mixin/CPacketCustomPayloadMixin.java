package com.github.minecraft_ta.atmcore.mixin;

import net.minecraft.network.play.client.CPacketCustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(CPacketCustomPayload.class)
public class CPacketCustomPayloadMixin {

    @ModifyConstant(method = "<init>(Ljava/lang/String;Lnet/minecraft/network/PacketBuffer;)V", constant = @Constant(intValue = 32767))
    public int init(int limit) {
        return Integer.MAX_VALUE;
    }
}
