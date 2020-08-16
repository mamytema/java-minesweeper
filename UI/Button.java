package com.mamytema.UI;

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

    public void click() {

        CheckCommand.check(x, y);
    }

    public void rightClick() {

        if (Global.map[x][y].isFlagged()) {
            FlagCommand.unFlag(x, y);
        } else {
            FlagCommand.flag(x, y);
        }
        Win.check();
    }
}
