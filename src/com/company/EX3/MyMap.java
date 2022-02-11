package com.company.EX3;

import java.security.Key;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class MyMap<T, K> implements Map<T, K> {

    Map<T, K> map;

    Semaphore semaphore = new Semaphore(1);

    public MyMap(){
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public K get(Object key) {
        return null;
    }

    @Override
    public K put(T key, K value) {
        try {
            semaphore.acquire();
            return map.put(key, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public K remove(Object key) {
        try {
            semaphore.acquire();
            return map.remove(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void putAll(Map<? extends T, ? extends K> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<T> keySet() {
        return null;
    }

    @Override
    public Collection<K> values() {
        return null;
    }

    @Override
    public Set<Entry<T, K>> entrySet() {
        return null;
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
