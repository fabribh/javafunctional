package org.example.optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");
        System.out.println(value);

        Object s = Optional.ofNullable("Hello my friend")
                .orElseThrow(() -> new IllegalStateException("exception"));
        System.out.println(s);

        Optional.ofNullable("john@gmail.com")
                .ifPresent(email -> System.out.println("sending email to " + email));

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("sending email to " + email),
                        () -> System.out.println("Cannot send email"));
    }
}
