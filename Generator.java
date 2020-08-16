package com.mamytema;

public class Generator {
    public static final String MINE = "mine";

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

    public static void generateGrid() {

        Tile[][] map = Global.map;

        for (int X = 0; X < Global.sizeX; X++) {

            for (int Y = 0; Y < Global.sizeY; Y++) {

                map[X][Y] = new Tile(X, Y, "space");
            }

        }

    }
}
