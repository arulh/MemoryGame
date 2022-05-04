package ui;

import model.Card;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class LaunchWindow implements ActionListener {

    public static final int HEIGHT = 370;
    public static final int WIDTH = 480;

    private Game game;
    private JFrame frame;

    public LaunchWindow() {
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

        frame = new JFrame();
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
                c.changeHidden();
                frame.add(c.displayCard());
                return;
            }
        }
    }
}
