package com.etolmach.stream.mappers;

import org.junit.Test;

import static com.etolmach.stream.mappers.CastMappers.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Evgeniy Tolmach
 */
public class CastMappersTest {

    public static final int PRIMITIVE_INT_VALUE = 123;
    public static final long PRIMITIVE_LONG_VALUE = 123L;
    public static final double PRIMITIVE_DOUBLE_VALUE = 123.0;

    public static final Integer INT_VALUE = 123;
    public static final Long LONG_VALUE = 123L;
    public static final Double DOUBLE_VALUE = 123.0;


    @Test
    public void testLongToInt() {
        int castedValue = longToInt().apply(PRIMITIVE_LONG_VALUE);
        assertEquals(PRIMITIVE_INT_VALUE, castedValue);
    }

    @Test
    public void testDoubleToInt() {
        int castedValue = doubleToInt().apply(PRIMITIVE_DOUBLE_VALUE);
        assertEquals(PRIMITIVE_INT_VALUE, castedValue);
    }

    @Test
    public void testIntToLong() {
        long castedValue = intToLong().apply(PRIMITIVE_INT_VALUE);
        assertEquals(PRIMITIVE_LONG_VALUE, castedValue);
    }

    @Test
    public void testDoubleToLong() {
        long castedValue = doubleToLong().apply(PRIMITIVE_DOUBLE_VALUE);
        assertEquals(PRIMITIVE_LONG_VALUE, castedValue);
    }

    @Test
    public void testIntToDouble() {
        double castedValue = intToDouble().apply(PRIMITIVE_INT_VALUE);
        assertEquals(PRIMITIVE_DOUBLE_VALUE, castedValue, 0);
    }

    @Test
    public void testLongToDouble() {
        double castedValue = longToDouble().apply(PRIMITIVE_LONG_VALUE);
        assertEquals(PRIMITIVE_DOUBLE_VALUE, castedValue, 0);
    }

    @Test
    public void testToInt() {
        assertEquals(INT_VALUE, toInt().apply(PRIMITIVE_INT_VALUE));
        assertEquals(INT_VALUE, toInt().apply(PRIMITIVE_LONG_VALUE));
        assertEquals(INT_VALUE, toInt().apply(PRIMITIVE_DOUBLE_VALUE));
    }

    @Test
    public void testToLong() {
        assertEquals(LONG_VALUE, toLong().apply(PRIMITIVE_INT_VALUE));
        assertEquals(LONG_VALUE, toLong().apply(PRIMITIVE_LONG_VALUE));
        assertEquals(LONG_VALUE, toLong().apply(PRIMITIVE_DOUBLE_VALUE));
    }

    @Test
    public void testToDouble() {
        assertEquals(DOUBLE_VALUE, toDouble().apply(PRIMITIVE_INT_VALUE));
        assertEquals(DOUBLE_VALUE, toDouble().apply(PRIMITIVE_LONG_VALUE));
        assertEquals(DOUBLE_VALUE, toDouble().apply(PRIMITIVE_DOUBLE_VALUE));
    }

}