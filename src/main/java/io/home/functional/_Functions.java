package io.home.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Functions {

    public static void main(String[] args) {
        Function<Integer, Integer> incrementByOne_Function = num -> num + 1;
        Function<Integer, Integer> multiplyBy10_Function = num -> num * 10;
        Function<Integer, Integer> add1AndThenMultiplyBy10_Function = incrementByOne_Function.andThen(multiplyBy10_Function);

        BiFunction<Integer, Integer, Integer> add1AndMultiplyByY_BiFunction
                = (num, multiplyBy) -> (num + 1) * multiplyBy;

        Integer value1 = incrementByOne_Function.apply(20);
        System.out.println("\nincrementByOne_Function.apply(20) = "+value1);

        Integer value2 = add1AndThenMultiplyBy10_Function.apply(54);
        System.out.println("\nadd1AndThenMultiplyBy10_Function.apply(54) = "+value2);

        Integer value3 = add1AndMultiplyByY_BiFunction.apply(99, 100);
        System.out.println("\nadd1AndMultiplyByY_BiFunction.apply(99, 100) = "+value3);



    }

}
