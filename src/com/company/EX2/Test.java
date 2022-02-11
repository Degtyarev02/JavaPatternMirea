package com.company.EX2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.LocalDate.*;

public class Test {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human(23, "John", "Snow", of(1999, 1, 23), 78),
                new Human(20, "Mike", "De-Santa", of(2000, 3, 21), 87),
                new Human(32, "Sam", "Fisher", of(1990, 5, 15), 102),
                new Human(40, "Ezio", "Auditore", of(1992, 2, 3), 98)
        );

        Stream<Human> humanStream1 = humans.stream();
        humanStream1
                .filter(human -> human.getBirthDate().isBefore(of(1999, 2, 3)))
                .forEach(System.out::println);

        Stream<Human> humanStream2 = humans.stream();
        humanStream2
                .map(human -> human.getWeight()-5)
                .forEach(System.out::println);

        Stream<Human> humanStream3 = humans.stream();
        String allNames = humanStream3
                .map(Human::getFirstName)
                .collect(Collectors.joining(" "));
        System.out.println(allNames);
    }
}
