package Problem03_WildFarm.animals;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class Cat extends Feline {
    private static final String sound = "Meowwww";
    String breed;

    public Cat(String name, String type, String breed, Double weight, String livingRegion) {
        super(name, type, weight, sound, livingRegion);
        this.setBreed(breed);
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString(){
        NumberFormat format = DecimalFormat.getInstance();
        format.setMinimumFractionDigits(0);

        return String.format("%s[%s, %s, %s, %s, %d]", type, name, breed, format.format(weight), livingRegion, foodEaten);
    }
}
