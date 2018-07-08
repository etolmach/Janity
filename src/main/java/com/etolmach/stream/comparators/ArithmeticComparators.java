package com.etolmach.stream.comparators;

import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

import static java.util.Arrays.stream;

/**
 * @author Evgeniy Tolmach
 */
public class ArithmeticComparators {

    public static IntPredicate factorOf(int dividend) {
        return divider -> dividend % divider == 0;
    }

    public static IntPredicate factorOf(int... dividends) {
        return divider -> stream(dividends).allMatch(divisibleBy(divider));
    }

    public static IntPredicate factorOfAny(int... dividends) {
        return divider -> stream(dividends).anyMatch(divisibleBy(divider));
    }

    public static IntPredicate notFactorOf(int dividend) {
        return divider -> dividend % divider != 0;
    }

    public static IntPredicate notFactorOf(int... dividends) {
        return divider -> stream(dividends).noneMatch(divisibleBy(divider));
    }

    public static LongPredicate factorOf(long dividend) {
        return divider -> dividend % divider == 0;
    }

    public static LongPredicate factorOf(long... dividends) {
        return divider -> stream(dividends).allMatch(divisibleBy(divider));
    }

    public static LongPredicate factorOfAny(long... dividends) {
        return divider -> stream(dividends).anyMatch(divisibleBy(divider));
    }

    public static LongPredicate notFactorOf(long dividend) {
        return divider -> dividend % divider != 0;
    }

    public static LongPredicate notFactorOf(long... dividends) {
        return divider -> stream(dividends).noneMatch(divisibleBy(divider));
    }

    public static IntPredicate divisibleBy(int divider) {
        return dividend -> dividend % divider == 0;
    }

    public static IntPredicate divisibleBy(int... dividers) {
        return i -> stream(dividers).allMatch(factorOf(i));
    }

    public static IntPredicate divisibleByAny(int... dividers) {
        return i -> stream(dividers).anyMatch(factorOf(i));
    }

    public static LongPredicate divisibleBy(long divider) {
        return dividend -> dividend % divider == 0;
    }

    public static LongPredicate divisibleBy(long... dividers) {
        return i -> stream(dividers).allMatch(factorOf(i));
    }

    public static LongPredicate divisibleByAny(long... dividers) {
        return i -> stream(dividers).anyMatch(factorOf(i));
    }

    public static IntPredicate notDivisibleBy(int divider) {
        return dividend -> dividend % divider != 0;
    }

    public static IntPredicate notDivisibleBy(int... dividers) {
        return i -> stream(dividers).noneMatch(factorOf(i));
    }

    public static LongPredicate notDivisibleBy(long divider) {
        return dividend -> dividend % divider != 0;
    }

    public static LongPredicate notDivisibleBy(long... dividers) {
        return i -> stream(dividers).noneMatch(factorOf(i));
    }

    public static IntPredicate isEvenInt() {
        return dividend -> (dividend & 1) == 0;
    }

    public static IntPredicate isOddInt() {
        return dividend -> (dividend & 1) != 0;
    }

    public static LongPredicate isEvenLong() {
        return dividend -> (dividend & 1L) == 0;
    }

    public static LongPredicate isOddLong() {
        return dividend -> (dividend & 1L) != 0;
    }
}
