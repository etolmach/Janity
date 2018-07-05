package com.etolmach.stream;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

/**
 * @author Evgeniy Tolmach
 */
public class Filter {

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

    // =====================================================================

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

    public static IntPredicate greaterThan(Integer value) {
        return greaterThan(value.intValue());
    }

    public static LongPredicate greaterThan(Long value) {
        return greaterThan(value.longValue());
    }

    public static DoublePredicate greaterThan(Double value) {
        return greaterThan(value.doubleValue());
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

}