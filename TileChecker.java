package com.mamytema;

import java.util.ArrayList;

public class TileChecker {
    public static boolean checkTile(String[] arguments) {
        Tile checkTile = Global.map[Integer.parseInt(arguments[1])][Integer.parseInt(arguments[2])];
        String[] types = new String[] { "one", "two", "three", "four", "five", "six", "seven", "eight" };
        System.out.println(checkTile.getType());
        for (String type : types) {
            if ( type.equals(checkTile.getType())) {
                checkTile.makeVisible();
                return true;
            }
        }
        return false;
    }
}

