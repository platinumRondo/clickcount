package com.github.platinumrondo.clickcount.model;

public class SingleIncrementCountModel implements CountModel {
    private long value;
    
    public SingleIncrementCountModel() {
        this(0);
    }
    
    public SingleIncrementCountModel(long start) {
        this.value = start;
    }

    @Override
    public void increment() {
        value++;
    }

    @Override
    public long get() {
        return value;
    }

    @Override
    public void reset() {
        value = 0;
    }
    
    @Override
    public String toString() {
        return Long.toString(value);
    }

}
