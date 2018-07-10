package com.etolmach.stream.chained;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Evgeniy Tolmach
 */
public interface StreamDsl {

    static <T, R> ChainedPredicate.Where<T, R> where(Function<T, R> extractor) {
        return new ChainedPredicate.Where<>(extractor);
    }

    static <T, R> Switch.When<T, R> when(Function<T, R> extractor) {
        return new Switch.When<>(extractor);
    }

    static <T> Switch.WhenIs<T> when(Predicate<T> predicate) {
        return new Switch.WhenIs<>(predicate);
    }

    static <T> Switch.WhenIs<T> when(Class<T> type, Predicate<T> predicate) {
        return new Switch.WhenIs<>(predicate);
    }

}
