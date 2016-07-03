package Problem06_Animals.animals;

import Problem06_Animals.interfaces.SoundProducible;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class Dog extends Animal implements SoundProducible {
    private final String sound = "BauBau";

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound(){
        return sound;
    }
}
