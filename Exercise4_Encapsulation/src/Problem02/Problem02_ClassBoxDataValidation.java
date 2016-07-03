package Problem02;

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

    public Box(double length, double width, double height) throws Exception{
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) throws Exception{
        if(length > 0) {
            this.length = length;
        }
        else{
            throw new Exception("Length cannot be zero or negative.");
        }
    }

    private void setWidth(double width) throws Exception{
        if(width > 0){
            this.width = width;
        }
        else{
            throw new Exception("Width cannot be zero or negative.");
        }
    }

    private void setHeight(double height) throws Exception{
        if(height > 0){
            this.height = height;
        }
        else {
            throw new Exception("Height cannot be zero or negative.");
        }
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
public class Problem02_ClassBoxDataValidation {
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
        try {
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%n",box.calculateArea());
            System.out.printf("Lateral Surface Area - %.2f%n",box.calculateLateralArea());
            System.out.printf("Volume - %.2f%n",box.calculateVolume());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
