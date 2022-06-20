package itSchool.com.foodjournal.exceptions;

public class ElementAlreadyExistsException extends RuntimeException{
    public ElementAlreadyExistsException(String message) {
        super(message);
    }
}
