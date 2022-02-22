package com.company.EX6.abstract_factory;

/**
 * todo Document type SportCarFactory
 */
public class SportCarFactory implements CarFactory {
    @Override
    public Car sedan() {
        return new SportSedan();
    }

    @Override
    public Car suv() {
        return new SportSUV();
    }
}
