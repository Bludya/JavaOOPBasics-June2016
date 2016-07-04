import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bludya on 28.6.2016 г..
 * All rights reserved!
 */
class Number{
    private int number;

    public Number(int number){
        this.number = number;
    }

    public String getLastDigitName(){
        switch (number%10){
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "foud";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "No digit";
        }
    }
}
public class Problem03_LastDigitName {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        Number number = new Number(n);

        System.out.println(number.getLastDigitName());
    }
}
