import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bludya on 22.6.2016 г..
 * All rights reserved!
 */

//Renamed to Person3, so that there is no error for already existing Person class from Problem1.

class Person3{
    String name;
    int age;

    public Person3(){
        this(1);
    }

    public Person3(int age){
        this("No name",age);
    }

    public Person3(String name, int age){
        this.name = name;
        this.age = age;
    }
}
public class Problem03_OpiniongPoll {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.valueOf(reader.readLine());

            List<Person3> personList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().split(" ");
                String name = line[0];
                int age = Integer.valueOf(line[1]);
                personList.add(new Person3(name, age));
            }
            personList.stream()
                    .filter( person -> person.age > 30)
                    .sorted((person1, person2) -> person1.name.compareTo(person2.name))
                    .forEach(person -> System.out.printf("%s - %d%n",person.name, person.age));
        }catch(Exception e){}
    }
}
