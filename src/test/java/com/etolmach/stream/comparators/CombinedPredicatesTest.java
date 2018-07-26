package com.etolmach.stream.comparators;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.etolmach.stream.comparators.ArithmeticPredicates.divisibleBy;
import static com.etolmach.stream.comparators.Comparators.greaterThan;
import static com.etolmach.stream.comparators.Predicates.all;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * @author Evgeniy Tolmach
 */
public class CombinedPredicatesTest {

    @Test
    public void testAll() {
        List<Integer> ints = IntStream.range(1, 10)
                .filter(
                        all(
                                greaterThan(5),
                                divisibleBy(3)
                        )
                )
                .boxed()
                .collect(Collectors.toList());

        assertEquals(asList(6, 9), ints);

    }

    @Test
    public void testAny() {
    }

    @Test
    public void testNone() {
    }
}