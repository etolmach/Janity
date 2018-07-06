package com.etolmach.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static com.etolmach.stream.ArithmeticReducers.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Evgeniy Tolmach
 */
public class ArithmeticReducersTest {

    @Test
    public void testMultiplyingPrimitiveInts() {
        int fact = IntStream.of(1, 2, 3).reduce(1, multiplyingPrimitiveInts());
        assertEquals(6, fact);
    }

    @Test
    public void testMultiplyingPrimitiveLongs() {
        long fact = LongStream.of(1, 2, 3).reduce(1, multiplyingPrimitiveLongs());
        assertEquals(6, fact);
    }

    @Test
    public void testMultiplyingPrimitiveDoubles() {
        double fact = DoubleStream.of(1.0, 2.0, 3.0).reduce(1.0, multiplyingPrimitiveDoubles());
        assertEquals(6.0, fact, 0);
    }

    @Test
    public void testMultiplyingInts() {
        int fact = Arrays.asList(1, 2, 3).stream().reduce(1, multiplyingInts());
        assertEquals(6, fact);
    }

    @Test
    public void testMultiplyingLongs() {
        long fact = Arrays.asList(1L, 2L, 3L).stream().reduce(1L, multiplyingLongs());
        assertEquals(6, fact);
    }

    @Test
    public void testMultiplyingDoubles() {
        double fact = Arrays.asList(1.0, 2.0, 3.0).stream().reduce(1.0, multiplyingDoubles());
        assertEquals(6.0, fact, 0);
    }

    @Test
    public void testAddingPrimitiveInts() {
        int sum = IntStream.of(1, 2, 3, 4).reduce(0, summingPrimitiveInts());
        assertEquals(10, sum);
    }

    @Test
    public void testAddingPrimitiveLongs() {
        long sum = LongStream.of(1, 2, 3, 4).reduce(0, summingPrimitiveLongs());
        assertEquals(10, sum);
    }

    @Test
    public void testAddingPrimitiveDoubles() {
        double sum = DoubleStream.of(1.0, 2.0, 3.0, 4.0).reduce(0.0, summingPrimitiveDoubles());
        assertEquals(10.0, sum, 0);
    }

    @Test
    public void testAddingInts() {
        int sum = Arrays.asList(1, 2, 3, 4).stream().reduce(0, summingInts());
        assertEquals(10, sum);
    }

    @Test
    public void testAddingLongs() {
        long sum = Arrays.asList(1L, 2L, 3L, 4L).stream().reduce(0L, summingLongs());
        assertEquals(10, sum);
    }

    @Test
    public void testAddingDoubles() {
        double sum = Arrays.asList(1.0, 2.0, 3.0, 4.0).stream().reduce(0.0, summingDoubles());
        assertEquals(10.0, sum, 0);
    }

}