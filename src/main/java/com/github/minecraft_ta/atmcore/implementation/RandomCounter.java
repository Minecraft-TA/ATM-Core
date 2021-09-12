package com.github.minecraft_ta.atmcore.implementation;

import java.util.Random;

public class RandomCounter extends Random {

    private int counter;

    @Override
    public int next(int bits) {
        counter++;
        return super.next(bits);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
