package software;

/**
 * Created by Bludya on 10.7.2016 г..
 * All rights reserved!
 */
public abstract class Software {
    private String name;
    private String type;
    private Integer capacityConsumption;
    private Integer memoryConsumption;

    protected Software(String name,
                     String type,
                     Integer capacityConsumption,
                     Integer memoryConsumption) {
        this.setName(name);
        this.setType(type);
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    public Integer getCapacityConsumption() {
        return capacityConsumption;
    }

    private void setCapacityConsumption(Integer capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    public Integer getMemoryConsumption() {
        return memoryConsumption;
    }

    private void setMemoryConsumption(Integer memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }

    @Override
    public String toString(){
        return this.getName();
    }
}
