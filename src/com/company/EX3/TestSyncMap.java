package com.company.EX3;


public class TestSyncMap {
    public static void main(String[] args) {

        MyMap<Integer, Integer> syncMap = new MyMap<>();

        Thread th1 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                syncMap.put(i, i);
            }
        });

        Thread th2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                syncMap.remove(i);
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
    }
}
