import hardware.Hardware;
import hardware.HeavyHardware;
import hardware.PowerHardware;
import software.ExpressSoftware;
import software.LightSoftware;
import software.Software;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Bludya on 10.7.2016 г..
 * All rights reserved!
 */
public class Main {
    static Map<String, Hardware> hardwareComponents = new LinkedHashMap<>();
    static Map<String, Hardware> dump = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String command = reader.readLine();

            if("System Split".equals(command)){
                break;
            }

            processCommand(command);
        }

        List<Hardware> sortedHardware = sortHardware();
        sortedHardware.forEach(System.out::println);
    }

    private static void processCommand(String command){
        Pattern pattern = Pattern.compile("([A-Za-z]+)\\((.*)\\)");
        Matcher matcher = pattern.matcher(command);

        if(!matcher.find()){
            return;
        }

        switch (matcher.group(1)) {
            case "RegisterPowerHardware":
                Hardware newPowerHardware = registerHardware("Power", matcher.group(2));
                if (newPowerHardware != null) {
                    hardwareComponents.put(newPowerHardware.getName(), newPowerHardware);
                }
                break;
            case "RegisterHeavyHardware":
                Hardware newHeavyHardware = registerHardware("Heavy", matcher.group(2));
                if (newHeavyHardware != null) {
                    hardwareComponents.put(newHeavyHardware.getName(), newHeavyHardware);
                }
                break;
            case "RegisterLightSoftware":
                tryRegisterSoftware("Light", matcher.group(2));
                break;
            case "RegisterExpressSoftware":
                tryRegisterSoftware("Express", matcher.group(2));
                break;
            case "ReleaseSoftwareComponent":
                tryReleaseSoftware(matcher.group(2));
                break;
            case "Analyze":
                System.out.println(analyzeSystem());
                break;
            case "Dump":
                tryDumpHardware(matcher.group(2));
                break;
            case "Restore":
                tryRestoreHardware(matcher.group(2));
                break;
            case "Destroy":
                tryDestroyHardware(matcher.group(2));
                break;
            case "DumpAnalyze":
                System.out.println(analyzeDump());
                break;
        }
    }

    private static String analyzeDump() {
        Integer powerHardwareComponents = 0;
        Integer heavyHardwareComponents = 0;
        Long expressSoftwareComponents = 0L;
        Long lightSoftwareComponents = 0L;
        Integer totalDumpedMemory = 0;
        Integer totalDumpedCapacity = 0;

        for (Hardware hardware : dump.values()){
            if(hardware.getType().equals("Power")){
                powerHardwareComponents ++;
            }
            else {
                heavyHardwareComponents ++;
            }
            expressSoftwareComponents += hardware.getExpressSoftware().size();
            lightSoftwareComponents += hardware.getLightSoftware().size();
            totalDumpedMemory += hardware.getUsedMemory();
            totalDumpedCapacity += hardware.getUsedCapacity();
        }

        String output = "Dump Analysis\n";
        output += String.format("Power Hardware Components: %d%n", powerHardwareComponents);
        output += String.format("Heavy Hardware Components: %d%n", heavyHardwareComponents);
        output += String.format("Express Software Components: %d%n", expressSoftwareComponents);
        output += String.format("Light Software Components: %d%n", lightSoftwareComponents);
        output += String.format("Total Dumped Memory: %d%n", totalDumpedMemory);
        output += String.format("Total Dumped Capacity: %d", totalDumpedCapacity);

        return output;
    }

    private static void tryDestroyHardware(String hardwareName) {
        if(!dump.containsKey(hardwareName)){
            return;
        }

        dump.remove(hardwareName);
    }

    private static void tryRestoreHardware(String hardwareName) {
        if(!dump.containsKey(hardwareName)){
            return;
        }

        Hardware hardware = dump.remove(hardwareName);
        hardwareComponents.put(hardwareName, hardware);
    }

    private static void tryDumpHardware(String hardwareName) {
        if(!hardwareComponents.containsKey(hardwareName)){
            return;
        }

        Hardware hardware = hardwareComponents.remove(hardwareName);
        dump.put(hardwareName, hardware);
    }

    private static String analyzeSystem() {
        Integer hardwareComponentsCount = 0;
        Integer softwareComponentsCount = 0;
        Integer memoryInUse = 0;
        Integer maximumMemory = 0;
        Integer capacityInUse = 0;
        Integer maximumCapacity = 0;

        List<Hardware> sortedHardware = sortHardware();

        for(Hardware hardware : sortedHardware){
            hardwareComponentsCount ++;
            softwareComponentsCount += hardware.getCountOfSoftware();
            memoryInUse += hardware.getUsedMemory();
            maximumMemory += hardware.getMaxMemory();
            capacityInUse += hardware.getUsedCapacity();
            maximumCapacity += hardware.getMaxCapacity();
        }

        String output = "System Analysis\n";
        output += String.format("Hardware Components: %d%n", hardwareComponentsCount);
        output += String.format("Software Components: %d%n", softwareComponentsCount);
        output += String.format("Total Operational Memory: %d / %d%n", memoryInUse, maximumMemory);
        output += String.format("Total Capacity Taken: %d / %d", capacityInUse, maximumCapacity);

        return output;
    }

    private static void tryReleaseSoftware(String data) {
        String[] releaseInfo = data.split(", ");
        String hardwareName = releaseInfo[0];
        String softwareName = releaseInfo[1];

        if(!hardwareComponents.containsKey(hardwareName)){
            return;
        }

        hardwareComponents.get(hardwareName).removeSoftware(softwareName);
    }

    private static void tryRegisterSoftware(String type, String data) {
        String[] swInfo = data.split(", ");
        String hardwareComponentName = swInfo[0];
        String softwareName = swInfo[1];
        Integer capacity = Integer.parseInt(swInfo[2]);
        Integer memory = Integer.parseInt(swInfo[3]);

        if(!hardwareComponents.containsKey(hardwareComponentName)){
            return;
        }

        Software software;

        switch (type){
            case "Express":
                software = new ExpressSoftware(softwareName, capacity, memory);
                break;
            case "Light":
                software = new LightSoftware(softwareName, capacity, memory);
                break;
            default:
                software = null;
                break;
        }

        if(software == null){
            return;
        }

        hardwareComponents.get(hardwareComponentName).addSoftware(software);
    }

    private static Hardware registerHardware(String type, String data) {
        String[] hwInfo = data.split(", ");
        String name = hwInfo[0];
        Integer capacity = Integer.parseInt(hwInfo[1]);
        Integer memory = Integer.parseInt(hwInfo[2]);

        switch (type){
            case "Power":
                return new PowerHardware(name, capacity, memory);
            case "Heavy":
                return new HeavyHardware(name, capacity, memory);
            default:
                return null;
        }
    }

    private static List<Hardware> sortHardware() {
        List<Hardware> sortedHardware = hardwareComponents.values().stream()
                .sorted((h1, h2) -> {
                    if(h1.getType().equals("Power") && !h2.getType().equals("Power")){
                        return -1;
                    }

                    if(!h1.getType().equals("Power") && h2.getType().equals("Power")){
                        return 1;
                    }

                    return 0;
                }).collect(Collectors.toList());

        return sortedHardware;
    }

}
