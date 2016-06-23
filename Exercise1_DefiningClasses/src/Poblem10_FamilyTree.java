import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Bludya on 23.6.2016 г..
 * All rights reserved!
 */
class Person4{
    String name;
    String birthday;
    List<Person4> parents;
    List<Person4> children;

    public Person4(String name){
        this.name = name;
    }

    public  Person4(StringBuilder birthday){
        this.birthday = birthday.toString();
    }
}
public class Poblem10_FamilyTree {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person4> people = new LinkedList<>();

        String firstPerson = reader.readLine();

        String[] line = reader.readLine().split(" - ");
        while(!"End".equals(line[0])){
            String parent = line[0];
            String child = line[1];
            line = reader.readLine().split(" - ");
        }



    }
}
