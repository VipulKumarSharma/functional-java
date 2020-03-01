package io.home.functional;

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

        System.out.println("Tracking execution");
        int result = IntStream.range(1, 10)
                .filter(Examples::isGreaterThan3)
                .filter(Examples::isEven)
                .map(Examples::doubleIt)
                .findFirst()
                .getAsInt();
        System.out.println(result);
    }

    static boolean isGreaterThan3(int n) {
        System.out.println("isGreaterThan3("+n+")");
        return n > 3;
    }

    static boolean isEven(int n) {
        System.out.println("isEven("+n+")");
        return n % 2 == 0;
    }

    static int doubleIt(int n) {
        System.out.println("doubleIt("+n+")");
        return n * 2;
    }
}
