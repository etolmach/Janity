package com.etolmach.stream;

import org.junit.Test;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

import static com.etolmach.stream.Suppliers.boxed;
import static com.etolmach.stream.Suppliers.unboxedBoolean;
import static com.etolmach.stream.Suppliers.unboxedDouble;
import static com.etolmach.stream.Suppliers.unboxedInt;
import static com.etolmach.stream.Suppliers.unboxedLong;
import static org.assertj.core.api.Assertions.assertThat;

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

    private BooleanSupplier primitiveBooleanSupplier = () -> true;
    private IntSupplier primitiveIntSupplier = () -> PRIMITIVE_INT_VALUE;
    private LongSupplier primitiveLongSupplier = () -> PRIMITIVE_LONG_VALUE;
    private DoubleSupplier primitiveDoubleSupplier = () -> PRIMITIVE_DOUBLE_VALUE;

    private Supplier<Boolean> booleanSupplier = () -> true;
    private Supplier<Integer> intSupplier = () -> PRIMITIVE_INT_VALUE;
    private Supplier<Long> longSupplier = () -> PRIMITIVE_LONG_VALUE;
    private Supplier<Double> doubleSupplier = () -> PRIMITIVE_DOUBLE_VALUE;

    @Test
    public void boxedBooleanSupplier() {
        assertThat(boxed(primitiveBooleanSupplier).get()).isTrue();
    }

    @Test
    public void boxedIntSupplier() {
        assertThat(boxed(primitiveIntSupplier).get()).isEqualTo(INT_VALUE);
    }

    @Test
    public void boxedLongSupplier() {
        assertThat(boxed(primitiveLongSupplier).get()).isEqualTo(LONG_VALUE);
    }

    @Test
    public void boxedDoubleSupplier() {
        assertThat(boxed(primitiveDoubleSupplier).get()).isEqualTo(DOUBLE_VALUE);
    }

    @Test
    public void unboxedBooleanSupplier() {
        assertThat(unboxedBoolean(booleanSupplier).getAsBoolean()).isTrue();
    }

    @Test
    public void unboxedIntSupplier() {
        assertThat(unboxedInt(intSupplier).getAsInt()).isEqualTo(PRIMITIVE_INT_VALUE);
    }

    @Test
    public void unboxedLongSupplier() {
        assertThat(unboxedLong(longSupplier).getAsLong()).isEqualTo(PRIMITIVE_LONG_VALUE);
    }

    @Test
    public void unboxedDoubleSupplier() {
        assertThat(unboxedDouble(doubleSupplier).getAsDouble()).isEqualTo(PRIMITIVE_DOUBLE_VALUE);
    }

}