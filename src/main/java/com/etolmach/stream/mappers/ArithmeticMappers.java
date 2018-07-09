package com.etolmach.stream.mappers;

import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;

/**
 * This class consists exclusively of static methods that
 * return functions for arithmetical transformations.
 *
 * @author Evgeniy Tolmach
 */
public class ArithmeticMappers {

    public static IntUnaryOperator multiplyPrimitiveBy(int multiplier) {
        return multiplicand -> multiplicand * multiplier;
    }

    public static LongUnaryOperator multiplyPrimitiveBy(long multiplier) {
        return multiplicand -> multiplicand * multiplier;
    }

    public static DoubleUnaryOperator multiplyPrimitiveBy(double multiplier) {
        return multiplicand -> multiplicand * multiplier;
    }

    public static Function<Integer, Integer> multiplyBy(Integer multiplier) {
        return multiplicand -> multiplicand * multiplier;
    }

    public static Function<Long, Long> multiplyBy(Long multiplier) {
        return multiplicand -> multiplicand * multiplier;
    }

    public static Function<Double, Double> multiplyBy(Double multiplier) {
        return multiplicand -> multiplicand * multiplier;
    }

    public static IntUnaryOperator primitiveModulo(int divisor) {
        return dividend -> dividend % divisor;
    }

    public static LongUnaryOperator primitiveModulo(long divisor) {
        return dividend -> dividend % divisor;
    }

    public static Function<Integer, Integer> modulo(Integer divisor) {
        return dividend -> dividend % divisor;
    }

    public static Function<Long, Long> modulo(Long divisor) {
        return dividend -> dividend % divisor;
    }

    public static IntUnaryOperator dividePrimitiveTo(int divisor) {
        return dividend -> dividend / divisor;
    }

    public static LongUnaryOperator dividePrimitiveTo(long divisor) {
        return dividend -> dividend / divisor;
    }

    public static DoubleUnaryOperator dividePrimitiveTo(double divisor) {
        return dividend -> dividend / divisor;
    }

    public static Function<Integer, Integer> divideTo(Integer divisor) {
        return dividend -> dividend / divisor;
    }

    public static Function<Double, Double> divideTo(Double divisor) {
        return dividend -> dividend / divisor;
    }

    public static Function<Double, Double> divideTo(Long divisor) {
        return dividend -> dividend / divisor;
    }

    public static IntUnaryOperator incrementPrimitiveBy(int value) {
        return i -> i + value;
    }

    public static LongUnaryOperator incrementPrimitiveBy(long value) {
        return i -> i + value;
    }

    public static DoubleUnaryOperator incrementPrimitiveBy(double value) {
        return i -> i + value;
    }

    public static Function<Integer, Integer> incrementBy(Integer value) {
        return i -> i + value;
    }

    public static Function<Long, Long> incrementBy(Long value) {
        return i -> i + value;
    }

    public static Function<Double, Double> incrementBy(Double value) {
        return i -> i + value;
    }

    public static IntUnaryOperator decrementPrimitiveBy(int value) {
        return i -> i - value;
    }

    public static LongUnaryOperator decrementPrimitiveBy(long value) {
        return i -> i - value;
    }

    public static DoubleUnaryOperator decrementPrimitiveBy(double value) {
        return i -> i - value;
    }

    public static Function<Integer, Integer> decrementBy(Integer value) {
        return i -> i - value;
    }

    public static Function<Long, Long> decrementBy(Long value) {
        return i -> i - value;
    }

    public static Function<Double, Double> decrementBy(Double value) {
        return i -> i - value;
    }

}
