package com.etolmach.stream.chained;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.etolmach.stream.comparators.Predicates.extracted;

/**
 * @author Evgeniy Tolmach
 */
public class Switch<T, F> {

    private final Switch<T, F> previousBranch;
    private final Predicate<T> predicate;
    private final F function;

    public Switch(Predicate<T> predicate, F function) {
        this(null, predicate, function);
    }

    public Switch(Switch<T, F> previousBranch, Predicate<T> predicate, F function) {
        this.previousBranch = previousBranch;
        this.predicate = predicate;
        this.function = function;
    }

    private Optional<F> evaluateCurrent(T t) {
        return predicate.test(t) ? Optional.of(function) : Optional.empty();
    }

    private Optional<F> evaluate(T t) {
        return Optional.ofNullable(previousBranch)
                .flatMap(branch -> branch.evaluate(t))
                .map(Optional::of)
                .orElseGet(() -> evaluateCurrent(t));
    }

    protected F evaluate(T t, F defaultFunction) {
        return evaluate(t).orElse(defaultFunction);
    }

    public static class Typed<T> {

        private final Class<T> type;

        public Typed(Class<T> type) {
            this.type = type;
        }

        public <R> When<T, R> when(Function<T, R> extractor) {
            return new When<>(extractor);
        }

        public <R> WhenIs<T> when(Predicate<T> predicate) {
            return new WhenIs<>(predicate);
        }

    }

    public static class When<T, R> {

        protected final Function<T, R> extractor;

        public When(Function<T, R> extractor) {
            this.extractor = extractor;
        }

        public WhenIs<T> is(Predicate<R> predicate) {
            return new WhenIs<>(extracted(extractor, predicate));
        }

    }

    public static class WhenIs<T> {

        protected final Predicate<T> predicate;

        public WhenIs(Predicate<T> predicate) {
            this.predicate = predicate;
        }

        public ConsumerSwitch<T> thenDo(Consumer<T> consumer) {
            return new ConsumerSwitch<>(predicate, consumer);
        }

        public <R> FunctionSwitch<T, R> thenMap(Function<T, R> function) {
            return new FunctionSwitch<>(predicate, function);
        }
    }

}
