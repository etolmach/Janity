package com.etolmach.stream.comparators;

import org.junit.Test;

import static com.etolmach.stream.comparators.Predicates.consideringAsTrue;
import static com.etolmach.stream.comparators.Predicates.consideringDoubleAsTrue;
import static com.etolmach.stream.comparators.Predicates.consideringIntAsTrue;
import static com.etolmach.stream.comparators.Predicates.consideringLongAsTrue;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Evgeniy Tolmach
 */
public class Predicates_consideringAsTrue_Test {

    @Test
    public void should_return_true_for_any_int() {
        assertThat(consideringIntAsTrue())
                .accepts(1, -2, 34, -567, 8901, -12131, 4151617, 1819202122);
    }

    @Test
    public void should_return_true_for_any_long() {
        assertThat(consideringLongAsTrue())
                .accepts(1L, -2L, 34L, -567L, 8901, -12131, 4151617, 1819202122);
    }


    @Test
    public void should_return_true_for_any_double() {
        assertThat(consideringDoubleAsTrue())
                .accepts(1.0, -2.0, 3.4, -56.7, 8.901, -1213.1, 41516.17, .1819202122);
    }

    @Test
    public void should_return_true_for_any_input() {
        assertThat(consideringAsTrue())
                .accepts(1, 2L, 3.45f, 6.789D, "a string", new int[]{1, 2, 3, 4}, new Object());
    }

}