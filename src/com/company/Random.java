package com.company;

public class Random {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            System.out.println((int) (Math.random() * 10000));
        }
    }
}
