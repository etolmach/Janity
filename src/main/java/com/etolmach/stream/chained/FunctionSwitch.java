package com.etolmach.stream.chained;

import java.util.function.Function;
import java.util.function.Predicate;

import static com.etolmach.stream.comparators.Predicates.extracted;

/**
 * @author Evgeniy Tolmach
 */
public class FunctionSwitch<T, R> extends Switch<T, Function<T, R>> {

    public FunctionSwitch(com.etolmach.stream.chained.FunctionSwitch<T, R> previous, Predicate<T> predicate, Function<T, R> function) {
        super(previous, predicate, function);
    }

    public FunctionSwitch(Predicate<T> predicate, Function<T, R> function) {
        super(predicate, function);
    }

    public Function<T, R> elseMap(Function<T, R> defaultFunction) {
        return t -> evaluate(t, defaultFunction).apply(t);
    }

    public When<T, R> when(Function<T, R> extractor) {
        return new When<>(this, extractor);
    }

    public WhenIs<T, R> when(Predicate<T> predicate) {
        return new WhenIs<>(this, predicate);
    }

    public static class When<T, R> {

        private final Function<T, R> extractor;
        private final com.etolmach.stream.chained.FunctionSwitch<T, R> previous;

        public When(com.etolmach.stream.chained.FunctionSwitch<T, R> previous, Function<T, R> extractor) {
            this.extractor = extractor;
            this.previous = previous;
        }

        public WhenIs<T, R> is(Predicate<R> predicate) {
            return new WhenIs<>(previous, extracted(extractor, predicate));
        }

    }

    public static class WhenIs<T, R> {

        private final Predicate<T> predicate;
        private final com.etolmach.stream.chained.FunctionSwitch<T, R> previous;

        public WhenIs(com.etolmach.stream.chained.FunctionSwitch<T, R> previous, Predicate<T> predicate) {
            this.predicate = predicate;
            this.previous = previous;
        }

        public com.etolmach.stream.chained.FunctionSwitch<T, R> thenMap(Function<T, R> function) {
            return new com.etolmach.stream.chained.FunctionSwitch<>(previous, predicate, function);
        }

    }
}
