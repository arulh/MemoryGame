package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Game implements Iterable<Card> {

    private List<Card> cards;

    public Game() {
        cards = new ArrayList<>();
    }

    public void addCard(Card c) {
        if (!cards.contains(c)) {
            cards.add(c);
            cards.add(new Card(c.getName(), c.getColor(), 2));
        }
    }

    public int getSize() {
        return cards.size();
    }

    @Override
    public Iterator<Card> iterator() {
        return new CardIterator();
    }

    private class CardIterator implements Iterator<Card> {

        private Iterator<Card> index = cards.iterator();
        private int n = 0;

        @Override
        public boolean hasNext() {
            return n < cards.size();
        }

        @Override
        public Card next() {
            Random rand = new Random();
            Card temp = cards.get(rand.nextInt(cards.size()));
            cards.remove(temp);
            return temp;
        }
    }
}
