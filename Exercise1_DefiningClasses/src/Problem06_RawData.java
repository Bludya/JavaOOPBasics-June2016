import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bludya on 22.6.2016 г..
 * All rights reserved!
 */
class Tire{
    int age;
    double pressure;

    public Tire(int age, double pressure){
        this.age = age;
        this.pressure = pressure;
    }
}

class Engine{
    int speed;
    int horsePower;

    public Engine(int speed, int horsePower){
        this.speed = speed;
        this.horsePower = horsePower;
    }
}

class Cargo{
    String type;
    int weight;

    public Cargo(int weight, String type){
        this.weight = weight;
        this.type = type;
    }
}

class Car1{
    String model;
    Engine engine;
    Cargo cargo;
    List<Tire> tires;

    public Car1(String model, Engine engine, Cargo cargo, Tire tire1, Tire tire2, Tire tire3, Tire tire4){
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        tires = new ArrayList<>(Arrays.asList(tire1, tire2, tire3, tire4));
    }

    public boolean isFlamable(){
        return cargo.type.equals("flamable") && engine.horsePower > 250;
    }

    public boolean isFragile(){
        boolean softTire = false;
        for(Tire tire : tires){
            if(tire.pressure < 1){
                softTire = true;
                break;
            }
        }

        return cargo.type.equals("fragile") && softTire;
    }

    @Override
    public String toString(){
        return this.model;
    }
}

public class Problem06_RawData {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        List<Car1> cars = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            String model = line[0];
            int engineSpeed = Integer.valueOf(line[1]);
            int enginePower = Integer.valueOf(line[2]);
            int cargoWeight = Integer.valueOf(line[3]);
            String cargoType = line[4];
            double tire1P = Double.valueOf(line[5]);
            int tire1Age = Integer.valueOf(line[6]);
            double tire2P = Double.valueOf(line[7]);
            int tire2Age = Integer.valueOf(line[8]);
            double tire3P = Double.valueOf(line[9]);
            int tire3Age = Integer.valueOf(line[10]);
            double tire4P = Double.valueOf(line[11]);
            int tire4Age = Integer.valueOf(line[12]);
            cars.add(
                    new Car1(model,
                            new Engine(engineSpeed,enginePower),
                            new Cargo(cargoWeight, cargoType),
                            new Tire(tire1Age,tire1P),
                            new Tire(tire2Age, tire2P),
                            new Tire(tire3Age, tire3P),
                            new Tire(tire4Age, tire4P)));
        }

        String command = reader.readLine();
        if("fragile".equals(command)){
            cars.stream().filter(Car1::isFragile).forEach(System.out::println);
        }

        if("flamable".equals(command)){
            cars.stream().filter(Car1::isFlamable).forEach(System.out::println);
        }
    }

}
