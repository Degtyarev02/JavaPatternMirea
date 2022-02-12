package com.company.EX6.builder;

/**
 * todo Document type Director
 */
public class Director {
    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void constructSportCar() {
        builder.setEngine("V8 Bi-Turbo");
        builder.setName("Ferrari");
    }

    public void constructSuv() {
        builder.setEngine("V6 Turbo");
        builder.setName("Toyota");
    }
}
