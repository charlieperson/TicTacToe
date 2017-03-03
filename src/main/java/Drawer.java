import java.io.PrintStream;
import java.util.ArrayList;

public class Drawer {

    private PrintStream out;
    private ArrayList<String> boardPositions;


    public Drawer(PrintStream out) {
        this.out = out;
    }

    public void draw(ArrayList<String> boardPositions) {
        this.boardPositions = boardPositions;
        String boardString = "";
        boardString += drawRow(1);
        boardString += drawRow(2);
        boardString += drawRow(3);
        out.println(boardString);
    }

    private String drawRow(int row) {
        String rowString = "";
        int startingIndex = ((row-1)*3);
        int endingIndex = row*3;
        for(int i=startingIndex; i<endingIndex; i++) {
            rowString += boardPositions.get(i);
            boolean lastNumberInRow = (i+1) % 3 == 0;
            if(!lastNumberInRow) rowString += "|";
        }
        boolean lastRow = row==3;
        if(!lastRow) rowString += "\n-----\n";
        return rowString;
    }
}
