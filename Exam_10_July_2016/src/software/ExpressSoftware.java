package software;

/**
 * Created by Bludya on 10.7.2016 г..
 * All rights reserved!
 */
public class ExpressSoftware extends Software{
    private static final String TYPE_OF_SOFTWARE = "Express";
    //doubled memory consumption for express software
    private static final Integer MEMORY_CONSUMPTION_MODIFIER = 2;

    public ExpressSoftware(String name,
                            Integer capacityConsumption,
                            Integer memoryConsumption) {
        super(name,
                TYPE_OF_SOFTWARE,
                capacityConsumption,
                (memoryConsumption * MEMORY_CONSUMPTION_MODIFIER));
    }
}
