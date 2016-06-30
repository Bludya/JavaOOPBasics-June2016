package Problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by Bludya on 30.6.2016 г..
 * All rights reserved!
 */
class Student{
    private String name;
    public Student(String name){
        this.name = name;
        StudentGroup.students.add(name);
    }
}

class StudentGroup{
    static HashSet<String> students;
    static{
        students = new HashSet<>();
    }
}
public class Problem02_UniqueStudentName {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String studentName = reader.readLine();
        while (!"End".equals(studentName)){
            Student newStudent = new Student(studentName);
            studentName = reader.readLine();
        }

        System.out.println(StudentGroup.students.size());
    }

}
