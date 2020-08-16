package com.mamytema.commands;

import com.mamytema.*;

public class CheckCommand {
    public static final String SPACE = "space";
    public static final String MINE = "mine";

    public static boolean check(String[] arguments) {
        Tile checkTile = Global.map[Integer.parseInt(arguments[1])][Integer.parseInt(arguments[2])];

        if (checkTile.getType().equals(SPACE)) {
            SpaceChecker.checkTile(arguments);
            Render.render();
        } else if (checkTile.getType().equals(MINE)) {
            System.out.println("You loose!");
            Cheats.showAll();
            return true;
        } else {
            TileChecker.checkTile(arguments);
            Render.render();
        }

        return false;
    }
}
