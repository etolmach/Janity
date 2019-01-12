package com.etolmach.stream.comparators;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

/**
 * @author Evgeniy Tolmach
 */
public class Predicates {

    public static IntPredicate consideringIntAs(boolean flag) {
        return t -> flag;
    }

    public static LongPredicate consideringLongAs(boolean flag) {
        return t -> flag;
    }

    public static DoublePredicate consideringDoubleAs(boolean flag) {
        return t -> flag;
    }

    public static <T> Predicate<T> consideringAs(boolean flag) {
        return t -> flag;
    }

    public static IntPredicate consideringIntAsTrue() {
        return consideringIntAs(true);
    }

    public static LongPredicate consideringLongAsTrue() {
        return consideringLongAs(true);
    }

    public static DoublePredicate consideringDoubleAsTrue() {
        return consideringDoubleAs(true);
    }

    public static <T> Predicate<T> consideringAsTrue() {
        return consideringAs(true);
    }

    public static IntPredicate consideringIntAsFalse() {
        return consideringIntAs(false);
    }

    public static LongPredicate consideringLongAsFalse() {
        return consideringLongAs(false);
    }

    public static DoublePredicate consideringDoubleAsFalse() {
        return consideringDoubleAs(false);
    }

    public static <T> Predicate<T> consideringAsFalse() {
        return consideringAs(false);
    }

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

    public static <T, R> Predicate<R> extracted(Function<R, T> extractor, Predicate<T> predicate) {
        return t -> predicate.test(extractor.apply(t));
    }

    private static Stream<IntPredicate> predicateStream(IntPredicate... predicates) {
        return stream(predicates).map(Objects::requireNonNull);
    }

    private static Stream<LongPredicate> predicateStream(LongPredicate... predicates) {
        return stream(predicates).map(Objects::requireNonNull);
    }

    private static Stream<DoublePredicate> predicateStream(DoublePredicate... predicates) {
        return stream(predicates).map(Objects::requireNonNull);
    }

    private static <T> Stream<Predicate<T>> predicateStream(Predicate<T>... predicates) {
        return stream(predicates).map(Objects::requireNonNull);
    }

    public static IntPredicate all(IntPredicate... predicates) {
        return value -> predicateStream(predicates).allMatch(trueFor(value));
    }

    public static LongPredicate all(LongPredicate... predicates) {
        return value -> predicateStream(predicates).allMatch(trueFor(value));
    }

    public static DoublePredicate all(DoublePredicate... predicates) {
        return value -> predicateStream(predicates).allMatch(trueFor(value));
    }

    public static <T> Predicate<T> all(Predicate<T>... predicates) {
        return value -> predicateStream(predicates).allMatch(trueFor(value));
    }

    public static IntPredicate any(IntPredicate... predicates) {
        return value -> predicateStream(predicates).anyMatch(trueFor(value));
    }

    public static LongPredicate any(LongPredicate... predicates) {
        return value -> predicateStream(predicates).anyMatch(trueFor(value));
    }

    public static DoublePredicate any(DoublePredicate... predicates) {
        return value -> predicateStream(predicates).anyMatch(trueFor(value));
    }

    public static <T> Predicate<T> any(Predicate<T>... predicates) {
        return value -> predicateStream(predicates).anyMatch(trueFor(value));
    }

    public static IntPredicate none(IntPredicate... predicates) {
        return value -> predicateStream(predicates).noneMatch(trueFor(value));
    }

    public static LongPredicate none(LongPredicate... predicates) {
        return value -> predicateStream(predicates).noneMatch(trueFor(value));
    }

    public static DoublePredicate none(DoublePredicate... predicates) {
        return value -> predicateStream(predicates).noneMatch(trueFor(value));
    }

    public static <T> Predicate<T> none(Predicate<T>... predicates) {
        return value -> predicateStream(predicates).noneMatch(trueFor(value));
    }

}
