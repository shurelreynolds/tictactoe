/*
@author Shurel Reynolds
*/
import com.shurel.tictactoe.Player;
import com.shurel.tictactoe.TicTacToe;
import com.shurel.tictactoe.TicTacToeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class TicTacToeTest {

    private TicTacToe ticTacToe;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1=new Player("Player 1",'X');
        player2=new Player("Player 2",'O');
        ticTacToe = new TicTacToe(player1,player2);

    }

    @Test
    public void testGridSize() {
        Assert.assertTrue("GridSize == 3", ticTacToe.getGridSize() == 3);
    }

    @Test
    public void testPlayerNames() {
        Assert.assertEquals("Player 1", ticTacToe.getPlayer1().getName());
        Assert.assertEquals("Player 2", ticTacToe.getPlayer2().getName());

    }

    @Test
    public void testPlayerSymbols() {
        Assert.assertEquals('X', ticTacToe.getPlayer1().getSymbol());
        Assert.assertEquals('O', ticTacToe.getPlayer2().getSymbol());

    }

    @Test
    public void testWhoIsNext() {
        Assert.assertEquals(ticTacToe.getPlayer1(), ticTacToe.whoIsNext());
    }

    @Test
    public void testIsGameOver() {
        Assert.assertEquals(false, ticTacToe.isGameOver());
    }

    @Test
    public void testPlayerCanMove() {
        Assert.assertEquals(false, ticTacToe.canMove(ticTacToe.getPlayer2()));
        Assert.assertEquals(true, ticTacToe.canMove(ticTacToe.getPlayer1()));
    }

    @Test
    public void testPlayerMove() {
        Point point=new Point(2,0);
        Assert.assertEquals(true, ticTacToe.canMove(point));

        try {
       ticTacToe.move(player1,point);
        } catch (TicTacToeException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(false, ticTacToe.canMove(point));


        //who is next = player 2;
    }


}
