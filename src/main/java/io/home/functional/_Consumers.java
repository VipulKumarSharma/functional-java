package io.home.functional;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumers {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = s -> System.out.print("\nConsumed string : "+s);
        BiConsumer<String, Integer> biConsumer = (s, num) -> System.out.println("\n"+s+" has "+num+" args");

        stringConsumer.accept("Hey !!");
        biConsumer.accept("BiConsumer", 2);
    }
}
