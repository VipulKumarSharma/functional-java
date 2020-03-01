package io.home.functional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static io.home.functional._Streams.Gender.*;

public class _Streams {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Employee {
        private String name;
        private Gender gender;
    }

    enum Gender {
        MALE, FEMALE, TRANS
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("John", MALE),
                new Employee("Maria", FEMALE),
                new Employee("Aisha", FEMALE),
                new Employee("Alex", MALE),
                new Employee("Alice", TRANS)
        );

        employees.stream()
            .map(e -> e.getName())
            .mapToInt(String::hashCode)
            .forEach(System.out::println);

        employees.stream()
                .map(e -> e.getName())
                .forEach(System.out::println);

        boolean containsOnlyFemales = employees.stream()
                .allMatch(e -> FEMALE.equals(e.getGender()));
        System.out.println("\nAll Females = "+containsOnlyFemales);

        boolean anyFemale = employees.stream()
                .anyMatch(e -> FEMALE.equals(e.getGender()));
        System.out.println("At least 1 Female = "+anyFemale);

        boolean noTransGender = employees.stream()
                .noneMatch(e -> TRANS.equals(e.getGender()));
        System.out.println("No TransGender = "+noTransGender);

    }
}
