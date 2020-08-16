package com.mamytema;

public class Global {

    public static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static int sizeX = 15;
    public static int sizeY = 15;
    public static int mineAmount = 2;
    public static int flagsLeft = 2;
    public static boolean gameEnded = false;
    public static Tile[] mineMap = new Tile[mineAmount];
    public static Tile[][] map = new Tile[sizeX][sizeY];

}
