package com.etolmach.stream.test;

import java.util.function.LongUnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Evgeniy Tolmach
 */
public class UnaryLongAssert {

    private final LongUnaryOperator operator;

    public UnaryLongAssert(LongUnaryOperator operator) {
        this.operator = operator;
    }

    public On on(long input) {
        return new On(this, input);
    }

    public static class On {
        private final UnaryLongAssert unary;
        private final long input;

        public On(UnaryLongAssert unary, long input) {
            this.unary = unary;
            this.input = input;
        }

        public UnaryLongAssert returns(long result) {
            assertThat(unary.operator.applyAsLong(input)).isEqualTo(result);
            return unary;
        }
    }
}
