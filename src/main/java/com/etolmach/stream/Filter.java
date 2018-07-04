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

}