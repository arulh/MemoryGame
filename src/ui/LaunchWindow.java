package ui;

import model.Card;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class LaunchWindow extends Window implements ActionListener {

    private Game game;
    private JButton button;

    private Map<JButton, Card> cards;
    private Collection<JButton> buttons;
//    private List<Card> cards;

    public LaunchWindow() {
        game = new Game();
        game.addCard(new Card("red", Color.RED));
        game.addCard(new Card("blue", Color.BLUE));
        game.addCard(new Card("yellow", Color.YELLOW));

        cards = new HashMap<>();
//        cards = new ArrayList<>();
        int n = 0;
        int m = 0;
        for (Card c : game) {
            cards.put(createCard(n*80, m*100+40, c), c);
            n++;
            if (n == 6) {
                m++;
                n = 0;
            }
        }

        reloadWindow();
    }

    private void reloadWindow() {
        frame = new JFrame();
        frame.setLayout(null);

//        buttons = cards.keySet();
//        for (JButton b : buttons) {
//            frame.add(b);
//        }
        int n = 0;
        int m = 0;
        for (Card c : cards) {
            createCard(n*80, m*100+40, c);
            n++;
            if (n == 6) {
                m++;
                n = 0;
            }
        }

        windowSettings("MAIN", Color.LIGHT_GRAY);
    }

    protected JButton createCard(int x, int y, Card c) {
        if (c.isHidden()) {
            button = new JButton();
        } else {
//            ImageIcon image = new ImageIcon(c.getImg());
//            Image i = image.getImage();
//            Image scaledImg = i.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
//            image = new ImageIcon(scaledImg);
//            button = new JButton(image);
            System.out.println("Card flipped");
            button = new JButton();
            button.setBackground(c.getColor());
//            button.setForeground(Color.BLUE);
            button.setBorderPainted(false);
            button.setOpaque(true);
            return button;
        }

        button.setBounds(x, y, 80, 100);
        button.addActionListener(this);
        frame.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = buttons.iterator().next();
        if (e.getSource() == b) {
            System.out.println("Button clicked");
            Card c = cards.get(b);

            JFrame temp = frame;
            cards.get(b).setHidden(!c.isHidden());
            reloadWindow();
            temp.dispose();
        }
    }
}
