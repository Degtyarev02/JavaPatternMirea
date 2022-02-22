package com.company;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private static final int SIZE = 50_000_000;
    private static final int HALF = SIZE / 2;

    public static void withoutConc() {
        long before = System.currentTimeMillis();
        float[] list = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            list[i] = (float) i;
        }
        for (int i = 0; i < SIZE; i++) {
            float f = list[i];
            list[i] = (float) (list[i] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
        }
        long after = System.currentTimeMillis();
        System.out.println("withoutConcurrency: " + ((float)(after - before)/1000) + " sec.");
    }

    public static void withConc(){

        long before = System.currentTimeMillis();
        float[] list1 = new float[HALF];
        float[] list2 = new float[HALF];

        Thread th1 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                list1[i] = (float) i;
            }
            for (int i = 0; i < HALF; i++) {
                float f = list1[i];
                list1[i] = (float) (list1[i] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
            }
        });

        Thread th2 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                list2[i] = (float) i;
            }
            for (int i = 0; i < HALF; i++) {
                float f = list2[i];
                list2[i] = (float) (list2[i] * Math.sin(0.2f + f / 5) * Math.cos(0.2f + f / 5) * Math.cos(0.4f + f / 2));
            }
        });

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float[] list = new float[SIZE];
        System.arraycopy(list1, 0, list, 0, HALF );
        System.arraycopy(list2, 0, list, HALF, HALF );

        long after = System.currentTimeMillis();
        System.out.println("withConcurrency: " + ((float)(after - before)/1000) + " sec.");
    }

    public static void main(String[] args) {
        withConc();
    }
}
