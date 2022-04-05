/*
@author Shurel Reynolds
*/
package com.shurel.tictactoe;

public class Player {
    private static int playerCounter=0;
    String name;
    char symbol;

    public Player(char symbol) {
        this.name="Player "+(++playerCounter);
        this.symbol=symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}
