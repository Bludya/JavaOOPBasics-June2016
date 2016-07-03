package Problem03_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bludya on 2.7.2016 г..
 * All rights reserved!
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] studentInfo = reader.readLine().split("\\s+");
            String studentFirstName = studentInfo[0];
            String studentLastName = studentInfo[1];
            String studentFacultyNumber = studentInfo[2];

            Human student = new Student(studentFirstName, studentLastName, studentFacultyNumber);

            String[] workerInfo = reader.readLine().split("\\s+");
            String workerFirstName = workerInfo[0];
            String workerLastName = workerInfo[1];
            Double salary = Double.parseDouble(workerInfo[2]);
            Double workHoursPerWeek = Double.parseDouble(workerInfo[3]);

            Human worker = new Worker(workerFirstName, workerLastName, salary, workHoursPerWeek);

            System.out.println(student);
            System.out.println(worker);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
