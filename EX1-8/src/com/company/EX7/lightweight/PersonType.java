package com.company.EX7.lightweight;

import java.util.Objects;

/**
 * todo Document type PersonType
 */
public class PersonType {
    private String skinColour;
    private String gender;
    private int age;

    public PersonType(String skinColour, String gender, int age) {
        this.skinColour = skinColour;
        this.gender = gender;
        this.age = age;
    }

    public String getSkinColour() {
        return skinColour;
    }

    public void setSkinColour(String skinColour) {
        this.skinColour = skinColour;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonType that = (PersonType) o;
        return age == that.age && Objects.equals(skinColour, that.skinColour) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skinColour, gender, age);
    }


    @Override
    public String toString() {
        return "PersonType{" +
            "skinColour='" + skinColour + '\'' +
            ", gender='" + gender + '\'' +
            ", age=" + age +
            '}';
    }
}
