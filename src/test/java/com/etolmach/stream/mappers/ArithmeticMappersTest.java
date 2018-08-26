package com.etolmach.stream.mappers;

import org.junit.Test;

import java.util.function.IntUnaryOperator;

import static com.etolmach.stream.mappers.ArithmeticMappers.modulo;
import static com.etolmach.stream.mappers.ArithmeticMappers.multiplyBy;
import static com.etolmach.stream.mappers.ArithmeticMappers.multiplyPrimitiveBy;
import static com.etolmach.stream.mappers.ArithmeticMappers.primitiveModulo;
import static com.etolmach.stream.test.FunctionalAsserts.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * @author Evgeniy Tolmach
 */
public class ArithmeticMappersTest {

    @Test
    public void testMultiplyPrimitiveByInt() {
        assertThat(multiplyPrimitiveBy(2))
                .on(-2).returns(-4)
                .on(0).returns(0)
                .on(2).returns(4);
    }

    @Test
    public void multiplyPrimitiveByLong() {
        assertThat(multiplyPrimitiveBy(2L))
                .on(-2L).returns(-4L)
                .on(0L).returns(0L)
                .on(2L).returns(4L);
    }

    @Test
    public void multiplyPrimitiveByDouble() {
        assertThat(multiplyPrimitiveBy(2.0))
                .on(-2.0).returns(-4.0)
                .on(0.0).returns(0.0)
                .on(2.0).returns(4.0);
    }

    @Test
    public void multiplyByInt() {
        assertThat(multiplyBy(2))
                .on(-2).returns(-4)
                .on(0).returns(0)
                .on(2).returns(4);
    }

    @Test
    public void multiplyByLong() {
        assertThat(multiplyBy(2L))
                .on(-2L).returns(-4L)
                .on(0L).returns(0L)
                .on(2L).returns(4L);
    }

    @Test
    public void multiplyByDouble() {
        assertThat(multiplyBy(2.0))
                .on(-2.0).returns(-4.0)
                .on(0.0).returns(0.0)
                .on(2.0).returns(4.0);
    }

    @Test
    public void primitiveIntModulo() {
        assertThat(primitiveModulo(3))
                .on(-5).returns(-2)
                .on(3).returns(0)
                .on(10).returns(1);
    }

    @Test
    public void primitiveLongModulo() {
        assertThat(primitiveModulo(3L))
                .on(-5L).returns(-2L)
                .on(3L).returns(0L)
                .on(10L).returns(1L);
    }

    @Test
    public void intModulo() {
        assertThat(modulo(3))
                .on(-5).returns(-2)
                .on(3).returns(0)
                .on(10).returns(1);
    }

    @Test
    public void longModulo() {
        assertThat(modulo(3L))
                .on(-5L).returns(-2L)
                .on(3L).returns(0L)
                .on(10L).returns(1L);
    }

    @Test
    public void dividePrimitiveTo() {
    }

    @Test
    public void dividePrimitiveTo1() {
    }

    @Test
    public void dividePrimitiveTo2() {
    }

    @Test
    public void divideTo() {
    }

    @Test
    public void divideTo1() {
    }

    @Test
    public void divideTo2() {
    }

    @Test
    public void incrementPrimitiveBy() {
    }

    @Test
    public void incrementPrimitiveBy1() {
    }

    @Test
    public void incrementPrimitiveBy2() {
    }

    @Test
    public void incrementBy() {
    }

    @Test
    public void incrementBy1() {
    }

    @Test
    public void incrementBy2() {
    }

    @Test
    public void decrementPrimitiveBy() {
    }

    @Test
    public void decrementPrimitiveBy1() {
    }

    @Test
    public void decrementPrimitiveBy2() {
    }

    @Test
    public void decrementBy() {
    }

    @Test
    public void decrementBy1() {
    }

    @Test
    public void decrementBy2() {
    }

    private void assertUnaryOperator(IntUnaryOperator operator, int in, int out) {
        assertEquals(out, operator.applyAsInt(in));
    }
}