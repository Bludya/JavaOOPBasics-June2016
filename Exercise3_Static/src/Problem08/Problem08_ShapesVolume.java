package Problem08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Bludya on 30.6.2016 г..
 * All rights reserved!
 */
class TriangularPrism{
    private double base;
    private double heightFromBase;
    private double length;

    public TriangularPrism(double base, double heightFromBase, double length){
        this.base = base;
        this.heightFromBase = heightFromBase;
        this.length = length;
    }

    public double getBase() {
        return base;
    }

    public double getHeightFromBase() {
        return heightFromBase;
    }

    public double getLength() {
        return length;
    }
}

class Cube{
    private double side;

    public Cube(double side){
        this.side = side;
    }

    public double getSide() {
        return side;
    }
}

class Cylinder{
    private double radius;
    private double height;

    public Cylinder(double radius, double height){
        this.radius = radius;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }
}

class VolumeCalculator{
    static double calculateCube(Cube cube){
        double side = cube.getSide();
        return Math.pow(side, 3);
    }

    static double calculateCylinder(Cylinder cylinder){
        double r = cylinder.getRadius();
        double height = cylinder.getHeight();
        return Math.PI * r * r * height;
    }

    static double calculateTriangularPrism(TriangularPrism prism){
        double base = prism.getBase();
        double height = prism.getHeightFromBase();
        double length = prism.getLength();

        return (height / 2) * base * length;
    }
}
public class Problem08_ShapesVolume {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] action = reader.readLine().split("\\s+");

        while(!"End".equals(action[0])){
            switch (action[0]){
                case "TrianglePrism":
                    double base = Double.valueOf(action[1]);
                    double height = Double.valueOf(action[2]);
                    double length = Double.valueOf(action[3]);
                    System.out.printf("%.3f%n", VolumeCalculator.calculateTriangularPrism(new TriangularPrism(base, height, length)));
                    break;
                case "Cube":
                    double side = Double.valueOf(action[1]);
                    System.out.printf("%.3f%n", VolumeCalculator.calculateCube(new Cube(side)));
                    break;
                case "Cylinder":
                    double radius = Double.valueOf(action[1]);
                    double sideHeight = Double.valueOf(action[2]);
                    System.out.printf("%.3f%n", VolumeCalculator.calculateCylinder(new Cylinder(radius, sideHeight)));
                    break;
                default:
                    break;
            }
            action = reader.readLine().split("\\s+");
        }

    }
}
