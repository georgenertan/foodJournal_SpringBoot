package itSchool.com.foodjournal.exceptions;

public class ElementDoesntExistException extends RuntimeException{
    public ElementDoesntExistException(String message) {
        super(message);
    }
}
