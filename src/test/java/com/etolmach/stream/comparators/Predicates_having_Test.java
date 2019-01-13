package com.etolmach.stream.comparators;

import static com.etolmach.stream.comparators.Predicates.having;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.function.Predicate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author Evgeniy Tolmach
 */
@RunWith(MockitoJUnitRunner.class)
public class Predicates_having_Test {

    private static final int INT_INPUT = 123;
    private static final long LONG_INPUT = 4567;
    private static final double DOUBLE_INPUT = 8.9011;

    @Mock
    private Object input;
    @Mock
    private Object output;
    @Mock
    private Predicate<Object> predicate;

    @Mock
    private IntFunction<Object> intFunction;
    @Mock
    private LongFunction<Object> longFunction;
    @Mock
    private DoubleFunction<Object> doubleFunction;
    @Mock
    private Function<Object, Object> function;

    @Test
    public void should_accept_int_when_function_returns_valid_result() {
        when(intFunction.apply(INT_INPUT)).thenReturn(output);
        when(predicate.test(output)).thenReturn(true);

        assertThat(having(intFunction, predicate)).accepts(INT_INPUT);
    }

    @Test
    public void should_reject_int_when_function_returns_invalid_result() {
        when(intFunction.apply(INT_INPUT)).thenReturn(output);
        when(predicate.test(output)).thenReturn(false);

        assertThat(having(intFunction, predicate)).rejects(INT_INPUT);
    }

    @Test
    public void should_accept_long_when_function_returns_valid_result() {
        when(longFunction.apply(LONG_INPUT)).thenReturn(output);
        when(predicate.test(output)).thenReturn(true);

        assertThat(having(longFunction, predicate)).accepts(LONG_INPUT);
    }

    @Test
    public void should_reject_long_when_function_returns_invalid_result() {
        when(longFunction.apply(LONG_INPUT)).thenReturn(output);
        when(predicate.test(output)).thenReturn(false);

        assertThat(having(longFunction, predicate)).rejects(LONG_INPUT);
    }


    @Test
    public void should_accept_double_when_function_returns_valid_result() {
        when(doubleFunction.apply(DOUBLE_INPUT)).thenReturn(output);
        when(predicate.test(output)).thenReturn(true);

        assertThat(having(doubleFunction, predicate)).accepts(DOUBLE_INPUT);
    }

    @Test
    public void should_reject_double_when_function_returns_invalid_result() {
        when(doubleFunction.apply(DOUBLE_INPUT)).thenReturn(output);
        when(predicate.test(output)).thenReturn(false);

        assertThat(having(doubleFunction, predicate)).rejects(DOUBLE_INPUT);
    }

    @Test
    public void should_accept_object_when_function_returns_valid_result() {
        when(function.apply(input)).thenReturn(output);
        when(predicate.test(output)).thenReturn(true);

        assertThat(having(function, predicate)).accepts(input);
    }

    @Test
    public void should_reject_object_when_function_returns_invalid_result() {
        when(function.apply(input)).thenReturn(output);
        when(predicate.test(output)).thenReturn(false);

        assertThat(having(function, predicate)).rejects(input);
    }


}