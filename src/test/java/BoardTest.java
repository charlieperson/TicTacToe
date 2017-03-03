import org.junit.Test;
import java.io.IOException;
import java.io.PrintStream;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    @Test
    public void shouldDrawInitialBoard() {
        PrintStream out = mock(PrintStream.class);
        Board board = new Board(out);
        board.draw();
        verify(out).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }

    @Test
    public void shouldRedrawBoardAppropriatelyWhenPlayerMovesToSquareThree() throws IOException {
        PrintStream out = mock(PrintStream.class);
        Board board = new Board(out);
        board.move(3);
        verify(out).println(
                "1|2|X\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }

    @Test
    public void shouldRedrawBoardAppropriatelyWhenPlayerMovesToSquareFour() throws IOException {
        PrintStream out = mock(PrintStream.class);
        Board board = new Board(out);
        board.move(4);
        verify(out).println(
                "1|2|3\n" +
                "-----\n" +
                "X|5|6\n" +
                "-----\n" +
                "7|8|9");
    }

}