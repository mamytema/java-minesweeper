package com.mamytema.commands;

import com.mamytema.*;
import com.mamytema.UI.GUI;

import java.util.concurrent.TimeUnit;

public class CheckCommand {
    public static final String SPACE = "space";
    public static final String MINE = "mine";

    public static boolean check(int x, int y) {
        Tile checkTile = Global.map[x][y];

        if (checkTile.getType().equals(SPACE)) {
            SpaceChecker.checkTile(x, y);
        } else if (checkTile.getType().equals(MINE)) {
            Render.renderDescriptionText("You loose!");
            Cheats.showAll();
            Render.renderAllGUI();
            return true;
        } else {
            TileChecker.checkTile(x, y);
        }

        return false;
    }
}
