import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.parseInt;

public class Game {

    private PrintStream out;
    private BufferedReader in;
    private Board board;
    private boolean playerOneTurn = true;

    public Game(PrintStream out, BufferedReader in, Board board) {
        this.out = out;
        this.in = in;
        this.board = board;
    }

    public void start() {
        handleUserInput();
    }

    private void handleUserInput() {
        board.draw();
        out.println("\nMake your move!");
        try {
            String input = in.readLine();
            processInput(input);
        } catch(IOException e) {
            out.print(e.getMessage());
        }
    }

    private void processInput(String input) {
        if(input.equals("quit")) return;
        int position = parseInt(input);
        if(board.positionHasNotBeenTaken(position)) {
            board.move(position, xOrO());
            playerOneTurn = !playerOneTurn;
        }
        if(board.isFull()) {
            handleDraw();
            return;
        }
        handleUserInput();
    }

    private void handleDraw() {
        out.println("Game is a draw");
        board.draw();
    }

    private String xOrO() {
        if(playerOneTurn) return "X";
        return "O";
    }

}
