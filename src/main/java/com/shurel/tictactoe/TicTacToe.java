/*
@author Shurel Reynolds
*/
package com.shurel.tictactoe;

import java.util.Arrays;


public class TicTacToe {
    private int gridSize = 3;
    //a game has nine fields in a 3x3 grid
    private String[][] grid = new String[gridSize][gridSize];
    private final Player player1;
    private final Player player2;

    public TicTacToe(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        System.out.println("Cross & Naught :D");
        //fill -  empty
        for (String i[] : grid) {
            // Fill each row with -.
            Arrays.fill(i, "-");
        }
        printGrid();
    }

    public String getGrid() {
        String out = "";
        for (String i[] : grid) {
            for (String j : i) {
                out += j + " ";
            }
            out += "\n";

        }
        return out;
    }

    public void printGrid() {
        System.out.println(getGrid());
    }

    public int getGridSize() {
        return gridSize;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
