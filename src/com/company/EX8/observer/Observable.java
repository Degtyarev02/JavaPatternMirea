package com.company.EX8.observer;

/**
 * todo Document type Observable
 */
public interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
