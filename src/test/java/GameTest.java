import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class GameTest {
    @Test
    public void shouldDrawBoardWhenGameStarts() {
        PrintStream out = mock(PrintStream.class);
        BufferedReader in = mock(BufferedReader.class);
        Game game = new Game(out, in);
        game.start();
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
        BufferedReader in = mock(BufferedReader.class);
        when(in.readLine()).thenReturn("3");
        Game game = new Game(out, in);
        game.start();
        game.move();
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
        BufferedReader in = mock(BufferedReader.class);
        when(in.readLine()).thenReturn("4");
        Game game = new Game(out, in);
        game.start();
        game.move();
        verify(out).println(
                "1|2|3\n" +
                "-----\n" +
                "X|5|6\n" +
                "-----\n" +
                "7|8|9");
    }
}