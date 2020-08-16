package com.mamytema.commands;

import com.mamytema.*;

public class FlagCommand {
    public static boolean flag(String[] arguments) {
        if (Global.flagsLeft == 0 ) {
            System.out.println("Out of flags.");
            return false;
        }
        Tile checkTile = Global.map[Integer.parseInt(arguments[1])][Integer.parseInt(arguments[2])];
        checkTile.flag();
        Global.flagsLeft--;
        Render.render();
        System.out.println("You have " + Global.flagsLeft + " flags left to place.");
        return false;
    }
    public static boolean unFlag(String[] arguments) {
        Tile checkTile = Global.map[Integer.parseInt(arguments[1])][Integer.parseInt(arguments[2])];
        if (checkTile.isFlagged()) {
            System.out.println("Already flagged tile.");
            return false;
        }
        checkTile.unFlag();
        Global.flagsLeft++;
        Render.render();
        return false;
    }
}
