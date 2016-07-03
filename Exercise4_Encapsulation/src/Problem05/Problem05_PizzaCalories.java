package Problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Bludya on 1.7.2016 г..
 * All rights reserved!
 */

class Dough{
    private final double WHITE = 1.5;
    private final double WHOLEGRAIN = 1.0;
    private final double CRISPY = 0.9;
    private final double CHEWY = 1.1;
    private final double HOMEMADE = 1.0;

    private String flour;
    private String bakingTechnique;
    private int weight;

    public Dough(String flour, String bakingTechnique, int weight) throws IllegalArgumentException{
        this.setFlour(flour);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setBakingTechnique(String bakingTechnique) throws IllegalArgumentException{
        if(!bakingTechnique.toLowerCase().equals("crispy")
                && !bakingTechnique.toLowerCase().equals("chewy")
                && !bakingTechnique.toLowerCase().equals("homemade")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setFlour(String flour) throws IllegalArgumentException{
        if(!flour.toLowerCase().equals("white") && !flour.toLowerCase().equals("wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flour = flour;
    }

    private void setWeight(int weight) throws IllegalArgumentException{
        if(weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double getCalories(){
        double flourModifier;
        double bakingModifier;

        switch (flour.toLowerCase()){
            case "white":
                flourModifier = WHITE;
                break;
            case "wholegrain":
                flourModifier = WHOLEGRAIN;
                break;
            default:
                flourModifier = 1;
                break;
        }

        switch (bakingTechnique.toLowerCase()){
            case "crispy":
                bakingModifier = CRISPY;
                break;
            case "chewy":
                bakingModifier = CHEWY;
                break;
            case "homemade":
                bakingModifier = HOMEMADE;
                break;
            default:
                bakingModifier = 1;
                break;
        }

        return 2 * weight * bakingModifier * flourModifier;
    }

    @Override
    public String toString(){
        return String.format("%.2f", getCalories());
    }
}

class Topping{
    private final double MEAT = 1.2;
    private final double VEGGIES = 0.8;
    private final double CHEESE = 1.1;
    private final double SAUCE = 0.9;

    private String type;
    private int weight;

    public Topping(String type, int weight) throws IllegalArgumentException{
        this.setType(type);
        this.setWeight(weight);
    }

    private void setWeight(int weight) throws IllegalArgumentException {
        if(weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", type));
        }
        this.weight = weight;
    }

    private void setType(String type) throws IllegalArgumentException {
        if(!type.toLowerCase().equals("meat")
                && !type.toLowerCase().equals("veggies")
                && !type.toLowerCase().equals("cheese")
                && !type.toLowerCase().equals("sauce")){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",type));
        }
        this.type = type;
    }

    public double getCalories(){
        double modifier;
        switch (type.toLowerCase()){
            case "meat":
                modifier = MEAT;
                break;
            case "veggies":
                modifier = VEGGIES;
                break;
            case "cheese":
                modifier = CHEESE;
                break;
            case "sauce":
                modifier = SAUCE;
                break;
            default:
                modifier = 1;
                break;
        }

        return weight * 2 * modifier;
    }

    @Override
    public String toString(){
        return String.format("%.2f", getCalories());
    }

}

class Pizza{
    private final int MAX_TOPPINGS = 10;

    private String name;
    private Dough dough;
    private int numberOfToppings;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings){
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
        this.setToppings();
    }

    public void setNumberOfToppings(int numberOfToppings) {
        if(numberOfToppings > MAX_TOPPINGS){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    private void setName(String name) throws IllegalArgumentException{
        if(name == null || name.trim().length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings() {
        this.toppings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getCalories(){
        double calories = dough.getCalories();
        for(Topping topping : toppings){
            calories += topping.getCalories();
        }
        return calories;
    }

    public int getToppingsCount(){
        return toppings.size();
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    @Override
    public String toString(){
        return String.format("%s - %.2f Calories.", name, getCalories());
    }
}

public class Problem05_PizzaCalories {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        try {


            String[] info = reader.readLine().split("\\s+");

            while(!"END".equals(info[0])){
                switch (info[0]){
                    case "Pizza":
                        Pizza pizza = tryMakePizza(info);
                        System.out.println(pizza);
                        break;
                    case "Dough":
                        Dough dough = tryMakeDough(info);
                        System.out.println(dough);
                        break;
                    case "Topping":
                        Topping topping = tryMakeTopping(info);
                        System.out.println(topping);
                        break;
                }
                info = reader.readLine().split("\\s+");
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static Topping tryMakeTopping(String[] info) {
        String toppingType = info[1];
        int toppingWeight = Integer.valueOf(info[2]);

        Topping topping = new Topping(toppingType, toppingWeight);
        return topping;
    }

    private static Dough tryMakeDough(String[] info) throws IllegalArgumentException{
        String doughFlour = info[1];
        String doughBakingTechnique = info[2];
        int doughWeight = Integer.valueOf(info[3]);

        Dough dough = new Dough(doughFlour, doughBakingTechnique, doughWeight);
        return dough;
    }

    private static Pizza tryMakePizza(String[] info) throws Exception{
        String pizzaName = info[1];
        int toppingCount = Integer.valueOf(info[2]);

        Pizza pizza = new Pizza(pizzaName, toppingCount);

        info = reader.readLine().split("\\s+");
        Dough dough = tryMakeDough(info);
        pizza.setDough(dough);

        for (int i = 0; i < toppingCount; i++) {
            info = reader.readLine().split("\\s+");
            Topping topping = tryMakeTopping(info);
            pizza.addTopping(topping);
        }

        return pizza;
    }
}
