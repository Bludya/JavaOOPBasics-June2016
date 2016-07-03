package Problem03_Mankind;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bludya on 2.7.2016 г..
 * All rights reserved!
 */
public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        Pattern pattern = Pattern.compile("[0-9a-zA-Z]{5,10}");
        Matcher matcher = pattern.matcher(facultyNumber);
        if(!matcher.find()){
            throw new IllegalArgumentException(Exceptions.INVALID_FACULTY_NUMBER);
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString(){
        return String.format("First Name: %s%nLast Name: %s%nFaculty number: %s%n", super.getFirstName(), super.getLastName(), facultyNumber);
    }
}
