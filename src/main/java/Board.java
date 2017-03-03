import java.io.PrintStream;
import java.util.ArrayList;

public class Board {
    private PrintStream out;
    private ArrayList<String> currentPositions;
    private Drawer drawer;

    public Board(PrintStream out, ArrayList<String> positions, Drawer drawer) {
        this.out = out;
        this.currentPositions = positions;
        this.drawer = drawer;
    }

    public void move(int square, String xOrO) {
        int desiredIndex = (square - 1);
        currentPositions.set((desiredIndex), xOrO);
    }

    public void draw() {
        drawer.draw(currentPositions);
    }

    public boolean positionHasNotBeenTaken(int square) {
        int desiredIndex = (square - 1);
        if(currentPositions.get(desiredIndex).equals("X") ||
            currentPositions.get(desiredIndex).equals("O")) {
            out.println("Location already taken");
            return false;
        }
        return true;
    }

    public boolean isFull() {
        boolean validator = true;
        for(String position : currentPositions) {
            if(!position.equals("X") && !position.equals("O")) {
                validator = false;
            }
        }
        return validator;
    }
}
