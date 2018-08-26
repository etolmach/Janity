package com.etolmach.stream.test;

import java.util.function.IntUnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Evgeniy Tolmach
 */
public class UnaryIntAssert {

    private final IntUnaryOperator operator;

    public UnaryIntAssert(IntUnaryOperator operator) {
        this.operator = operator;
    }

    public On on(int input) {
        return new On(this, input);
    }

    public static class On {
        private final UnaryIntAssert unary;
        private final int input;


        public On(UnaryIntAssert unary, int input) {
            this.unary = unary;
            this.input = input;
        }

        public UnaryIntAssert returns(int result) {
            assertThat(unary.operator.applyAsInt(input)).isEqualTo(result);
            return unary;
        }
    }
}
