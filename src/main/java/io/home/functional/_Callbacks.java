package io.home.functional;

import java.util.function.Consumer;

public class _Callbacks {
    public static void main(String[] args) {
        hello("Vipul", "Sharma",
                s -> System.out.println("No last name provided"));

        hello("John", null,
                s -> System.out.println("No last name provided"));

        hello2(null, "Stanley",
                () -> System.out.println("No first name provided")
        );
    }

    static void hello(String fName, String lName, Consumer<String> callBack) {
        System.out.println();
        System.out.println(fName);

        if(lName != null) {
            System.out.println(lName);
        } else {
            callBack.accept(fName);
        }
    }

    static void hello2(String fName, String lName, Runnable callBack) {
        System.out.println();

        if(fName != null) {
            System.out.println(fName);
        } else {
            callBack.run();
        }
        System.out.println(lName);
    }
}
