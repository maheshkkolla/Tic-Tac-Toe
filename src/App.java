import java.util.Scanner;

/**
 * Created by maheshkk on 3/27/2015.
 */
public class App {

    Game game;
    public App(Game game){
        this.game = game;
    }

    public void run() {
        System.out.println(game.getPrintableBoard());
        char player = 'X';
        while(true){
            try{
                playByTurn(game, player);
                player = (player == 'X') ? 'O' : 'X';
            }catch(InvalidPositionException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void playByTurn(Game game,char playerSymbol) throws InvalidPositionException {
        System.out.println("Player: " + playerSymbol);
        System.out.println("Select the position where you want to put: ");
        Scanner scanner = new Scanner(System.in);
        if(game.putValueInCell(scanner.nextInt(),playerSymbol)){
            System.out.println(game.getPrintableBoard());
            System.out.println("Player: "+playerSymbol+" Won");
            System.exit(0);
        }
        System.out.println(game.getPrintableBoard());
    }
}
