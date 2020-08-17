package com.mamytema.commands;

import com.mamytema.*;

public class CheckCommand {
    public static final String SPACE = "space";
    public static final String MINE = "mine";

    public static void check(int x, int y) {
        Tile checkTile = Global.map[x][y];

        if (checkTile.getType().equals(SPACE)) {
            SpaceChecker.checkTile(x, y);
        } else if (checkTile.getType().equals(MINE)) {
            Render.renderDescriptionText("You loose!");
            Cheats.showAll();
            Render.renderAllGUI();
        } else {
            TileChecker.checkTile(x, y);
        }

    }
}
