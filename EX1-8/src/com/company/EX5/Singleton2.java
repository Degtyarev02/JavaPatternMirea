package com.company.EX5;

/**
 * todo Document type Singleton2
 */
public class Singleton2 {
    private static final Singleton2 INSTANCE = new Singleton2();

    private Singleton2() {}

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
