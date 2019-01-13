package com.etolmach.stream.comparators;

import static com.etolmach.stream.comparators.Predicates.all;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import org.junit.Test;

/**
 * @author Evgeniy Tolmach
 */
public class Predicates_all_Test {

    private static IntPredicate INT_GREATER_THAN_ONE = i -> i > 1;
    private static LongPredicate LONG_GREATER_THAN_ONE = i -> i > 1;
    private static DoublePredicate DOUBLE_GREATER_THAN_ONE = i -> i > 1;
    private static Predicate<Integer> GREATER_THAN_ONE = i -> i > 1;

    private static IntPredicate INT_EQUAL_TO_0 = i -> i == 0;
    private static LongPredicate LONG_EQUAL_TO_0 = i -> i == 0;
    private static DoublePredicate DOUBLE_EQUAL_TO_0 = i -> i == 0;
    private static Predicate<Integer> EQUAL_TO_0 = i -> i == 0;

    private static IntPredicate INT_EQUAL_TO_3 = i -> i == 3;
    private static LongPredicate LONG_EQUAL_TO_3 = i -> i == 3;
    private static DoublePredicate DOUBLE_EQUAL_TO_3 = i -> i == 3;
    private static Predicate<Integer> EQUAL_TO_3 = i -> i == 3;

    @Test
    public void should_reject_integers_when_first_rejects() {
        assertThat(
                   all(
                        INT_GREATER_THAN_ONE,
                        INT_EQUAL_TO_0
                   )
        ).rejects(0, -1, -23, -456, -789);
    }

    @Test
    public void should_reject_integers_when_second_rejects() {
        assertThat(
                   all(
                        INT_GREATER_THAN_ONE,
                        INT_EQUAL_TO_3
                   )
        ).rejects(2, 23, 456, 789);
    }

    @Test
    public void should_reject_integers_when_all_reject() {
        assertThat(
                   all(
                        INT_GREATER_THAN_ONE,
                        INT_EQUAL_TO_3
                   )
        ).rejects(-1, -23, -456, -789);
    }

    @Test
    public void should_accept_integers_when_all_accept() {
        assertThat(
                   all(
                        INT_GREATER_THAN_ONE,
                        INT_EQUAL_TO_3
                   )
        ).accepts(3);
    }

    @Test
    public void should_reject_longs_when_first_rejects() {
        assertThat(
                   all(
                        LONG_GREATER_THAN_ONE,
                        LONG_EQUAL_TO_0
                   )
        ).rejects(0, -1, -23, -456, -789);
    }

    @Test
    public void should_reject_longs_when_second_rejects() {
        assertThat(
                   all(
                        LONG_GREATER_THAN_ONE,
                        LONG_EQUAL_TO_3
                   )
        ).rejects(2L, 23L, 456L, 789);
    }

    @Test
    public void should_reject_longs_when_all_reject() {
        assertThat(
                   all(
                        LONG_GREATER_THAN_ONE,
                        LONG_EQUAL_TO_3
                   )
        ).rejects(-1L, -23L, -456, -789);
    }

    @Test
    public void should_accept_longs_when_all_accept() {
        assertThat(
                   all(
                        LONG_GREATER_THAN_ONE,
                        LONG_EQUAL_TO_3
                   )
        ).accepts(3L);
    }

    @Test
    public void should_reject_doubles_when_first_rejects() {
        assertThat(
                   all(
                        DOUBLE_GREATER_THAN_ONE,
                        DOUBLE_EQUAL_TO_0
                   )
        ).rejects(0.0, -1.0, -2.3, -45.6, -789);
    }

    @Test
    public void should_reject_doubles_when_second_rejects() {
        assertThat(
                   all(
                        DOUBLE_GREATER_THAN_ONE,
                        DOUBLE_EQUAL_TO_3
                   )
        ).rejects(2.0, 2.3, 45.6, 789);
    }

    @Test
    public void should_reject_doubles_when_all_reject() {
        assertThat(
                   all(
                        DOUBLE_GREATER_THAN_ONE,
                        DOUBLE_EQUAL_TO_3
                   )
        ).rejects(-1.0, -2.3, -45.6, -789);
    }

    @Test
    public void should_accept_doubles_when_all_accept() {
        assertThat(
                   all(
                        DOUBLE_GREATER_THAN_ONE,
                        DOUBLE_EQUAL_TO_3
                   )
        ).accepts(3.0);
    }

    @Test
    public void should_reject_objects_when_first_rejects() {
        assertThat(
                   all(
                        GREATER_THAN_ONE,
                        EQUAL_TO_0
                   )
        ).rejects(0, -1, -23, -456, -789);
    }

    @Test
    public void should_reject_objects_when_second_rejects() {
        assertThat(
                   all(
                        GREATER_THAN_ONE,
                        EQUAL_TO_3
                   )
        ).rejects(2, 23, 456, 789);
    }

    @Test
    public void should_reject_objects_when_all_reject() {
        assertThat(
                   all(
                        GREATER_THAN_ONE,
                        EQUAL_TO_3
                   )
        ).rejects(-1, -23, -456, -789);
    }

    @Test
    public void should_accept_objects_when_all_accept() {
        assertThat(
                   all(
                        GREATER_THAN_ONE,
                        EQUAL_TO_3
                   )
        ).accepts(3);
    }

}
