package Problem05_OnlineRadioDatabase.exceptions;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class InvalidSongMinutesException extends InvalidSongLengthException {
    private static final String msg = "Song minutes should be between 0 and 14.";

    public InvalidSongMinutesException() {
        super(msg);
    }
}
