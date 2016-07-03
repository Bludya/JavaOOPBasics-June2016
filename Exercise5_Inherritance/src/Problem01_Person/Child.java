package Problem01_Person;

/**
 * Created by Bludya on 2.7.2016 г..
 * All rights reserved!
 */
public class Child extends Person{
    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    protected void setAge(int age){
        if(age > 15){
            throw new IllegalArgumentException(Exceptions.OLD_TO_BE_CHILD);
        }
        super.setAge(age);
    }


}
