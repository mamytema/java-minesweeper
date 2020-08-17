package com.mamytema;

import java.util.ArrayList;

public class SpaceChecker {

    public static final String SPACE = "space";

    private static ArrayList<Tile> checkTilesNeighbors(Tile checkTile) {
        ArrayList<Tile> checkedTiles = new ArrayList<>();
        Tile[] checkedTileNeighbors = checkTile.getNeighbors();

        checkedTiles.add(checkTile);

        for (Tile neighbor : checkedTileNeighbors) {

            if (neighbor == null) {
                continue;
            }

            if (neighbor.getType().equals("space")) {
                neighbor.makeVisible();
                checkedTiles.add(neighbor);
            }
        }
        return checkedTiles;
    }

    private static void checkNeighborNeighbors(ArrayList<Tile> checkedTiles) {
        for (int tile = 0; tile < checkedTiles.size(); tile++) {
            Tile[] checkedTilesNeighbors = checkedTiles.get(tile).getNeighbors();
            for (Tile neighbor : checkedTilesNeighbors) {

                if (neighbor == null) continue;
                if (neighbor.getType().equals(SPACE)) {
                    if (checkedTiles.size() < 2500) {
                        if (!checkedTiles.contains(neighbor)) {
                            checkedTiles.add(neighbor);
                        }
                    }
                }

                neighbor.makeVisible();
            }
        }
    }

    public static void checkTile(int x, int y) {
        Tile checkTile = Global.map[x][y];
        if (!checkTile.getType().equals(SPACE)) {
            return;
        }

        checkTile.makeVisible();

        ArrayList<Tile> checkedTiles = checkTilesNeighbors(checkTile);

        checkNeighborNeighbors(checkedTiles);

        Render.renderAllGUI();
    }
}
