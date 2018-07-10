package com.etolmach.stream.chained;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;

import static com.etolmach.stream.chained.ChainedPredicate.where;
import static com.etolmach.stream.comparators.Comparators.equalTo;
import static com.etolmach.stream.comparators.Comparators.greaterThan;
import static com.etolmach.stream.comparators.Predicates.not;
import static com.etolmach.stream.comparators.StringPredicates.startingWith;
import static java.lang.Integer.valueOf;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * @author Evgeniy Tolmach
 */

@RunWith(MockitoJUnitRunner.class)
public class ChainedPredicateChainTest {

    @Mock
    private Player player1;
    @Mock
    private Player player2;
    @Mock
    private Player player3;
    @Mock
    private Player player4;

    private List<Player> players;

    @Before
    public void setUp() {
        Mockito.when(player1.getName()).thenReturn("John");
        Mockito.when(player2.getName()).thenReturn("Jack");
        Mockito.when(player3.getName()).thenReturn("Alex");
        Mockito.when(player4.getName()).thenReturn("Bob");

        Mockito.when(player1.getScore()).thenReturn(26.3);
        Mockito.when(player2.getScore()).thenReturn(44.1);
        Mockito.when(player3.getScore()).thenReturn(15.12);
        Mockito.when(player4.getScore()).thenReturn(21.32);

        players = asList(player1, player2, player3, null, player4);
    }

    @Test
    public void isTrue() {
        Assert.assertTrue(
                DoubleStream.of(1.1, 2.2, 3.1)
                        .boxed()
                        .filter(where(Double::intValue).is(equalTo(valueOf(0))))
                        .collect(toList())
                        .isEmpty()
        );
    }

    @Test
    public void isFalse() {

        final Double minScore = 29.12;
        final String prefix = "J";

        List<Player> filteredPlayers = players.stream()
                .filter(
                        where(Player::getName).is(not(startingWith(prefix)))
                                .and(Player::getScore).is(not(greaterThan(minScore)))
                )
                .collect(toList());

        Assert.assertEquals(players, asList(player2));
    }

    @Test
    public void testSwitch() {
//        players.stream()
//                .forEach(
//                        switching(
//                                when(Player::getName).is(not(startingWith("J"))).then(System.out::println)
//                        ).elseDo(doNothing())
//                );

        players.stream()
                .map(
                        StreamDsl
                                .when((Predicate<Player>) Objects::isNull).thenMap(__ -> "Null")
                                .when(Player::getName).is(startingWith("J")).thenMap(s -> "Starting with J!")
                                .when(Player::getName).is(not(startingWith("A"))).thenMap(s -> "Not starting with A!")
                                .when(Player::getName).is(startingWith("B")).thenMap(s -> "Starting with B!")
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
