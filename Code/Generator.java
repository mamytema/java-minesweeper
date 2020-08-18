package minesweeper;

import javax.swing.*;

public class Generator {
    public static final String MINE = "mine";

    public static void generateGame(int sizeX, int sizeY, int mines, int maxMinesPerTile) {
        Global.sizeX = sizeX;
        Global.sizeY = sizeY;
        Global.mineAmount = mines;
        Global.flagsLeft = mines;
        Global.maxMinesPerTile = maxMinesPerTile;
        Global.map = new Tile[Global.sizeX][Global.sizeY];
        Global.mineMap = new Tile[Global.mineAmount];
        Global.jButtonMap = new JButton[Global.sizeX][Global.sizeY];
    }

    public static void generateNumberGrid() {
        for (int X = 0; X < Global.map.length; X++) {
            for (int Y = 0; Y < Global.map[X].length; Y++) {
                if (Global.map[X][Y].getType().equals(MINE)) { continue; }
                Tile[] neighbors = Global.map[X][Y].getNeighbors();
                for (Tile neighbor : neighbors) {
                    if (neighbor == null) {
                        continue;
                    }
                    if (neighbor.getType().equals(MINE)) {
                        Global.map[X][Y].addMineNearby();
                    }
                }
                Global.map[X][Y].setTypeToMinesNearby();
            }
        }
    }

    @Deprecated
    public static void generateMines() {
        int mineIndex = 0;
        for (int i = 0; i < Global.mineAmount; i++) {
            int x = Global.randomInt(0, Global.sizeX - 1);
            int y = Global.randomInt(0, Global.sizeY - 1);

            if (Global.map[x][y].getType().equals(MINE)) { continue; }

            Global.map[x][y].setType(MINE);
            Global.mineMap[mineIndex] = Global.map[x][y];
            mineIndex++;
        }
    }

    public static void generateMinesAndIgnore(int ignoreX, int ignoreY) {
        int mineIndex = 0;
        MineLoop:
        for (int i = 0; i < Global.mineAmount; i++) {

            int x = Global.randomInt(0, Global.sizeX - 1);
            int y = Global.randomInt(0, Global.sizeY - 1);

            if (Global.map[x][y] == Global.map[ignoreX][ignoreY]) {
                i--;
                continue;
            }

            if (Global.map[x][y].getType().equals(MINE)) {
                i--;
                continue;
            }

            for (Tile neighbor : Global.map[x][y].getNeighbors()) {
                if (neighbor == Global.map[ignoreX][ignoreY]) {
                    i--;
                    continue MineLoop;
                }
            }

            Global.map[x][y].setType(MINE);
            Global.mineMap[mineIndex] = Global.map[x][y];
            mineIndex++;
        }
    }

    public static void removeUnusedMines() {
        for (int x = 0; x < Global.map.length; x++) {
            for (int y = 0; y < Global.map[x].length; y++) {

                int minesAround = 0;

                for (Tile tile : Global.map[x][y].getNeighbors()) {

                    if (tile.getType().equals(MINE)) {
                        if (minesAround == Global.maxMinesPerTile) {
                            tile.setType("space");
                        } else {
                            minesAround++;
                        }
                    }
                }
            }
        }
    }

    public static void generateGrid() {

        Tile[][] map = Global.map;

        for (int X = 0; X < Global.sizeX; X++) {

            for (int Y = 0; Y < Global.sizeY; Y++) {

                map[X][Y] = new Tile(X, Y, "space");
            }

        }

    }
}
