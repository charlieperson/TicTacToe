import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private PrintStream out;
    private ArrayList<String> currentPositions;

    public Board(PrintStream out) {
        this.out = out;
        this.currentPositions = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
    }

    public void move(int square) {
        currentPositions.set((square-1), "X");
        draw();
    }

    public void draw() {
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
            rowString += currentPositions.get(i);
            boolean lastNumberInRow = (i+1) % 3 == 0;
            if(!lastNumberInRow) rowString += "|";
        }
        boolean lastRow = row==3;
        if(!lastRow) rowString += "\n-----\n";
        return rowString;
    }
}
