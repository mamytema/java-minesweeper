package com.mamytema.UI;

import com.mamytema.Global;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame {

    private static final int screenWidth = Global.sizeY * 35;
    private static final int screenHeight = Global.sizeX * 35;
    private static JFrame mainFrame;

    public static void close() {
        mainFrame.setVisible(false);
        mainFrame.dispose();
    }

    public GUI() throws IOException {

        mainFrame = new JFrame("Minesweeper");

        GridLayout grid = new GridLayout(Global.sizeX, Global.sizeY);

        JPanel gridPanel = new JPanel();
        gridPanel.setSize(screenWidth, screenHeight);
        gridPanel.setLayout(grid);
        mainFrame.getContentPane().add(gridPanel);


        mainFrame.setSize(screenWidth + 20 , screenHeight + 70);
        mainFrame.setLocation(300,200);

        mainFrame.setIconImage(Global.getImage("appImage.png").getImage());

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JButton[][] buttons = new JButton[Global.sizeX][Global.sizeY];

        JLabel description = new JLabel("Click any tile to start.");
        description.setSize(screenWidth, 10);

        Font f = new Font("serif", Font.PLAIN, 25);

        description.setFont(f);

        mainFrame.getContentPane().add(description);
        description.setVerticalAlignment(JLabel.BOTTOM);

        Global.description = description;


        for (int X = 0; X < Global.sizeX; X++) {
            for (int Y = 0; Y < Global.sizeY; Y++) {

                File file = new File("").getCanonicalFile();

                ImageIcon tileIcon = new ImageIcon("C:\\Users\\Dominykas\\" +
                        "IdeaProjects\\Epic gamer\\" +
                        "src\\com\\mamytema\\assets\\UndiscoveredTile.png");

                buttons[X][Y] = new JButton();

                buttons[X][Y].setIcon(tileIcon);

                buttons[X][Y].setSize(10, 10);

                Button button = new Button(X, Y);

                gridPanel.add(buttons[X][Y]);
                buttons[X][Y].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent arg0) {
                        if (arg0.getButton() == MouseEvent.BUTTON3){
                            button.rightClick();
                        } else {
                            button.click();
                        }
                    }
                });
            }
        }

        Global.jButtonMap = buttons;

        mainFrame.setVisible(true);
    }
}
