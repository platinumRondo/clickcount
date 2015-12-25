package com.github.platinumrondo.clickcount.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Random;

public class SingleIncrementCountModelTest {
    private SingleIncrementCountModel model;
    
    @Before
    public void setUp() {
        model = new SingleIncrementCountModel();
    }
    
    @Test
    public void testConstructorWithInitialValue() {
        Random r = new Random();
        int initialValue = r.nextInt();
        model = new SingleIncrementCountModel(initialValue);
        assertEquals(initialValue, model.get());
    }
    
    @Test
    public void testIncrement() {
        model.increment();
        assertEquals(1, model.get());
    }
    
    @Test
    public void testGet() {
        assertEquals(0, model.get());
    }
    
    @Test
    public void testReset() {
        model.reset();
        assertEquals(0, model.get());
    }

}
