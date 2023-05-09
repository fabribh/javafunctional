package org.example.streams;


import java.util.List;
import java.util.stream.Collectors;

import static org.example.streams._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FAMALE),
                new Person("Aisha", FAMALE),
                new Person("Alex", MALE),
                new Person("Alice", FAMALE)
        );

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        boolean allFemale = people.stream()
                .allMatch(person -> FAMALE.equals(person.gender));
        System.out.println("All are female? " + allFemale);

        boolean anyFemale = people.stream()
                .anyMatch(person -> FAMALE.equals(person.gender));
        System.out.println("Any are female? " + anyFemale);

        boolean noneMatch = people.stream()
                .noneMatch(person -> NOT_INFORMED.equals(person.gender));
        System.out.println("Are none of match? " + noneMatch);
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
        MALE, FAMALE, NOT_INFORMED
    }
}
