package io.home.functional;

import java.util.IntSummaryStatistics;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Examples {

    static boolean isPrime(final int number) {
        Predicate<Integer> isDivisible = divisor -> number % divisor == 0;

        return number > 1 && IntStream.range(2, number)
                .noneMatch(isDivisible::test);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("\nisPrime(7) = "+isPrime(71));

        System.out.println("\nTracking execution");
        int result = IntStream.range(1, 10)
                .filter(Examples::isGreaterThan3)
                .skip(2)
                .filter(Examples::isEven)
                .map(Examples::doubleIt)
                .findFirst()
                .getAsInt();
        System.out.println("Result = "+result);

        double total = DoubleStream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (left, right) -> left + right);
        System.out.println("\nTotal using reduce() = "+total);

        IntSummaryStatistics intSummaryStatistics = IntStream.of(7, 2, 19, 88, 73, 4 ,10)
                .summaryStatistics();
        System.out.println("\n"+intSummaryStatistics);
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
