package Problem05_OnlineRadioDatabase.models;

import Problem05_OnlineRadioDatabase.exceptions.*;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class Song {
    private String name;
    private String artist;
    private int minutes;
    private int seconds;

    public Song(String artist, String name, int minutes, int seconds) throws InvalidSongException{
        this.setArtist(artist);
        this.setName(name);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    private void setName(String name)  throws InvalidSongException{
        if(name == null || name.trim().length() < 3 || name.trim().length() > 30){
            throw new InvalidSongNameException();
        }
        this.name = name;
    }

    private void setArtist(String artist)  throws InvalidSongException{
        if(artist == null || artist.trim().length() < 3 || artist.trim().length() > 20){
            throw new InvalidArtistNameException();
        }
        this.artist = artist;
    }

    private void setMinutes(int minutes)  throws InvalidSongLengthException{
        if(minutes < 0 || minutes > 14){
            throw new InvalidSongMinutesException();
        }
        this.minutes = minutes;
    }

    private void setSeconds(int seconds)  throws InvalidSongLengthException{
        if(seconds < 0 || seconds > 59){
            throw new InvalidSongSecondsException();
        }
        this.seconds = seconds;
    }


    public int getTotalTime() {
        return minutes * 60 + seconds;
    }
}
