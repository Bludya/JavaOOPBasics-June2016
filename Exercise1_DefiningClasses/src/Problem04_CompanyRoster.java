import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Bludya on 22.6.2016 г..
 * All rights reserved!
 */

/*Define a class Employee that holds the following information: name, salary, position, department, email and age. The name, salary,
position and department are mandatory while the rest are optional.

Your task is to write a program which takes N lines of employees from the console and calculates the department with the highest average
salary and prints for each employee in that department his name, salary, email and age – sorted by salary in descending order. If an employee
doesn’t have an email – in place of that field you should print “n/a” instead, if he doesn’t have an age – print “-1” instead. The salary should
be printed to two decimal places after the seperator.*/

class Employee implements Comparable<Employee>{
    String name;
    double salary;
    String position;
    String department;
    String email;
    int age;

    public Employee(String name, double salary, String position, String department){
        this(name, salary, position, department, "n/a", -1);
    }
    public Employee(String name, double salary, String position, String department, String email){
        this(name, salary, position, department, email, -1);
    }
    public Employee(String name, double salary, String position, String department, int age){
        this(name, salary, position, department, "n/a", age);
    }

    public Employee(String name, double salary, String position, String department, String email, int age){
        this.name = name;
        this.salary = salary;
        this. position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }

    @Override
    public int compareTo(Employee employee) {
        return Double.compare(employee.salary, this.salary);
    }
}

public class Problem04_CompanyRoster {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Employee> employeeList = new ArrayList<>();
        Map<String, Double> departments = new HashMap<>();
        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            String name = line[0];
            double salary = Double.valueOf(line[1]);
            String position = line[2];
            String department = line[3];

            if (!departments.containsKey(department)) {
                departments.put(department, salary);
            } else {
                Double depSalary = salary + departments.get(department);
                departments.replace(department, depSalary);
            }

            if (line.length == 4) {
                employeeList.add(new Employee(name, salary, position, department));
            }

            if (line.length == 5) {
                if (isNumber(line[4])) {
                    int age = Integer.valueOf(line[4]);
                    employeeList.add(new Employee(name, salary, position, department, age));
                } else {
                    String email = line[4];
                    employeeList.add(new Employee(name, salary, position, department, email));
                }
            }

            if (line.length == 6) {
                String email = line[4];
                int age = Integer.valueOf(line[5]);
                employeeList.add(new Employee(name, salary, position, department, email, age));
            }
        }

        String bestDepartment = departments.entrySet().stream()
                .max((entry1, entry2) -> entry1.getValue() >= entry2.getValue() ? 1 : -1)
                .get().getKey();

        System.out.println("Highest Average Salary: " + bestDepartment);
        employeeList.stream()
                .filter(employee -> employee.department.equals(bestDepartment))
                .sorted()
                .forEach(System.out::println);
    }
    private static boolean isNumber(String number){
        try{
            Integer.parseInt(number);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}
