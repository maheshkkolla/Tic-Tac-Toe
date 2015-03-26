import java.util.ArrayList;
import java.util.List;

/**
 * Created by maheshkk on 3/26/2015.
 */
public class Board {
    List<Cell> cells;
    int noOfRows;
    int noOfCols;

    public Board(int noOfRows, int noOfCols) {
        this.noOfRows = noOfRows;
        this.noOfCols = noOfCols;
        cells = new ArrayList<Cell>();
    }
    private void addCell(Cell cell){
        cells.add(cell);
    }

    public void create() {
        for(int rowId = 1; rowId <= noOfRows; rowId++){
            for(int colId = 1; colId <= noOfCols; colId++) {
                addCell(new Cell(rowId,colId,""));
            }
        }
    }

    public void putValueInCell(int rowId, int colId, String playerSymbol) {
        for (Cell cell: cells) {
            if(cell.equals(new Cell(rowId, colId,""))) cell.setValue(playerSymbol);
        }
    }

    public String asPrintable() {
        StringBuilder board = new StringBuilder("");
        board.append(getColIndexRepresentation()+System.lineSeparator());
        board.append("Row"+System.lineSeparator());
        for (int rowId = 1; rowId <= noOfRows; rowId++){
            board.append(rowId + "\t\t");
            for(int colId = 1; colId <= noOfCols; colId++){
                board.append( getCell(rowId, colId).asString() + "\t\t");
            }
            board.append(System.lineSeparator()+System.lineSeparator());
        }
        return board.toString();
    }

    private Cell getCell(int rowId, int colId) {
        for(Cell cell: cells){
            if(cell.isYourIndex(rowId,colId)) return cell;
        }
        return null;
    }

    public String getColIndexRepresentation() {
        String colIndex = "Col\t\t";
        for (int i=1; i<=noOfCols;i++){
            colIndex+=i+"\t\t";
        }
        return colIndex;
    }
}
