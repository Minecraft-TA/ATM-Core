package com.github.minecraft_ta.atmcore.mixin;

import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TileEntityChest.class)
public class TileEntityChestMixin {

    @Redirect(method = "checkForAdjacentChests", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;isAreaLoaded(Lnet/minecraft/util/math/BlockPos;I)Z"))
    public boolean checkForAdjacentChests(World world, BlockPos center, int radius) {
        return true;
    }

}
