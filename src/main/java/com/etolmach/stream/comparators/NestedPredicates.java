package com.etolmach.stream.comparators;

import java.util.function.*;

import static com.etolmach.stream.mappers.Mappers.applyTo;
import static java.util.Arrays.stream;

/**
 * @author Evgeniy Tolmach
 */
public class NestedPredicates {

    public static <R> IntPredicate resultsAreEqual(IntFunction<R> function, IntFunction<R>... targetFunctions) {
        return i -> {
            R value = function.apply(i);
            return stream(targetFunctions)
                    .map(applyTo(i))
                    .allMatch(Comparators.equalTo(value));
        };
    }

    public static <R> LongPredicate resultsAreEqual(LongFunction<R> function, LongFunction<R>... targetFunctions) {
        return l -> {
            R value = function.apply(l);
            return stream(targetFunctions)
                    .map(applyTo(l))
                    .allMatch(Comparators.equalTo(value));
        };
    }

    public static <R> DoublePredicate resultsAreEqual(DoubleFunction<R> function, DoubleFunction<R>... targetFunctions) {
        return d -> {
            R value = function.apply(d);
            return stream(targetFunctions)
                    .map(applyTo(d))
                    .allMatch(Comparators.equalTo(value));
        };
    }

    public static <T, R> Predicate<T> resultsAreEqual(Function<T, R> function, Function<T, R>... targetFunctions) {
        return t -> {
            R value = function.apply(t);
            return stream(targetFunctions)
                    .map(applyTo(t))
                    .allMatch(Comparators.equalTo(value));
        };
    }

    // =====================================================================

    public static <R> IntPredicate resultsAreNotEqual(IntFunction<R> function, IntFunction<R>... targetFunctions) {
        return i -> {
            R value = function.apply(i);
            return stream(targetFunctions)
                    .map(applyTo(i))
                    .noneMatch(Comparators.equalTo(value));
        };
    }

    public static <R> LongPredicate resultsAreNotEqual(LongFunction<R> function, LongFunction<R>... targetFunctions) {
        return l -> {
            R value = function.apply(l);
            return stream(targetFunctions)
                    .map(applyTo(l))
                    .noneMatch(Comparators.equalTo(value));
        };
    }

    public static <R> DoublePredicate resultsAreNotEqual(DoubleFunction<R> function, DoubleFunction<R>... targetFunctions) {
        return d -> {
            R value = function.apply(d);
            return stream(targetFunctions)
                    .map(applyTo(d))
                    .noneMatch(Comparators.equalTo(value));
        };
    }

    public static <T, R> Predicate<T> resultsAreNotEqual(Function<T, R> function, Function<T, R>... targetFunctions) {
        return t -> {
            R value = function.apply(t);
            return stream(targetFunctions)
                    .map(applyTo(t))
                    .noneMatch(Comparators.equalTo(value));
        };
    }

}
