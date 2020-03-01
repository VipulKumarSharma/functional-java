package io.home.functional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static io.home.functional._Streams.Gender.*;

public class _Streams {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Employee {
        private String name;
        private Gender gender;
        private int age;
    }

    enum Gender {
        MALE, FEMALE, TRANS
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Adam", MALE, 19),
                new Employee("Bhawna", FEMALE, 36),
                new Employee("Casey", FEMALE, 25),
                new Employee("Daniel", MALE, 27),
                new Employee("Don", TRANS, 54)
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

        System.out.println("\nSorting employees by (name -> gender)");
        employees.stream()
            .sorted(
                Comparator.comparing(Employee::getName)
                          .thenComparing(Employee::getGender)
            )
            .forEach(System.out::println);

        System.out.println("\nMin age Employee");
        employees.stream()
            .min(Comparator.comparing(Employee::getAge))
            .ifPresent(System.out::println);

        System.out.println("\nMax age Employee");
        employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .ifPresent(System.out::println);

        System.out.println("\nGroup Employees by Gender");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender))
                .forEach((gender, empList) -> {
                    System.out.println(gender+" : "+
                        empList.stream().map(Employee::getName).collect(Collectors.toList()));
                });

    }
}
