package com.company.EX3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MySet<T> implements Set<T> {

    Set<T> set;

    public MySet() {
        set = new HashSet<>();
    }


    public final Lock lock = new ReentrantLock();/*
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
*/
    @Override
    public int size() {
        try{
            lock.lock();
            return set.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        try{
            lock.lock();
            return set.isEmpty();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean contains(Object o) {
        try{
            lock.lock();
            return set.contains(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Iterator<T> iterator() {
        try{
            lock.lock();
            return set.iterator();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Object[] toArray() {
        try{
            lock.lock();
            return set.toArray();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        try{
            lock.lock();
            return set.toArray(a);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean add(T t) {
        try{
            lock.lock();
            return set.add(t);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        try{
            lock.lock();
            return set.remove(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try{
            lock.lock();
            return set.containsAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        try{
            lock.lock();
            return set.addAll(c);
        } finally {
            lock.unlock();
        }    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try{
            lock.lock();
            return set.retainAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try{
            lock.lock();
            return set.removeAll(c);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void clear() {
        try{
            lock.lock();
            set.clear();
        } finally {
            lock.unlock();
        }

    }

    @Override
    public String toString() {
        try{
            lock.lock();
            return set.toString();
        } finally {
            lock.unlock();
        }
    }
}
