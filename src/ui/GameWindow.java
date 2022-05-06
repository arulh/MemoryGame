package ui;

import model.Card;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends Window implements ActionListener {

    private Game game;

    public GameWindow() {
        game = new Game();

        game.addCard(new Card("red", Color.RED));
        game.addCard(new Card("blue", Color.BLUE));
        game.addCard(new Card("yellow", Color.YELLOW));

        game.addCard(new Card("orange", Color.ORANGE));
        game.addCard(new Card("green", Color.GREEN));
        game.addCard(new Card("black", Color.BLACK));

        game.addCard(new Card("pink", Color.PINK));
        game.addCard(new Card("magenta", Color.MAGENTA));
        game.addCard(new Card("cyan", Color.CYAN));

//        frame = new JFrame();
        frame.setLayout(null);
        for (Card c : game) {
            c.addActionListener(this);
            frame.add(c.displayCard());
        }
        formatWindow("MAIN", Color.lightGray);
    }

    private void formatWindow(String text, Color c) {
        frame.setTitle(text);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.getContentPane().setBackground(c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Card c : game) {
            if (e.getSource() == c) {
                game.update(c);
//                c.changeHidden();
                viewCards();
                return;
            }
        }
    }

    private void viewCards() {
        for (Card c : game) {
            frame.add(c.displayCard());
        }
    }
}
