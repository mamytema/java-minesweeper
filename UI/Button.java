package com.mamytema.UI;

import com.mamytema.Generator;
import com.mamytema.Global;
import com.mamytema.Render;
import com.mamytema.Win;
import com.mamytema.commands.*;

public class Button {

    private final int x;
    private final int y;

    public Button(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private void startGame() {
        Generator.generateMinesAndIgnore(x, y);
        Generator.generateNumberGrid();
        Render.renderDescriptionText("Right click to flag mines.");
    }

    public void click() {
        if (Global.gameEnded) {
            return;
        }

        if (!Global.gameStarted) {
            startGame();
            Global.gameStarted = true;
        }

        CheckCommand.check(x, y);
    }

    public void rightClick() {
        if (Global.gameEnded || !Global.gameStarted) {
            return;
        }

        if (Global.map[x][y].isFlagged()) {
            FlagCommand.unFlag(x, y);
        } else {
            FlagCommand.flag(x, y);
        }
        Win.check();
    }
}
