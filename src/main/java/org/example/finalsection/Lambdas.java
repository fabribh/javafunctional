package org.example.finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {

        Function<String, String> upperCaseName = name -> name.toUpperCase();
        System.out.println("upperCaseName " + upperCaseName.apply("fabio"));

        Function<String, String> upperCaseNameSimple = String::toUpperCase;
        System.out.println("upperCaseNameSimple " + upperCaseNameSimple.apply("fabio"));

        Function<String, String> upperCaseNameExtraLogic = name -> {
            if (name.isBlank()) throw new IllegalStateException("name is blank");
            return name.toUpperCase();
        };
        System.out.println("upperCaseNameExtraLogic " + upperCaseNameExtraLogic.apply("fabio"));

        BiFunction<String, Integer, String> upperCaseNameBiFunction = (name, age) -> {
            if (name.isBlank()) throw new IllegalStateException("name is blank");
            System.out.println("upperCaseNameBiFunction " + age);
            return name.toUpperCase();
        };
        System.out.println("upperCaseNameBiFunction " + upperCaseNameBiFunction.apply("John", 18));
    }
}
