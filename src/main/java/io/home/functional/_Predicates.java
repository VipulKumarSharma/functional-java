package io.home.functional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static io.home.functional._Predicates.Gender.FEMALE;
import static io.home.functional._Predicates.Gender.MALE;

public class _Predicates {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Person {
        private String name;
        private Gender gender;
    }

    enum Gender {
        MALE, FEMALE
    }

    public static void main(String[] args) {

        List<Person> people = List.of(
            new Person("John", MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("Alice", FEMALE)
        );

        Predicate<Person> person_Predicate = person -> FEMALE.equals(person.getGender());

        System.out.println("Females ::");
        people.stream()
            .filter(person_Predicate)
            .forEach(System.out::println);

        Predicate<String> isValidPhnNoLength_Predicate = s -> s.length() == 10;
        Predicate<String> isValidPhnNoStarting_Predicate = s -> s.startsWith("9");
        BiPredicate<String, Integer> biPredicate = (s, num) -> s.length() == num;

        boolean test = isValidPhnNoLength_Predicate.test("9123456798");
        System.out.println("\nisValidPhnNoLength_Predicate.test(9123456789) = "+test);

        boolean test1 = isValidPhnNoLength_Predicate.and(isValidPhnNoStarting_Predicate).test("9123456798");
        System.out.println("\nisValidPhnNoLength_Predicate.and(isValidPhnNoStarting_Predicate).test(9123456798) = "+test1);

        boolean test2 = isValidPhnNoLength_Predicate.or(isValidPhnNoStarting_Predicate).test("0123456798");
        System.out.println("\nisValidPhnNoLength_Predicate.or(isValidPhnNoStarting_Predicate).test(0123456798) = "+test2);

        boolean test3 = biPredicate.test("TEST", 4);
        System.out.println("\nbiPredicate.test(TEST, 4) = "+test3);
    }

}
