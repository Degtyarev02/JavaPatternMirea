package com.company.EX3;

import java.util.HashSet;
import java.util.Set;

public class TestSyncSet {

    public static void main(String[] args) {

        MySet<Integer> syncSet = new MySet<>();

        Thread th1 = new Thread(() -> {
           for(int i = 0; i < 1000; i++) {
               syncSet.add(i);
           }
        });

        Thread th2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                syncSet.remove(i);
            }
        });

        th1.start();
        th2.start();

        try{
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(syncSet);
    }
}
