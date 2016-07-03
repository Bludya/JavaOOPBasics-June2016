package Problem01_Person;

/**
 * Created by Bludya on 2.7.2016 г..
 * All rights reserved!
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.length() <= 3){
            throw new IllegalArgumentException(Exceptions.SMALL_NAME);
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    protected void setAge(int age) {
        if(age < 1){
            throw new IllegalArgumentException(Exceptions.NEGATIVE_AGE);
        }
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s, Age: %d",
                this.getName(),
                this.getAge()));

        return stringBuilder.toString();
    }
}
