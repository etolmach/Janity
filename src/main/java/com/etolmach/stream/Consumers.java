package com.etolmach.stream;

import java.util.function.Consumer;

/**
 * @author Evgeniy Tolmach
 */
public class Consumers {

    public static <T> Consumer<T> doNothing() {
        return __ -> {
        };
    }

}
