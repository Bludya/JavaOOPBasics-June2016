import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Bludya on 28.6.2016 г..
 * All rights reserved!
 */

class Person{
    private String name;

    public Person(String name){
        this.name = name;
    }

    public String printGreeting(){
        return this.name + " says \"Hello\"!";
    }
}
public class Problem01_MethodSaysHello{
    public static void main(String[] args) throws Exception{
        Field[] fields = Person.class.getDeclaredFields();
        Method[] methods = Class.forName("Person").getDeclaredMethods();
        if (fields.length != 1 || methods.length != 1) {
            throw new ClassFormatError();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = new Person(reader.readLine());

        System.out.println(person.printGreeting());

    }
}
