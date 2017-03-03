import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board(System.out, new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9")));
        Game game = new Game(System.out, in, board);
        game.start();
    }
}




