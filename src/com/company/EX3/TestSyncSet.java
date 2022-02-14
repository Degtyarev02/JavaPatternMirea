package com.company.EX3;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public class TestSyncSet {

    public static void main(String[] args) {

        MySet<Integer> syncSet = new MySet<>();
        /*Set<Integer> syncSet = new HashSet<>();*/

        Thread th1 = new Thread(() -> {
           for(int i = 0; i < 10; i++) {
               syncSet.add(i);
           }
        });



        Thread th2 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                syncSet.add(i);
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
        System.out.println(syncSet.size());
    }
}
