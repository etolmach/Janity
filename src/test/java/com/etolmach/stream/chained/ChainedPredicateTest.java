package com.etolmach.stream.chained;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Objects;
import java.util.stream.DoubleStream;

import static com.etolmach.stream.chained.StreamDsl.typedSwitch;
import static com.etolmach.stream.chained.StreamDsl.where;
import static com.etolmach.stream.comparators.Comparators.equalTo;
import static com.etolmach.stream.comparators.Comparators.greaterThan;
import static com.etolmach.stream.comparators.Predicates.not;
import static com.etolmach.stream.comparators.StringPredicates.startingWith;
import static java.lang.Integer.valueOf;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

/**
 * @author Evgeniy Tolmach
 */

@RunWith(MockitoJUnitRunner.class)
public class ChainedPredicateTest {

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
        when(player1.getName()).thenReturn("John");
        when(player2.getName()).thenReturn("Jack");
        when(player3.getName()).thenReturn("Alex");
        when(player4.getName()).thenReturn("Bob");

//        when(player1.getScore()).thenReturn(26.3);
//        when(player2.getScore()).thenReturn(44.1);
        when(player3.getScore()).thenReturn(15.12);
        when(player4.getScore()).thenReturn(21.32);

        players = asList(player1, player2, player3, player4);
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

        List<Player> filteredPlayers = players.stream()
                .filter(
                        StreamDsl
                                .where(Player::getName).is(not(startingWith("J")))
                                .and(Player::getScore).is(greaterThan((Double) 20.12))
                ).collect(toList());

        Assertions.assertThat(filteredPlayers)
                .containsExactly(player4);
    }

    @Test
    public void testSwitch() {
        players.stream()
                .map(
                        typedSwitch(Player.class)
                                .when(Objects::isNull).thenMap(__ -> "Null")
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


//        BiFunction<? super Object, ? super Object, ?> mergeFunc = null;
//        Map<Player, Double> collect = players
//                .stream()
//                .collect(
//                        () -> new HashMap<>(),
//                        (map, player) -> {
//                            map.computeIfAbsent(player)
//                        },
//                        (map1, map2) -> new HashMap<>().merge(map1, map2, mergeFunc)
//                );

    }

    interface Player {

        String getName();

        double getScore();

    }

}