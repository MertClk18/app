package experiments;

import equipments.Equipment;

public class WindSpeedDetector extends Equipment {
    public WindSpeedDetector() {
        super("ws");
    }

    @Override
    public void use() {
        System.out.println("Using Wind Speed Detector.");
    }
}