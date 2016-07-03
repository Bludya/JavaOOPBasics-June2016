package Problem05_OnlineRadioDatabase.exceptions;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class InvalidSongSecondsException extends InvalidSongLengthException{
    private static final String msg = "Song seconds should be between 0 and 59.";

    public InvalidSongSecondsException() {
        super(msg);
    }
}
