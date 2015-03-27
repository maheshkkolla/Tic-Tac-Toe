/**
 * Created by maheshkk on 3/26/2015.
 */
public class InvalidPositionException extends Exception {
    public InvalidPositionException(String type) {
        super("Position is "+type);
    }
}
