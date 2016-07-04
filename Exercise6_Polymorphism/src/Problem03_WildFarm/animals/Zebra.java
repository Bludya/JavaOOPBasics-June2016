package Problem03_WildFarm.animals;

import Problem03_WildFarm.foods.Food;
import Problem03_WildFarm.foods.Vegetable;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class Zebra extends Mammal{
    private final static String sound = "Zs";

    public Zebra(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, sound, livingRegion);
    }
    @Override
    public void eatFood(Food food){
        if(food instanceof Vegetable){
            super.eatFood(food);
            return;
        }
        System.out.println("Zebras are not eating that type of food!");
    }
}
