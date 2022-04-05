/*
@author Shurel Reynolds
*/
package com.shurel.tictactoe;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    private static int playerCounter=0;
    private String name;
    private char symbol;
    ArrayList <Point> moves=new ArrayList<>();
    Player opponent;

    public Player(String name) {
         this.name=name;

    }

    public String getName() {
        return name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public ArrayList<Point> getMoves() {
        return moves;
    }

    public void move(Point point) {
        moves.add(point);
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public String toString(){
        return getName()+" -> "+getSymbol();
    }
}
