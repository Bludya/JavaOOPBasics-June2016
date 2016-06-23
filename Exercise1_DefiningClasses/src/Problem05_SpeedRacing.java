import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Bludya on 22.6.2016 г..
 * All rights reserved!
 */
class Car{
    String model;
    double fuel;
    double fuelCost;
    int distanceTraveled;

    public Car(String model, double fuel, Double fuelCost){
        this.model = model;
        this.fuel = fuel;
        this.fuelCost = fuelCost;
    }

    public boolean drive(int distance){
        Double fuelUsed = distance * fuelCost;
        if(fuelUsed <= fuel){
            fuel -= fuelUsed;
            distanceTraveled += distance;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %d", model, fuel, distanceTraveled);
    }

}
public class Problem05_SpeedRacing {
    public static void main(String[] args) throws  IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            String model = line[0];
            double fuel = Double.valueOf(line[1]);
            double fuelCost = Double.valueOf(line[2]);

            cars.put(model, new Car(model, fuel, fuelCost));
        }

        String[] driving = reader.readLine().split("\\s+");
        while(!"End".equals(driving[0])){
            String model = driving[1];
            int distance = Integer.valueOf(driving[2]);

            if(!cars.get(model).drive(distance)){
                System.out.println("Insufficient fuel for the drive");
            }

            driving = reader.readLine().split("\\s+");
        }

        cars.values().stream().forEach(System.out::println);

    }
}
