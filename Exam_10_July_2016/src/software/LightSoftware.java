package software;

/**
 * Created by Bludya on 10.7.2016 г..
 * All rights reserved!
 */
public class LightSoftware extends Software {
    private static final String TYPE_OF_SOFTWARE = "Light";
    //capacity consumption icnreased by 50 % of its given value => value + (value/2);
    private static final int CAPACITY_CONSUMPTION_MODIFIER = 2;
    //memory consumption decreased by 50 % of its given value => value / 2;
    private static final int MEMORY_CONSUMPTION_MODIFIER = 2;

    public LightSoftware(String name,
                          Integer capacityConsumption,
                          Integer memoryConsumption) {
        super(name,
                TYPE_OF_SOFTWARE,
                (capacityConsumption + (capacityConsumption / CAPACITY_CONSUMPTION_MODIFIER)),
                (memoryConsumption / MEMORY_CONSUMPTION_MODIFIER));
    }
}
