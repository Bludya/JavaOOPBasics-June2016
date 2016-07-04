import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bludya on 28.6.2016 г..
 * All rights reserved!
 */
class Number3{
    private int number;
    private boolean isPrime;

    public Number3(int number){
        this.number = number;
        this.isPrime = primeChecker(number);
    }

    public Number3(int number, boolean isPrime){
        this.number = number;
        this.isPrime = isPrime;
    }

    public int getNumber() {
        return number;
    }

    public boolean getIsPrime(){
        return isPrime;
    }

    public Number3 getNextPrime(){
        int newNumber = number + 1;
        while(true){
            if(primeChecker(newNumber)){
                return new Number3(newNumber, true);
            }
            newNumber++;
        }

    }

    private boolean primeChecker(int number){
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number%i == 0){
                isPrime = false;
            }
        }

        return isPrime;
    }


}
public class Problem06_PrimeChecker {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        Number3 number = new Number3(n);

        System.out.println(number.getNextPrime().getNumber() + ", " + number.getIsPrime());
    }
}
