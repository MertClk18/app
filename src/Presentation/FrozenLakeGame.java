package Presentation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import equipments.CameraPlacementExperiment;
import equipments.EquipmentStorage;
import experiments.Experiment;
import experiments.WindSpeedMeasurement;
import lake.FrozenLake;
import utilities.Position;

public class FrozenLakeGame {
	   public static void main(String[] args) {
	        // Initialize lake, equipment storage, and experiments
	        FrozenLake lake = new FrozenLake();
	        EquipmentStorage storage = new EquipmentStorage();
	        Set<Experiment> experiments = new HashSet<>();
	        
	        experiments.add(new WindSpeedMeasurement(new Position(3, 3)));
	        experiments.add(new CameraPlacementExperiment(new Position(4, 4)));

	        System.out.println("Welcome to Frozen Lake Puzzle App.");
	        System.out.println("There are 2 researchers waiting at the lake entrance.");
	        System.out.println("There are 2 experiment(s) that must be completed:");
	        System.out.println("- Wind Speed Measurement");
	        System.out.println("- Camera Placement");
	        System.out.println("The initial map of the frozen lake:");
	        lake.printLakeMap();

	        // Initialize researchers
	        Researcher researcher1 = new Researcher(1);
	        Researcher researcher2 = new Researcher(2);

	        // Play turns for each researcher
	        playResearcherTurn(researcher1, lake, experiments, storage);
	        playResearcherTurn(researcher2, lake, experiments, storage);

	        // Print final results
	        System.out.println("-----------> Research goal(s) have been accomplished. Here are their results:");
	        for (Experiment experiment : experiments) {
	            experiment.report();
	        }
	        System.out.println("-----------> SUCCESSFUL");
	    }

	    public static void playResearcherTurn(Researcher researcher, FrozenLake lake, Set<Experiment> experiments, EquipmentStorage storage) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("=====> Researcher " + researcher.getId() + " starts waiting at the entrance and can select up to 2 pieces of equipment of the same type.");
	        researcher.prepareForExpedition(storage, scanner);

	        while (researcher.isActive()) {
	            researcher.playTurn(lake, experiments, storage);
	        }

	        System.out.println("=====> Researcher " + researcher.getId() + " stops moving.");
	    }
	}

