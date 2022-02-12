package com.company.EX5;

/**
 * todo Document type Test
 */
public class Test {

    //Check hash codes

    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton1Another = Singleton1.getInstance();

        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton2 singleton2Another = Singleton2.getInstance();

        Singleton3 singleton3 = Singleton3.INSTANCE;
        Singleton3 singleton3Another = Singleton3.INSTANCE;

        System.out.println("Singleton 1 hashes");
        System.out.println(singleton1.hashCode() + " " + singleton1Another.hashCode() + " " + singleton1.equals(singleton1Another) + "\n");

        System.out.println("Singleton 2 hashes");
        System.out.println(singleton2.hashCode() + " " + singleton2Another.hashCode() + " " + singleton2.equals(singleton2Another) + "\n");

        System.out.println("Singleton 3 hashes");
        System.out.println(singleton3.hashCode() + " " + singleton3Another.hashCode() + " " + singleton3.equals(singleton3Another) + "\n");
    }
}
