package com.etolmach.stream.test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Evgeniy Tolmach
 */
public class UnaryFunctionAssert<T, R> {

    private final Function<T, R> function;

    public UnaryFunctionAssert(Function<T, R> function) {
        this.function = function;
    }

    public On<T, R> on(T input) {
        return new On<>(this, input);
    }

    public static class On<T, R> {
        private final UnaryFunctionAssert<T, R> unary;
        private final T input;


        public On(UnaryFunctionAssert<T, R> unary, T input) {
            this.unary = unary;
            this.input = input;
        }

        public UnaryFunctionAssert returns(R result) {
            assertThat(unary.function.apply(input)).isEqualTo(result);
            return unary;
        }
    }
}
