package com.etolmach.stream;

import java.util.function.*;

/**
 * @author Evgeniy Tolmach
 */
public class Suppliers {

    public static Supplier<Boolean> boxed(BooleanSupplier supplier) {
        return supplier::getAsBoolean;
    }

    public static Supplier<Integer> boxed(IntSupplier supplier) {
        return supplier::getAsInt;
    }

    public static Supplier<Long> boxed(LongSupplier supplier) {
        return supplier::getAsLong;
    }

    public static Supplier<Double> boxed(DoubleSupplier supplier) {
        return supplier::getAsDouble;
    }

    public static BooleanSupplier unboxedBoolean(Supplier<Boolean> supplier) {
        return supplier::get;
    }

    public static IntSupplier unboxedInt(Supplier<Number> supplier) {
        return supplier.get()::intValue;
    }

    public static LongSupplier unboxedLong(Supplier<Number> supplier) {
        return supplier.get()::longValue;
    }

    public static DoubleSupplier unboxedDouble(Supplier<Number> supplier) {
        return supplier.get()::doubleValue;
    }

    public static Supplier<Integer> asInt(Supplier<Number> supplier) {
        return boxed(unboxedInt(supplier));
    }

    public static Supplier<Long> asLong(Supplier<Number> supplier) {
        return boxed(unboxedLong(supplier));
    }

    public static Supplier<Double> asDouble(Supplier<Number> supplier) {
        return boxed(unboxedDouble(supplier));
    }

    public static <T, R> Supplier<R> mapped(Supplier<T> supplier, Function<T, R> mapper) {
        return () -> mapper.apply(supplier.get());
    }

}
