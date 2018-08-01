package com.etolmach.stream.mappers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

import static com.etolmach.stream.mappers.Mappers.applyTo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Evgeniy Tolmach
 */
@RunWith(MockitoJUnitRunner.class)
public class MappersTest {

    public static final int INT_VALUE = 10;
    public static final long LONG_VALUE = 10L;
    public static final double DOUBLE_VALUE = 10.0;

    public static final String STRING_VALUE = "someValue";

    @Test
    public void applyToInt() {
        IntFunction<String> function = mock(IntFunction.class);
        when(function.apply(INT_VALUE)).thenReturn(STRING_VALUE);

        Function<IntFunction<String>, String> applicator = applyTo(INT_VALUE);

        assertEquals(STRING_VALUE, applicator.apply(function));
    }

    @Test
    public void applyToLong() {
        LongFunction<String> function = mock(LongFunction.class);
        when(function.apply(LONG_VALUE)).thenReturn(STRING_VALUE);

        Function<LongFunction<String>, String> applicator = applyTo(LONG_VALUE);

        assertEquals(STRING_VALUE, applicator.apply(function));
    }

    @Test
    public void applyToDouble() {
        DoubleFunction<String> function = mock(DoubleFunction.class);
        when(function.apply(DOUBLE_VALUE)).thenReturn(STRING_VALUE);

        Function<DoubleFunction<String>, String> applicator = applyTo(DOUBLE_VALUE);

        assertEquals(STRING_VALUE, applicator.apply(function));
    }

    @Test
    public void applyToObject() {
        List<Integer> list = mock(List.class);
        Function<List<Integer>, String> function = mock(Function.class);

        when(function.apply(list)).thenReturn(STRING_VALUE);

        Function<Function<List<Integer>, String>, String> applicator = applyTo(list);

        assertEquals(STRING_VALUE, applicator.apply(function));

    }

}
