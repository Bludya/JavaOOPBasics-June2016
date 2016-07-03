package Problem06_Animals;

import Problem06_Animals.animals.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String animal = reader.readLine();

            while (animal != null && !"Beast!".equals(animal)) {
                try {
                String[] animalInfo = reader.readLine().split("\\s+");
                String name = animalInfo[0];
                int age = Integer.parseInt(animalInfo[1]);
                String gender;

                Animal newAnimal = null;

                switch (animal.toLowerCase()) {
                    case "dog":
                        gender = animalInfo[2];
                        newAnimal = new Dog(name, age, gender);
                        break;
                    case "frog":
                        gender = animalInfo[2];
                        newAnimal = new Frog(name, age, gender);
                        break;
                    case "cat":
                        gender = animalInfo[2];
                        newAnimal = new Cat(name, age, gender);
                        break;
                    case "kitten":
                        newAnimal = new Kitten(name, age);
                        break;
                    case "tomcat":
                        newAnimal = new Tomcat(name, age);
                        break;
                }
                if (newAnimal != null) {
                    System.out.println(animal);
                    System.out.println(newAnimal.toString());
                }


                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
                animal = reader.readLine();
            }

    }
}
