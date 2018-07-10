package com.etolmach.stream.chained;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.etolmach.stream.Consumers.doNothing;
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

    protected Optional<F> evaluateCurrent(T t) {
        return predicate.test(t) ? Optional.of(function) : Optional.empty();
    }

    protected Optional<F> evaluate(T t) {
        return Optional.ofNullable(previousBranch)
                .flatMap(branch -> branch.evaluate(t))
                .map(Optional::of)
                .orElseGet(() -> evaluateCurrent(t));
    }

    protected F evaluate(T t, F defaultFunction) {
        return evaluate(t).orElse(defaultFunction);
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

    public static class FunctionSwitch<T, R> extends Switch<T, Function<T, R>> {

        public FunctionSwitch(FunctionSwitch<T, R> previous, Predicate<T> predicate, Function<T, R> function) {
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
            private final FunctionSwitch<T, R> previous;

            public When(FunctionSwitch<T, R> previous, Function<T, R> extractor) {
                this.extractor = extractor;
                this.previous = previous;
            }

            public WhenIs<T, R> is(Predicate<R> predicate) {
                return new WhenIs<>(previous, extracted(extractor, predicate));
            }

        }

        public static class WhenIs<T, R> {

            private final Predicate<T> predicate;
            private final FunctionSwitch<T, R> previous;

            public WhenIs(FunctionSwitch<T, R> previous, Predicate<T> predicate) {
                this.predicate = predicate;
                this.previous = previous;
            }

            public FunctionSwitch<T, R> thenMap(Function<T, R> function) {
                return new FunctionSwitch<>(previous, predicate, function);
            }

        }
    }

    public static class ConsumerSwitch<T> extends Switch<T, Consumer<T>> implements Consumer<T> {

        public ConsumerSwitch(Predicate<T> predicate, Consumer<T> consumer) {
            super(predicate, consumer);
        }

        public ConsumerSwitch(Switch<T, Consumer<T>> previous, Predicate<T> predicate, Consumer<T> consumer) {
            super(previous, predicate, consumer);
        }

        public Consumer<T> elseDo(Consumer<T> defaultConsumer) {
            return t -> evaluate(t, defaultConsumer).accept(t);
        }

        @Override
        public void accept(T t) {
            elseDo(doNothing()).accept(t);
        }

        public <R> When<T, R> when(Function<T, R> extractor) {
            return new When<>(this, extractor);
        }

        public <R> WhenIs<T, R> when(Predicate<T> predicate) {
            return new WhenIs(this, predicate);
        }

        public static class When<T, R> {

            private final Function<T, R> extractor;
            private final ConsumerSwitch<T> previous;

            public When(ConsumerSwitch<T> previous, Function<T, R> extractor) {
                this.extractor = extractor;
                this.previous = previous;
            }

            public WhenIs<T, R> is(Predicate<R> predicate) {
                return new WhenIs<>(previous, extracted(extractor, predicate));
            }

        }

        public static class WhenIs<T, R> {

            private final Predicate<T> predicate;
            private final ConsumerSwitch<T> previous;

            public WhenIs(ConsumerSwitch<T> previous, Predicate<T> predicate) {
                this.predicate = predicate;
                this.previous = previous;
            }

            public ConsumerSwitch<T> thenDo(Consumer<T> consumer) {
                return new ConsumerSwitch<>(previous, predicate, consumer);
            }

        }


    }

}
