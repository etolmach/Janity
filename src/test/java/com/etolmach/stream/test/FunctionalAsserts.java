package com.etolmach.stream.test;

import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;

/**
 * @author Evgeniy Tolmach
 */
public class FunctionalAsserts {

    public static <T, R> UnaryFunctionAssert<T, R> assertThat(Function<T, R> function) {
        return new UnaryFunctionAssert<>(function);
    }

    public static UnaryIntAssert assertThat(IntUnaryOperator operator) {
        return new UnaryIntAssert(operator);
    }

    public static UnaryLongAssert assertThat(LongUnaryOperator operator) {
        return new UnaryLongAssert(operator);
    }

    public static UnaryDoubleAssert assertThat(DoubleUnaryOperator operator) {
        return new UnaryDoubleAssert(operator);
    }
}
