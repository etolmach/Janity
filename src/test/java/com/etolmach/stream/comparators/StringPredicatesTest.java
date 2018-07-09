package com.etolmach.stream.comparators;

import org.junit.Test;

import static com.etolmach.stream.comparators.StringPredicates.endingWith;
import static com.etolmach.stream.comparators.StringPredicates.startingWith;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Evgeniy Tolmach
 */
public class StringPredicatesTest {

    @Test
    public void testStartsWith() {
        assertTrue(StringPredicates.startingWith("He").test("Hello"));
        assertFalse(StringPredicates.startingWith("e").test("Hello"));
    }

    @Test
    public void testStartsWithOffset() {
        assertTrue(startingWith("e", 1).test("Hello"));
        assertFalse(startingWith("He", 1).test("Hello"));
    }

    @Test
    public void testEndsWith() {
        assertTrue(endingWith("o").test("Hello"));
        assertFalse(endingWith("l").test("Hello"));
    }
}