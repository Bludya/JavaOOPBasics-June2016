package Problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Bludya on 30.6.2016 г..
 * All rights reserved!
 */
class Animal{
    private String name;
    private String breed;

    public Animal(String name, String breed){
        this.name = name;
        this.breed = breed;
        AnimalClinic.patientID++;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }
}

class AnimalClinic{
    static int patientID;
    static int healedAnimalsCount;
    static int rehabilitedAnimalsCount;

    static{
        patientID = 0;
        healedAnimalsCount = 0;
        rehabilitedAnimalsCount  = 0;
    }
}
public class Problem05_AnimalClinic {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Animal>> animals = new LinkedHashMap<>();
        animals.put("heal", new ArrayList<>());
        animals.put("rehabilitate", new ArrayList<>());

        String[] command = reader.readLine().split("\\s+");

        while(!"End".equals(command[0])){
            String name = command[0];
            String breed = command[1];
            String action = command[2];

            Animal newAnimal = new Animal(name, breed);
            animals.get(action).add(newAnimal);

            if("heal".equals(action)){
                AnimalClinic.healedAnimalsCount++;
                System.out.printf("Patient %d: [%s (%s)] has been healed!%n", AnimalClinic.patientID, newAnimal.getName(), newAnimal.getBreed());
            }
            else if("rehabilitate".equals(action)){
                AnimalClinic.rehabilitedAnimalsCount++;
                System.out.printf("Patient %d: [%s (%s)] has been rehabilitated!%n", AnimalClinic.patientID, newAnimal.getName(), newAnimal.getBreed());
            }
            command = reader.readLine().split("\\s+");
        }
        System.out.printf("Total healed animals: %d%n", AnimalClinic.healedAnimalsCount);
        System.out.printf("Total rehabilitated animals: %d%n", AnimalClinic.rehabilitedAnimalsCount);
        String action = reader.readLine();

        animals.get(action).forEach(animal -> System.out.println(animal.getName() + " " + animal.getBreed()));

    }
}
