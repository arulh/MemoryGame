package model;

import ui.Observer;
import ui.Window;

import java.util.*;

public class Game extends Window implements Iterable<Card> {

    private List<Card> cards;
    private boolean isShuffled = false;
    private int guess = 0;

    private Card prevGuess;
    private Card currentGuess;

    public Game() {
        cards = new ArrayList<>();
    }

    public void addCard(Card c) {
        if (!cards.contains(c)) {
            cards.add(c);
            cards.add(new Card(c.getName(), c.getColor(), 2));
        }
    }

    public boolean gameOver() {
        for (Card c : this) {
            if (c.isHidden()) {
                return false;
            }
        }
        return true;
    }

    public void update(Card selectedCard) {
//        int guess = 0;
        if (guess == 2) {
            if (prevGuess.equals(currentGuess)) {
                // guess correct
                System.out.println("Correct");
            } else {
                prevGuess.changeHidden();
                currentGuess.changeHidden();
            }
            prevGuess = null;
            currentGuess = null;
            guess = 0;
            return;
        }
        if (prevGuess == null) {
            prevGuess = selectedCard;
            prevGuess.changeHidden();
//            frame.add(prevGuess.displayCard());
            guess++;
        } else {
            currentGuess = selectedCard;
            currentGuess.changeHidden();
//            frame.add(currentGuess.displayCard());
//            try {
//                Thread.sleep(150);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            guess++;
        }
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
