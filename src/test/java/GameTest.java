import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;


public class GameTest {
    private PrintStream out;
    private BufferedReader in;
    private Board board;
    private Game game;

    @Before
    public void setUp() {
        out = mock(PrintStream.class);
        in = mock(BufferedReader.class);
        board = mock(Board.class);
        game = new Game(out, in, board);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() throws IOException {
        when(in.readLine()).thenReturn("quit");
        game.start();
        verify(board).draw();
    }

    @Test
    public void shouldPromptSecondUserToMakeMoveAfterFirstPlayerMoves() throws IOException {
        when(in.readLine()).thenReturn("3", "2", "quit");
        when(board.positionHasNotBeenTaken(3)).thenReturn(true);
        when(board.positionHasNotBeenTaken(2)).thenReturn(true);
        game.start();
        verify(board).move(3, "X");
        verify(board).move(2, "O");
    }
}