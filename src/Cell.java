/**
 * Created by maheshkk on 3/26/2015.
 */
public class Cell {
    int rowId;
    int colId;
    String value;

    public Cell(int rowId, int colId, String value) {
        this.rowId = rowId;
        this.colId = colId;
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o){
        Cell cell = (Cell)o;
        return ((this.rowId == cell.rowId) &&
                (colId == cell.colId) &&
                (this.value.equals(cell.value))
        );
    }

    public boolean isYourIndex(int rowId, int colId) {
        return(this.rowId == rowId && this.colId == colId);
    }

    public String asString() {
        return "" + value + "";
    }
}
