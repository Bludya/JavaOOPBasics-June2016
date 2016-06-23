import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bludya on 22.6.2016 г..
 * All rights reserved!
 */

class Engine2{
    String model;
    String power;
    String displacement;
    String efficiency;

    public Engine2(String model, String power){
        this(model, power, "n/a", "n/a");
    }
    public Engine2(String model, String power, int displacement){
        this(model, power, String.format("%d", displacement), "n/a");
    }
    public Engine2(String model, String power, String efficiency){
        this(model, power, "n/a", efficiency);
    }
    public Engine2(String model, String power, String displacement, String efficiency){
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString(){
        return String.format("  %s:%n    Power: %s%n    Displacement: %s%n    Efficiency: %s%n", model, power, displacement, efficiency);
    }
}

class Car2{
    String model;
    Engine2 engine;
    String weight;
    String color;

    public Car2(String model, Engine2 engine){
        this(model, engine, "n/a", "n/a");
    }

    public Car2(String model, Engine2 engine, int weight){
        this(model, engine, String.valueOf(weight), "n/a");
    }

    public Car2(String model, Engine2 engine, String color){
        this(model, engine, "n/a", color);
    }

    public Car2(String model, Engine2 engine, String weight, String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString(){
        return String.format("%s:%n%sWeight: %s%nColor: %s", model, engine.toString(), weight, color);
    }
}
public class Problem07_CarSalesman {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Engine2> engines = new HashMap<>();
        List<Car2> cars = new ArrayList<>();

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] engine = reader.readLine().split("\\s+");
            String model = engine[0];
            String power = engine[1];

            if(engine.length == 2){
                engines.put(model, new Engine2(model, power));
            }

            if(engine.length ==3){
                if(isNumber(engine[2])){
                    int displacement = Integer.valueOf(engine[2]);
                    engines.put(model, new Engine2(model, power, displacement));
                }
                else{
                    String efficiency = engine[2];
                    engines.put(model, new Engine2(model, power, efficiency));
                }
            }

            if(engine.length == 4){
                String displacement = engine[2];
                String efficiency = engine[3];
                engines.put(model, new Engine2(model, power, displacement, efficiency));
            }
        }

        int m = Integer.valueOf(reader.readLine());

        for (int i = 0; i < m; i++) {
            String[] car = reader.readLine().split("\\s+");

            String model = car[0];
            String engine = car[1];

            if(car.length == 2){
                cars.add(new Car2(model, engines.get(engine)));
            }

            if(car.length == 3){
                if(isNumber(car[2])){
                    int weight = Integer.valueOf(car[2]);
                    cars.add(new Car2(model, engines.get(engine), weight));
                }
                else{
                    String color = car[2];
                    cars.add(new Car2(model, engines.get(engine), color));
                }
            }

            if(car.length == 4){
                String weight = car[2];
                String color = car[3];
                cars.add(new Car2(model, engines.get(engine), weight, color));
            }
        }

        cars.stream().forEach(System.out::println);
    }

    public static boolean isNumber(String number){
        try {
            Integer.parseInt(number);
        }catch (NumberFormatException e){
            return false;
        }

        return true;
    }
}
