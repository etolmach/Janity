package com.etolmach.stream.test;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;

import java.util.function.DoubleUnaryOperator;

import static org.assertj.core.api.Assertions.offset;

/**
 * @author Evgeniy Tolmach
 */
public class UnaryDoubleAssert {

    private final DoubleUnaryOperator operator;

    public UnaryDoubleAssert(DoubleUnaryOperator operator) {
        this.operator = operator;
    }

    public On on(double input) {
        return new On(this, input);
    }

    public static class On {
        private final UnaryDoubleAssert unary;
        private final double input;

        public On(UnaryDoubleAssert unary, double input) {
            this.unary = unary;
            this.input = input;
        }

        public UnaryDoubleAssert returns(double result) {
            return returns(result, offset(0.0));
        }

        public UnaryDoubleAssert returns(double result, Offset<Double> offset) {
            Assertions.assertThat(unary.operator.applyAsDouble(input)).isCloseTo(result, offset);
            return unary;
        }
    }
}
