package WitcherDiceGame;
import acm.graphics.GCompound;
import acm.graphics.GOval;
import java.awt.Color;

class Dot extends GCompound {

    Dot(double r) {
        GOval circle = new GOval(2 * r, 2 * r);
        circle.setFilled(true);
        circle.setFillColor(Color.BLACK);
        add(circle, -r, -r);
        markAsComplete();
    }
}
