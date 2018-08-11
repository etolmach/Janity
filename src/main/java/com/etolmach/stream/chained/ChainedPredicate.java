package com.etolmach.stream.chained;

import java.util.function.Function;
import java.util.function.Predicate;

import static com.etolmach.stream.comparators.Predicates.extracted;

/**
 * @author Evgeniy Tolmach
 */
public class ChainedPredicate<T> implements Predicate<T> {

    protected final Predicate<T> predicate;

    ChainedPredicate(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean test(T t) {
        return predicate.test(t);
    }

    public static <T, R> Where<T, R> where(Function<T, R> extractor) {
        return new Where<>(extractor);
    }

    @Override
    public ChainedPredicate<T> and(Predicate<? super T> other) {
        return new ChainedPredicate<>(predicate.and(other));
    }

    @Override
    public ChainedPredicate<T> or(Predicate<? super T> other) {
        return new ChainedPredicate<>(predicate.or(other));
    }

    public <R> And<T, R> and(Function<T, R> extractor) {
        return new And<>(this, extractor);
    }

    public <R> Or<T, R> or(Function<T, R> extractor) {
        return new Or<>(this, extractor);
    }

    public static abstract class AbstractChain<T, R> {

        protected final Function<T, R> mapper;

        AbstractChain(Function<T, R> mapper) {
            this.mapper = mapper;
        }

    }

    public static class Where<T, R> extends AbstractChain<T, R> {

        public Where(Function<T, R> mapper) {
            super(mapper);
        }

        public ChainedPredicate<T> is(Predicate<R> predicate) {
            return new ChainedPredicate<>(extracted(mapper, predicate));
        }

    }

    static abstract class CombinatorChain<T, R> extends AbstractChain<T, R> {

        protected final Function<Predicate<T>, Predicate<T>> combineFunction;

        CombinatorChain(Function<Predicate<T>, Predicate<T>> combineFunction, Function<T, R> mapper) {
            super(mapper);
            this.combineFunction = combineFunction;
        }

        public ChainedPredicate<T> is(Predicate<R> predicate) {
            return new ChainedPredicate<>(combineFunction.apply(extracted(mapper, predicate)));
        }
    }

    public static final class And<T, R> extends CombinatorChain<T, R> {
        And(ChainedPredicate<T> chain, Function<T, R> mapper) {
            super(chain::and, mapper);
        }
    }

    public static final class Or<T, R> extends CombinatorChain<T, R> {
        Or(ChainedPredicate<T> chain, Function<T, R> mapper) {
            super(chain::or, mapper);
        }
    }

}
