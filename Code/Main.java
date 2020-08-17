package minesweeper;

import minesweeper.UI.GUI;
import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static final String CUSTOMIZE = "cus";

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Enter to quick start or cus to customize");
//        String command = sc.nextLine();
//
//        if (command.equals(CUSTOMIZE)) {
//            System.out.print("Size X: ");
//            Global.sizeX = sc.nextInt();
//            System.out.print("Size Y: ");
//            Global.sizeY = sc.nextInt();
//            System.out.print("Mines amount: ");
//            Global.mineAmount = sc.nextInt();
//            System.out.print("Flag amount (must be atleast amount to mines to be playable): ");
//            Global.flagsLeft = sc.nextInt();
//        }
//        System.out.println("Starting GUI, a window should pop up.");

        Global.map = new Tile[Global.sizeX][Global.sizeY];
        Global.mineMap = new Tile[Global.mineAmount];
        Global.jButtonMap = new JButton[Global.sizeX][Global.sizeY];

        Generator.generateGrid();

        new GUI();


    }

}
