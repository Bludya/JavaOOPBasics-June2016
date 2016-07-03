package Problem04_MordorsCrueltyPlan.factories;

import Problem04_MordorsCrueltyPlan.foods.Food;

import java.util.List;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class MoodFactory {
    public static String produceMood(List<Food> foods){
        int amountOfHappiniess = 0;

        for (Food food : foods) {
            amountOfHappiniess += food.getAmount();
        }

        if(amountOfHappiniess < -5){
            return amountOfHappiniess + "\n" + "Angry";
        }
        else if (amountOfHappiniess < 0){
            return amountOfHappiniess + "\n" + "Sad";
        }
        else if (amountOfHappiniess < 15){
            return amountOfHappiniess + "\n" + "Happy";
        }
        else{
            return amountOfHappiniess + "\n" + "JavaScript";
        }
    }
}
