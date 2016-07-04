package Problem02_VehiclesExtended.vehicles;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class Bus extends Vehicle {
    private final static double addedConsumption = 1.4;

    public Bus(double tankCapacity, double fuelQuantity, double fuelConsumption) {
        super(tankCapacity, fuelQuantity, fuelConsumption + 1.4);
    }

    public boolean driveWithoutPeople(double amount){
        double fuelQuantity = super.getFuelQuantity();
        double fuelConsumption = super.getFuelConsumption() - addedConsumption;

        if(amount * fuelConsumption <= fuelQuantity){
            super.setFuelQuantity(fuelQuantity - (amount * fuelConsumption));
            return true;
        }
        return false;
    }
}
