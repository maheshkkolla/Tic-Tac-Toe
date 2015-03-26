import java.util.Scanner;

/**
 * Created by maheshkk on 3/26/2015.
 */
public class TicTacToe {

    public static void main(String[] args) {
        Board board = new Board(3,3);
        board.create();
        System.out.println(board.asPrintable());
        Scanner scanner = new Scanner(System.in);
        while(true){
            playByTurn(board, "X");
            playByTurn(board, "O");
        }
    }

    private static void playByTurn(Board board,String playerSymbol) {
        System.out.println("Player: "+playerSymbol);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Row Number: ");
        int rowId = scanner.nextInt();
        System.out.println("Enter Col Number: ");
        int colId = scanner.nextInt();
        board.putValueInCell(rowId, colId,playerSymbol);
        System.out.println(board.asPrintable());
    }

}
