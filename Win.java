package com.mamytema;

import com.mamytema.UI.GUI;
import com.mamytema.commands.Cheats;

import java.beans.IntrospectionException;
import java.util.concurrent.TimeUnit;

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
