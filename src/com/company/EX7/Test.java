package com.company.EX7;

import com.company.EX7.facade.CarEngineFacade;
import com.company.EX7.lightweight.Person;
import com.company.EX7.lightweight.PersonsFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * todo Document type Test
 */
public class Test {
    public static void main(String[] args) {
        lightweightTestPattern();
        facadePatternTest();
    }

    public static void lightweightTestPattern() {
        System.out.println("=====================Lightweight pattern=====================");
        PersonsFactory factory = new PersonsFactory();
        List<Person> people = new ArrayList<>();
        people.add(new Person(10, 20, factory.getPersonType("White", "Man", 34)));
        people.add(new Person(15, 21, factory.getPersonType("White", "Women", 19)));
        people.add(new Person(12, 31, factory.getPersonType("Black", "Man", 45)));
        people.add(new Person(20, 40, factory.getPersonType("White", "Man", 67)));
        people.add(new Person(42, 10, factory.getPersonType("White", "Man", 73)));
        people.add(new Person(54, 50, factory.getPersonType("White", "Women", 31)));
        people.add(new Person(12, 27, factory.getPersonType("White", "Man", 34)));
        System.out.println(people);
    }
    public static void facadePatternTest(){
        System.out.println("=====================Facade pattern=====================");
        CarEngineFacade.startEngine();
        CarEngineFacade.stopEngine();
    }
}
