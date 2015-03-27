import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by maheshkk on 3/26/2015.
 */
public class Board {
    private char[][] cells;
    private int noOfRows;


    public Board(int noOfRows) {
        cells = new char[noOfRows][noOfRows];
        for(int i=0;i<noOfRows;i++)
            Arrays.fill(cells[i],' ');
        this.noOfRows = noOfRows;
    }

    public String asPrintable() {
        StringBuilder board = new StringBuilder("");
        board.append(getColHeader() + System.lineSeparator()+"Row"+System.lineSeparator());
        for (int rowId = 0; rowId < noOfRows; rowId++) {
            board.append(rowId+"\t");
            for (int colId = 0; colId < noOfRows; colId++) {
                board.append("\t" + cells[rowId][colId]);
            }
            board.append(System.lineSeparator());
        }
        return board.toString();
    }

    public String getColHeader() {
        String col = "Col:\t";
        for (int i=0;i<noOfRows;i++){
            col += i + "\t";
        }
        return col;
    }

    public boolean putValueInCell(int rowId, int colId, char playerSymbol) throws InvalidPositionException {
        char cell;
        try{
            cell = cells[rowId][colId];
        }catch(ArrayIndexOutOfBoundsException e){
            throw new InvalidPositionException("not present");
        }
        if(cell == ' '){
            cells[rowId][colId] = playerSymbol;
            return checkWin();
        } else throw new InvalidPositionException("filled");

    }

    private boolean checkWin() {
        Set<Character> rowSet = new HashSet<Character>();
        Set<Character> colSet = new HashSet<Character>();
        for (int rowId=0;rowId<noOfRows;rowId++){
            for (int colId=0;colId<noOfRows;colId++){
                rowSet.add(cells[rowId][colId]);
                colSet.add(cells[colId][rowId]);
            }
            if(rowSet.size() == 1 || colSet.size() == 1) return true;
            rowSet = new HashSet<Character>();
            colSet = new HashSet<Character>();
        }
        return false;
    }
}