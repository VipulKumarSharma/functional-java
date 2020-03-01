package io.home.functional.combinator;

import java.time.LocalDate;

import static io.home.functional.combinator.CustomerValidator.*;

public class _CombinatorPattern {

    /** Takes functions as args & return new functions
     ** Allows us to chain functions
     **/
    public static void main(String[] args) {
        Customer customer = new Customer(
            "Alice", "alice@email.com", "0876543210", LocalDate.of(2000,1,1)
        );

        ValidationResult result = isEmailValid()
                                    .and(isPhnNoValid())
                                    .and(isAnAdult())
                                    .apply(customer);
        // Nothing will be executed until we call .apply();

        if(result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
        System.out.println("\nCustomer Validation = "+result);
    }
}
