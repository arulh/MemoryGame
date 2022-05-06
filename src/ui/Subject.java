package ui;

import model.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    public void notifyObservers(Card selectedCard) {
        for (Observer o : observers) {
            o.update(selectedCard);
        }
    }
}
