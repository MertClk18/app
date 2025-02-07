package experiments;

import java.util.Random;

import utilities.Position;

public class WindSpeedMeasurement extends Experiment {
    private int windSpeed;

    public WindSpeedMeasurement(Position position) {
        super(position);
    }

    @Override
    public void perform() {
        Random rand = new Random();
        this.windSpeed = rand.nextInt(15) + 1; // Random wind speed between 1 and 15 m/s
        System.out.println("-- Wind Speed Measurement: " + windSpeed + " m/s");
    }

    @Override
    public void report() {
        System.out.println("-- Wind Speed Measurement: " + windSpeed + " m/s");
    }
}