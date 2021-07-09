package com.github.minecraft_ta.atmcore.mixin;

import com.github.minecraft_ta.atmcore.implementation.RandomCounter;
import net.minecraft.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(World.class)
public class WorldMixin {

    @Mutable
    @Shadow
    @Final
    public Random rand;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void init(ISaveHandler saveHandlerIn, WorldInfo info, WorldProvider providerIn, Profiler profilerIn, boolean client, CallbackInfo ci) {
        this.rand = new RandomCounter();
    }

    @Inject(method = "setRandomSeed", at = @At("RETURN"))
    public void setRandomSeed(int seedX, int seedY, int seedZ, CallbackInfoReturnable<Random> cir) {
        if (rand instanceof RandomCounter) {
            ((RandomCounter) rand).setCounter(0);
        }
    }

}
