package minesweeper.UI.mainScreen;

import minesweeper.*;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private static final int screenWidth = Global.sizeY * 35;
    private static final int screenHeight = Global.sizeX * 35;
    private static JFrame mainFrame;

    public static void createDescriptionLabel() {
        JLabel description = new JLabel("Click any tile to start.");
        description.setSize(screenWidth, 10);

        Font f = new Font("serif", Font.PLAIN, 25);
        description.setFont(f);

        mainFrame.getContentPane().add(description);
        description.setVerticalAlignment(JLabel.BOTTOM);

        Global.description = description;
    }


    public GUI()  {

        mainFrame = new JFrame("Minesweeper");

        GridLayout grid = new GridLayout(Global.sizeX, Global.sizeY);

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(grid);

        gridPanel.setSize(screenWidth, screenHeight);

        mainFrame.getContentPane().add(gridPanel);

        mainFrame.setSize(screenWidth + 20 , screenHeight + 70);
        mainFrame.setLocation(300,200);
        mainFrame.setIconImage(Global.getImage("appImage.png").getImage());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        createDescriptionLabel();
        GUIButtons.createButtonsGrid(gridPanel);

        mainFrame.setVisible(true);

    }
}
