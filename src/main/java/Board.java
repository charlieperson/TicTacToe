import java.io.PrintStream;
import java.util.ArrayList;

public class Board {
    private PrintStream out;
    private ArrayList<String> currentPositions;

    public Board(PrintStream out, ArrayList<String> positions) {
        this.out = out;
        this.currentPositions = positions;
    }

    public void move(int square, String xOrO) {
        currentPositions.set((square-1), xOrO);
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
