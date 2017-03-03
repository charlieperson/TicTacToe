import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DrawerTest {

    @Test
    public void shouldBeAbleToDrawBoardCorrectly() {
        ArrayList<String> positions = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        PrintStream out = mock(PrintStream.class);
        Drawer drawer = new Drawer(out);
        drawer.draw(positions);
        verify(out).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }

}