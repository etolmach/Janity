package com.etolmach.stream;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

/**
 * @author Evgeniy Tolmach
 * @see java.util.function.BiFunction BiFunction
 * @see java.util.function.BinaryOperator BinaryOperator
 * @see java.util.function.IntBinaryOperator IntBinaryOperator
 * @see java.util.function.LongBinaryOperator LongBinaryOperator
 * @see java.util.function.DoubleBinaryOperator DoubleBinaryOperator
 * @see java.util.stream.Stream#reduce(BinaryOperator) Stream.reduce(BinaryOperator)
 */
public class ArithmeticReducers {

    public static IntBinaryOperator multiplyingPrimitiveInts() {
        return (x, y) -> x * y;
    }

    public static LongBinaryOperator multiplyingPrimitiveLongs() {
        return (x, y) -> x * y;
    }

    public static DoubleBinaryOperator multiplyingPrimitiveDoubles() {
        return (x, y) -> x * y;
    }

    public static BinaryOperator<Integer> multiplyingInts() {
        return (x, y) -> x * y;
    }

    public static BinaryOperator<Long> multiplyingLongs() {
        return (x, y) -> x * y;
    }

    public static BinaryOperator<Double> multiplyingDoubles() {
        return (x, y) -> x * y;
    }

    public static IntBinaryOperator summingPrimitiveInts() {
        return (x, y) -> x + y;
    }

    public static LongBinaryOperator summingPrimitiveLongs() {
        return (x, y) -> x + y;
    }

    public static DoubleBinaryOperator summingPrimitiveDoubles() {
        return (x, y) -> x + y;
    }

    public static BinaryOperator<Integer> summingInts() {
        return (x, y) -> x + y;
    }

    public static BinaryOperator<Long> summingLongs() {
        return (x, y) -> x + y;
    }

    public static BinaryOperator<Double> summingDoubles() {
        return (x, y) -> x + y;
    }

}
