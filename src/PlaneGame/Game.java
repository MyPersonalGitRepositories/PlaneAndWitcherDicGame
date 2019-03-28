package PlaneGame;

import acm.program.GraphicsProgram;
import acm.graphics.GImage;
import acm.graphics.GLabel;

public class Game extends GraphicsProgram {

    public boolean live = true;
    public boolean right = true;
    public boolean attack = false;

    public int speed = 3;
    public int tA = -500;
    public int tY = 615;

    public GImage tank1 = new GImage("tank.png", tA, tY);

    public void init(){
        this.setSize(1300, 815);
        GImage background = new GImage("Background.png");
        background.setBounds(0,0,1300,770);
        add(background);
        add(Data.plane);

        addKeyListeners();
        addMouseListeners();
        add(tank1);
    }

    public void game(){
        while (live == true) {

            Data.all+=1;

            while (tA < 1000 && live == true) {
                tank1.setLocation(tA += speed, tY);

                if (Data.xPlane > 0 && Data.xPlane < 1050 && right == true) {
                    Data.plane.setLocation(Data.xPlane += 2, Data.yPlane);
                } else if (Data.xPlane > 0 && Data.xPlane < 1050) {
                    Data.plane.setLocation(Data.xPlane -= 2, Data.yPlane);
                } else {
                    end();
                }

                if (attack == true) {
                    Data.bomb.setLocation(Data.xBomb, Data.yBomb += 7);
                    while (Data.yBomb > 615 && Data.yBomb < 815) {
                        if (Data.xBomb > tA-20 && Data.xBomb < tA + 150) {
                            remove(Data.bomb);
                            tank1.setImage("bdsh.png");
                            tank1.setImage("bdsh.png");
                            tank1.setImage("bdsh.png");
                            tank1.setImage("bdsh.png");
                            tank1.setImage("bdsh.png");
                            tank1.setImage("bdsh.png");
                            tank1.setImage("bdsh.png");
                            tank1.setImage("bdsh.png");
                            tank1.setImage("bdsh.png");
                            tank1.setImage("bdsh.png");
                            tank1.setImage("bdsh.png");
                            tank1.setImage("bdsh.png");
                            tank1.setImage("bdsh.png");
                            tank1.setImage("nothing.png");
                            attack = false;
                            Data.frags++;
                            remove(Data.bomb);
                        }  break;
                    }
                    if (Data.yBomb == 600) {
                        attack = false;
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                }
            }
            if(live == true) {
                tA = -300;
                tY = 615;

                tank1.setImage("tank.png");
                if(speed<=5) {
                    speed++;
                }
            }
        }
    }
    public void end() {
        live = false;
        GLabel alert = new GLabel("Game Over, your score is: " + Data.frags + "/" + Data.all , (getWidth()/2)-110, getHeight()/2);
        alert.setFont("Arial-20");
        add(alert);
        Data.plane.setImage("vzryv.png");
        for(int i=1;i<6;i++){
            if(i==1){
                Data.plane.setImage("vzryv.png");
            } else if(i==2){
                Data.plane.setImage("vzryv.png");
            }else if(i==3){
                Data.plane.setImage("vzryv.png");
            }else if(i==4){
                Data.plane.setImage("vzryv.png");
            }
            try {
                Thread.sleep(40 );
            } catch (InterruptedException ex) {
            }
        }
//        remove(Data.plane);
    }
}