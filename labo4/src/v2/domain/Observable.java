package v2.domain;

import v2.domain.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(BankEvent event) {
        observers.forEach(o -> o.update(event));
    }
}
