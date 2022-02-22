package com.company.EX3;

import java.util.HashMap;
import java.util.Map;

public class TestSyncMap {
    public static void main(String[] args) {

        MyMap<Integer, Integer> syncMap = new MyMap<>();
        /*Map<Integer, Integer> syncMap = new HashMap<>();*/

        Thread th1 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                syncMap.put(i, i);
            }
        });

        Thread th2 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                syncMap.put(i, i);
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

        System.out.println(syncMap);
        System.out.println(syncMap.size());
    }
}
