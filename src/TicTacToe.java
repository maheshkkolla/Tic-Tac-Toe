import java.util.Scanner;

/**
 * Created by maheshkk on 3/26/2015.
 */
public class TicTacToe {

    public static void main(String[] args) {
        Game game = new Game(Integer.parseInt(args[0]));
        App app = new App(game);
        app.run();
    }




}
