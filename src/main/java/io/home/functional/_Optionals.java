package io.home.functional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class _Optionals {
    public static void main(String[] args) {

        Supplier<String> orElseGet_Supplier = () -> "\nnull value found";

        Object fetchedValue = Optional.ofNullable(null)
                .orElseGet(orElseGet_Supplier);
        System.out.println(fetchedValue);

        Consumer<Object> ifPresent_Consumer = data -> System.out.println("Data = "+data);
        Runnable orElse_Runnable            = () -> System.out.println("No data found");

        Optional.ofNullable(null)
            .ifPresentOrElse(ifPresent_Consumer, orElse_Runnable);
    }
}
