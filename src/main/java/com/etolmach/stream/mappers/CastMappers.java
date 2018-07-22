package com.etolmach.stream.mappers;

import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

/**
 * @author Evgeniy Tolmach
 */
public class CastMappers {

    public static LongFunction<Integer> longToInt() {
        return value -> (int) value;
    }

    public static DoubleFunction<Integer> doubleToInt() {
        return value -> (int) value;
    }

    public static IntFunction<Long> intToLong() {
        return value -> (long) value;
    }

    public static DoubleFunction<Long> doubleToLong() {
        return value -> (long) value;
    }

    public static IntFunction<Double> intToDouble() {
        return value -> (double) value;
    }

    public static LongFunction<Double> longToDouble() {
        return value -> (double) value;
    }

    public static Function<Number, Integer> toInt() {
        return number -> number.intValue();
    }

    public static Function<Number, Long> toLong() {
        return number -> number.longValue();
    }

    public static Function<Number, Double> toDouble() {
        return number -> number.doubleValue();
    }

    public static <T, R> Function<T, R> to(Class<R> type) {
        return type::cast;
    }

}
