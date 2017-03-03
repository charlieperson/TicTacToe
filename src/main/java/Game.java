import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Game {

    private final PrintStream out;
    private BufferedReader in;
    private ArrayList<String> board;

    public Game(PrintStream out, BufferedReader in) {
        this.out = out;
        this.in = in;
        this.board = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
    }

    public void start() {
        drawBoard();
    }

    public void move() {
        try {
            String move = in.readLine();
            board.set((parseInt(move)-1), "X");
            drawBoard();

        } catch(IOException e) {
            out.print(e.getMessage());
        }
    }


    private void drawBoard() {
        String board = "";
        board += drawRow(1);
        board += drawRow(2);
        board += drawRow(3);
        out.println(board);
    }

    private String drawRow(int row) {
        String rowString = "";
        int startingIndex = ((row-1)*3);
        int endingIndex = row*3;
        for(int i=startingIndex; i<endingIndex; i++) {
            rowString += board.get(i);
            boolean lastNumberInRow = (i+1) % 3 == 0;
            if(!lastNumberInRow) rowString += "|";
        }
        boolean lastRow = row==3;
        if(!lastRow) rowString += "\n-----\n";
        return rowString;
    }


}
