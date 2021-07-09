package com.github.minecraft_ta.atmcore.implementation;

import java.util.Random;

public class RandomCounter extends Random {

    private int counter;

    @Override
    public int nextInt() {
        counter++;
        return super.nextInt();
    }

    @Override
    public int nextInt(int bound) {
        counter++;
        return super.nextInt(bound);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
