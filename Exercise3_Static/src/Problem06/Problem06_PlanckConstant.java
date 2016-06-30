package Problem06;

/**
 * Created by Bludya on 30.6.2016 г..
 * All rights reserved!
 */

class Calculation{
    static double planck;
    static double pi;

    static{
        planck = 6.62606896e-34;
        pi = 3.14159;
    }

    static double reducePlanck(){
        return planck / (2 * pi);
    }
}
public class Problem06_PlanckConstant {
    public static void main(String[] args) {
        System.out.println(Calculation.reducePlanck());
    }
}
