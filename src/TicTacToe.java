import java.util.Scanner;

/**
 * Created by maheshkk on 3/26/2015.
 */
public class TicTacToe {

    public static void main(String[] args) {
        Game game = new Game(3);
        game.create();
        System.out.println(game.getPrintableBoard());
        while(true){
            try{
                playByTurn(game, 'X');
                playByTurn(game, 'O');
            }catch(InvalidPositionException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void playByTurn(Game game,char playerSymbol) throws InvalidPositionException {
        System.out.println("Player: " + playerSymbol);
        Scanner scanner = new Scanner(System.in);
        if(game.putValueInCell(scanner.nextInt(),playerSymbol)){
            System.out.println(game.getPrintableBoard());
            System.out.println("Player: "+playerSymbol+" Won");
            System.exit(0);
        }
        System.out.println(game.getPrintableBoard());
    }

}
