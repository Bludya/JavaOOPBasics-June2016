package Problem04_MordorsCrueltyPlan.factories;

import Problem04_MordorsCrueltyPlan.foods.*;

/**
 * Created by Bludya on 2.7.2016 г..
 * All rights reserved!
 */
public class FoodFactory{
    public static Food produceFood(String food){
        switch (food.toLowerCase()){
            case "cram":
                return new Cram();
            case "lembas":
                return new Lembas();
            case "apple":
                return new Apple();
            case "melon":
                return new Melon();
            case "honeycake":
                return new HoneyCake();
            case "mushrooms":
                return new Mushrooms();
            default:
                return new Else();
        }
    }

}
