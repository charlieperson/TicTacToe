import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> positions = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        Drawer drawer = new Drawer(System.out);
        Board board = new Board(System.out, positions, drawer);
        Game game = new Game(System.out, in, board);
        game.start();
    }
}




