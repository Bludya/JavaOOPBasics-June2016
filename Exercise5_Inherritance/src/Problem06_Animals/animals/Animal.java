package Problem06_Animals.animals;

import Problem06_Animals.interfaces.SoundProducible;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class Animal implements SoundProducible {
    private String name;
    private int age;
    private String gender;

    private final String sound = "Not implemented!";

    public Animal(String name, int age, String gender) throws IllegalArgumentException{
            this.setName(name);
            this.setAge(age);
            this.setGender(gender);
    }

    private void setName(String name) {
        if(name == null || name.trim().length() == 0){
            throw new IllegalArgumentException("Invalid input");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if(age < 1){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private void setGender(String gender) {
        if(gender == null || (!"male".equals(gender.toLowerCase()) && !"female".equals(gender.toLowerCase()))){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String produceSound(){
        return sound;
    }

    @Override
    public String toString(){
        return String.format("%s %d %s%n%s", name, age, gender, this.produceSound());
    }
}
