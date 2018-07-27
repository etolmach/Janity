package com.etolmach.stream.chained;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;
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

        when(player1.getScore()).thenReturn(26.3);
        when(player2.getScore()).thenReturn(44.1);
        when(player3.getScore()).thenReturn(15.12);
        when(player4.getScore()).thenReturn(21.32);

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
    }

    interface Player {

        String getName();

        double getScore();

    }

    interface Device {
        // ...
        boolean isDisconnected();

        void reconnect();
    }

    interface Gateway {
        // ...
        List<Device> getDevices();
    }

    @Test
    public void test() {

        List<Gateway> gateways = null;

        for (Gateway gateway : gateways) {
            for (Device device : gateway.getDevices()) {
                if (device.isDisconnected()) {
                    device.reconnect();
                }
            }
        }

        gateways.stream()
                .forEach(gateway -> {
                            gateway.getDevices()
                                    .parallelStream()
                                    .filter(device -> device.isDisconnected())
                                    .forEach(device -> device.reconnect());
                        }
                );

        gateways.parallelStream()
                .map(gateway -> gateway.getDevices().parallelStream())
                .map(stream -> stream.filter(device -> device.isDisconnected()))
                .forEach(stream -> stream.forEach(device -> device.reconnect()));

        gateways.parallelStream()
                .map(Gateway::getDevices)
                .flatMap(List::parallelStream)
                .filter(Device::isDisconnected)
                .forEach(Device::reconnect);


    }

    public static <K, E, C extends Collection<E>> Optional<E> removeOne(Map<K, C> map, K key) {
        C col = map.get(key);
        if (col != null) {
            Iterator<E> it = col.iterator();
            E e = it.next();
            if (!it.hasNext()) {
                it.remove();
            }
            return Optional.ofNullable(e);
        }
        return Optional.empty();
    }

    public static <K, E> E removeOne__(Map<K, Collection<E>> map, K key) {
        Collection<E> col = map.get(key);
        Iterator<E> it = col.iterator();
        E e = it.next();
        if (!it.hasNext()) {
            it.remove();
        }
        return e;
    }

    public static <K, E, C extends Collection<E>> E removeOne_(Map<K, C> map, K key) {
        C col = map.get(key);
        if (col != null) {
            Iterator<E> it = col.iterator();
            if (it.hasNext()) {
                E e = it.next();
                if (!it.hasNext()) {
                    it.remove();
                }
                return e;
            } else {
                map.remove(key);
            }
        }
        return null;
    }

    @Test
    public void anotherTest() {
        Stack<String> list = new Stack();
        list.add("1");
        list.add("2");

        Map<Integer, List<String>> map = new HashMap<>();
        map.put(1, list);
        map.put(2, new Stack());


        Assert.assertEquals("1", removeOne(map, 1));
        Assert.assertEquals(1, map.get(1).size());
        Assert.assertNull(removeOne(map, 2));
        Assert.assertFalse(map.containsKey(2));

        Assert.assertFalse(map.containsKey(1));


        List<Group> groups = null;

//        Set<String> groupedUsers = groups.stream()
//                .flatMap(g -> Stream.concat(
//                        Stream.of(g.getTeamLeadId()),
//                        g.getTeamMemberIds().stream()))
//                .collect(toSet());


    }

    private interface Group {
        String getTeamLeadId();

        Set<String> getTeamMemberIds();
    }
}















