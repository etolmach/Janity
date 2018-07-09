package com.etolmach.stream.comparators;

import java.util.function.*;

/**
 * @author Evgeniy Tolmach
 */
public class Predicates {

    public static IntPredicate not(IntPredicate predicate) {
        return predicate.negate();
    }

    public static LongPredicate not(LongPredicate predicate) {
        return predicate.negate();
    }

    public static DoublePredicate not(DoublePredicate predicate) {
        return predicate.negate();
    }

    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return predicate.negate();
    }

    public static Predicate<IntPredicate> trueFor(int value) {
        return predicate -> predicate.test(value);
    }

    public static Predicate<LongPredicate> trueFor(long value) {
        return predicate -> predicate.test(value);
    }

    public static Predicate<DoublePredicate> trueFor(double value) {
        return predicate -> predicate.test(value);
    }

    public static <T> Predicate<Predicate<T>> trueFor(T value) {
        return predicate -> predicate.test(value);
    }

    public static Predicate<IntPredicate> trueFor(IntSupplier supplier) {
        return predicate -> predicate.test(supplier.getAsInt());
    }

    public static Predicate<LongPredicate> trueFor(LongSupplier supplier) {
        return predicate -> predicate.test(supplier.getAsLong());
    }

    public static Predicate<DoublePredicate> trueFor(DoubleSupplier supplier) {
        return predicate -> predicate.test(supplier.getAsDouble());
    }

    public static <T> Predicate<Predicate<T>> trueFor(Supplier<T> supplier) {
        return predicate -> predicate.test(supplier.get());
    }

    public static <T1, T2> Predicate<BiPredicate<T1, T2>> trueFor(T1 value1, T2 value2) {
        return predicate -> predicate.test(value1, value2);
    }

    public static <T1, T2> Predicate<BiPredicate<T1, T2>> trueFor(Supplier<T1> supplier1, Supplier<T2> supplier2) {
        return predicate -> predicate.test(supplier1.get(), supplier2.get());
    }

}
