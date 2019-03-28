package WitcherDiceGame;

import acm.graphics.GCompound;
import acm.graphics.GRect;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Dice extends GCompound implements MouseListener {

    boolean used = false;
    private GRect dice;
    int value;
    boolean marked = false;

    Dice(int size, int v) {

        value = v;
        double quater = size / 4.0;

        dice = new GRect(size, size);
        dice.setFilled(true);
        dice.setFillColor(Color.WHITE);
        add(dice);

        Dot dot = new Dot(size / 16.0);

        switch (value) {

            case 1: {
                add(dot, quater * 2, quater * 2);
                break;
            }

            case 2: {
                add(dot, quater * 3, quater);
                dot = new Dot(size / 16.0);
                add(dot, quater, quater * 3);
                break;
            }

            case 3: {
                add(dot, quater * 3, quater);
                dot = new Dot(size / 16.0);
                add(dot, quater, quater * 3);
                dot = new Dot(size / 16.0);
                add(dot, quater * 2, quater * 2);
                break;
            }

            case 4: {
                add(dot, quater * 3, quater);
                dot = new Dot(size / 16.0);
                add(dot, quater, quater * 3);
                dot = new Dot(size / 16.0);
                add(dot, quater, quater);
                dot = new Dot(size / 16.0);
                add(dot, quater * 3, quater * 3);
                break;
            }

            case 5: {
                add(dot, quater * 3, quater);
                dot = new Dot(size / 16.0);
                add(dot, quater, quater * 3);
                dot = new Dot(size / 16.0);
                add(dot, quater, quater);
                dot = new Dot(size / 16.0);
                add(dot, quater * 3, quater * 3);
                dot = new Dot(size / 16.0);
                add(dot, quater * 2, quater * 2);
                break;
            }

            case 6: {
                add(dot, quater * 3, quater);
                dot = new Dot(size / 16.0);
                add(dot, quater, quater * 3);
                dot = new Dot(size / 16.0);
                add(dot, quater, quater);
                dot = new Dot(size / 16.0);
                add(dot, quater * 3, quater * 3);
                dot = new Dot(size / 16.0);
                add(dot, quater, quater * 2);
                dot = new Dot(size / 16.0);
                add(dot, quater * 3, quater * 2);
                break;
            }
        }
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!used) {
            dice.setFillColor(dice.getFillColor() == Color.WHITE ? Color.green : Color.white);
            marked = !marked;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
