import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Bludya on 28.6.2016 г..
 * All rights reserved!
 */
class DecimalNumber{
    private String number;

    public DecimalNumber(String number){
        this.number = number;
    }

    public String getReversedNumber(){
        return new StringBuilder(number).reverse().toString();
    }
}
public class Problem04_NumberInReversedorder {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        DecimalNumber number = new DecimalNumber(reader.readLine());
        System.out.println(number.getReversedNumber());
    }
}
