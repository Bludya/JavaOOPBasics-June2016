package Problem03_WildFarm.animals;

import Problem03_WildFarm.foods.Food;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public abstract class Animal {
    String name;
    String type;
    String sound;
    Double weight;
    int foodEaten;

    public Animal(String name, String type, Double weight, String sound) {
        this.setName(name);
        this.setType(type);
        this.setWeight(weight);
        this.setSound(sound);
    }

    private String getSound() {
        return sound;
    }

    private void setSound(String sound) {
        this.sound = sound;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    private Double getWeight() {
        return weight;
    }

    private void setWeight(Double weight) {
        this.weight = weight;
    }

    private int getFoodEaten() {
        return foodEaten;
    }

    private void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public void makeSound(){
        System.out.println(sound);
    }

    public void eatFood(Food food){

        foodEaten = food.getQuantity();
    }

}
