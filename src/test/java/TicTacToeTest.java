/*
@author Shurel Reynolds
*/
import com.shurel.tictactoe.TicTacToe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

    private TicTacToe ticTacToe;

    @Before
    public void setUp() {
        ticTacToe = new TicTacToe();

    }

    @Test
    public void testGridSize() {
        Assert.assertTrue("GridSize == 3", ticTacToe.getGridSize() == 3);
    }

}
