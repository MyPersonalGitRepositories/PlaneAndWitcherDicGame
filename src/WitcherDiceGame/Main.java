package WitcherDiceGame;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Main extends GraphicsProgram {


    private Dice[] player2 = null;
    private Dice[] player1 = null;
    private Random random;
    private int size;
    private boolean pause1 = false;
    private boolean pause2 = false;
    private Game.Comb res1;
    private Game.Comb res2;

    public void init() {
        setSize(1500, 1000);
    }

    public void run() {

        GImage background = new GImage("background.jpg");
        add(background);

        final Game game = new Game();
        random = new Random();
        size = (getWidth()) / 5;
        size -= 10;

        GLine half = new GLine(0, getHeight() / 2.0, getWidth(), getHeight() / 2.0);
        add(half);

        GLabel p = new GLabel("Player 1");
        p.setColor(Color.WHITE);
        p.setFont("Algerian-25");
        add(p, getWidth() / 2.0 - p.getWidth() / 2.0, p.getAscent() + 10);

        p = new GLabel("Player 2");
        p.setColor(Color.WHITE);
        p.setFont("Algerian-25");
        add(p, getWidth() / 2.0 - p.getWidth() / 2.0, p.getAscent() + getHeight() / 2.0 + 10);

        final Dice[] player1 = new Dice[5];
        final Dice[] player2 = new Dice[5];

        for (int i = 0, space = 0; i < 5; i++, space += 6) {
            player1[i] = new Dice(size, random.nextInt(6) + 1);
            add(player1[i], i * size + 10 + space, half.getStartPoint().getY() / 2 - size / 2.0);
        }
        for (int i = 0, space = 0; i < 5; i++, space += 6) {
            player2[i] = new Dice(size, random.nextInt(6) + 1);
            add(player2[i], i * size + 10 + space, half.getStartPoint().getY() + half.getStartPoint().getY() / 2 - size / 2.0);
        }

        game.reroll();

        GRect ready1 = new GRect(100, 40);
        ready1.setFilled(true);
        ready1.setFillColor(Color.WHITE);
        add(ready1, getWidth() / 2.0 - ready1.getWidth() / 2.0, getHeight() / 2.0 - ready1.getHeight() - 5);
        GLabel ok1 = new GLabel("Ready!");
        ok1.setFont("Monospaced-bold-22");
        add(ok1, getWidth() / 2.0 - ok1.getWidth() / 2.0, ready1.getY() + ok1.getAscent() + 5);

        MouseListener r1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!pause1) {
                    for (int i = 0; i < 5; i++) {
                        if (player1[i].marked) {
                            double x = player1[i].getX();
                            double y = player1[i].getY();
                            remove(player1[i]);
                            player1[i] = new Dice(size, random.nextInt(6) + 1);
                            add(player1[i], x, y);
                        }
                        player1[i].used = true;
                    }
                    res1 = game.checkCombination(player1);
                    pause1 = true;
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
        };
        ready1.addMouseListener(r1);

        GRect ready2 = new GRect(100, 40);
        ready2.setFilled(true);
        ready2.setFillColor(Color.WHITE);
        add(ready2, getWidth() / 2.0 - ready2.getWidth() / 2.0, getHeight() - ready2.getHeight() - 5);
        ok1 = new GLabel("Ready!");
        ok1.setFont("Monospaced-bold-22");
        add(ok1, getWidth() / 2.0 - ok1.getWidth() / 2.0, ready2.getY() + ok1.getAscent() + 5);

        MouseListener r2 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!pause2) {
                    for (int i = 0; i < 5; i++) {
                        if (player2[i].marked) {
                            double y = player2[i].getY();
                            double x = player2[i].getX();
                            remove(player2[i]);
                            player2[i] = new Dice(size, random.nextInt(6) + 1);
                            add(player2[i], x, y);
                        }
                        player2[i].used = true;
                    }
                    res2 = game.checkCombination(player2);
                    pause2 = true;
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
        };
        ready2.addMouseListener(r2);

        while (true) {

            while (!pause1 || !pause2) {
                pause(0.01);
            }

            if (game.winner(res1, res2)) {
                exit();
                break;
            }

            pause1 = false;
            pause2 = false;
        }
    }
}
