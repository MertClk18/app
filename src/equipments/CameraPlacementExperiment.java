package equipments;

import java.util.Random;

import experiments.Experiment;
import utilities.Position;

public class CameraPlacementExperiment extends Experiment {
    private boolean isSuccessful;

    public CameraPlacementExperiment(Position position) {
        super(position);
    }

    @Override
    public void perform() {
        Random rand = new Random();
        this.isSuccessful = rand.nextBoolean();
        System.out.println("-- Camera Placement: " + (isSuccessful ? "The camera started recording." : "The camera failed to start recording."));
    }

    @Override
    public void report() {
        System.out.println("-- Camera Placement: " + (isSuccessful ? "The camera started recording." : "The camera failed to start recording."));
    }
}
