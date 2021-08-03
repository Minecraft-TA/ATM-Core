package com.github.minecraft_ta.atmcore.block;

import com.github.minecraft_ta.atmcore.ATMCore;
import com.github.minecraft_ta.atmcore.implementation.RandomCounter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import java.util.Random;

public class RandomBlockTile extends TileEntity implements ITickable {

    @Override
    public void update() {
        if (!world.isRemote) {
            ATMCore.LOGGER.info(world.provider.getDimensionType().getId());

            Random rand = world.rand;
            if (rand instanceof RandomCounter) {
                BlockPos pos = this.getPos();
                EntityPlayer closestPlayer = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 100, false);
                System.out.println(((RandomCounter) rand).getCounter());
                if (closestPlayer != null) {
                    closestPlayer.sendMessage(new TextComponentString("Random calls: " + ((RandomCounter) rand).getCounter()));
                }
                ((RandomCounter) rand).setCounter(0);
            }
        }
    }
}
