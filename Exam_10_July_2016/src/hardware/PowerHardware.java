package hardware;

/**
 * Created by Bludya on 10.7.2016 г..
 * All rights reserved!
 */
public class PowerHardware extends Hardware {
    private static final String TYPE_OF_HARDWARE = "Power";
    //75% modifier for both capacity and memory. formula => (value * 3) / 4;
    private static final Integer PERCENT_MODIFIER = 3;
    private static final Integer FULL_PART_MODIFIER = 4;

    public PowerHardware(String name,
                          Integer maxCapacity,
                          Integer maxMemory) {
        super(name,
                TYPE_OF_HARDWARE,
                (maxCapacity - ((maxCapacity * PERCENT_MODIFIER) / FULL_PART_MODIFIER)),
                (maxMemory + ((maxMemory * PERCENT_MODIFIER) / FULL_PART_MODIFIER)));
    }
}
