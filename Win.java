package com.mamytema;

public class Win {
    public static boolean check() {
        for (Tile mine : Global.mineMap) {
            if (!mine.isFlagged()) {
                return false;
            }
        }
        return true;
    }
}
