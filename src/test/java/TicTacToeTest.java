/*
@author Shurel Reynolds
*/
import com.shurel.tictactoe.Player;
import com.shurel.tictactoe.TicTacToe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

    private TicTacToe ticTacToe;

    @Before
    public void setUp() {
        ticTacToe = new TicTacToe(new Player('X'),new Player('O'));

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


}
