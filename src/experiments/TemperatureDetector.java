package experiments;

import equipments.Equipment;

public class TemperatureDetector extends Equipment {
    public TemperatureDetector() {
        super("td");
    }

    @Override
    public void use() {
        System.out.println("Using Temperature Detector.");
    }
}