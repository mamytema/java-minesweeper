package com.mamytema.commands;

import com.mamytema.*;

public class FlagCommand {
    public static void flag(int x, int y) {
        if (Global.flagsLeft == 0 ) {
            Render.renderDescriptionText("Out of flags.");
            return;
        }
        if (Global.map[x][y].isVisible()) {
            Render.renderDescriptionText("You can't flag a visible tile.");
            return;
        }
        Tile checkTile = Global.map[x][y];
        checkTile.flag();
        Global.flagsLeft--;
        Render.renderDescriptionText("You have " + Global.flagsLeft + " flags left to place.");
        Render.renderTile(x, y);
    }
    public static void unFlag(int x, int y) {
        Tile checkTile = Global.map[x][y];
        if (!checkTile.isFlagged()) {
            return;
        }
        checkTile.unFlag();
        Global.flagsLeft++;
        Render.renderTile(x, y);
    }
}
