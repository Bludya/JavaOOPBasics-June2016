package hardware;

import software.Software;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bludya on 10.7.2016 г..
 * All rights reserved!
 */
public abstract class Hardware {
    private String name;
    private String type;
    private Integer maxCapacity;
    private Integer maxMemory;
    private Integer usedCapacity;
    private Integer usedMemory;
    HashMap<String, Software> storedSoftware;

    protected Hardware(String name,
                     String type,
                     Integer maxCapacity,
                     Integer maxMemory) {
        this.setName(name);
        this.setType(type);
        this.setMaxCapacity(maxCapacity);
        this.setMaxMemory(maxMemory);
        storedSoftware = new LinkedHashMap<>();
        this.setUsedMemory(0);
        this.setUsedCapacity(0);
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

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    private void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Integer getMaxMemory() {
        return maxMemory;
    }

    private void setMaxMemory(Integer maxMemory) {
        this.maxMemory = maxMemory;
    }

    private HashMap<String, Software> getStoredSoftware() {
        return storedSoftware;
    }

    private void setUsedCapacity(Integer usedCapacity) {
        this.usedCapacity = usedCapacity;
    }

    public Integer getUsedCapacity() {
        return usedCapacity;
    }

    private void setUsedMemory(Integer usedMemory) {
        this.usedMemory = usedMemory;
    }

    public Integer getUsedMemory() {
        return usedMemory;
    }

    public Integer getCountOfSoftware(){
        return this.getStoredSoftware().size();
    }

    public void addSoftware(Software software){
        Integer leftCapacity = this.getMaxCapacity() - this.getUsedCapacity();
        Integer leftMemory = this.getMaxMemory() - this.getUsedMemory();

        if(software.getCapacityConsumption() > leftCapacity ||
                software.getMemoryConsumption() > leftMemory){
            return;
        }

        this.getStoredSoftware().put(software.getName(), software);
        this.setUsedMemory(this.getUsedMemory() + software.getMemoryConsumption());
        this.setUsedCapacity(this.getUsedCapacity() + software.getCapacityConsumption());
    }

    public void removeSoftware(String softwareName){
        if(!this.getStoredSoftware().containsKey(softwareName)){
            return;
        }

        Software software = this.getStoredSoftware().remove(softwareName);
        this.setUsedCapacity(this.getUsedCapacity() - software.getCapacityConsumption());
        this.setUsedMemory(this.getUsedMemory() - software.getMemoryConsumption());
    }

    public List<Software> getExpressSoftware(){
        return this.getStoredSoftware().values().stream()
                .filter(software -> software.getType().equals("Express"))
                .collect(Collectors.toList());
    }

    public List<Software> getLightSoftware(){
        return this.getStoredSoftware().values().stream()
                .filter(software -> software.getType().equals("Light"))
                .collect(Collectors.toList());
    }

    @Override
    public String toString(){
        String output = String.format("Hardware Component - %s%n", this.getName());
        output += String.format("Express Software Components - %d%n", this.getExpressSoftware().size());
        output += String.format("Light Software Components - %d%n", this.getLightSoftware().size());
        output += String.format("Memory Usage: %d / %d%n", this.getUsedMemory(), this.getMaxMemory());
        output += String.format("Capacity Usage: %d / %d%n", this.getUsedCapacity(), this.getMaxCapacity());
        output += String.format("Type: %s%n", this.getType());
        output += "Software Components: ";
        if(this.getStoredSoftware().size() > 0) {
            output += this.getStoredSoftware().values().toString().replaceAll("[\\[\\]]", "");
        }
        else {
            output += "None";
        }

        return output;
    }
}
