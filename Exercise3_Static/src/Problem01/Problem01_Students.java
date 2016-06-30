package Problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Bludya on 30.6.2016 г..
 * All rights reserved!
 */
class Student{
    static int numberOfStudents;
    private String name;

    static {
        numberOfStudents = 0;
    }

    public Student(String name){
        this.name = name;
        numberOfStudents++;
    }

}
public class Problem01_Students {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String studentName = reader.readLine();
        while (!"End".equals(studentName)){
            Student newStudent = new Student(studentName);
            studentName = reader.readLine();
        }

        System.out.println(Student.numberOfStudents);
    }
}
