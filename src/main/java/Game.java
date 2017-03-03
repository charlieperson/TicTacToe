import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Game {

    private PrintStream out;
    private BufferedReader in;
    private Board board;

    public Game(PrintStream out, BufferedReader in, Board board) {
        this.out = out;
        this.in = in;
        this.board = board;
    }

    public void start() {
        board.draw();
    }

//    public void move() {
//        out.println("\nMake your move!");
//        try {
//            String move = in.readLine();
//            board.set((parseInt(move)-1), "X");
//            drawBoard();
//
//        } catch(IOException e) {
//            out.print(e.getMessage());
//        }
//    }

}
