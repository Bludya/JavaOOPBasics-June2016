package bg.softuni.exceptions;

/**
 * Created by Bludya on 4.7.2016 г..
 * All rights reserved!
 */
public class KeyNotFoundException extends RuntimeException {
    private static final String NOT_ENROLLED_IN_COURSE = "Student must be enrolled in a course before you set his mark.";

    public KeyNotFoundException() {
        super(NOT_ENROLLED_IN_COURSE);
    }

    protected KeyNotFoundException(String message) {
        super(message);
    }
}
