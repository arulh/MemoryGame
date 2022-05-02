package ui;

import model.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class Window extends JFrame {

    public static final int HEIGHT = 370;
    public static final int WIDTH = 480;

    protected JFrame frame;
    private JButton button;

    protected JButton createCard(int x, int y, Card c, ActionListener a) {
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
        }

        button.setBounds(x, y, 80, 100);
        button.addActionListener(a);
//        frame.add(button);
        return button;
    }

    protected void windowSettings(String text, Color c) {
        frame.setTitle(text);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.getContentPane().setBackground(c);
    }
}
