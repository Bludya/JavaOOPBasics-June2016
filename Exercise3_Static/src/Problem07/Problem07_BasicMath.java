package Problem07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.SyncFailedException;
import java.util.DoubleSummaryStatistics;

/**
 * Created by Bludya on 30.6.2016 г..
 * All rights reserved!
 */
class MathUtil{
    static double sum(double a, double b){
        return a+b;
    }

    static double substract(double a, double b){
        return a-b;
    }

    static double multiply(double a, double b){
        return a * b;
    }

    static double divide(double a, double b){
        return a / b;
    }

    static double percentage(double a, double b){
        return (a/100) * b;
    }
}
public class Problem07_BasicMath {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] action = reader.readLine().split("\\s+");

        while(!"End".equals(action[0])){
            double a = Double.valueOf(action[1]);
            double b = Double.valueOf(action[2]);
            switch (action[0]){
                case "Sum":
                    System.out.printf("%.2f%n", MathUtil.sum(a, b));
                    break;
                case "Subtract":
                    System.out.printf("%.2f%n", MathUtil.substract(a, b));
                    break;
                case "Multiply":
                    System.out.printf("%.2f%n", MathUtil.multiply(a, b));
                    break;
                case "Divide":
                    System.out.printf("%.2f%n", MathUtil.divide(a, b));
                    break;
                case "Percentage":
                    System.out.printf("%.2f%n", MathUtil.percentage(a, b));
                    break;
                default:
                    break;
            }
            action = reader.readLine().split("\\s+");
        }
    }
}
