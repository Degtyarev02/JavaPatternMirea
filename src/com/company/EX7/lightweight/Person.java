package com.company.EX7.lightweight;

/**
 * todo Document type Person
 */
public class Person {
    private int x;
    private int y;
    private PersonType personType;

    public Person(int x, int y, PersonType personType) {
        this.x = x;
        this.y = y;
        this.personType = personType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    @Override
    public String toString() {
        return "Person{" +
            "x=" + x +
            ", y=" + y +
            ", personType=" + personType +
            '}';
    }
}
