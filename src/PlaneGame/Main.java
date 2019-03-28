package PlaneGame;
import java.awt.event.KeyEvent;

public class Main extends Game {
    public void run(){
        init();
        game();
    }
    public void keyPressed(KeyEvent event) {
        if (live == true) {
            if (event.getKeyCode() == 39) {
                Data.plane.setImage("Plane.png");
                if (Data.xPlane > 0 && Data.xPlane < 1050 ) {
                    Data.plane.setLocation(Data.xPlane += 10, Data.yPlane);
                }else {
                    end();
                }
                right = true;
            }

            if (event.getKeyCode() == 37) {
                Data.plane.setImage("Plane1.png");
                if (Data.xPlane > 0 && Data.xPlane < 1050) {
                    Data.plane.setLocation(Data.xPlane -= 10, Data.yPlane);
                }else {
                    end();
                }
            }

            if (event.getKeyCode() == 38) {
                if (Data.yPlane > 0 && Data.yPlane < 700) {
                    Data.plane.setLocation(Data.xPlane, Data.yPlane -= 3);
                } else {
                    end();
                }
            }

            if (event.getKeyCode() == 40) {
                if (Data.yPlane > 0 && Data.yPlane < 340) {
                    Data.plane.setLocation(Data.xPlane, Data.yPlane += 3);
                } else {
                    end();
                }
            }

            if (event.getKeyCode() == 32) {
                attack = true;
                Data.xBomb = Data.xPlane;
                Data.yBomb = Data.yPlane+50;
                Data.bomb.setImage("bomb.png");
                add(Data.bomb);
            }
        }
    }
}
