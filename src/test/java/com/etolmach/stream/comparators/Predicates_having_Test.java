package com.etolmach.stream.comparators;

import static com.etolmach.stream.comparators.Predicates.having;
import static com.etolmach.stream.comparators.StringPredicates.startingWith;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author Evgeniy Tolmach
 */
@RunWith(MockitoJUnitRunner.class)
public class Predicates_having_Test {

    public static final String PREFIX = "F";
    public static final String VALID_NAME = "Foo";
    public static final String INVALID_NAME = "Bar";
    @Mock
    private User validUser;
    @Mock
    private User invalidUser;

    @Before
    public void setUp() {
        Mockito.when(validUser.getName()).thenReturn(VALID_NAME);
        Mockito.when(invalidUser.getName()).thenReturn(INVALID_NAME);
    }

    @Test
    public void should_reject_object_with_non_matching_field() {
        assertThat(having(User::getName, startingWith(PREFIX))).rejects(invalidUser);
    }

    @Test
    public void should_accept_object_with_matching_field() {
        assertThat(having(User::getName, startingWith(PREFIX))).accepts(validUser);
    }

    private interface User {
        String getName();
    }

}