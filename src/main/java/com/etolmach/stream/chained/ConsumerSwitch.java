package com.etolmach.stream.chained;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.etolmach.stream.Consumers.doNothing;
import static com.etolmach.stream.comparators.Predicates.extracted;

/**
 * @author Evgeniy Tolmach
 */
public class ConsumerSwitch<T> extends Switch<T, Consumer<T>> implements Consumer<T> {

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
        private final com.etolmach.stream.chained.ConsumerSwitch<T> previous;

        public When(com.etolmach.stream.chained.ConsumerSwitch<T> previous, Function<T, R> extractor) {
            this.extractor = extractor;
            this.previous = previous;
        }

        public WhenIs<T, R> is(Predicate<R> predicate) {
            return new WhenIs<>(previous, extracted(extractor, predicate));
        }

    }

    public static class WhenIs<T, R> {

        private final Predicate<T> predicate;
        private final com.etolmach.stream.chained.ConsumerSwitch<T> previous;

        public WhenIs(com.etolmach.stream.chained.ConsumerSwitch<T> previous, Predicate<T> predicate) {
            this.predicate = predicate;
            this.previous = previous;
        }

        public com.etolmach.stream.chained.ConsumerSwitch<T> thenDo(Consumer<T> consumer) {
            return new com.etolmach.stream.chained.ConsumerSwitch<>(previous, predicate, consumer);
        }

    }


}
