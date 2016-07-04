import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bludya on 28.6.2016 г..
 * All rights reserved!
 */
class Person2{
    private String name;
    private int age;

    public Person2(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name + " " + age;
    }
}
class Family{
    private List<Person2> people;

    public Family(){
        people = new ArrayList();
    }

    public void addFamilyMember(Person2 person){
        people.add(person);
    }

    public Person2 getOldestMember(){
        return people.stream().max((person1, person2) -> Integer.compare(person1.getAge(), person2.getAge())).get();
    }

}
public class Problem02_OldestFamilyMember {
    public static void main(String[] args) throws Exception{
        Method getOldestMethod = Class.forName("Family").getMethod("getOldestMember");
        Method addMemberMethod =Class.forName("Family").getMethod("addFamilyMember",Person2.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Family family = new Family();
        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] personInfo = reader.readLine().split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            Person2 newMember = new Person2(name, age);
            family.addFamilyMember(newMember);
        }

        Person2 oldestMember = family.getOldestMember();
        System.out.println(oldestMember);
    }
}
