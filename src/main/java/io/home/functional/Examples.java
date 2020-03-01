package io.home.functional;

import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Examples {

    static IntPredicate isDivisible(Integer num) {
        return index -> num % index == 0;
    }

    static Function<Integer, Boolean> isPrime
            = num -> num > 1 && IntStream.range(2, num)
                                         .noneMatch(isDivisible(num));

    public static void main(String[] args) {
        System.out.println();
        System.out.println("isPrime.apply(7) = "+isPrime.apply(7));
    }
}
