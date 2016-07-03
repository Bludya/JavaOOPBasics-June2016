package Problem04_MordorsCrueltyPlan;

import Problem04_MordorsCrueltyPlan.factories.FoodFactory;
import Problem04_MordorsCrueltyPlan.factories.MoodFactory;
import Problem04_MordorsCrueltyPlan.foods.Food;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Food> foods = new ArrayList<>();
        String[] foodStrings = reader.readLine().split("\\s+");

        for(String food : foodStrings){
            foods.add(FoodFactory.produceFood(food));
        }

        System.out.println(MoodFactory.produceMood(foods));
    }
}
