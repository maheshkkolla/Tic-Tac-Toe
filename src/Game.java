import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by maheshkk on 3/27/2015.
 */
public class Game {
    private List<Character> board = new ArrayList<Character>();
    private int size;

    public Game(int size) {
        this.size = size;
        for (int i=1;i<= size*size; i++){
            board.add(Character.forDigit(i,10));
        }
    }

    public String getPrintableBoard() {
        String result = "";
        for(int i=0;i<board.size();i=i+size) {
            for(int j=i;j<i+size;j++){
                result += board.get(j) +"\t";
            }
            result+=System.lineSeparator();
        }
        return result;
    }

    public boolean putValueInCell(int index, char symbol) throws InvalidPositionException {
        try{
            Integer.parseInt(String.valueOf(board.get(index-1)));
        } catch(NumberFormatException e){
            throw new InvalidPositionException("filled");
        } catch(IndexOutOfBoundsException e){
            throw new InvalidPositionException("not present");
        }
        board.remove(index-1);
        board.add(index-1,symbol);
        return hasGameCompleted();
    }

    private boolean hasGameCompleted() {
        return checkRowWinningStrategy() ||
                checkColWinningStrategy() ||
                checkDiagonalsWinningStrategy();
    }

    private boolean checkDiagonalsWinningStrategy() {
        return checkLeftDiagonal() || checkRightDiagonal();
    }

    private boolean checkRightDiagonal() {
        Set<Character> right = new HashSet<Character>();
        for(int i=size-1; i<board.size()-1;i=i+(size-1)){
            right.add(board.get(i));
        }
        if(right.size() ==1) return true;
        return false;

    }

    private boolean checkLeftDiagonal() {
        Set<Character> left = new HashSet<Character>();
        for (int i=0;i<board.size();i=i+size+1){
            left.add(board.get(i));
        }
        if(left.size() ==1) return true;
        return false;
    }

    private boolean checkRowWinningStrategy() {
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<board.size();i=i+size){
            for(int j=i;j<i+size;j++) {
                set.add(board.get(j));
            }
            if(set.size() == 1) return true;
            set = new HashSet<Character>();
        }
        return false;
    }

    private boolean checkColWinningStrategy() {
        Set<Character> set = new HashSet<Character>();
        for (int j=0;j<size;j++){
            for(int i=j;i<board.size();i = i+size){
                set.add(board.get(i));
            }
            if(set.size() == 1) return true;
            set = new HashSet<Character>();
        }
        return false;
    }
}
