package Problem03_WildFarm.animals;

import Problem03_WildFarm.foods.Food;
import Problem03_WildFarm.foods.Meat;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class Tiger extends Feline {
    private static final String sound = "ROAAR!!!";
    String livingRegion;

    public Tiger(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, sound, livingRegion);
        this.setLivingRegion(livingRegion);
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public void eatFood(Food food){
        if(food instanceof Meat){
            super.eatFood(food);
            return;
        }
        System.out.println("Tigers are not eating that type of food!");
    }
}
