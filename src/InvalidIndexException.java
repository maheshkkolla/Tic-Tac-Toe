/**
 * Created by maheshkk on 3/26/2015.
 */
public class InvalidIndexException extends Exception {
    public InvalidIndexException(String type) {
        super("Index is "+type);
    }
}
