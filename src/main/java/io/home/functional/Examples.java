package io.home.functional;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Examples {

    static boolean isPrime(final int number) {
        Predicate<Integer> isDivisible = divisor -> number % divisor == 0;

        return number > 1 && IntStream.range(2, number)
                .noneMatch(isDivisible::test);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("isPrime(7) = "+isPrime(71));
    }
}
