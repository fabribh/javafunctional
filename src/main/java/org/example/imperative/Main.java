package org.example.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
              new Person("John", Gender.MALE),
              new Person("Maria", Gender.FAMALE),
              new Person("Aisha", Gender.FAMALE),
              new Person("Alex", Gender.MALE),
              new Person("Alice", Gender.FAMALE)
        );

        // Imperative approach
        System.out.println("// Imperative approach");
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (Gender.FAMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

        // Declarative approach
        System.out.println("// Declarative approach");
        List<Person> collectOfFemales = people.stream()
                .filter(person -> Gender.FAMALE.equals(person.gender))
                .collect(Collectors.toList());
        collectOfFemales.forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FAMALE
    }
}
