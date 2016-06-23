import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bludya on 23.6.2016 г..
 * All rights reserved!
 */

class Company{
    String name;
    String department;
    double salary;
    public Company(String name, String department, double salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return String.format("%s %s %.2f", name, department, salary);
    }
}
class Pokemon1{
    String name;
    String type;

    public Pokemon1(String name, String type){
        this.name = name;
        this.type = type;
    }
    @Override
    public String toString(){
        return String.format("%s %s", name, type);
    }
}
class Parent{
    String name;
    String birthday;

    public Parent(String name, String birthday){
        this.name = name;
        this. birthday = birthday;
    }
    public String toString(){
        return String.format("%s %s", name, birthday);
    }
}
class Child{
    String name;
    String birthday;

    public Child(String name, String birthday){
        this.name = name;
        this.birthday = birthday;
    }
    public String toString(){
        return String.format("%s %s", name, birthday);
    }
}
class Car3{
    String model;
    int speed;

    public Car3(String model, int speed){
        this.model = model;
        this.speed = speed;
    }
    public String toString(){
        return String.format("%s %d", model, speed);
    }
}

class Person1{
    String name;
    Company company;
    Car3 car;
    List<Pokemon1> pokemons;
    List<Parent> parents;
    List<Child> children;

    public Person1(String name){
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String toString(){
        String output = String.format("%s%n", name);
        output += String.format("Company:%n");
        if(company != null){
            output += company + "\n";
        }
        output += String.format("Car:%n");
        if(car != null){
            output += car + "\n";
        }
        output += String.format("Pokemon:%n");
        for(Pokemon1 pokemon : pokemons) {
            output += String.format("%s%n", pokemon);
        }
        output += String.format("Parents:%n");
        for(Parent parent : parents){
            output += String.format("%s%n", parent);
        }
        output += String.format("Children:%n");
        for(Child child : children){
            output += String.format("%s%n", child);
        }
        return output;

    }
}

public class Problem09_Google {
    public static void main(String[] args) throws IOException{
        Map<String, Person1> peopple = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split("\\s+");
        while(!"End".equals(line[0])){
            String name = line[0];
            String asset = line[1];

            if(!peopple.containsKey(name)){
                peopple.put(name, new Person1(name));
            }

            if("company".equals(asset)){
                String companyName = line[2];
                String department = line[3];
                double salary = Double.valueOf(line[4]);
                peopple.get(name).company = new Company(companyName, department, salary);
            }
            else if("pokemon".equals(asset)){
                String pokemonName = line[2];
                String pokemonType = line[3];

                peopple.get(name).pokemons.add(new Pokemon1(pokemonName, pokemonType));
            }
            else if("parents".equals(asset)){
                String parentName = line[2];
                String parentBirthday = line[3];

                peopple.get(name).parents.add(new Parent(parentName, parentBirthday));
            }
            else if("children".equals(asset)){
                String childName = line[2];
                String childBirthday = line[3];

                peopple.get(name).children.add(new Child(childName, childBirthday));
            }
            else if("car".equals(asset)){
                String carModel = line[2];
                int carSpeed = Integer.valueOf(line[3]);

                peopple.get(name).car = new Car3(carModel, carSpeed);
            }
            line = reader.readLine().split("\\s+");
        }

        String name = reader.readLine();

        System.out.print(peopple.get(name));
    }
}
