package Problem02_VehiclesExtended.vehicles;

/**
 * Created by Bludya on 3.7.2016 г..
 * All rights reserved!
 */
public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double tankCapacity, double fuelQuantity, double fuelConsumption) {
        this.setTankCapacity(tankCapacity);
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if(fuelQuantity < 0){
            System.out.println("Fuel must be a positive number");
            return;
        }
        this.fuelQuantity = fuelQuantity;
    }

    private void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    protected double getFuelConsumption() {
        return fuelConsumption;
    }

    public void refuel(double amount){
        double currentFuel = getFuelQuantity();
        if(currentFuel + amount > tankCapacity){
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        setFuelQuantity(currentFuel + amount);
    }

    public boolean drive(double distance){
        if(distance * fuelConsumption <= fuelQuantity){
            fuelQuantity -= distance * fuelConsumption;
            return true;
        }

        return false;
    }

}
