package com.etolmach.stream.comparators;

import org.junit.Test;

import static com.etolmach.stream.comparators.Predicates.consideringAsFalse;
import static com.etolmach.stream.comparators.Predicates.consideringDoubleAsFalse;
import static com.etolmach.stream.comparators.Predicates.consideringIntAsFalse;
import static com.etolmach.stream.comparators.Predicates.consideringLongAsFalse;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Evgeniy Tolmach
 */
public class Predicates_consideringAsFalse_Test {

    @Test
    public void should_return_false_for_any_int() {
        assertThat(consideringIntAsFalse())
                .rejects(1, -2, 34, -567, 8901, -12131, 4151617, 1819202122);
    }

    @Test
    public void should_return_false_for_any_long() {
        assertThat(consideringLongAsFalse())
                .rejects(1L, -2L, 34L, -567L, 8901, -12131, 4151617, 1819202122);
    }


    @Test
    public void should_return_false_for_any_double() {
        assertThat(consideringDoubleAsFalse())
                .rejects(1.0, -2.0, 3.4, -56.7, 8.901, -1213.1, 41516.17, .1819202122);
    }

    @Test
    public void should_return_false_for_any_input() {
        assertThat(consideringAsFalse())
                .rejects(1, 2L, 3.45f, 6.789D, "a string", new int[]{1, 2, 3, 4}, new Object());
    }

}