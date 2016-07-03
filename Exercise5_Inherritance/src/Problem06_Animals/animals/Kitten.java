package Problem06_Animals.animals;

import Problem06_Animals.interfaces.SoundProducible;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class Kitten extends Cat implements SoundProducible {
    private final static String defaultGender = "Female";
    private final String sound = "Miau";

    public Kitten(String name, int age) {
        super(name, age, defaultGender);
    }

    @Override
    public String produceSound(){
        return sound;
    }
}
