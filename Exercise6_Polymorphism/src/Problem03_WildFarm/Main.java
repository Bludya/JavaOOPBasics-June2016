package Problem03_WildFarm;

import Problem03_WildFarm.animals.*;
import Problem03_WildFarm.foods.Food;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String[] info = reader.readLine().split("\\s+");
            if("End".equals(info[0])){
                break;
            }

            String animalType = info[0];
            String animalName = info[1];
            double animalWeight = Double.parseDouble(info[2]);
            String livingRegion = info[3];
            Animal animal = null;

            switch (animalType){
                case "Cat":
                    String breed = info[4];
                    animal = new Cat(animalName,animalType, breed, animalWeight, livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, animalType, animalWeight, livingRegion);
                    break;
                case "Mouse":
                    animal = new Mouse(animalName, animalType, animalWeight, livingRegion);
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, animalType, animalWeight, livingRegion);
                    break;
            }

            info = reader.readLine().split("\\s+");
            String type = info[0];
            int amount = Integer.parseInt(info[1]);

            Class<?> clazz = Class.forName("Problem03_WildFarm.foods." + type);
            Constructor<?> constructor = clazz.getConstructor(int.class);
            Food food = (Food)constructor.newInstance(amount);

            animal.makeSound();

            if (animal != null) {
                animal.eatFood(food);
            }

            System.out.println(animal);
        }
    }
}
