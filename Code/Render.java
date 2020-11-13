package minesweeper;

import javax.swing.*;

public class Render {
    private static void makeLine() {
        System.out.println("- " + "- - ".repeat(Global.map.length));
    }
    @Deprecated
    public static void render() {
        String[] outputList = new String[Global.map.length + 1];
        StringBuilder outputLine;
        outputList[0] = "  ";

        for (int i = 0; i < Global.sizeY; i++) {
            outputList[0] = outputList[0] + i + "   ";
        }
        for (int X = 0; X < Global.map.length; X++) {
            outputLine = new StringBuilder(X + " ");
            for (int Y = 0; Y < Global.map[X].length; Y++) {

                outputLine.append(Global.map[X][Y].getCharCode()).append(" | ");

            }

            outputList[X + 1] = outputLine.toString();

        }

        for (String output : outputList) {
            System.out.println(output);
            makeLine();
        }
    }

    public static void renderAllGUI() {
        for (int X = 0; X < Global.jButtonMap.length; X++) {
            for (int Y = 0; Y < Global.jButtonMap[X].length; Y++) {

                JButton button = Global.jButtonMap[X][Y];
                ImageIcon image = Global.getImage( Global.map[X][Y].getImageCode() );
                button.setIcon(image);

            }
        }
    }

    public static void renderTile(int X, int Y) {
        Win.check();
        JButton button = Global.jButtonMap[X][Y];
        ImageIcon image = Global.getImage( Global.map[X][Y].getImageCode());
        button.setIcon(image);
    }

    public static void renderDescriptionText(String text) {
        Global.description.setText(text);
    }
}
