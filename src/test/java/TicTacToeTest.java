/*
@author Shurel Reynolds
*/

import com.shurel.tictactoe.Player;
import com.shurel.tictactoe.TicTacToe;
import com.shurel.tictactoe.TicTacToeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {

    private TicTacToe ticTacToe;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1=new Player("Player 1");
        player2=new Player("Player 2");
        try {
            ticTacToe = new TicTacToe(player1,player2);
        } catch (TicTacToeException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGridSize() {
        Assert.assertTrue("GridSize == 3", ticTacToe.getGridSize() == 3);
    }

    @Test
    public void testPlayerNames() {
        assertEquals("Player 1", ticTacToe.getPlayer1().getName());
        assertEquals("Player 2", ticTacToe.getPlayer2().getName());

    }

    @Test
    public void testPlayerSymbols() {
        assertEquals('X', ticTacToe.getPlayer1().getSymbol());
        assertEquals('O', ticTacToe.getPlayer2().getSymbol());

    }

    @Test
    public void testWhoIsNext() {
        assertEquals(ticTacToe.getPlayer1(), ticTacToe.whoIsNext());
    }

    @Test
    public void testIsGameOver() {
        assertEquals(false, ticTacToe.isGameOver());
    }

    @Test
    public void testPlayerCanMove() {
        assertEquals(false, ticTacToe.canMove(ticTacToe.getPlayer2()));
        assertEquals(true, ticTacToe.canMove(ticTacToe.getPlayer1()));
    }

    @Test
    public void testPlayerMove() {
        Point point=new Point(2,0);
        assertEquals(true, ticTacToe.canMove(point));
        Player nextPlayer=ticTacToe.whoIsNext();
        int moveCount=nextPlayer.getMoves().size();

        try {
            ticTacToe.move(point);
            // move was made with output
            String expected="--X\n---\n---";
            assertEquals(expected, ticTacToe.getGrid());
           //check moves made by player
            assertEquals(moveCount+1, nextPlayer.getMoves().size());
            //check who is next
            Assert.assertNotEquals(nextPlayer,ticTacToe.whoIsNext());

        } catch (TicTacToeException e) {
            e.printStackTrace();
        }


        //who is next = player 2;
    }







}
