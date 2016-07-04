import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Bludya on 29.6.2016 г..
 * All rights reserved!
 */
class Pizza {
    String name;
    Integer type;
    List<Pizza> pizzas;

    public Pizza(String name, Integer type) {
        this.name = name;
        this.type = type;
        this.pizzas = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }

    public List<Pizza> getPizzas() {
        return this.pizzas;
    }

    public Map<String, Pizza> wtf() {
        return new HashMap<>();
    }

    @Override
    public String toString() {
        return this.name;
    }
}


public class Problem09_PizzaTime {
    public static void main(String[] args) throws Exception {
        Class<?> pizzaClass = Pizza.class;
        Method[] methods = pizzaClass.getDeclaredMethods();
        List<Method> checkedMethods = Arrays.stream(methods)
                .filter(m -> m.getReturnType().getName().contains("Map"))
                .collect(Collectors.toList());

        if (checkedMethods.size() < 1) {
            throw new ClassFormatException();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pizzas = reader.readLine();
        Map<Integer, List<Pizza>> pizzaGroups = new TreeMap<>();

        Pattern pattern = Pattern.compile("([0-9]+)(\\S+)");
        Matcher matcher = pattern.matcher(pizzas);

        while (matcher.find()) {
            Integer group = Integer.valueOf(matcher.group(1));
            String name = matcher.group(2);

            if (!pizzaGroups.containsKey(group)) {
                pizzaGroups.put(group, new ArrayList<>());
            }
            pizzaGroups.get(group).add(new Pizza(name, group));
        }

        pizzaGroups.entrySet().stream()
                .forEach(pizza1 -> System.out.printf("%s - %s%n",
                        pizza1.getKey(),
                        pizza1.getValue().toString().replaceAll("\\[","").replaceAll("\\]","")));
    }
}
