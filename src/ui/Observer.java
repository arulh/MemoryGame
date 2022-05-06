package ui;

import model.Card;

public interface Observer {
    public void update(Card selectedCard);
}
