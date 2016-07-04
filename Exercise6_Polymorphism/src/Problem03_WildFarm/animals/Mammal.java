package Problem03_WildFarm.animals;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public abstract class Mammal extends Animal{
    String livingRegion;

    public Mammal(String name, String type, Double weight, String sound, String livingRegion) {
        super(name, type, weight, sound);
        this.livingRegion = livingRegion;
    }
    @Override
    public String toString(){
        NumberFormat format = DecimalFormat.getInstance();
        format.setMinimumFractionDigits(0);

        return String.format("%s[%s, %s, %s, %d]", type, name, format.format(weight), livingRegion, foodEaten);
    }
}
