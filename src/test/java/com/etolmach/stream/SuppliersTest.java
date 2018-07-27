package com.etolmach.stream;

import org.junit.Test;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

import static com.etolmach.stream.Suppliers.boxed;
import static org.junit.Assert.assertEquals;

/**
 * @author Evgeniy Tolmach
 */
public class SuppliersTest {

    private static int PRIMITIVE_INT_VALUE = 123;
    private static long PRIMITIVE_LONG_VALUE = 123L;
    private static double PRIMITIVE_DOUBLE_VALUE = 123.0;

    private static Integer INT_VALUE = 123;
    private static Long LONG_VALUE = 123L;
    private static Double DOUBLE_VALUE = 123.0;

    private IntSupplier primitiveIntSupplier = () -> PRIMITIVE_INT_VALUE;
    private LongSupplier primitiveLongSupplier = () -> PRIMITIVE_LONG_VALUE;
    private DoubleSupplier primitiveDoubleSupplier = () -> PRIMITIVE_DOUBLE_VALUE;

    @Test
    public void boxedIntSupplier() {
        assertEquals(INT_VALUE, boxed(primitiveIntSupplier).get());
    }

    @Test
    public void boxedLongSupplier() {
        assertEquals(LONG_VALUE, boxed(primitiveLongSupplier).get());
    }

    @Test
    public void boxedDoubleSupplier() {
        assertEquals(DOUBLE_VALUE, boxed(primitiveDoubleSupplier).get());
    }

}