package com.etolmach.stream;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

/**
 * @author Evgeniy Tolmach
 */
public class ArithmeticReducers {

    public static final IntBinaryOperator MULTIPLYING_PRIMITIVE_INTS = (x, y) -> x * y;
    public static final LongBinaryOperator MULTIPLYING_PRIMITIVE_LONGS = (x, y) -> x * y;
    public static final DoubleBinaryOperator MULTIPLYING_PRIMITIVE_DOUBLES = (x, y) -> x * y;

    public static final BinaryOperator<Integer> MULTIPLYING_INTS = (x, y) -> x * y;
    public static final BinaryOperator<Long> MULTIPLYING_LONGS = (x, y) -> x * y;
    public static final BinaryOperator<Double> MULTIPLYING_DOUBLES = (x, y) -> x * y;

    public static IntBinaryOperator multiplyingPrimitiveInts() {
        return MULTIPLYING_PRIMITIVE_INTS;
    }

    public static LongBinaryOperator multiplyingPrimitiveLongs() {
        return MULTIPLYING_PRIMITIVE_LONGS;
    }

    public static DoubleBinaryOperator multiplyingPrimitiveDoubles() {
        return MULTIPLYING_PRIMITIVE_DOUBLES;
    }

    public static BinaryOperator<Integer> multiplyingInts() {
        return MULTIPLYING_INTS;
    }

    public static BinaryOperator<Long> multiplyingLongs() {
        return MULTIPLYING_LONGS;
    }

    public static BinaryOperator<Double> multiplyingDoubles() {
        return MULTIPLYING_DOUBLES;
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
