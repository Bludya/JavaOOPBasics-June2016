package Problem02_VehiclesExtended.vehicles;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public class Truck extends Vehicle {
    private static final double addedConsumption = 1.6;

    public Truck(double tankCapacity, double fuelQuantity, double fuelConsumption) {
        super(tankCapacity, fuelQuantity, fuelConsumption + addedConsumption);
    }

    @Override
    public void refuel(double amount){
        double currentFuel = super.getFuelQuantity();
        super.setFuelQuantity(currentFuel + amount*0.95);
    }

}
