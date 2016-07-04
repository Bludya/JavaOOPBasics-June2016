package bg.softuni.exceptions;

/**
 * Created by Bludya on 4.7.2016 г..
 * All rights reserved!
 */
public class InvalidFileNameException extends RuntimeException {
    private static final String FORBIDDEN_SYMBOLS_CONTAINED_IN_NAME =
            "The given name contains symbols that are not allowed to be used in names of files or folders.";

    public InvalidFileNameException() {
        super(FORBIDDEN_SYMBOLS_CONTAINED_IN_NAME);
    }

    protected InvalidFileNameException(String message) {
        super(message);
    }
}
