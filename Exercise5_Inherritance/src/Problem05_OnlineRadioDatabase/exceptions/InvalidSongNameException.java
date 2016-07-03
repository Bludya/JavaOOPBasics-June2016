package Problem05_OnlineRadioDatabase.exceptions;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class InvalidSongNameException extends InvalidSongException{
    private static final String msg = "Song name should be between 3 and 30 symbols.";

    public InvalidSongNameException() {
        super(msg);
    }
}
