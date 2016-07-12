package hardware;

/**
 * Created by Bludya on 10.7.2016 г..
 * All rights reserved!
 */
public class HeavyHardware extends Hardware {
    private static final String TYPE_OF_HARDWARE = "Heavy";
    //25% modifier for memory. formula => (value * 1) / 4;
    private static final Integer PERCENT_MODIFIER = 1;
    private static final Integer FULL_PART_MODIFIER = 4;
    //double capacity;
    private static final Integer CAPACITY_MODIFIER = 2;

    public HeavyHardware(String name,
                          Integer maxCapacity,
                          Integer maxMemory) {
        super(name,
                TYPE_OF_HARDWARE,
                (maxCapacity * CAPACITY_MODIFIER),
                (maxMemory - ((maxMemory * PERCENT_MODIFIER) / FULL_PART_MODIFIER)));
    }
}
