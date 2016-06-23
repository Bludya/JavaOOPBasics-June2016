import java.lang.reflect.Field;

/**
 * Created by Bludya on 22.6.2016 г..
 * All rights reserved!
 */

class Person{
    String name;
    Integer age;

    public Person(){
        this("No_Name", 0);
    }

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}

public class Problem01_DefineAClassPerson {
        public static void main(String[] args) throws Exception {
            Person pesho = new Person();
            pesho.age = 20;
            pesho.name = "Pesho";

            Person gosho = new Person("Gosho",18);
            Person stamat = new Person("Stamat",43);


            Class person = Person.class;
            Field[] fields = person.getDeclaredFields();
            System.out.println(fields.length);
        }
}
