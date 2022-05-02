package model;

import java.awt.*;
import java.util.Objects;

public class Card {

    private String name;
    private Color c;
    private int id;
    private boolean isHidden;

    public Card(String name, Color c) {
        this.name = name;
        this.c = c;
        this.id = 1;
        isHidden = true;
    }

    public Card(String name, Color c, int id) {
        this(name, c);
        this.id = id;
        isHidden = true;
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

    public void setHidden(boolean b) {
        isHidden = b;
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
        return id == card.id && name.equals(card.name) && c.equals(card.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, c, id);
    }
}
