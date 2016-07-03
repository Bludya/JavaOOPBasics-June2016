package Problem06_Animals.animals;

import Problem06_Animals.interfaces.SoundProducible;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class Tomcat extends Cat implements SoundProducible{
    private static final String defaultGender = "Male";
    private final String sound = "Give me one million b***h";

    public Tomcat(String name, int age) {
        super(name, age, defaultGender);
    }

    @Override
    public String produceSound(){
        return sound;
    }
}
