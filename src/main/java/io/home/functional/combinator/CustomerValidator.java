package io.home.functional.combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

enum ValidationResult {
    SUCCESS,
    PHN_NO_NOT_VALID,
    EMAIL_NOT_VALID,
    IS_NOT_AN_ADULT
}

public interface CustomerValidator extends Function<Customer, ValidationResult> {

    static CustomerValidator isEmailValid () {
        return c -> c.getEmail().contains("@")
                ? ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }

    static CustomerValidator isPhnNoValid () {
        return c -> c.getPhnNo().startsWith("9")
                ? ValidationResult.SUCCESS : ValidationResult.PHN_NO_NOT_VALID;
    }

    static CustomerValidator isAnAdult () {
        return c -> Period.between(c.getDob(), LocalDate.now()).getYears() >= 18
                ? ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT ;
    }

    default CustomerValidator and (CustomerValidator other) {
        return c -> {
          ValidationResult result = this.apply(c);

          /** If result of 1st function is SUCCESS, then check other one **/
          return result.equals(ValidationResult.SUCCESS) ? other.apply(c) : result;
        };
    }
}
