
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Bludya on 22.6.2016 г..
 * All rights reserved!
 */

class Pokemon{
    String name;
    String element;
    int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public boolean damage(int amount) {
        health -= amount;
        return health > 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

}

class Trainer implements Comparable<Trainer>{
    protected int damageAmount = 10;
    String name;
    int badges;
    List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public void tournament(String element) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.element.equals(element)) {
                badges++;
                return;
            }
        }
        pokemons.forEach(pokemon -> pokemon.damage(damageAmount));

        pokemons = pokemons.stream().filter(pokemon -> pokemon.health > 0).collect(Collectors.toList());
    }

    @Override
    public int compareTo(Trainer trainer){
        return Integer.compare(trainer.badges, this.badges);
    }

    @Override
    public String toString(){
        return String.format("%s %d %d", name, badges, pokemons.size());
    }

}

public class Problem08_PokemonTrainer {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String[] line = reader.readLine().split("\\s+");

        while(!"Tournament".equals(line[0])){
            String trainer = line[0];
            String pokemon = line[1];
            String element = line[2];
            int health = Integer.valueOf(line[3]);

            if(!trainers.containsKey(trainer)) {
                trainers.put(trainer, new Trainer(trainer));
            }
            trainers.get(trainer).addPokemon(new Pokemon(pokemon, element, health));
            line = reader.readLine().split("\\s+");
        }

        String element = reader.readLine();

        while(!"End".equals(element)){
            for(Trainer trainer : trainers.values()){
                trainer.tournament(element);
            }
            element = reader.readLine();
        }

        trainers.values().stream().sorted().forEach(System.out::println);

    }

}
