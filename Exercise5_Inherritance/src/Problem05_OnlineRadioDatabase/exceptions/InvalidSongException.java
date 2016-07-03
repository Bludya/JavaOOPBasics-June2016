package Problem05_OnlineRadioDatabase.exceptions;

/**
 * Created by Bludya on 2.7.2016 г..
 * All rights reserved!
 */
public class InvalidSongException extends RuntimeException {
    private static final String msg = "Invalid song.";

    public InvalidSongException() {
        super(msg);
    }
    protected InvalidSongException(String msg) {
        super(msg);
    }
}
