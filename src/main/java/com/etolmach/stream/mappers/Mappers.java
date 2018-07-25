package com.etolmach.stream.mappers;

import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

/**
 * @author Evgeniy Tolmach
 */
public class Mappers {

    public static <R> Function<IntFunction<R>, R> applyTo(int value) {
        return function -> function.apply(value);
    }

    public static <R> Function<LongFunction<R>, R> applyTo(long value) {
        return function -> function.apply(value);
    }

    public static <R> Function<DoubleFunction<R>, R> applyTo(double value) {
        return function -> function.apply(value);
    }

    public static <T, R> Function<Function<T, R>, R> applyTo(T value) {
        return function -> function.apply(value);
    }

    public static <T, R> Function<T, R> constant(R value) {
        return __ -> value;
    }

    public static <T> Function<T, Integer> intValueOf(Function<T, ? extends Number> function) {
        return function.andThen(Number::intValue);
    }

    public static <T> Function<T, Long> longValueOf(Function<T, ? extends Number> function) {
        return function.andThen(Number::longValue);
    }

    public static <T> Function<T, Double> doubleValueOf(Function<T, ? extends Number> function) {
        return function.andThen(Number::doubleValue);
    }

}
