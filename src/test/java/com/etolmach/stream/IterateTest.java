package com.etolmach.stream;

import org.junit.Test;

import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static com.etolmach.stream.Iterate.decrementingBy;
import static com.etolmach.stream.Iterate.incrementingBy;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Evgeniy Tolmach
 */
public class IterateTest {

    @Test
    public void testIncrementingByInt() {
        assertOperatorWorks(incrementingBy(2), 0, 2, 4, 6, 8, 10);
    }

    @Test
    public void testIncrementingByLong() {
        assertOperatorWorks(incrementingBy(2L), 0L, 2L, 4L, 6L, 8L, 10L);
    }

    @Test
    public void testIncrementingByDouble() {
        assertOperatorWorks(incrementingBy(2.0), 0.0, 2.0, 4.0, 6.0, 8.0, 10.0);
    }

    @Test
    public void testDecrementingByInt() {
        assertOperatorWorks(decrementingBy(2), 8, 6, 4, 2);
    }

    @Test
    public void testDecrementingByLong() {
        assertOperatorWorks(decrementingBy(2L), 8L, 6L, 4L, 2L);
    }

    @Test
    public void testDecrementingByDouble() {
        assertOperatorWorks(decrementingBy(2.0), 8.0, 6.0, 4.0, 2.0);
    }

    private void assertOperatorWorks(Object operator, Object... expectedValues) {
        List<?> actual = null;
        if (operator instanceof IntUnaryOperator) {
            actual = generateList((Integer) expectedValues[0], (IntUnaryOperator) operator, expectedValues.length);
        } else if (operator instanceof LongUnaryOperator) {
            actual = generateList((Long) expectedValues[0], (LongUnaryOperator) operator, expectedValues.length);
        } else if (operator instanceof DoubleUnaryOperator) {
            actual = generateList((Double) expectedValues[0], (DoubleUnaryOperator) operator, expectedValues.length);
        } else {
            fail("Operator is not supported : " + operator.getClass());
        }
        assertEquals(asList(expectedValues), actual);
    }

    private List<Integer> generateList(Integer from, IntUnaryOperator operator, int length) {
        return IntStream.iterate(from, operator)
                .limit(length)
                .boxed()
                .collect(toList());
    }

    private List<Long> generateList(Long from, LongUnaryOperator operator, int length) {
        return LongStream.iterate(from, operator)
                .limit(length)
                .boxed()
                .collect(toList());
    }

    private List<Double> generateList(Double from, DoubleUnaryOperator operator, int length) {
        return DoubleStream.iterate(from, operator)
                .limit(length)
                .boxed()
                .collect(toList());
    }

}