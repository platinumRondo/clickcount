package com.github.platinumrondo.clickcount.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SingleIncrementCountModelTest {
    private SingleIncrementCountModel model;
    
    @Before
    public void setUp() {
        model = new SingleIncrementCountModel();
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
