package equipments;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import experiments.TemperatureDetector;
import experiments.WindSpeedDetector;

public class EquipmentStorage {
    private Map<String, Queue<Equipment>> equipmentMap;

    public EquipmentStorage() {
        equipmentMap = new HashMap<>();
        initializeStorage();
    }

    private void initializeStorage() {
        addEquipment(new TemperatureDetector(), 10);
        addEquipment(new WindSpeedDetector(), 10);
        addEquipment(new Camera(), 5);
        addEquipment(new ChiselingEquipment(), 5);
        addEquipment(new ClimbingEquipment(), 5);
        addEquipment(new LargeWoodenBoard(), 5);
        addEquipment(new ProtectiveHelmet(), 5);
    }

    public void addEquipment(Equipment equipment, int count) {
        equipmentMap.putIfAbsent(equipment.getType(), new LinkedList<>());
        for (int i = 0; i < count; i++) {
            equipmentMap.get(equipment.getType()).add(equipment);
        }
    }

    public Equipment takeEquipment(String type) throws Exception {
        Queue<Equipment> queue = equipmentMap.get(type);
        if (queue == null || queue.isEmpty()) {
            throw new Exception("Equipment of type " + type + " is unavailable.");
        }
        return queue.poll();
    }

    public void returnEquipment(Equipment equipment) {
        equipmentMap.putIfAbsent(equipment.getType(), new LinkedList<>());
        equipmentMap.get(equipment.getType()).add(equipment);
    }
}
