package Problem06;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
class Team{
    private String name;
    private int numberOfPlayers;
    private double rating;
    private Map<String, Player> players;

    public Team(String name) throws IllegalArgumentException{
        this.setName(name);
        this.players = new HashMap<>();
    }

    private void setName(String name) throws IllegalArgumentException{
        if(name == null || name.trim().length() == 0){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player){
        numberOfPlayers++;
        rating += player.getAverageRating();
        players.put(player.getName(), player);
    }

    public void removePlayer(String playerName) throws IllegalArgumentException{
        if(!players.containsKey(playerName)){
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, name));
        }
        numberOfPlayers--;
        rating -= players.get(playerName).getAverageRating();
        players.remove(playerName);
    }

    @Override
    public String toString(){
        return String.format("%s - %.0f", name, rating);
    }
}
