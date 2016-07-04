import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Bludya on 29.6.2016 г..
 * All rights reserved!
 */
class Car{
    private double speed;
    private double fuel;
    private double fuelEconomy;
    private double traveledDistance;
    private double traveledTime;

    public Car(double speed, double fuel, double fuelEconomy){
        this.speed = speed;
        this.fuel = fuel;
        this.fuelEconomy = fuelEconomy;
        this.traveledDistance = 0.0;
        this.traveledTime = 0.0;
    }

    public double getTraveledDistance(){
        return traveledDistance;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTraveledTime() {
        return traveledTime;
    }

    public void travel(double distance){
        double canTravel = (fuel * 100) / fuelEconomy;

        if(canTravel < distance){
            distance = canTravel;
        }
        traveledDistance += distance;
        fuel -= distance * (fuelEconomy / 100);
        traveledTime += (distance / speed) * 60;
    }

    public void refuel(double amount){
        fuel += amount;
    }

}
public class Problem08_CarList {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carInfo = reader.readLine().split("\\s+");
        double speed = Double.valueOf(carInfo[0]);
        double fuel = Double.valueOf(carInfo[1]);
        double fuelEconomy = Double.valueOf(carInfo[2]);

        Car car = new Car(speed, fuel, fuelEconomy);

        String[] command = reader.readLine().split("\\s+");
        while(!"END".equals(command[0])){
            switch (command[0]){
                case "Travel":
                    car.travel(Double.valueOf(command[1]));
                    break;
                case "Refuel":
                    car.refuel(Double.valueOf(command[1]));
                    break;
                case "Distance":
                    System.out.println(String.format("Total distance: %s kilometers", car.getTraveledDistance()));
                    break;
                case "Time":
                    System.out.println(String.format("Total time: %d hours and %d minutes", (int)car.getTraveledTime() / 60, (int)car.getTraveledTime() % 60));
                    break;
                case "Fuel":
                    System.out.println(String.format("Fuel left: %s liters", car.getFuel()));
                    break;
                default:
                    break;
            }
            command = reader.readLine().split("\\s+");
        }
    }
}
