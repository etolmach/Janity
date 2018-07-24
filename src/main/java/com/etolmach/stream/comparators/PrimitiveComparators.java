package com.etolmach.stream.comparators;

import java.util.Objects;
import java.util.function.*;

import static com.etolmach.stream.mappers.Mappers.applyTo;
import static java.util.Arrays.stream;

/**
 * @author Evgeniy Tolmach
 */
public class PrimitiveComparators {

    public static IntPredicate equalsTo(int value) {
        return i -> i == value;
    }

    public static LongPredicate equalsTo(long value) {
        return i -> i == value;
    }

    public static DoublePredicate equalsTo(double value) {
        return i -> i == value;
    }

    public static IntPredicate equalsTo(Integer value) {
        return equalsTo(value.intValue());
    }

    public static LongPredicate equalsTo(Long value) {
        return equalsTo(value.longValue());
    }

    public static DoublePredicate equalsTo(Double value) {
        return equalsTo(value.doubleValue());
    }

    public static <T> Predicate<T> equalsTo(T t) {
        return o -> Objects.equals(o, t);
    }

    public static IntPredicate equalsTo(IntSupplier supplier) {
        return i -> i == supplier.getAsInt();
    }

    public static LongPredicate equalsTo(LongSupplier supplier) {
        return i -> i == supplier.getAsLong();
    }

    public static DoublePredicate equalsTo(DoubleSupplier supplier) {
        return i -> i == supplier.getAsDouble();
    }

    public static <T> Predicate<T> equalsTo(Supplier<T> supplier) {
        return o -> Objects.equals(o, supplier.get());
    }

    public static IntPredicate notEqualsTo(int value) {
        return i -> i != value;
    }

    public static LongPredicate notEqualsTo(long value) {
        return i -> i != value;
    }

    public static DoublePredicate notEqualsTo(double value) {
        return i -> i != value;
    }

    public static IntPredicate notEqualsTo(Integer value) {
        return notEqualsTo(value.intValue());
    }

    public static LongPredicate notEqualsTo(Long value) {
        return notEqualsTo(value.longValue());
    }

    public static DoublePredicate notEqualsTo(Double value) {
        return notEqualsTo(value.doubleValue());
    }

    // =====================================================================

    public static IntPredicate lessThan(int value) {
        return i -> i < value;
    }

    public static LongPredicate lessThan(long value) {
        return i -> i < value;
    }

    public static DoublePredicate lessThan(double value) {
        return i -> i < value;
    }

    public static IntPredicate lessThan(Integer value) {
        return lessThan(value.intValue());
    }

    public static LongPredicate lessThan(Long value) {
        return lessThan(value.longValue());
    }

    public static DoublePredicate lessThan(Double value) {
        return lessThan(value.doubleValue());
    }

    // =====================================================================

    public static IntPredicate lessOrEqualTo(int value) {
        return i -> i <= value;
    }

    public static LongPredicate lessOrEqualTo(long value) {
        return i -> i <= value;
    }

    public static DoublePredicate lessOrEqualTo(double value) {
        return i -> i <= value;
    }

    public static IntPredicate lessOrEqualTo(Integer value) {
        return lessOrEqualTo(value.intValue());
    }

    public static LongPredicate lessOrEqualTo(Long value) {
        return lessOrEqualTo(value.longValue());
    }

    public static DoublePredicate lessOrEqualTo(Double value) {
        return lessOrEqualTo(value.doubleValue());
    }

    // =====================================================================

    public static IntPredicate greaterThan(int value) {
        return i -> i > value;
    }

    public static LongPredicate greaterThan(long value) {
        return i -> i > value;
    }

    public static DoublePredicate greaterThan(double value) {
        return i -> i > value;
    }

    // TODO: refactor other comparators
    public static <T extends Comparable> Predicate<T> greaterThan(Object o) {
        return t -> t.compareTo(o) > 0;
    }

    // =====================================================================

    public static IntPredicate greaterOrEqualTo(int value) {
        return i -> i >= value;
    }

    public static LongPredicate greaterOrEqualTo(long value) {
        return i -> i >= value;
    }

    public static DoublePredicate greaterOrEqualTo(double value) {
        return i -> i >= value;
    }

    public static IntPredicate greaterOrEqualTo(Integer value) {
        return greaterOrEqualTo(value.intValue());
    }

    public static LongPredicate greaterOrEqualTo(Long value) {
        return greaterOrEqualTo(value.longValue());
    }

    public static DoublePredicate greaterOrEqualTo(Double value) {
        return greaterOrEqualTo(value.doubleValue());
    }

    // =====================================================================

    private static <T, R> boolean resultsAre(Predicate<R> predicate, T val, Function<T, R>... functions) {
        if (functions.length == 0) return false;
        if (functions.length == 1) return true;
        R res = functions[0].apply(val);
        return stream(functions, 1, functions.length)
                .map(applyTo(val))
                .allMatch(predicate);

    }

    public static <R> IntPredicate resultsAreEqual(IntFunction<R>... functions) {
        return i -> {
            if (functions.length == 0) return false;
            if (functions.length == 1) return true;
            R value = functions[0].apply(i);
            return stream(functions, 1, functions.length)
                    .map(applyTo(i))
                    .allMatch(equalsTo(value));

        };
    }

    public static <R> LongPredicate resultsAreEqual(LongFunction<R> function, LongFunction<R>... targetFunctions) {
        return l -> {
            R value = function.apply(l);
            return stream(targetFunctions)
                    .map(applyTo(l))
                    .allMatch(equalsTo(value));
        };
    }

    public static <R> DoublePredicate resultsAreEqual(DoubleFunction<R> function, DoubleFunction<R>... targetFunctions) {
        return d -> {
            R value = function.apply(d);
            return stream(targetFunctions)
                    .map(applyTo(d))
                    .allMatch(equalsTo(value));
        };
    }

}
