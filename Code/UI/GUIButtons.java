package minesweeper.UI;

import minesweeper.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GUIButtons {
    public static void createButtonsGrid(JPanel gridPanel) {
        final JButton[][] buttons = new JButton[Global.sizeX][Global.sizeY];
        Global.jButtonMap = buttons;
        for (int X = 0; X < Global.sizeX; X++) {
            for (int Y = 0; Y < Global.sizeY; Y++) {

                ImageIcon tileIcon = Global.getImage("UndiscoveredTile.png");

                buttons[X][Y] = new JButton();
                buttons[X][Y].setIcon(tileIcon);
                buttons[X][Y].setSize(10, 10);

                Button button = new Button(X, Y);

                gridPanel.add(buttons[X][Y]);
                buttons[X][Y].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent arg0) {
                        if (arg0.getButton() == MouseEvent.BUTTON3) {
                            button.rightClick();
                        } else {
                            button.click();
                        }
                    }
                });

            }
        }
    }
}
