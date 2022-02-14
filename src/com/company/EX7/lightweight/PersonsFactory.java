package com.company.EX7.lightweight;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * todo Document type PersonsFactory
 */
public class PersonsFactory {
    static private Set<PersonType> typeList = new HashSet<>();

    public PersonsFactory() {
        typeList.addAll(Arrays.asList(
            new PersonType("White", "Man", 34),
            new PersonType("White", "Women", 21),
            new PersonType("Black", "Man", 45),
            new PersonType("White", "Man", 64),
            new PersonType("White", "Women", 31),
            new PersonType("White", "Man", 78)));
    }

    public PersonType getPersonType(String skinColour, String gender, int age) {
        PersonType tmpType = new PersonType(skinColour, gender, age);
        if (typeList.contains(tmpType)) {
            for (PersonType type : typeList) {
                if (type.equals(tmpType)) {
                    System.out.println("Такой тип есть, возвращаю существуюший");
                    return type;
                }
            }
        }

        System.out.println("Такого типа нет, создаю новый");
        typeList.add(tmpType);
        return tmpType;
    }
}
