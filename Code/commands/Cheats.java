package minesweeper.commands;

import minesweeper.*;

public class Cheats {
    public static void showAll() {
        for (int X = 0; X < Global.map.length; X++) {
            for (int Y = 0; Y < Global.map[X].length; Y++) {
                Global.map[X][Y].makeVisible();
            }
        }
        Global.gameEnded = true;
        Render.renderAllGUI();
    }
}
