package Problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem06_FootballTeamGenerator {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, Team> teams = new HashMap<>();
    public static void main(String[] args) throws IOException{


        String[] input = reader.readLine().split(";");
        while(!"END".equals(input[0])){
            try {
                switch (input[0]) {
                    case "Team":
                        Team team = tryMakeTeam(input);
                        teams.put(team.getName(), team);
                        break;
                    case "Add":
                        tryAddPlayer(input);
                        break;
                    case "Remove":
                        tryRemovePlayer(input);
                        break;
                    case "Rating":
                        tryShowRating(input);
                        break;
                }
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            input = reader.readLine().split(";");
        }

    }

    private static void tryShowRating(String[] input) {
        String teamName = input[1];
        if(teams.containsKey(teamName)){
            System.out.println(teams.get(teamName));
        }
        else{
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }
    }

    private static void tryRemovePlayer(String[] input) throws IllegalArgumentException{
        String team = input[1];
        String playerName = input[2];

        if(teams.containsKey(team)){
            teams.get(team).removePlayer(playerName);
        }
        else {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", team));
        }
    }

    private static Player tryAddPlayer(String[] input) throws IllegalArgumentException{
        String team = input[1];
        String name = input[2];
        int endurance = Integer.valueOf(input[3]);
        int sprint = Integer.valueOf(input[4]);
        int dribble = Integer.valueOf(input[5]);
        int passing = Integer.valueOf(input[6]);
        int shooting = Integer.valueOf(input[7]);
        Player player = new Player(name, endurance, sprint, dribble, passing, shooting);

        if(teams.containsKey(team)){
            teams.get(team).addPlayer(player);
        }
        else{
            throw new IllegalArgumentException(String.format("Team %s does not exist.", team));
        }

        return player;
    }

    private static Team tryMakeTeam(String[] input) throws IllegalArgumentException{
        String name = input[1];
        return new Team(name);
    }
}
