package com.etolmach.stream.comparators;

import org.junit.Test;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

import static com.etolmach.stream.comparators.PrimitiveComparators.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Evgeniy Tolmach
 */
public class PrimitiveComparatorsTest {

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
        Integer ten = Integer.valueOf(10);
        assertFalse(equalsTo(ten).test(8));
        assertTrue(equalsTo(ten).test(10));
        assertFalse(equalsTo(ten).test(12));
    }

    @Test
    public void equalsToLongObject() {
        Long ten = Long.valueOf(10L);
        assertFalse(equalsTo(ten).test(8));
        assertTrue(equalsTo(ten).test(10));
        assertFalse(equalsTo(ten).test(12));
    }

    @Test
    public void equalsToDoubleObject() {
        Double ten = Double.valueOf(10.0);
        assertFalse(equalsTo(ten).test(8.0));
        assertTrue(equalsTo(ten).test(10.0));
        assertFalse(equalsTo(ten).test(12.0));
    }

    @Test
    public void equalsToAnObject() {
        Double ten = Double.valueOf(10.0);
        assertFalse(equalsTo(ten).test(8.0));
        assertTrue(equalsTo(ten).test(10.0));
        assertFalse(equalsTo(ten).test(12.0));
//        assertFalse(equalTo(new PrimitiveComparatorsTest()).test(12.0));
    }

    @Test
    public void equalsToIntFromSupplier() {
        IntSupplier supplier = () -> 10;
        assertFalse(equalsTo(supplier).test(8));
        assertTrue(equalsTo(supplier).test(10));
        assertFalse(equalsTo(supplier).test(12));
    }

    @Test
    public void equalsToLongFromSupplier() {
        LongSupplier supplier = () -> 10L;
        assertFalse(equalsTo(supplier).test(8L));
        assertTrue(equalsTo(supplier).test(10L));
        assertFalse(equalsTo(supplier).test(12L));
    }

    @Test
    public void equalsToDoubleFromSupplier() {
        DoubleSupplier supplier = () -> 10.0;
        assertFalse(equalsTo(supplier).test(8.0));
        assertTrue(equalsTo(supplier).test(10.0));
        assertFalse(equalsTo(supplier).test(12.0));
    }

    @Test
    public void equalsToAnObjectFromSupplier() {
        PrimitiveComparatorsTest object = new PrimitiveComparatorsTest();
        assertFalse(Comparators.equalTo(() -> object).test(new PrimitiveComparatorsTest()));
        assertTrue(Comparators.equalTo(() -> object).test(object));
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
        Integer ten = Integer.valueOf(10);
        assertTrue(notEqualsTo(ten).test(8));
        assertFalse(notEqualsTo(ten).test(10));
        assertTrue(notEqualsTo(ten).test(12));
    }

    @Test
    public void notEqualsToLongObject() {
        Long ten = Long.valueOf(10L);
        assertTrue(notEqualsTo(ten).test(8));
        assertFalse(notEqualsTo(ten).test(10));
        assertTrue(notEqualsTo(ten).test(12));
    }

    @Test
    public void notEqualsToDoubleObject() {
        Double ten = Double.valueOf(10.0);
        assertTrue(notEqualsTo(ten).test(8.0));
        assertFalse(notEqualsTo(ten).test(10.0));
        assertTrue(notEqualsTo(ten).test(12.0));
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

    @Test
    public void greaterThanInt() {
        assertFalse(greaterThan(10).test(8));
        assertFalse(greaterThan(10).test(10));
        assertTrue(greaterThan(10).test(12));
    }

    @Test
    public void greaterThanLong() {
        assertFalse(greaterThan(10L).test(8));
        assertFalse(greaterThan(10L).test(10));
        assertTrue(greaterThan(10L).test(12));
    }

    @Test
    public void greaterThanDouble() {
        assertFalse(greaterThan(10.0).test(8.0));
        assertFalse(greaterThan(10.0).test(10.0));
        assertTrue(greaterThan(10.0).test(12.0));
    }

    @Test
    public void greaterThanIntObject() {
        assertFalse(greaterThan(Integer.valueOf(10)).test(8));
        assertFalse(greaterThan(Integer.valueOf(10)).test(10));
        assertTrue(greaterThan(Integer.valueOf(10)).test(12));
    }

    @Test
    public void greaterThanLongObject() {
        assertFalse(greaterThan(Long.valueOf(10L)).test(8));
        assertFalse(greaterThan(Long.valueOf(10L)).test(10));
        assertTrue(greaterThan(Long.valueOf(10L)).test(12));
    }

    @Test
    public void greaterThanDoubleObject() {
        assertFalse(greaterThan(Double.valueOf(10.0)).test(8.0));
        assertFalse(greaterThan(Double.valueOf(10.0)).test(10.0));
        assertTrue(greaterThan(Double.valueOf(10.0)).test(12.0));
    }

    @Test
    public void greaterOrEqualToInt() {
        assertFalse(greaterOrEqualTo(10).test(8));
        assertTrue(greaterOrEqualTo(10).test(10));
        assertTrue(greaterOrEqualTo(10).test(12));
    }

    @Test
    public void greaterOrEqualToLong() {
        assertFalse(greaterOrEqualTo(10L).test(8));
        assertTrue(greaterOrEqualTo(10L).test(10));
        assertTrue(greaterOrEqualTo(10L).test(12));
    }

    @Test
    public void greaterOrEqualToDouble() {
        assertFalse(greaterOrEqualTo(10.0).test(8.0));
        assertTrue(greaterOrEqualTo(10.0).test(10.0));
        assertTrue(greaterOrEqualTo(10.0).test(12.0));
    }

    @Test
    public void greaterOrEqualToIntObject() {
        assertFalse(greaterOrEqualTo(Integer.valueOf(10)).test(8));
        assertTrue(greaterOrEqualTo(Integer.valueOf(10)).test(10));
        assertTrue(greaterOrEqualTo(Integer.valueOf(10)).test(12));
    }

    @Test
    public void greaterOrEqualToLongObject() {
        assertFalse(greaterOrEqualTo(Long.valueOf(10L)).test(8));
        assertTrue(greaterOrEqualTo(Long.valueOf(10L)).test(10));
        assertTrue(greaterOrEqualTo(Long.valueOf(10L)).test(12));
    }

    @Test
    public void greaterOrEqualToDoubleObject() {
        assertFalse(greaterOrEqualTo(Double.valueOf(10.0)).test(8.0));
        assertTrue(greaterOrEqualTo(Double.valueOf(10.0)).test(10.0));
        assertTrue(greaterOrEqualTo(Double.valueOf(10.0)).test(12.0));
    }
}
