package Problem05_OnlineRadioDatabase.exceptions;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class InvalidSongLengthException extends InvalidSongException {
    private static final String msg = "Invalid song length.";

    public InvalidSongLengthException() {
        super(msg);
    }
    protected InvalidSongLengthException(String msg) {
        super(msg);
    }
}
