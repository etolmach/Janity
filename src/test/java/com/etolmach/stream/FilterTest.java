package com.etolmach.stream;

import org.junit.Test;

import static com.etolmach.stream.Filter.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Evgeniy Tolmach
 */
public class FilterTest {

    @Test
    public void equalsToInt() {
        assertFalse(equalsTo(10).test(8));
        assertTrue(equalsTo(10).test(10));
        assertFalse(equalsTo(10).test(12));
    }

    @Test
    public void equalsToLong() {
        assertFalse(equalsTo(10L).test(8));
        assertTrue(equalsTo(10L).test(10));
        assertFalse(equalsTo(10L).test(12));
    }

    @Test
    public void equalsToDouble() {
        assertFalse(equalsTo(10.0).test(8.0));
        assertTrue(equalsTo(10.0).test(10.0));
        assertFalse(equalsTo(10.0).test(12.0));
    }

    @Test
    public void equalsToIntObject() {
        assertFalse(equalsTo(Integer.valueOf(10)).test(8));
        assertTrue(equalsTo(Integer.valueOf(10)).test(10));
        assertFalse(equalsTo(Integer.valueOf(10)).test(12));
    }

    @Test
    public void equalsToLongObject() {
        assertFalse(equalsTo(Long.valueOf(10L)).test(8));
        assertTrue(equalsTo(Long.valueOf(10L)).test(10));
        assertFalse(equalsTo(Long.valueOf(10L)).test(12));
    }

    @Test
    public void equalsToDoubleObject() {
        assertFalse(equalsTo(Double.valueOf(10.0)).test(8.0));
        assertTrue(equalsTo(Double.valueOf(10.0)).test(10.0));
        assertFalse(equalsTo(Double.valueOf(10.0)).test(12.0));
    }

    @Test
    public void notEqualsToInt() {
        assertTrue(notEqualsTo(10).test(8));
        assertFalse(notEqualsTo(10).test(10));
        assertTrue(notEqualsTo(10).test(12));
    }

    @Test
    public void notEqualsToLong() {
        assertTrue(notEqualsTo(10L).test(8));
        assertFalse(notEqualsTo(10L).test(10));
        assertTrue(notEqualsTo(10L).test(12));
    }

    @Test
    public void notEqualsToDouble() {
        assertTrue(notEqualsTo(10.0).test(8.0));
        assertFalse(notEqualsTo(10.0).test(10.0));
        assertTrue(notEqualsTo(10.0).test(12.0));
    }

    @Test
    public void notEqualsToIntObject() {
        assertTrue(notEqualsTo(Integer.valueOf(10)).test(8));
        assertFalse(notEqualsTo(Integer.valueOf(10)).test(10));
        assertTrue(notEqualsTo(Integer.valueOf(10)).test(12));
    }

    @Test
    public void notEqualsToLongObject() {
        assertTrue(notEqualsTo(Long.valueOf(10L)).test(8));
        assertFalse(notEqualsTo(Long.valueOf(10L)).test(10));
        assertTrue(notEqualsTo(Long.valueOf(10L)).test(12));
    }

    @Test
    public void notEqualsToDoubleObject() {
        assertTrue(notEqualsTo(Double.valueOf(10.0)).test(8.0));
        assertFalse(notEqualsTo(Double.valueOf(10.0)).test(10.0));
        assertTrue(notEqualsTo(Double.valueOf(10.0)).test(12.0));
    }

    @Test
    public void lessThanInt() {
        assertTrue(lessThan(10).test(8));
        assertFalse(lessThan(10).test(10));
        assertFalse(lessThan(10).test(12));
    }

    @Test
    public void lessThanLong() {
        assertTrue(lessThan(10L).test(8));
        assertFalse(lessThan(10L).test(10));
        assertFalse(lessThan(10L).test(12));
    }

    @Test
    public void lessThanDouble() {
        assertTrue(lessThan(10.0).test(8.0));
        assertFalse(lessThan(10.0).test(10.0));
        assertFalse(lessThan(10.0).test(12.0));
    }

    @Test
    public void lessThanIntObject() {
        assertTrue(lessThan(Integer.valueOf(10)).test(8));
        assertFalse(lessThan(Integer.valueOf(10)).test(10));
        assertFalse(lessThan(Integer.valueOf(10)).test(12));
    }

    @Test
    public void lessThanLongObject() {
        assertTrue(lessThan(Long.valueOf(10L)).test(8));
        assertFalse(lessThan(Long.valueOf(10L)).test(10));
        assertFalse(lessThan(Long.valueOf(10L)).test(12));
    }

    @Test
    public void lessThanDoubleObject() {
        assertTrue(lessThan(Double.valueOf(10.0)).test(8.0));
        assertFalse(lessThan(Double.valueOf(10.0)).test(10.0));
        assertFalse(lessThan(Double.valueOf(10.0)).test(12.0));
    }

    @Test
    public void lessOrEqualToInt() {
        assertTrue(lessOrEqualTo(10).test(8));
        assertTrue(lessOrEqualTo(10).test(10));
        assertFalse(lessOrEqualTo(10).test(12));
    }

    @Test
    public void lessOrEqualToLong() {
        assertTrue(lessOrEqualTo(10L).test(8));
        assertTrue(lessOrEqualTo(10L).test(10));
        assertFalse(lessOrEqualTo(10L).test(12));
    }

    @Test
    public void lessOrEqualToDouble() {
        assertTrue(lessOrEqualTo(10.0).test(8.0));
        assertTrue(lessOrEqualTo(10.0).test(10.0));
        assertFalse(lessOrEqualTo(10.0).test(12.0));
    }

    @Test
    public void lessOrEqualToIntObject() {
        assertTrue(lessOrEqualTo(Integer.valueOf(10)).test(8));
        assertTrue(lessOrEqualTo(Integer.valueOf(10)).test(10));
        assertFalse(lessOrEqualTo(Integer.valueOf(10)).test(12));
    }

    @Test
    public void lessOrEqualToLongObject() {
        assertTrue(lessOrEqualTo(Long.valueOf(10L)).test(8));
        assertTrue(lessOrEqualTo(Long.valueOf(10L)).test(10));
        assertFalse(lessOrEqualTo(Long.valueOf(10L)).test(12));
    }

    @Test
    public void lessOrEqualToDoubleObject() {
        assertTrue(lessOrEqualTo(Double.valueOf(10.0)).test(8.0));
        assertTrue(lessOrEqualTo(Double.valueOf(10.0)).test(10.0));
        assertFalse(lessOrEqualTo(Double.valueOf(10.0)).test(12.0));
    }

    
}
