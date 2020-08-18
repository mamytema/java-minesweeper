package minesweeper.UI.startScreen;

import minesweeper.Generator;
import minesweeper.UI.mainScreen.GUI;

public class Difficulties {


    public static void veryEasyEvent() {
        Generator.generateGame(9, 9, 10, 3);
        Generator.generateGrid();
        StartScreen.close();
        new GUI();
    }

    public static void easyEvent() {
        Generator.generateGame(10, 10, 15, 3);
        Generator.generateGrid();
        StartScreen.close();
        new GUI();
    }

    public static void mediumEvent() {
        Generator.generateGame(15, 15, 75, 4);
        Generator.generateGrid();
        StartScreen.close();
        new GUI();
    }

    public static void hardEvent() {
        Generator.generateGame(20, 20, 130, 6);
        Generator.generateGrid();
        StartScreen.close();
        new GUI();
    }

    public static void veryHardEvent() {
        Generator.generateGame(25, 25, 180, 6);
        Generator.generateGrid();
        StartScreen.close();
        new GUI();
    }

    public static void extremeEvent() {
        Generator.generateGame(27, 27, 350, 8);
        Generator.generateGrid();
        StartScreen.close();
        new GUI();
    }

}
