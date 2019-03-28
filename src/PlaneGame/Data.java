package PlaneGame;

import acm.graphics.GImage;

public class Data {

    public static int xPlane = 40;
    public static int yPlane = 40;

    public static GImage plane = new GImage("Plane.png", Data.xPlane, Data.yPlane);

    public static int xBomb = Data.xPlane;
    public static int yBomb = Data.yPlane+30;

    public static GImage bomb = new GImage("bomb.png", xBomb, yBomb);

    public static int frags = 0;
    public static int all = 0;
}
