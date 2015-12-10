package com.github.platinumrondo.clickcount.model;

public interface CountModel {
    
    /**
     * Increment the count. The implementation decide how much.
     */
    void increment();
    /**
     * @return the current value reached
     */
    long get();
    /**
     * Reset the count to its original value. Usually zero, depends on the
     * implementation.
     */
    void reset();

}
