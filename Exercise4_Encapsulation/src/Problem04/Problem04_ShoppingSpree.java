package Problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bludya on 1.7.2016 г..
 * All rights reserved!
 */
class Product{
    private String name;
    private double price;

    public Product(String name, double price){
        this.setName(name);
        this.setPrice(price);
    }

    public void setName(String name) {
        if(name.isEmpty() || name.trim().length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    public void setPrice(double price) {
        if(price < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
class Person{
    private String name;
    private double money;
    private List<Product> bag;

    public Person(String name, double money) throws IllegalArgumentException{
        this.setName(name);
        this.setMoney(money);
        this.bag = new ArrayList<>();
    }

    public void setMoney(double money) throws IllegalArgumentException{
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public void setName(String name) throws IllegalArgumentException{
        if(name.isEmpty() || name.trim().length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Product> getBag() {
        return bag;
    }

    public void buyProduct(Product product){
        if(product.getPrice() > money){
            System.out.printf("%s can't afford %s%n", name, product);
        }
        else{
            bag.add(product);
            money -= product.getPrice();
            System.out.printf("%s bought %s%n", name, product);
        }
    }

}
public class Problem04_ShoppingSpree {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> peopleMap = new LinkedHashMap<>();
        Map<String, Product> productMap = new LinkedHashMap<>();
        try {
            String[] people = reader.readLine().split(";");

            for (String person : people) {
                String name = person.split("=")[0];
                double money = Double.valueOf(person.split("=")[1]);
                peopleMap.put(name, new Person(name, money));
            }

            String[] products = reader.readLine().split(";");
            for (String product : products) {
                String name = product.split("=")[0];
                Double price = Double.valueOf(product.split("=")[1]);
                productMap.put(name, new Product(name, price));
            }

            String[] command = reader.readLine().split("\\s+");

            while (!"END".equals(command[0])) {
                String person = command[0];
                String product = command[1];

                peopleMap.get(person).buyProduct(productMap.get(product));
                command = reader.readLine().split("\\s+");
            }

            for (Person person : peopleMap.values()) {
                if(person.getBag().isEmpty()){
                    System.out.printf("%s - Nothing bought", person.getName());
                    continue;
                }
                System.out.printf("%s - %s%n", person.getName(), person.getBag().toString().replaceAll("\\[|\\]", ""));
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
