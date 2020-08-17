package com.mamytema;

import com.mamytema.commands.Cheats;

public class Win {
    public static void check() {
        for (Tile mine : Global.mineMap) {
            if (mine != null && !mine.isFlagged()) {
                return;
            }
        }
        Render.renderDescriptionText("You won!");
        Global.gameEnded = true;
        Cheats.showAll();

    }
}
