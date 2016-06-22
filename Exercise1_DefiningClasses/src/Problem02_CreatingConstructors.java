import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

/**
 * Created by Bludya on 22.6.2016 г..
 * All rights reserved!
 */

//Renamed to Person2, so that there is no error for already existing Person class from Problem1.

class Person2{
    String name;
    int age;

    public Person2(){
        this(1);
    }

    public Person2(int age){
        this("No name",age);
    }

    public Person2(String name, int age){
        this.name = name;
        this.age = age;
    }
}
public class Problem02_CreatingConstructors {
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        Class personClass = Person2.class;
        Constructor emptyCtor = personClass.getDeclaredConstructor();
        Constructor ageCtor = personClass.getDeclaredConstructor(int.class);
        Constructor nameAgeCtor = personClass
                .getDeclaredConstructor(String.class, int.class);

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        Person2 basePerson = (Person2) emptyCtor.newInstance();
        Person2 personWithAge = (Person2) ageCtor.newInstance(age);
        Person2 personFull = (Person2) nameAgeCtor.newInstance(name, age);

        System.out.printf("%s %s%n", basePerson.name, basePerson.age);
        System.out.printf("%s %s%n", personWithAge.name, personWithAge.age);
        System.out.printf("%s %s%n", personFull.name, personFull.age);
    }

}
