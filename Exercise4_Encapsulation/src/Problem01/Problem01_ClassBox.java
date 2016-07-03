package Problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by Bludya on 1.7.2016 г..
 * All rights reserved!
 */

class Box{
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double calculateArea(){
        return length * width * 2 + (width + length) * 2 * height;
    }

    public double calculateLateralArea(){
        return (width + length) * height * 2;
    }

    public double calculateVolume(){
        return width * length * height;
    }

}
public class Problem01_ClassBox {
    public static void main(String[] args) throws Exception{

        Class boxClass = Box.class;
        Field[] fields = boxClass.getDeclaredFields();
        System.out.println(Arrays.asList(fields)
                .stream()
                .filter(f -> Modifier.isPrivate(f.getModifiers())).count());


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.valueOf(reader.readLine());
        double width = Double.valueOf(reader.readLine());
        double height = Double.valueOf(reader.readLine());

        Box box = new Box(length, width, height);

        System.out.printf("Surface Area - %.2f%n",box.calculateArea());
        System.out.printf("Lateral Surface Area - %.2f%n",box.calculateLateralArea());
        System.out.printf("Volume - %.2f%n",box.calculateVolume());
    }
}
