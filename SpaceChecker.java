package com.mamytema;

import java.util.ArrayList;
import com.mamytema.commands.*;

public class SpaceChecker {

    public static final String SPACE = "space";

    public static boolean checkTile(String[] arguments) {
        Tile checkTile = Global.map[Integer.parseInt(arguments[1])][Integer.parseInt(arguments[2])];
        ArrayList<Tile> checkedTiles = new ArrayList<>();
        if (!checkTile.getType().equals(SPACE)) return false;
        checkedTiles.add(checkTile);

        checkTile.makeVisible();
        Tile[] checkedTileNeighbors = checkTile.getNeighbors();

        for (Tile neighbor : checkedTileNeighbors) {

            if (neighbor == null) {
                continue;
            }

            if (neighbor.getType().equals("space")) {
                neighbor.makeVisible();
                checkedTiles.add(neighbor);
            }
        }
        int amountOfNeighbors = 0;
        for (int tile = 0; tile < checkedTiles.size(); tile++) {
            Tile[] checkedTilesNeighbors = checkedTiles.get(tile).getNeighbors();
            for (Tile neighbor : checkedTilesNeighbors) {

                if (neighbor == null) continue;
                if (neighbor.getType().equals(SPACE)) {
                    if (checkedTiles.size() < 100) {
                        if (!checkedTiles.contains(neighbor)) {
                            checkedTiles.add(neighbor);
                            amountOfNeighbors++;
                        }
                    }
                }

                neighbor.makeVisible();
            }
        }
        System.out.println(amountOfNeighbors);
        return false;
    }
}
