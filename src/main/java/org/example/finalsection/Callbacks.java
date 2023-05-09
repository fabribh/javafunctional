package org.example.finalsection;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {

        // using callback of type Consumer
        System.out.println("// using callback of type Consumer");
        hello("John", "Montana", null);
        System.out.println("*********************************************");

        System.out.println("// using callback of type Consumer with lastName null");
        hello("John", null, value -> {
            System.out.println("no lastName provided for " + value);
        });
        System.out.println("*********************************************");

        // Using callback of type Runnable
        System.out.println("// Using callback of type Runnable");
        hello2("John", null, ()
                -> System.out.println("no lastName provided"));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}
