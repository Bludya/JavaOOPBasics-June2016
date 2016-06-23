import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bludya on 23.6.2016 г..
 * All rights reserved!
 */

class Cat{
    String name;

    public Cat(String name){
        this.name = name;
    }
}

class Siamese extends Cat{
    String earSize;
    public Siamese(String name, String earSize){
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString(){
        return String.format("Siamese %s %s", name, earSize);
    }

}
class Cymric extends Cat{
    String furLength;

    public Cymric(String name, String furLength){
        super(name);
        this.furLength = furLength;
    }
    @Override
    public String toString(){
        return String.format("Cymric %s %s", name, furLength);
    }

}
class StreetExtraordinaire extends Cat{
    String decibelsOfMeows;
    public StreetExtraordinaire(String name, String decibelsOfMeows){
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }
    @Override
    public String toString(){
        return String.format("StreetExtraordinaire %s %s", name, decibelsOfMeows);
    }

}

public class Problem11_CatLady {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Cat> cats = new HashMap<>();

        String[] line = reader.readLine().split("\\s+");

        while(!"End".equals(line[0])){
            String breed = line[0];
            String name = line[1];
            String asset = line[2];

            switch (breed){
                case "Siamese":
                    cats.put(name, new Siamese(name, asset));
                    break;
                case "Cymric":
                    cats.put(name, new Cymric(name, asset));
                    break;
                case "StreetExtraordinaire":
                    cats.put(name, new StreetExtraordinaire(name, asset));
                    break;
                default:
                    break;
            }
            line = reader.readLine().split("\\s+");
        }
        String name = reader.readLine();
        System.out.println(cats.get(name));

    }
}
