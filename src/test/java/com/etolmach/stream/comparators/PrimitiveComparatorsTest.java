package com.etolmach.stream.comparators;

import org.junit.Test;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

import static com.etolmach.stream.comparators.PrimitiveComparators.equalsTo;
import static com.etolmach.stream.comparators.PrimitiveComparators.greaterOrEqualTo;
import static com.etolmach.stream.comparators.PrimitiveComparators.greaterThan;
import static com.etolmach.stream.comparators.PrimitiveComparators.lessOrEqualTo;
import static com.etolmach.stream.comparators.PrimitiveComparators.lessThan;
import static com.etolmach.stream.comparators.PrimitiveComparators.notEqualsTo;
import static java.lang.Double.valueOf;
import static java.lang.Integer.valueOf;
import static java.lang.Long.valueOf;
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
        Integer ten = valueOf(10);
        assertFalse(equalsTo(ten).test(8));
        assertTrue(equalsTo(ten).test(10));
        assertFalse(equalsTo(ten).test(12));
    }

    @Test
    public void equalsToLongObject() {
        Long ten = valueOf(10L);
        assertFalse(equalsTo(ten).test(8));
        assertTrue(equalsTo(ten).test(10));
        assertFalse(equalsTo(ten).test(12));
    }

    @Test
    public void equalsToDoubleObject() {
        Double ten = valueOf(10.0);
        assertFalse(equalsTo(ten).test(8.0));
        assertTrue(equalsTo(ten).test(10.0));
        assertFalse(equalsTo(ten).test(12.0));
    }

    @Test
    public void equalsToAnObject() {
        Double ten = valueOf(10.0);
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
        Integer ten = valueOf(10);
        assertTrue(notEqualsTo(ten).test(8));
        assertFalse(notEqualsTo(ten).test(10));
        assertTrue(notEqualsTo(ten).test(12));
    }

    @Test
    public void notEqualsToLongObject() {
        Long ten = valueOf(10L);
        assertTrue(notEqualsTo(ten).test(8));
        assertFalse(notEqualsTo(ten).test(10));
        assertTrue(notEqualsTo(ten).test(12));
    }

    @Test
    public void notEqualsToDoubleObject() {
        Double ten = valueOf(10.0);
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
        assertTrue(lessThan(valueOf(10)).test(8));
        assertFalse(lessThan(valueOf(10)).test(10));
        assertFalse(lessThan(valueOf(10)).test(12));
    }

    @Test
    public void lessThanLongObject() {
        assertTrue(lessThan(valueOf(10L)).test(8));
        assertFalse(lessThan(valueOf(10L)).test(10));
        assertFalse(lessThan(valueOf(10L)).test(12));
    }

    @Test
    public void lessThanDoubleObject() {
        assertTrue(lessThan(valueOf(10.0)).test(8.0));
        assertFalse(lessThan(valueOf(10.0)).test(10.0));
        assertFalse(lessThan(valueOf(10.0)).test(12.0));
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
        assertTrue(lessOrEqualTo(valueOf(10)).test(8));
        assertTrue(lessOrEqualTo(valueOf(10)).test(10));
        assertFalse(lessOrEqualTo(valueOf(10)).test(12));
    }

    @Test
    public void lessOrEqualToLongObject() {
        assertTrue(lessOrEqualTo(valueOf(10L)).test(8));
        assertTrue(lessOrEqualTo(valueOf(10L)).test(10));
        assertFalse(lessOrEqualTo(valueOf(10L)).test(12));
    }

    @Test
    public void lessOrEqualToDoubleObject() {
        assertTrue(lessOrEqualTo(valueOf(10.0)).test(8.0));
        assertTrue(lessOrEqualTo(valueOf(10.0)).test(10.0));
        assertFalse(lessOrEqualTo(valueOf(10.0)).test(12.0));
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
        assertFalse(greaterThan(valueOf(10)).test(8));
        assertFalse(greaterThan(valueOf(10)).test(10));
        assertTrue(greaterThan(valueOf(10)).test(12));
    }

    @Test
    public void greaterThanLongObject() {
        assertFalse(greaterThan(valueOf(10L)).test(8L));
        assertFalse(greaterThan(valueOf(10L)).test(10L));
        assertTrue(greaterThan(valueOf(10L)).test(12L));
    }

    @Test
    public void greaterThanDoubleObject() {
        assertFalse(greaterThan(valueOf(10.0)).test(8.0));
        assertFalse(greaterThan(valueOf(10.0)).test(10.0));
        assertTrue(greaterThan(valueOf(10.0)).test(12.0));
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
        assertFalse(greaterOrEqualTo(valueOf(10)).test(8));
        assertTrue(greaterOrEqualTo(valueOf(10)).test(10));
        assertTrue(greaterOrEqualTo(valueOf(10)).test(12));
    }

    @Test
    public void greaterOrEqualToLongObject() {
        assertFalse(greaterOrEqualTo(valueOf(10L)).test(8));
        assertTrue(greaterOrEqualTo(valueOf(10L)).test(10));
        assertTrue(greaterOrEqualTo(valueOf(10L)).test(12));
    }

    @Test
    public void greaterOrEqualToDoubleObject() {
        assertFalse(greaterOrEqualTo(valueOf(10.0)).test(8.0));
        assertTrue(greaterOrEqualTo(valueOf(10.0)).test(10.0));
        assertTrue(greaterOrEqualTo(valueOf(10.0)).test(12.0));
    }
}
