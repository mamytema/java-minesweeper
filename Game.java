package com.mamytema;

import com.mamytema.commands.*;
import java.util.Scanner;

import static com.mamytema.commands.CheckCommand.check;
import static java.lang.String.valueOf;

public class Game {

    public static final String CHECK = "check";
    public static final String FLAG = "flag";
    public static final String UNFLAG = "unflag";

    public static final String SPACE = "space";

    public static void show() {
        for (Tile[] xTile : Global.map) {
            for (Tile yTile : xTile) {
                if (yTile.getType().equals(SPACE)) {
                    check(new String[] {
                            "check",
                            valueOf(yTile.getPos('x')),
                            valueOf(yTile.getPos('y'))
                    });
                    return;
                }
            }
        }
    }

    public static void mainLoop() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("X - Y> ");
            String input = sc.nextLine();
            String[] arguments = input.split(" ");
            if (arguments[0].equals(CHECK)) {
                if (check(arguments)) break;
            } else if (arguments[0].equals(FLAG)) {
                if (FlagCommand.flag(arguments)) break;
            } else if (arguments[0].equals(UNFLAG)) {
                if (FlagCommand.flag(arguments)) break;
            }
            if (Win.check()) {
                Cheats.showAll();
                Render.render();
                System.out.println("You won! All mines have been discovered.");
                break;
            }
        }
    }
}
