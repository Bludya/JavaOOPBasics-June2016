import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bludya on 28.6.2016 г..
 * All rights reserved!
 */
class Fibonacci{
    private List<Long> numbers;

    public Fibonacci(int end){
        numbers = new ArrayList<>();
        numbers.add(0l);
        numbers.add(1l);
        numbers.add(1l);

        for (int i = 3; i < end; i++) {
            numbers.add(numbers.get(i-2) + numbers.get(i-1));
        }
    }

    public List<Long> getNumbersInRange(int start, int end){
        return numbers.subList(start, end);
    }
}
public class Problem05_FibonacciNumbers {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.valueOf(reader.readLine());
        int end = Integer.valueOf(reader.readLine());

        Fibonacci fibonacci = new Fibonacci(end);
        System.out.println(fibonacci.getNumbersInRange(start, end).toString().replaceAll("[\\[\\]]",""));
    }
}
