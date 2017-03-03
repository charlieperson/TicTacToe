import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board(System.out);
        Game game = new Game(System.out, in, board);
        game.start();
    }
}




