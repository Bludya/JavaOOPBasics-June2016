package bg.softuni.exceptions;

/**
 * Created by Bludya on 4.7.2016 г..
 * All rights reserved!
 */
public class InvalidPathException extends RuntimeException {
    private static final String INVALID_PATH = "The source does not exist.";

    public InvalidPathException() {
        super(INVALID_PATH);
    }

    protected InvalidPathException(String message) {
        super(message);
    }
}
