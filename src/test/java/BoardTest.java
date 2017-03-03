import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private ArrayList<String> positions;
    private PrintStream out;
    private Drawer drawer;

    @Before
    public void setUp() {
        drawer = mock(Drawer.class);
        positions = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        out = mock(PrintStream.class);
    }

    @Test
    public void shouldDrawInitialBoard() {
        Board board = new Board(out, positions, drawer);
        board.draw();
        verify(drawer).draw(positions);
    }

    @Test
    public void shouldResetPositionsAppropriatelyWhenPlayerOneMovesToSquareThree() throws IOException {
        Board board = new Board(out, positions, drawer);
        board.move(3, "X");
        assertEquals("X", positions.get(2));
    }

    @Test
    public void shouldResetPositionsAppropriatelyWhenPlayerMovesToSquareFour() throws IOException {
        Board board = new Board(out, positions, drawer);
        board.move(4, "O");
        assertEquals("O", positions.get(3));
    }

    @Test
    public void shouldNotLetAPlayerMoveIntoASpotThatHasAlreadyBeenTaken() throws IOException {
        Board board = new Board(out, positions, drawer);
        board.move(4, "O");
        board.positionHasNotBeenTaken(4);
        verify(out).println("Location already taken");
    }

    @Test
    public void shouldKnowWhenBoardIsFull() {
        positions = new ArrayList<>(Arrays.asList("X", "O", "X", "X", "O", "O", "O", "X", "X"));
        Board board = new Board(out, positions, drawer);
        assertEquals(true, board.isFull());
    }

//    @Test
//    public void shouldKnowWhenAPlayerWinsHorizontally() {
//        positions = new ArrayList<>(Arrays.asList("X", "O", "X", "O", "O", "O", "O", "X", "X"));
//        Board board = new Board(out, positions, drawer);
//        assertEquals("2", board.returnWinner());
//    }
}