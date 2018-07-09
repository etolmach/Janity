package com.etolmach.stream.comparators;

import java.util.function.*;

/**
 * @author Evgeniy Tolmach
 */
public class Predicates {

    public static Predicate<IntPredicate> testing(int value) {
        return predicate -> predicate.test(value);
    }

    public static Predicate<LongPredicate> testing(long value) {
        return predicate -> predicate.test(value);
    }

    public static Predicate<DoublePredicate> testing(double value) {
        return predicate -> predicate.test(value);
    }

    public static <T> Predicate<Predicate<T>> testing(T value) {
        return predicate -> predicate.test(value);
    }

    public static <T1, T2> Predicate<BiPredicate<T1, T2>> testing(T1 value1, T2 value2) {
        return predicate -> predicate.test(value1, value2);
    }

}
