/*
@author Shurel Reynolds
*/
package com.shurel.tictactoe;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TicTacToe {
    private int gridSize = 3;
    //a game has nine fields in a 3x3 grid
    private char[][] grid = new char[gridSize][gridSize];
    private final Player player1;
    private final Player player2;
    private final List<Player> playerList=new ArrayList<>();
    private Player nextPlayer;

    public TicTacToe(Player player1, Player player2) throws TicTacToeException{

        if(player1 == null)throw new TicTacToeException("Player 1 is null");
       if(player2 == null)throw new TicTacToeException("Player 2 is null");

        this.player1 = player1;
        playerList.add(player1);
        this.player2 = player2;
        playerList.add(player1);
        playerList.add(player2);
        nextPlayer=player1;

        player1.setOpponent(player2);
        player2.setOpponent(player1);

        player1.setSymbol('X');
        player2.setSymbol('O');


        System.out.println("Cross & Naught :D");
        //fill -  empty
        for (char i[] : grid) {
            // Fill each row with -.
            Arrays.fill(i, '-');
        }
        printPlayers();
      update();
    }

    private void update() {
        printGrid();

        printWhoIsNext();
    }

    public String getGrid() {
        String out = "";
        for (char i[] : grid) {
            for (char j : i) {
                out += j;
            }
            out += "\n";

        }
        return out.trim();
    }

    public void printGrid() {
        System.out.println(getGrid());
    }

    public void printPlayers() {
        System.out.println(player1);
        System.out.println(player2);
    }

    private void printWhoIsNext() {
        System.out.println(whoIsNext()+" is next");
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
    //return the player with the least moves
    //in any case start with player1
    public Player whoIsNext(){
     //
        return nextPlayer;
    }

    public boolean isGameOver(){
       return player1.getMoves().size()+player2.getMoves().size()==gridSize*gridSize;
    }

    public boolean canMove(Player player){
        return player.equals(whoIsNext());
    }
    public boolean canMove(Point point){
        return grid[point.y][point.x]=='-';
    }

    public void move(Player player, Point point) throws TicTacToeException {
        if(player == null)throw new TicTacToeException("Player is null");
        else if(player == null)throw new TicTacToeException("Player is null");

       else if(point.x<0 || point.y<0 || point.x>=gridSize || point.y>=gridSize)throw new TicTacToeException("Point is out of bounds. Grid size is "+gridSize+" x "+gridSize);

        else if(!whoIsNext().equals(player))throw new TicTacToeException(player.getName()+" is not next");


        else if(!canMove(player))throw new TicTacToeException("It is not "+player.getName()+"'s turn");

        if(!canMove(point)) throw new TicTacToeException("Cannot move to this point: "+grid[point.y][point.x]+" already in place");

        else if(isGameOver()) throw new TicTacToeException("Game already over");



        grid[point.y][point.x]=player.getSymbol();
        player.move(point);
        nextPlayer=player1.equals(player)?player2:player1;
        this.update();

    }
//move the next player to this point
    public void move(Point point) throws TicTacToeException {
        move(whoIsNext(), point);
    }
}
