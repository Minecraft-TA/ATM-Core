package com.github.minecraft_ta.atmcore.block;

import com.github.minecraft_ta.atmcore.ATMCore;
import com.github.minecraft_ta.atmcore.implementation.RandomCounter;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.TextComponentString;

import java.util.Random;

public class RandomBlockTile extends TileEntity implements ITickable {

    @Override
    public void update() {
        if (!world.isRemote) {
            Random rand = world.rand;
            if (rand instanceof RandomCounter) {
                final int randCounter = ((RandomCounter) rand).getCounter();

                int counter = 0;
                while (rand.nextInt(33) != 0) {
                    counter++;
                }
                ATMCore.LOGGER.info("Calledcounter: " + randCounter + " Callcounter : " + counter);
                int finalCounter = counter;
                world.playerEntities.forEach(entityPlayer -> entityPlayer.sendMessage(new TextComponentString("Calledcounter: " + randCounter + " Callcounter : " + finalCounter)));
                ((RandomCounter) rand).setCounter(0);
            }
        }
    }
}
