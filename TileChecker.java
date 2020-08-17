package com.mamytema;

public class TileChecker {
    public static void checkTile(int x, int y) {
        Tile checkTile = Global.map[x][y];
        String[] types = new String[] { "one", "two", "three", "four", "five", "six", "seven", "eight" };
        System.out.println(checkTile.getType());
        for (String type : types) {
            if ( type.equals(checkTile.getType())) {
                checkTile.makeVisible();
                Render.renderTile(x, y);
                return;
            }
        }
    }
}

