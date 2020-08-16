package com.mamytema;

import com.mamytema.UI.GUI;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.print("start-start or cus-customize");
        String command = sc.nextLine();
        switch(command) {
            case "cus":
                System.out.print("Size X: ");
                Global.sizeX = sc.nextInt();
                System.out.print("Size Y: ");
                Global.sizeY = sc.nextInt();
                System.out.print("Mines amount: ");
                Global.mineAmount = sc.nextInt();
                System.out.print("Flag amount (must be atleast amount to mines to be playable): ");
                Global.flagsLeft = sc.nextInt();
                break;
        }
        System.out.println("Starting GUI, a window should pop up.");

        Global.map = new Tile[Global.sizeX][Global.sizeY];
        Global.mineMap = new Tile[Global.mineAmount];
        Global.jButtonMap = new JButton[Global.sizeX][Global.sizeY];

        Generator.generateGrid();
        Generator.generateMines();
        Generator.generateNumberGrid();

        GUI gui = new GUI();


    }

}
