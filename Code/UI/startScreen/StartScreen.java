package minesweeper.UI.startScreen;


import minesweeper.Global;

import javax.swing.*;
import java.awt.*;

public class StartScreen {
    private static JFrame mainFrame;

    private static void add(JLabel component) {
        mainFrame.getContentPane().add(component);
    }
    private static void add(JPanel component) {
        mainFrame.getContentPane().add(component);
    }

    public static void close() {
        mainFrame.setVisible(false);
        mainFrame.dispose();
    }

    public StartScreen() {
        mainFrame = new JFrame("Minesweeper Start");


//        mainFrame.getContentPane().add;

        mainFrame.setSize(500 , 500);
        mainFrame.setLocation(300,200);
        mainFrame.setIconImage(Global.getImage("Flagged.png").getImage());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font textFont = new Font("serif", Font.PLAIN, 50);

        GridLayout grid = new GridLayout(6, 6, 4, 4);
        JPanel difficulty = new JPanel();
        difficulty.setLayout(grid);
        difficulty.setSize(450, 200);
        difficulty.setLocation(25, 125);

        Font difficultyButtonFont = new Font("arial", Font.PLAIN, 25);
        Font extremeButtonFont = new Font("arial", Font.BOLD, 26);

        Button veryEasyButton = new Button("Very easy", difficultyButtonFont, Color.GREEN);

        Button easyButton = new Button("Easy", difficultyButtonFont, Button.DARK_GREEN);

        Button mediumButton = new Button("Medium", difficultyButtonFont, Color.YELLOW);

        Button hardButton = new Button("Hard", difficultyButtonFont, Color.ORANGE);

        Button veryHardButton = new Button("Very hard", difficultyButtonFont, Color.RED);

        Button impossibleButton = new Button("Impossible", extremeButtonFont, Color.BLACK);

        Button[] buttons = {
                veryEasyButton,
                easyButton,
                mediumButton,
                hardButton,
                veryHardButton,
                impossibleButton
        };

        DifficultyButtons.addListenersToButtons(buttons);

        JLabel start = new JLabel("Minesweeper", JLabel.CENTER);
        start.setSize(500, 25);
        start.setLocation(250, 0);
        start.setFont(textFont);
        start.setVerticalAlignment(JLabel.TOP);

        mainFrame.setVisible(true);

        add(difficulty);
        difficulty.add(veryEasyButton.getButton());
        difficulty.add(easyButton.getButton());
        difficulty.add(mediumButton.getButton());
        difficulty.add(hardButton.getButton());
        difficulty.add(veryHardButton.getButton());
        difficulty.add(impossibleButton.getButton());
        add(start);
    }
}
