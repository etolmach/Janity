package com.etolmach.stream.mappers;

import java.util.function.Function;

/**
 * @author Evgeniy Tolmach
 */
public class StringMappers {

    public static Function<String, String[]> splitBy(String regex, int limit) {
        return s -> s.split(regex, limit);
    }

    public static Function<String, String[]> splitBy(String regex) {
        return splitBy(regex, 0);
    }

    public static Function<String, String> substring(int begin) {
        return s -> s.substring(begin);
    }

    public static Function<String, String> substring(int begin, int end) {
        return s -> s.substring(begin, end);
    }

}
