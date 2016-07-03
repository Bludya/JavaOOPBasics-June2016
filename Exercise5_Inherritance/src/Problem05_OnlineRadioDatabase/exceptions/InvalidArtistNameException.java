package Problem05_OnlineRadioDatabase.exceptions;

/**
 * Created by Bludya on 2.7.2016 г..
 * All rights reserved!
 */
public class InvalidArtistNameException extends InvalidSongException{
    private static final String msg = "Artist name should be between 3 and 20 symbols.";

    public InvalidArtistNameException() {
        super(msg);
    }
}
