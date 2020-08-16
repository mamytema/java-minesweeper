package com.mamytema;

public class Render {
    private static void makeLine() {
        System.out.println("- " + "- - ".repeat(Global.map.length));
    }

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
}
