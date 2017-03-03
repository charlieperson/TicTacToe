import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class GameTest {
    @Test
    public void shouldDrawBoardWhenGameStarts() {
        PrintStream out = mock(PrintStream.class);
        BufferedReader in = mock(BufferedReader.class);
        Board board = mock(Board.class);
        Game game = new Game(out, in, board);
        game.start();
        verify(board).draw();
    }
}