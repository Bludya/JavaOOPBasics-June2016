package Problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Bludya on 30.6.2016 г..
 * All rights reserved!
 */
class TemperatureConverter{
    static double convertToFahrenheit(int temperatureC){
        return temperatureC * 1.8 + 32;
    }
    static double convertToCelsius(int temperatureF){
        return (temperatureF - 32) / 1.8;
    }
}
public class Problem03_TemperatureConverter {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String conversion = reader.readLine();
        while (!"End".equals(conversion)){
            int degrees = Integer.parseInt(conversion.split("\\s+")[0]);
            String metric = conversion.split("\\s+")[1];
            if("Fahrenheit".equals(metric)){
                System.out.printf("%.2f Celsius%n", TemperatureConverter.convertToCelsius(degrees));
            }
            else if("Celsius".equals(metric)){
                System.out.printf("%.2f Fahrenheit%n", TemperatureConverter.convertToFahrenheit(degrees));
            }
            conversion = reader.readLine();
        }
    }
}
