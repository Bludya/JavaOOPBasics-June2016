package Problem05_OnlineRadioDatabase;

import Problem05_OnlineRadioDatabase.exceptions.InvalidSongException;
import Problem05_OnlineRadioDatabase.models.Song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bludya on 2.7.2016 г..
 * All rights reserved!
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Song> songs = new ArrayList<>();
        int totalTime = 0;
        for (int i = 0; i < n; i++) {
            String[] songString = reader.readLine().split(";");
            if(songString.length < 3){
                throw new InvalidSongException();
            }
            String artist = songString[0];
            String songName = songString[1];
            String[] time = songString[2].split(":");
            try{
                int minutes = Integer.parseInt(time[0]);
                int seconds = Integer.parseInt(time[1]);
                Song song = new Song(artist, songName, minutes, seconds);
                songs.add(song);
                totalTime += song.getTotalTime();
                System.out.println("Song added.");
            }catch (NumberFormatException e){
                System.out.println("Invalid song length.");
            }catch (InvalidSongException e){
                System.out.println(e.getMessage());
            }

        }
        System.out.printf("Songs added: %d%n", songs.size());
        System.out.printf("Playlist length: %dh %dm %ds%n", totalTime / 3600, (totalTime % 3600) / 60, totalTime % 60);

    }
}
