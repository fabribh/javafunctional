package org.example.combinatorpattern;

import java.time.LocalDate;

import static org.example.combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+0584654684684",
                LocalDate.of(2000, 1, 1)
        );
        System.out.println(new CustomerValidatorService().isValid(customer));
        // If valid we can store customer in db

        // Using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
