package Presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import equipments.Equipment;
import equipments.EquipmentStorage;
import experiments.Experiment;
import lake.FrozenLake;

public class Researcher {
    private int id;
    private List<Equipment> bag;
    private boolean isActive;
    private int positionRow, positionCol;
    private String equipmentType;

    public Researcher(int id) {
        this.id = id;
        this.bag = new ArrayList<>();
        this.isActive = true;
        this.positionRow = 0; // Entrance row
        this.positionCol = 5; // Entrance column
        this.equipmentType = null;
    }

    public void prepareForExpedition(EquipmentStorage storage, Scanner scanner) {
        System.out.println("=====> Preparing expedition. Select equipment:");
        while (true) {
            System.out.println("[td] Temperature detector\n[ws] Wind speed detector\n[cm] Camera\n[ch] Chiseling equipment\n[cl] Climbing equipment\n[wb] Large wooden board\n[ph] Protective helmet\n[no] Stop taking equipment and head out to the lake");
            System.out.print("Enter equipment code: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("no")) {
                if (bag.isEmpty()) {
                    System.out.println("*** Cannot head out with an empty bag.");
                } else {
                    System.out.println("Final contents of bag: " + bag);
                    break;
                }
            } else {
                try {
                    Equipment equipment = storage.takeEquipment(input);
                    String currentType = equipment.getType();
                    if (equipmentType == null) {
                        equipmentType = currentType;
                    } else if (!equipmentType.equals(currentType)) {
                        System.out.println("*** Cannot mix equipment types.");
                        storage.returnEquipment(equipment);
                        continue;
                    }
                    if (bag.size() >= 2) {
                        System.out.println("*** Cannot carry more than 2 pieces of equipment.");
                        storage.returnEquipment(equipment);
                    } else {
                        bag.add(equipment);
                        System.out.println("Bag contents: " + bag);
                    }
                } catch (Exception e) {
                    System.out.println("*** " + e.getMessage());
                }
            }
        }
    }

    public void playTurn(FrozenLake lake, Set<Experiment> experiments, EquipmentStorage storage) {
        Scanner scanner = new Scanner(System.in);
        while (isActive) {
            System.out.println("=====> Researcher " + id + " current position: " + positionRow + ", " + positionCol);
            System.out.println("Choose direction to slide ([U] Up, [D] Down, [L] Left, [R] Right):");
            String direction = scanner.nextLine().toUpperCase();

            if (!direction.matches("[UDLR]")) {
                System.out.println("*** Invalid input. Try again.");
                continue;
            }

            int nextRow = positionRow;
            int nextCol = positionCol;
            switch (direction) {
                case "U": nextRow--; break;
                case "D": nextRow++; break;
                case "L": nextCol--; break;
                case "R": nextCol++; break;
            }

            if (!lake.isInsideLake(nextRow, nextCol)) {
                System.out.println("*** Out of bounds. Choose another direction.");
                continue;
            }

            positionRow = nextRow;
            positionCol = nextCol;

            if (lake.isHazard(positionRow, positionCol)) {
                System.out.println("!!! Encountered hazard at position " + positionRow + ", " + positionCol);
                if (bag.stream().anyMatch(e -> e.getType().equals("wb"))) {
                    System.out.println("Using Large Wooden Board to bypass hazard.");
                    bag.removeIf(e -> e.getType().equals("wb"));
                } else {
                    System.out.println("*** Fell into hazard! Game over for researcher " + id);
                    isActive = false;
                    break;
                }
            }

            lake.printLakeMap();
            System.out.println("[1] Continue moving\n[2] Perform experiment\n[3] Sit down");
            int action = scanner.nextInt();
            scanner.nextLine();

            if (action == 2) {
                performExperiment(experiments);
            } else if (action == 3) {
                isActive = false;
                System.out.println("Researcher " + id + " sits down.");
            }
        }
    }

    private void performExperiment(Set<Experiment> experiments) {
        for (Experiment experiment : experiments) {
            if (experiment.getPosition().getX() == positionRow && experiment.getPosition().getX() == positionCol) {
                experiment.perform();
                System.out.println("Experiment performed at position: " + positionRow + ", " + positionCol);
                return;
            }
        }
        System.out.println("No experiment available at this position.");
    }

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }
}


