package com.etolmach.stream.comparators;

import org.junit.Test;

import static com.etolmach.stream.comparators.Predicates.consideringAs;
import static com.etolmach.stream.comparators.Predicates.consideringDoubleAs;
import static com.etolmach.stream.comparators.Predicates.consideringIntAs;
import static com.etolmach.stream.comparators.Predicates.consideringLongAs;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Evgeniy Tolmach
 */
public class Predicates_consideringAs_Test {

    @Test
    public void should_return_false_for_any_int() {
        assertThat(consideringIntAs(false))
                .rejects(1, -2, 34, -567, 8901, -12131, 4151617, 1819202122);
    }

    @Test
    public void should_return_false_for_any_long() {
        assertThat(consideringLongAs(false))
                .rejects(1L, -2L, 34L, -567L, 8901, -12131, 4151617, 1819202122);
    }


    @Test
    public void should_return_false_for_any_double() {
        assertThat(consideringDoubleAs(false))
                .rejects(1.0, -2.0, 3.4, -56.7, 8.901, -1213.1, 41516.17, .1819202122);
    }

    @Test
    public void should_return_false_for_any_input() {
        assertThat(consideringAs(false))
                .rejects(1, 2L, 3.45f, 6.789D, "a string", new int[]{1, 2, 3, 4}, new Object());
    }
    @Test
    public void should_return_true_for_any_int() {
        assertThat(consideringIntAs(true))
                .accepts(1, -2, 34, -567, 8901, -12131, 4151617, 1819202122);
    }

    @Test
    public void should_return_true_for_any_long() {
        assertThat(consideringLongAs(true))
                .accepts(1L, -2L, 34L, -567L, 8901, -12131, 4151617, 1819202122);
    }


    @Test
    public void should_return_true_for_any_double() {
        assertThat(consideringDoubleAs(true))
                .accepts(1.0, -2.0, 3.4, -56.7, 8.901, -1213.1, 41516.17, .1819202122);
    }

    @Test
    public void should_return_true_for_any_input() {
        assertThat(consideringAs(true))
                .accepts(1, 2L, 3.45f, 6.789D, "a string", new int[]{1, 2, 3, 4}, new Object());
    }

}