package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Card extends JButton {

    private String name;
    private Color c;
    private int id;
    private boolean isHidden;
    private int x;
    private int y;

    public Card(String name, Color c) {
        super();
        this.name = name;
        this.c = c;
        this.id = 1;
        isHidden = true;
    }

    public Card(String name, Color c, int id) {
        super();
        this.name = name;
        this.c = c;
        this.id = id;
        isHidden = true;
    }

    public JButton displayCard() {
        if (!isHidden) {
            this.setBackground(c);
            this.setBorderPainted(false);
            this.setOpaque(true);
        } else {
            this.setBorderPainted(true);
            this.setOpaque(false);
        }
        this.setBounds(x, y, 80, 100);
        return this;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return c;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void changeHidden() {
        isHidden = !isHidden;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", img='" + c + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return name.equals(card.name) && c.equals(card.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, c, id);
    }
}
