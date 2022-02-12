package com.company.EX6.abstract_factory;

/**
 * todo Document type CivilCarFactroy
 */
public class CivilCarFactory implements CarFactory{
    @Override
    public Car sedan() {
        return new Sedan();
    }

    @Override
    public Car suv() {
        return new SUV();
    }
}
