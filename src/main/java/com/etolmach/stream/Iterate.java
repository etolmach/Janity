package com.etolmach.stream;

import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;

/**
 * @author Evgeniy Tolmach
 */
public class Iterate {

    public static IntUnaryOperator incrementingBy(int value) {
        return i -> i + value;
    }

    public static LongUnaryOperator incrementingBy(long value) {
        return i -> i + value;
    }

    public static DoubleUnaryOperator incrementingBy(double value) {
        return i -> i + value;
    }

    public static IntUnaryOperator decrementingBy(int value) {
        return i -> i - value;
    }

    public static LongUnaryOperator decrementingBy(long value) {
        return i -> i - value;
    }

    public static DoubleUnaryOperator decrementingBy(double value) {
        return i -> i - value;
    }

}
