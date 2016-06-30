package Problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Bludya on 30.6.2016 г..
 * All rights reserved!
 */
class BeerCounter{
    static int beerInStock;
    static int beersDrankCount;

    static{
        beerInStock = 0;
        beersDrankCount = 0;
    }

    static void buyBeer(int count){
        beerInStock += count;
    }

    static void drinkBeer(int count){
        beersDrankCount += count;
        beerInStock -= count;
    }
}
public class Problem04_BeerCounter {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] command = reader.readLine().split("\\s+");

        while(!"End".equals(command[0])){
            int beersBought = Integer.valueOf(command[0]);
            int beersDrank = Integer.valueOf(command[1]);

            BeerCounter.buyBeer(beersBought);
            BeerCounter.drinkBeer(beersDrank);
            command = reader.readLine().split("\\s+");
        }

        System.out.printf("%d %d%n", BeerCounter.beerInStock, BeerCounter.beersDrankCount);
    }
}
