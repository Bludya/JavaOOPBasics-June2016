package bg.softuni.exceptions;

/**
 * Created by Bludya on 4.7.2016 г..
 * All rights reserved!
 */
public class InvalidStringException extends RuntimeException {
    private static final String NULL_OR_EMPTY_VALUE = "The value of the variable CANNOT be null or empty!";

    public InvalidStringException() {
        super(NULL_OR_EMPTY_VALUE);
    }

    protected InvalidStringException(String message) {
        super(message);
    }
}
