package com.mamytema;

public class Main {

    public static void main(String[] args) {

        Generator.generateGrid();
        Generator.generateMines();
        Generator.generateNumberGrid();

        Game.show();
        Game.mainLoop();

    }

}
