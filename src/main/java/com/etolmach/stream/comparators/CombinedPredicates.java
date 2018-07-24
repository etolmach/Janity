package com.etolmach.stream.comparators;

import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.etolmach.stream.comparators.Predicates.trueFor;
import static java.util.Arrays.stream;

/**
 * @author Evgeniy Tolmach
 */
public class CombinedPredicates {

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
