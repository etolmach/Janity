package com.etolmach.stream.chained;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Objects;

import static com.etolmach.stream.chained.StreamDsl.typedSwitch;
import static com.etolmach.stream.comparators.Predicates.not;
import static com.etolmach.stream.comparators.StringPredicates.startingWith;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;

/**
 * @author Evgeniy Tolmach
 */
@RunWith(MockitoJUnitRunner.class)
public class SwitchTest {

    @Mock
    private ChainedPredicateTest.Player player1;
    @Mock
    private ChainedPredicateTest.Player player2;
    @Mock
    private ChainedPredicateTest.Player player3;
    @Mock
    private ChainedPredicateTest.Player player4;

    private List<ChainedPredicateTest.Player> players;

    @Before
    public void setUp() {
        when(player1.getName()).thenReturn("John");
        when(player2.getName()).thenReturn("Jack");
        when(player3.getName()).thenReturn("Alex");
        when(player4.getName()).thenReturn("Bob");

        players = asList(player1, player2, player3, player4);
    }


    @Test
    public void testSwitch() {
        players.stream()
                .map(
                        typedSwitch(ChainedPredicateTest.Player.class)
                                .when(Objects::isNull).thenMap(__ -> "Null")
                                .when(ChainedPredicateTest.Player::getName).is(startingWith("J")).thenMap(s -> "Starting with J!")
                                .when(ChainedPredicateTest.Player::getName).is(not(startingWith("A"))).thenMap(s -> "Not starting with A!")
                                .when(ChainedPredicateTest.Player::getName).is(startingWith("B")).thenMap(s -> "Starting with B!")
                                .elseMap(__ -> "Default!")
                )
                .forEach(System.out::println);

        players.stream()
                .forEach(
                        StreamDsl
                                .when(Objects::isNull).thenDo(__ -> System.out.println("Null value!"))
//                                .when(Player::getName).is(startingWith("J")).thenDo(c -> System.out.println(c + " Starting with J!"))
//                                .when(Player::getName).is(not(startingWith("A"))).thenDo(s -> "Not starting with A!")
//                                .when(Player::getName).is(startingWith("B")).thenDo(s -> "Starting with B!")
                                .elseDo(System.out::println)
                );
    }

    interface Player {

        String getName();

        double getScore();

    }


}