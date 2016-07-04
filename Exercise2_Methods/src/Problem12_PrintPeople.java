import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bludya on 29.6.2016 г..
 * All rights reserved!
 */

class People implements Comparable<People>{
    private String name;
    private int age;
    private String occupation;

    public People(String name, int age, String occupation){
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return String.format("%s - age: %d, occupation: %s", name, age, occupation);
    }

    @Override
    public int compareTo(People o) {
        return Integer.compare(this.age, o.age);
    }
}
public class Problem12_PrintPeople {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split("\\s+");
        List<People> people = new ArrayList<>();

        while(!"END".equals(info[0])){
            String name = info[0];
            int age = Integer.valueOf(info[1]);
            String occupation = info[2];
            people.add(new People(name, age, occupation));
            info = reader.readLine().split("\\s+");
        }
        people.stream().sorted().forEach(System.out::println);
    }
}
