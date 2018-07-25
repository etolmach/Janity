package com.etolmach.stream.comparators;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.etolmach.stream.comparators.ArithmeticPredicates.*;
import static com.etolmach.stream.mappers.ArithmeticMappers.primitiveModulo;
import static org.junit.Assert.*;

/**
 * @author Evgeniy Tolmach
 */
public class ArithmeticPredicatesTest {

    @Test
    public void testFactorOfInt() {
        assertTrue(factorOf(10).test(5));
    }

    @Test
    public void testFactorOfInts() {
        assertTrue(factorOf(10, 25).test(5));
    }

    @Test
    public void testFactorOfAnyInt() {
        assertTrue(factorOfAny(11, 25).test(5));
    }

    @Test
    public void testFactorOfLong() {
        assertTrue(factorOf(10L).test(5L));
    }

    @Test
    public void testFactorOfAllLongs() {
        assertTrue(factorOf(10L, 25L).test(5L));
    }

    @Test
    public void testFactorOfAnyLong() {
        assertTrue(factorOfAny(11L, 25L).test(5L));
    }

    @Test
    public void testNotFactorOfInt() {
        assertTrue(notFactorOf(10).test(3));
    }

    @Test
    public void testNotFactorOfInts() {
        assertTrue(notFactorOf(10, 11).test(3));
    }

    @Test
    public void testNotFactorOfLong() {
        assertTrue(notFactorOf(10L).test(3L));
    }

    @Test
    public void testNotFactorOfLongs() {
        assertTrue(notFactorOf(10L, 11L).test(3L));
    }

    @Test
    public void testDivisibleByInt() {
        assertTrue(divisibleBy(5).test(10));
    }

    @Test
    public void testDivisibleByInts() {
        assertTrue(divisibleBy(2, 5).test(10));
    }

    @Test
    public void testDivisibleByAnyInt() {
        assertTrue(divisibleByAny(3, 5).test(10));
    }

    @Test
    public void testDivisibleByLong() {
        assertTrue(divisibleBy(5).test(10));
    }

    @Test
    public void testDivisibleByLongs() {
        assertTrue(divisibleBy(2L, 5L).test(10L));
    }

    @Test
    public void testDivisibleByAnyLong() {
        assertTrue(divisibleByAny(3L, 5L).test(10L));
    }

    @Test
    public void testNotDivisibleByInt() {
        assertTrue(notDivisibleBy(3).test(10));
    }

    @Test
    public void testNotDivisibleByInts() {
        assertTrue(notDivisibleBy(3, 4).test(10));
    }

    @Test
    public void testNotDivisibleByLong() {
        assertTrue(notDivisibleBy(3L).test(10L));
    }

    @Test
    public void testNotDivisibleByLongs() {
        assertTrue(notDivisibleBy(3L, 4L).test(10L));
    }

    @Test
    public void testIsOddInt() {
        assertTrue(isOddInt().test(9));
        assertFalse(isOddInt().test(10));
    }

    @Test
    public void testIsEvenInt() {
        assertFalse(isEvenInt().test(9));
        assertTrue(isEvenInt().test(10));
    }

    @Test
    public void testIsOddLong() {
        assertTrue(isOddLong().test(9));
        assertFalse(isOddLong().test(10));
    }

    @Test
    public void testIsEvenLong() {
        assertFalse(isEvenLong().test(9L));
        assertTrue(isEvenLong().test(10L));
    }

    @Test
    public void compoundTest() {

        List<Integer> list = IntStream.range(1, 100)
                // [1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 25, 30, 50, 60, 75]
                .filter(factorOf(900, 1200))
                // [15, 30, 60, 75]
                .filter(divisibleBy(3, 5))
                // [15, 75]
                .filter(isOddInt())
                // [1, 5]
                .map(primitiveModulo(7))
                .boxed()
                .collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 5), list);
    }

}