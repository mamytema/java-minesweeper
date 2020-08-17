package minesweeper;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Global {

    public static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static int sizeX = 10;
    public static int sizeY = 10;
    public static int mineAmount = 15;
    public static int flagsLeft = 15;

    public static boolean gameEnded = false;
    public static boolean gameStarted = false;

    public static Tile[] mineMap;
    public static Tile[][] map;

    public static JLabel description;
    public static JButton[][] jButtonMap;

    public static String assetsPath = "./assets/";

    public static ImageIcon getImage(String file) {
        return new ImageIcon(assetsPath + file);
    }

}
