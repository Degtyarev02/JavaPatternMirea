package com.company.EX6.abstract_factory;

/**
 * todo Document type Client
 */
public class Client {
    private final Car sedan;
    private final Car suv;

    public Client(CarFactory factory) {
        sedan = factory.sedan();
        suv = factory.suv();
    }

    public void print() {
        sedan.printType();
        suv.printType();
    }
}
