package model;

import java.util.*;

public class Game implements Iterable<Card> {

    private List<Card> cards;
    private boolean isShuffled = false;

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
        private int m = 0;

        public CardIterator() {
            if (!isShuffled) {
                Collections.shuffle(cards);
                isShuffled = true;
            }
        }

        @Override
        public boolean hasNext() {
            return index.hasNext();
        }

        @Override
        public Card next() {
            Card current = index.next();
            current.setX(n*80);
            current.setY(m*100+40);
            n++;
            if (n == 6) {
                m++;
                n = 0;
            }
            return current;
        }
    }
}
