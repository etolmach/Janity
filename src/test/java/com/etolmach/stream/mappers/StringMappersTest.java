package com.etolmach.stream.mappers;

import org.junit.Test;

import static com.etolmach.stream.mappers.StringMappers.splitBy;
import static com.etolmach.stream.mappers.StringMappers.substring;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Evgeniy Tolmach
 */
public class StringMappersTest {

    public static final String STRING = "a,b,c,d";
    public static final String REGEX = ",";
    public static final int LIMIT = 3;
    public static final int BEGIN = 2;
    public static final int END = 4;

    @Test
    public void testSplitBy() {
        assertArrayEquals(
                STRING.split(REGEX),
                splitBy(REGEX).apply(STRING)
        );
    }

    @Test
    public void testSplitWithLimit() {
        assertArrayEquals(
                STRING.split(REGEX, LIMIT),
                splitBy(REGEX, LIMIT).apply(STRING)
        );
    }

    @Test
    public void testSubstringWithBegin() {
        assertEquals(
                STRING.substring(BEGIN),
                substring(BEGIN).apply(STRING)
        );
    }

    @Test
    public void testSubstringWithBeginAndEnd() {
        assertEquals(
                STRING.substring(BEGIN, END),
                substring(BEGIN, END).apply(STRING)
        );
    }
}