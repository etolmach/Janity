package com.etolmach.stream.mappers;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;

/**
 * This class consists exclusively of static methods that
 * return functions for arithmetical transformations.
 *
 * @author Evgeniy Tolmach
 */
public class IntMappers {

    public static IntUnaryOperator multiplyPrimitiveBy(int multiplier) {
        return multiplicand -> multiplicand * multiplier;
    }

    public static Function<Integer, Integer> multiplyBy(int multiplier) {
        return multiplicand -> multiplicand * multiplier;
    }

    public static IntUnaryOperator primitiveModulo(int divisor) {
        return dividend -> dividend % divisor;
    }

    public static Function<Integer, Integer> modulo(int divisor) {
        return dividend -> dividend % divisor;
    }

    public static IntUnaryOperator dividePrimitiveTo(int divisor) {
        return dividend -> dividend / divisor;
    }

    public static Function<Integer, Integer> divideTo(int divisor) {
        return dividend -> dividend / divisor;
    }

    public static IntUnaryOperator incrementPrimitive() {
        return i -> i + 1;
    }

    public static IntUnaryOperator incrementPrimitiveBy(int value) {
        return i -> i + value;
    }

    public static Function<Integer, Integer> incrementBy(int value) {
        return i -> i + value;
    }

    public static IntUnaryOperator decrementPrimitive() {
        return i -> i - 1;
    }

    public static IntUnaryOperator decrementPrimitiveBy(int value) {
        return i -> i - value;
    }

    public static Function<Integer, Integer> decrementBy(int value) {
        return i -> i - value;
    }

}