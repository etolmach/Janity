package com.etolmach.stream.comparators;

import java.util.function.Predicate;

/**
 * @author Evgeniy Tolmach
 */
public class StringPredicates {

    public static Predicate<String> startsWith(String prefix) {
        return s -> s.startsWith(prefix);
    }

    public static Predicate<String> startsWith(String prefix, int offset) {
        return s -> s.startsWith(prefix, offset);
    }

    public static Predicate<String> endsWith(String suffix) {
        return s -> s.endsWith(suffix);
    }

}
