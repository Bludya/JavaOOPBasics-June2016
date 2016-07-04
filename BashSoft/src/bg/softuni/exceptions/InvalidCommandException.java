package bg.softuni.exceptions;

/**
 * Created by Bludya on 4.7.2016 г..
 * All rights reserved!
 */
public class InvalidCommandException extends RuntimeException {
    private static final String INVALID_COMMAND = "The command '%s' is invalid";

    public InvalidCommandException(String message) {
        super(String.format(INVALID_COMMAND, message));
    }
}
