package minesweeper.UI.startScreen;

import minesweeper.Global;

import javax.swing.*;
import java.awt.*;

public class Button {

    public static final Color DARK_GREEN = new Color(0, 153, 0);

    private final JButton button;
    private static int idCount = 0;
    private final int id;

    public Button(String text, Font buttonFont, Color color) {
        button = new JButton();
        button.setText(text);
        button.setFont(buttonFont);
        button.setForeground(color);
        id = idCount;
        idCount++;
    }

    public int getId() {
        return id;
    }

    public JButton getButton() {
        return button;
    }

    public void setPicture(String file) {
        button.setIcon(Global.getImage(file));
    }

}
