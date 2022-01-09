package model;

import controller.Observer;

import java.util.ArrayList;

public class Observable {
    private final ArrayList<Observer> observers;

    public Observable() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(CipherEvent event) {
        observers.forEach(o -> o.update(event));
    }
}
